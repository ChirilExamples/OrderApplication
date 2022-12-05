package com.example.anclinic.oreder_feature.data.mapper

import com.example.anclinic.core.data.local.entities.OrderEntity
import com.example.anclinic.oreder_feature.domain.model.Order

fun Order.toOrderEntity(delivererName:String):OrderEntity{
    return OrderEntity(
        orderId = orderId,
        date = date,
        delivererTime = delivererTime,
        delivererName = delivererName,
    )
}