package com.mrflaitx.taskapp35.domain


data class ShopItem(
    var id: Int = UNDEFINED_ID,
    val name: String,
    val count: Int,
    var enabled: Boolean
) {
    companion object {
        const val UNDEFINED_ID = -1
    }
}