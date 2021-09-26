package com.stockbit.local.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.stockbit.local.entity.CryptoEntity
import io.reactivex.Single

@Dao
interface BaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(crypto: List<CryptoEntity>)

    @Query("SELECT * from crypto")
    fun getData() : DataSource.Factory<Int, CryptoEntity>
}