package com.example.anclinic.core.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.anclinic.core.data.local.entities.OrderEntity
import com.example.anclinic.core.data.local.entities.OrderProductEntity
import com.example.anclinic.core.data.local.entities.OrderWithProducts

@Dao
interface OrderDao {
    @Transaction
    @Query("SELECT * FROM OrderEntity")
    suspend fun getOrderWithProducts ():List<OrderWithProducts>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrder(orderEntity : OrderEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrderProductEntities(orderProductEntities : List<OrderProductEntity>)


}