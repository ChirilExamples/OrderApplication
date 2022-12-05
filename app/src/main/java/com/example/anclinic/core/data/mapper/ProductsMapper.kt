package com.example.anclinic.core.data.mapper

import com.example.anclinic.core.data.local.entities.ProductEntity
import com.example.anclinic.core.domain.model.Product

fun ProductEntity.toProduct():Product{
    return Product(
        productId = productId,
        name = name,
        pricePerAmount = pricePerAmount
    )
}