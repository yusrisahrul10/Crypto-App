package com.stockbit.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.annotation.NonNull
import androidx.room.ColumnInfo

@Entity(tableName = "crypto")
data class CryptoEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "idCrypto")
        val idCrypto: String,

        @ColumnInfo(name = "name")
        val name: String,


        @ColumnInfo(name = "fullName")
        val fullName: String,

        @ColumnInfo(name = "price")
        val price: String,

        @ColumnInfo(name = "priceChange")
        val priceChange: String,

        @ColumnInfo(name = "priceChangePct")
        val priceChangePct: String,

)
