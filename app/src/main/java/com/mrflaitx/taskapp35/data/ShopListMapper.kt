package com.mrflaitx.taskapp35.data

import com.mrflaitx.taskapp35.domain.ShopItem

class ShopListMapper {

    fun mapEntityToDBModel(shopItem: ShopItem) = ShopItemDBModel(
        id = shopItem.id,
        name = shopItem.name,
        count = shopItem.count,
        enabled = shopItem.enabled
    )

    fun mapDBModelToEntity(shopItemDBModelToEntity: ShopItemDBModel) = ShopItem(
        id = shopItemDBModelToEntity.id,
        name = shopItemDBModelToEntity.name,
        count = shopItemDBModelToEntity.count,
        enabled = shopItemDBModelToEntity.enabled

    )

    fun mapListDbModelToListEntity(list: List<ShopItemDBModel>) = list.map {
        mapDBModelToEntity(it)
    }
}