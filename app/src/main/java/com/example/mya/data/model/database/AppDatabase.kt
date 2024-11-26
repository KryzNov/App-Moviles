package com.example.mya.data.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mya.data.model.ServiceEntity
import com.example.mya.data.model.dao.ServiceDao


@Database(entities =[ServiceEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun serviceDao(): ServiceDao
}