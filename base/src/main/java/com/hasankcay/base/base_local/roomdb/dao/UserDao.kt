package com.hasankcay.base.base_local.roomdb.dao

import androidx.room.Dao
import com.hasankcay.base.base_local.roomdb.entity.UserEntity

@Dao
abstract class UserDao: BaseDao<UserEntity> {

}