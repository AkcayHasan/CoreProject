package com.hasankcay.base.base_local.roomdb.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hasankcay.base.base_local.roomdb.dao.UserDao
import com.hasankcay.base.base_local.roomdb.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class BaseDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao
}