package com.example.anclinic.core.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.anclinic.core.data.local.entities.DelivererEntity
import com.example.anclinic.core.data.local.entities.DelivererWithProduct

@Dao
interface DelivererDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDeliverer(delivererEntity: DelivererEntity)

    @Transaction
    @Query("SELECT * FROM DelivererEntity")
    suspend fun getDeliverers():List<DelivererWithProduct>

    @Query("Select name FROM DELIVERERENTITY WHERE delivererId = :delivererId")
    suspend fun getDelivererNameById(delivererId:String):String
}