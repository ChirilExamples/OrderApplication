package com.example.anclinic.core.domain.model

import com.example.anclinic.core.domain.SelectAndSortableByName

data class Product(
    val productId:String,
    override val name:String,
    val pricePerAmount:Float
): SelectAndSortableByName
