package com.mrflaitx.taskapp35.presentation.add

import androidx.lifecycle.ViewModel
import com.mrflaitx.taskapp35.data.ShopListRepositoryImpl
import com.mrflaitx.taskapp35.domain.AddShopItemUseCase
import com.mrflaitx.taskapp35.domain.ShopItem

class AddViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val addShopItemUseCase = AddShopItemUseCase(repository)

    fun addShopItem(shopItem: ShopItem){
        addShopItemUseCase.addShopItem(shopItem)
    }

}