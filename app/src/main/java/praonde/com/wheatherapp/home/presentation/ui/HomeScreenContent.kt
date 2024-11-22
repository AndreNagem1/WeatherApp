package praonde.com.wheatherapp.home.presentation.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import praonde.com.wheatherapp.common.SubmitLoadingState

@Composable
fun HomeScreenContent(
    state: SubmitLoadingState<String>,
    onSearchItemClick: (Int) -> Unit
) {
    when (state) {
        SubmitLoadingState.Loading -> {}
        SubmitLoadingState.Idle -> HomeIdleText()

        is SubmitLoadingState.Success -> {
            LazyColumn(
                modifier = Modifier.padding(top = 32.dp, start = 20.dp, end = 20.dp)
            ) {
                items(listSearchItems.size) { index ->
                    if (index > 0) {
                        Spacer(modifier = Modifier.height(32.dp))
                    }
                    SearchListItem(
                        onSearchListItemClick = { onSearchItemClick(index) }
                    )
                }
            }
        }

        else -> {}
    }
}

private val listSearchItems = listOf("", "", "", "", "")
