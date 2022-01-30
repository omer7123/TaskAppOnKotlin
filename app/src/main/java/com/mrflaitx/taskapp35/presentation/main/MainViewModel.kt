package com.mrflaitx.taskapp35.presentation.main

import androidx.lifecycle.ViewModel
import com.mrflaitx.taskapp35.data.ShopListRepositoryImpl
import com.mrflaitx.taskapp35.domain.*

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val addShopItemUseCase = AddShopItemUseCase(repository)
    private val getShopItemListUseCase = GetShopListUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)


    val shopList = getShopItemListUseCase.getShopList()

    fun addShopItem(shopItem: ShopItem){
        addShopItemUseCase.addShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }


//    fun getShopItemList(){
//        val list = getShopItemListUseCase.getShopList()
//        shopList.value = list
//        Log.e("TAG", "getShopItemList(ViewModel): $list ", )
//    }




}