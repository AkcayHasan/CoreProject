package com.hasankcay.base.base_local.roomdb.dao

import androidx.room.*

@Dao
interface BaseDao<T> {

    /**
     * Insert an entity in the database.
     *
     * @param entity the entity to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: T)

    /**
     * Insert a list of entities in the database.
     *
     * @param entityList the list of entities to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entityList: List<T>)

    /**
     * Update an entity from the database.
     *
     * @param entity the entity to be updated.
     */
    @Update
    suspend fun update(entity: T)

    /**
     * Delete an entity from the database.
     *
     * @param entity the entity to be deleted.
     */
    @Delete
    suspend fun delete(entity: T)
}