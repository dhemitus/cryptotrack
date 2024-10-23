package com.dhemitus.cryptotrack.crypto.presentation.coin_list

import com.dhemitus.cryptotrack.crypto.presentation.models.CoinUi

sealed interface CoinListAction {
    data class OnCoinClick(val coinui: CoinUi): CoinListAction
}