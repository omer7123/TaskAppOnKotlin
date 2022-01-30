package com.mrflaitx.taskapp35.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shop_items")
data class ShopItemDBModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int = -1,
    val name:String,
    val count:Int,
    val enabled:Boolean
){

}