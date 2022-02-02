package com.mrflaitx.taskapp35

import android.app.Application
import androidx.room.Room
import com.mrflaitx.taskapp35.data.AppDataBase
import com.mrflaitx.taskapp35.data.ShopListRepositoryImpl

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        appDataBase = Room.databaseBuilder(applicationContext, AppDataBase::class.java, "dataBase.db")
            .fallbackToDestructiveMigration()
            .build()
        repository = ShopListRepositoryImpl
    }

    companion object {
        lateinit var appDataBase: AppDataBase
        lateinit var repository: ShopListRepositoryImpl
    }
}