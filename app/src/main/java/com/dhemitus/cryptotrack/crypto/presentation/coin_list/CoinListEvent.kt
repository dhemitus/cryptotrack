package com.dhemitus.cryptotrack.crypto.presentation.coin_list

import com.dhemitus.cryptotrack.core.domain.util.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError): CoinListEvent
}