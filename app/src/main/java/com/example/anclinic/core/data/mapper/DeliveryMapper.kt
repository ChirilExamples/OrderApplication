package com.example.anclinic.core.data.mapper

import com.example.anclinic.core.data.local.entities.DelivererEntity
import com.example.anclinic.core.domain.model.Deliverer
import com.example.anclinic.core.domain.model.Product

fun DelivererEntity.toDeliverer(products:List<Product>):Deliverer{
    return Deliverer(
        deliveverId = delivererId,
        name = name,
        products = products
    )
}