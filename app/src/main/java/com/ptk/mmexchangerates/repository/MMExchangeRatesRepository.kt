@file:OptIn(InternalAPI::class)

package com.ptk.mmexchangerates.repository

import android.app.Application
import com.ptk.mmexchangerates.R
import com.ptk.mmexchangerates.data_source.remote.ApiService
import com.ptk.mmexchangerates.model.RemoteResource
import io.ktor.client.features.*
import io.ktor.util.*
import kotlinx.coroutines.flow.channelFlow
import javax.inject.Inject

class MMExchangeRatesRepository @Inject constructor(
    private val apiService: ApiService,
    private val application: Application,
) {
    fun getLatestExchangeRates() = channelFlow {
        try {
            send(RemoteResource.Loading)
            val response = apiService.getLatestExchangeRates()
            send(RemoteResource.Success(response))
        } catch (e: Exception) {
            when (e) {
                is HttpRequestTimeoutException -> {
                    send(RemoteResource.Failure(errorMessage = application.getString(R.string.connection_error_message)))
                }
                else -> {
                    if (e.toString()
                            .split(":")[0] == "kotlinx.serialization.json.internal.JsonDecodingException"
                    ) {
                        val errorMessage = "No result"
                        send(RemoteResource.Failure(errorMessage = errorMessage))
                    } else {
                        val errorMessage = "Something went wrong, ${e.localizedMessage}"
                        send(RemoteResource.Failure(errorMessage = errorMessage))
                    }
                }
            }
        }
    }

    fun getCurrencies() = channelFlow {
        try {
            send(RemoteResource.Loading)
            val response = apiService.getCurrencies()
            send(RemoteResource.Success(response))
        } catch (e: Exception) {
            when (e) {
                is HttpRequestTimeoutException -> {
                    send(RemoteResource.Failure(errorMessage = application.getString(R.string.connection_error_message)))
                }
                else -> {
                    val errorMessage = "Something went wrong, ${e.localizedMessage}"
                    send(RemoteResource.Failure(errorMessage = errorMessage))
                }
            }
        }
    }

    fun getHistory(date: String) = channelFlow {
        try {
            send(RemoteResource.Loading)
            val response = apiService.getHistory(date)
            send(RemoteResource.Success(response))
        } catch (e: Exception) {
            when (e) {
                is HttpRequestTimeoutException -> {
                    send(RemoteResource.Failure(errorMessage = application.getString(R.string.connection_error_message)))
                }
                else -> {
                    if (e.toString()
                            .split(":")[0] == "kotlinx.serialization.json.internal.JsonDecodingException"
                    ) {
                        val errorMessage = "No result"
                        send(RemoteResource.Failure(errorMessage = errorMessage))
                    } else {
                        val errorMessage = "Something went wrong, ${e.localizedMessage}"
                        send(RemoteResource.Failure(errorMessage = errorMessage))
                    }
                }
            }
        }
    }

}