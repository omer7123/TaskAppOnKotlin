package com.mrflaitx.taskapp35.presentation.add

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mrflaitx.taskapp35.R
import com.mrflaitx.taskapp35.data.ShopListRepositoryImpl
import com.mrflaitx.taskapp35.databinding.ActivityAddBinding
import com.mrflaitx.taskapp35.domain.AddShopItemUseCase
import com.mrflaitx.taskapp35.domain.ShopItem

class AddActivity : AppCompatActivity(R.layout.activity_add) {
    private lateinit var binding: ActivityAddBinding
    private val viewModel: AddViewModel by viewModels()

    private val repository = ShopListRepositoryImpl

    private val addShopItemUseCase = AddShopItemUseCase(repository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.saveBtn.setOnClickListener {
            val shopItem = ShopItem(
                Integer.parseInt(binding.idTv.text.toString()),
                binding.nameTv.text.toString(),
                0,
                true,
                )
            addShopItemUseCase.addShopItem(shopItem)
            finish()
        }
    }

}