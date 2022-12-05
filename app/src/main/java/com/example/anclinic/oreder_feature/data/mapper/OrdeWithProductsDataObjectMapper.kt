package com.example.anclinic.oreder_feature.data.mapper

import com.example.anclinic.core.data.local.entities.OrderWithProducts
import com.example.anclinic.oreder_feature.domain.model.BoughtProducts
import com.example.anclinic.oreder_feature.domain.model.Order

fun OrderWithProducts.toOrder():Order{
    return Order(
        orderId = orderEntity.orderId,
        date = orderEntity.date,
        delivererName = orderEntity.delivererName,
        delivererTime = orderEntity.delivererTime,
        products = products.zip(orderProductEntities).map {
            BoughtProducts(
                it.component1().productId,
                it.component1().name,
                it.component1().pricePerAmount,
                it.component2().amount
            )
        }
    )
}