package com.dhemitus.cryptotrack.crypto.presentation.coin_list

import androidx.compose.runtime.Immutable
import com.dhemitus.cryptotrack.crypto.presentation.models.CoinUi

@Immutable
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CoinUi> = emptyList(),
    val selectedCoin: CoinUi? = null
)
