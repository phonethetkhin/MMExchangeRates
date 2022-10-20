package com.ptk.mmexchangerates.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ptk.mmexchangerates.model.ExchangeRatesModel
import com.ptk.mmexchangerates.model.RemoteResource
import com.ptk.mmexchangerates.model.dto.CurrencyModel
import com.ptk.mmexchangerates.repository.MMExchangeRatesRepository
import com.ptk.mmexchangerates.util.showToast
import com.ptk.mmexchangerates.view.ui_resources.ui_state.UIStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MMExchangeRatesViewModel @Inject constructor(
    private val repository: MMExchangeRatesRepository, private val application: Application
) :
    ViewModel() {

    private val _uiStates = MutableStateFlow(UIStates())
    val uiStates = _uiStates.asStateFlow()


    private val _screenTitle = MutableStateFlow("")
    val screenTitle: MutableStateFlow<String>
        get() = _screenTitle

    fun setTitle(newTitle: String) {
        _screenTitle.value = newTitle
    }

    fun setDate(date: String) {
        _uiStates.update { it.copy(selectedDate = date) }
    }

    fun setSelectedCurrency(currency: String) {
        _uiStates.update { it.copy(selectedCurrency = currency) }
    }

    fun setResult(result: String) {
        _uiStates.update { it.copy(convertedResult = result) }
    }

    fun getLatestExchangeRates() {
        repository.getLatestExchangeRates().onEach { remoteResource ->
            when (remoteResource) {
                is RemoteResource.Loading ->
                    _uiStates.update {
                        it.copy(showLoadingDialog = true)
                    }
                is RemoteResource.Success -> {
                    val rateList = ArrayList<ExchangeRatesModel>()
                    Log.e("Hello", remoteResource.data.rates.toString())
                    remoteResource.data.rates.forEach {
                        rateList.add(ExchangeRatesModel(it.key, it.value))
                    }
                    Log.e("Hello", rateList.toString())
                    _uiStates.update {
                        it.copy(
                            showLoadingDialog = false,
                            rates = rateList,
                            noResult = false

                        )
                    }
                }
                is RemoteResource.Failure -> {
                    _uiStates.update {
                        it.copy(
                            showLoadingDialog = false,
                            noResult = remoteResource.errorMessage == "No result"
                        )
                    }
                    application.showToast(remoteResource.errorMessage.toString())
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getCurrencies() {
        repository.getCurrencies().onEach { remoteResource ->
            when (remoteResource) {
                is RemoteResource.Loading ->
                    _uiStates.update {
                        it.copy(showLoadingDialog = true)
                    }
                is RemoteResource.Success -> {
                    val currencyList = ArrayList<CurrencyModel>()
                    remoteResource.data.currencies.forEach {
                        currencyList.add(CurrencyModel(it.key, it.value))
                    }
                    _uiStates.update {
                        it.copy(
                            showLoadingDialog = false,
                            currencies = currencyList
                        )
                    }
                }
                is RemoteResource.Failure -> {
                    _uiStates.update { it.copy(showLoadingDialog = false) }
                    application.showToast(remoteResource.errorMessage.toString())
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getHistory(date: String) {
        repository.getHistory(date).onEach { remoteResource ->
            when (remoteResource) {
                is RemoteResource.Loading ->
                    _uiStates.update {
                        it.copy(showLoadingDialog = true)
                    }
                is RemoteResource.Success -> {
                    val rateList = ArrayList<ExchangeRatesModel>()
                    Log.e("TESTING!@#", remoteResource.data.rates.toString())
                    if (remoteResource.data.rates.isNotEmpty()) {
                        remoteResource.data.rates.forEach {
                            rateList.add(ExchangeRatesModel(it.key, it.value))
                        }
                    }
                    Log.e("Hello", rateList.toString())

                    _uiStates.update {
                        it.copy(
                            showLoadingDialog = false,
                            rates = rateList,
                            noResult = false

                        )
                    }
                }
                is RemoteResource.Failure -> {
                    _uiStates.update {
                        it.copy(
                            showLoadingDialog = false,
                            noResult = remoteResource.errorMessage == "No result"
                        )
                    }
                    application.showToast(remoteResource.errorMessage.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}