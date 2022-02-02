package com.mrflaitx.taskapp35.presentation.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrflaitx.taskapp35.data.ShopListRepositoryImpl
import com.mrflaitx.taskapp35.domain.AddShopItemUseCase
import com.mrflaitx.taskapp35.domain.ShopItem
import kotlinx.coroutines.launch

class AddViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val addShopItemUseCase = AddShopItemUseCase(repository)

    fun addShopItem(shopItem: ShopItem) {
        viewModelScope.launch {
            addShopItemUseCase.addShopItem(shopItem)
        }
    }

}