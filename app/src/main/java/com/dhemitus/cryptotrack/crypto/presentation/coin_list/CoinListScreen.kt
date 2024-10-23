package com.dhemitus.cryptotrack.crypto.presentation.coin_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.dhemitus.cryptotrack.crypto.presentation.coin_list.components.CoinListItem
import com.dhemitus.cryptotrack.crypto.presentation.coin_list.components.previewCoin
import com.dhemitus.cryptotrack.ui.theme.CryptoTrackTheme

@Composable
fun CoinListScreen(
    state: CoinListState,
    onAction: (CoinListAction) -> Unit,
    modifier: Modifier = Modifier
){
    if(state.isLoading) {
        Box(
            modifier = modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }
    } else {
        LazyColumn (
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            items(state.coins) {coinui ->
                CoinListItem(
                    coinui = coinui,
                    onClick = {
                        onAction(CoinListAction.OnCoinClick(coinui))
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun CoinListScreenPreview(){
    CryptoTrackTheme {
        CoinListScreen(
            state = CoinListState(
                coins = (1..100).map{
                    previewCoin.copy(id = it.toString())
                }
            ),
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background),
            onAction = {}
        )
    }
}