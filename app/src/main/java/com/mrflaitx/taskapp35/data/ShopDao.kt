package com.mrflaitx.taskapp35.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ShopDao {

    @Query("SELECT * FROM shop_items")
    fun getShopList(): LiveData<List<ShopItemDBModel>>

    @Query("SELECT * FROM shop_items WHERE id=:shopItemId LIMIT 1")
    fun getShopItem(shopItemId:Int): ShopItemDBModel

    @Insert
    fun addShopItem(shopItemDbModel: ShopItemDBModel)

    @Delete
    fun deleteShopItem(shopItemDbModel: ShopItemDBModel)

}