package com.mrflaitx.taskapp35.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.mrflaitx.taskapp35.domain.ShopItem
import com.mrflaitx.taskapp35.domain.ShopListRepository
import com.mrflaitx.taskapp35.App

object ShopListRepositoryImpl : ShopListRepository {
    private lateinit var shopItem: ShopItem
    private var autoIncrementId = 0
    private val mapper = ShopListMapper()

    override suspend fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        Log.e("ololo", shopItem.id.toString())
        App.appDataBase.shopListDao().addShopItem(mapper.mapEntityToDBModel(shopItem))
//        shopList.add(shopItem)
//        updateList()
//        Log.e("TAG", "addShopItem: $shopItem")
    }

    override suspend fun deleteShopItem(shopItem: ShopItem) {
//        shopList.remove(shopItem)
//        updateList()
        App.appDataBase.shopListDao().deleteShopItem(mapper.mapEntityToDBModel(shopItem))
    }

    override fun editShopItem(shopItem: ShopItem) {
//        val oldElement = getShopItem(shopItem.id)
//        shopList.remove(oldElement)
//        addShopItem(shopItem)
    }

    override fun getShopList(): LiveData<List<ShopItem>> = Transformations.map(
        App.appDataBase.shopListDao().getShopList()
    ) {
        mapper.mapListDbModelToListEntity(it)
    }


//    private fun updateList() {
//        shopListLD.value = shopList.toList()
//    }

    override suspend fun getShopItem(shopItemId: Int): ShopItem {
//        return shopList.find { shopItem ->
//            shopItem.id == shopItemId
//        } ?: throw RuntimeException("Element with id $shopItemId not found")
        if (App.appDataBase.shopListDao().getShopItem(shopItemId) != null) {
            shopItem = mapper.mapDBModelToEntity(App.appDataBase.shopListDao().getShopItem(shopItemId))
        }else{
            shopItem = ShopItem(100000, "Не найден",0,true)
        }
        return shopItem
    }
}