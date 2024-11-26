package com.example.mya.data.model.database

import androidx.room.Database

@Database(entities =[ServiceEntity::class], version = 1)
abstract class AppDatabase : RoomDatabases() {
    abstract fun serviceDao(): ServiceDao

}