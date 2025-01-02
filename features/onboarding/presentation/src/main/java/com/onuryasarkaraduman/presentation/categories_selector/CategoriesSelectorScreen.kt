package com.onuryasarkaraduman.presentation.categories_selector

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.onuryasarkaraduman.core.R
import com.onuryasarkaraduman.core.domain.model.UserCategory
import com.onuryasarkaraduman.presentation.categories_selector.CategoriesContract.CategoriesUiAction
import com.onuryasarkaraduman.presentation.categories_selector.CategoriesContract.CategoriesUiEffect
import com.onuryasarkaraduman.presentation.components.NextButton
import com.onuryasarkaraduman.presentation.welcome.components.CategoryCard
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CategoriesSelectorScreen(
    onAction: (CategoriesUiAction) -> Unit,
    uiEffect: Flow<CategoriesUiEffect>,
    onNavigateNextScreen: () -> Unit,
) {

    val lifeCycleOwner = androidx.lifecycle.compose.LocalLifecycleOwner.current

    LaunchedEffect(uiEffect, lifeCycleOwner) {
        lifeCycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
            uiEffect.collect { effect ->
                when (effect) {
                    is CategoriesUiEffect.GoToNextScreen -> {
                        onNavigateNextScreen()
                    }
                }

            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val selectedStates = remember {
            mutableStateListOf<Boolean>().apply {
                addAll(List(UserCategory.entries.count()) { false })
            }
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                UserCategory.entries.forEachIndexed { index, category ->
                    CategoryCard(
                        title = stringResource(id = category.displayName),
                        image = category.imageResource,
                        isSelected = selectedStates[index],
                        onToggleSelect = { selectedStates[index] = !selectedStates[index] }
                    )
                }
            }
        }
        NextButton(
            text = stringResource(id = R.string.next),
            textColor = colorResource(id = R.color.black),
            isEnabled = selectedStates.count { it } >= 4, // TODO: Kendime Not: Bu business logic :D Use casede mi olmalı yoksa başka bir yerde mi? Araştır
            onClick = {
                val selectedStatesList = selectedStates.toList() // TODO: Bu bile bir business logic
                onAction(
                    CategoriesUiAction.SaveCategories(selectedStates = selectedStatesList)
                )
            }
        )
    }
}