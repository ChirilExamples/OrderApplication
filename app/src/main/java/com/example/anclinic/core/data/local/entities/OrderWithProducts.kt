package com.example.anclinic.core.data.local.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class OrderWithProducts(
    @Embedded val orderEntity: OrderEntity,
    @Relation(
        parentColumn = "orderId",
        entityColumn ="productId",
        associateBy = Junction(OrderProductEntity::class)
    )
    val products:List<ProductEntity>,
    @Relation(
        parentColumn = "orderId",
        entityColumn = "orderId"
    )
    val orderProductEntities: List<OrderProductEntity>
)
