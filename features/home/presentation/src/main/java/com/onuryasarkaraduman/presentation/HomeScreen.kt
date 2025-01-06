package com.onuryasarkaraduman.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.onuryasarkaraduman.core.R
import com.onuryasarkaraduman.design_system.CategoriesSegmentedButtonRow
import com.onuryasarkaraduman.design_system.ErrorScreen
import com.onuryasarkaraduman.design_system.LoadingScreen
import com.onuryasarkaraduman.model.CategoriesRecommendedModel
import com.onuryasarkaraduman.presentation.HomeContract.UiAction
import com.onuryasarkaraduman.presentation.HomeContract.UiEffect
import com.onuryasarkaraduman.presentation.HomeContract.UiState
import com.onuryasarkaraduman.presentation.components.DividerHorizontal
import com.onuryasarkaraduman.presentation.components.FriendsProfileImage
import com.onuryasarkaraduman.presentation.components.HomeRecommendedBooksCard
import com.onuryasarkaraduman.presentation.components.TextHeaders
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@Composable
fun HomeScreen(
    uiState: UiState,
    onAction: (UiAction) -> Unit,
    uiEffect: Flow<UiEffect>,
    onNavigateRecommendedDetail: (String) -> Unit,
) {
    val context = LocalContext.current // Toast message için lazım
    val lifeCycleOwner = androidx.lifecycle.compose.LocalLifecycleOwner.current
    val selectedCategory = uiState.selectedCategory

    LaunchedEffect(uiEffect, lifeCycleOwner) {
        lifeCycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
            onAction(UiAction.LoadCategoriesAndFetchBooks)
            uiEffect.collect { effect ->
                when (effect) {
                    is UiEffect.GoToDetailScreen -> {
                        onNavigateRecommendedDetail("route")
                    }

                    is UiEffect.ShowToastMessage -> {

                    }
                }

            }
        }
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextHeaders(title = stringResource(id = R.string.friends))
        FriendActionsSection()
        DividerHorizontal(
            color = colorResource(id = R.color.yellow)
        )

        TextHeaders(title = stringResource(id = R.string.recommended_for_you))

        CategoriesChipsContent(
            selectedCategory = selectedCategory,
            onCategorySelected = { category ->
                onAction(UiAction.FetchBooksByCategoryChipButtons(category))
            },
            uiState = uiState
        )

        when {
            uiState.isLoading -> LoadingScreen()
            uiState.recommendedList.isNotEmpty() && uiState.setCategories.isNotEmpty() -> {
                RecommendedForYouSection(recommendedList = uiState.recommendedList)

            }

            else -> ErrorScreen(
                message = uiState.errorMessage.orEmpty(),
                onClick = {}
            )
        }
    }
}


@Composable
fun FriendActionsSection() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(10) {
            FriendsProfileImage()
        }
    }
}

@Composable
fun CategoriesChipsContent(
    selectedCategory: String,
    onCategorySelected: (String) -> Unit,
    uiState: UiState,
) { /*
    Burada when case ini metoda gömmmemin sebebi aslında doğrudan ui etkileşimi sonucunda tetiklenmesinden dolayı.
    Okunabilirliği arttırmak istedim ama doğru bir yöntem olmayabilir. Çünkü sayfa açıldığında direkt tetiklenmiyor
    sadece kullanıcı chip buttonlara bastığında tetiklenen bir durum. Chiplerin çalışmaması durumda ui da bu metoda bakılacak
 */
    when {
        uiState.setCategories.isNotEmpty() -> {
            CategoriesSegmentedButtonRow(
                categories = uiState.setCategories.toList(),
                selectedCategory = selectedCategory,
                onCategorySelected = onCategorySelected
            )
        }
    }
}


@Composable
fun RecommendedForYouSection(recommendedList: List<CategoriesRecommendedModel>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(recommendedList) {
            HomeRecommendedBooksCard(
                book = it,
                onClick = {}
            )


        }
    }
}

@Composable
fun TrendingBooksSection() {

}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(
    @PreviewParameter(HomeScreenPreviewProvider::class) uiState: UiState,
) {
    HomeScreen(
        uiState = uiState,
        onAction = {},
        uiEffect = flow { },
        onNavigateRecommendedDetail = {}
    )
}