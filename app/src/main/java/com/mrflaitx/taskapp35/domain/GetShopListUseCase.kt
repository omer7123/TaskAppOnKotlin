package com.mrflaitx.taskapp35.domain

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopList() = shopListRepository.getShopList()
}