package com.example.anclinic.oreder_feature.domain.repository

import com.example.anclinic.core.domain.model.Deliverer
import com.example.anclinic.core.domain.model.Product
import com.example.anclinic.oreder_feature.domain.model.Order

interface OrderRepository {

    suspend fun insertOrder(order: Order)

    suspend fun getOrders(): List<Order>

    suspend fun getDeliverer(): List<Deliverer>

    suspend fun getProductsForDeliverer(delivererId: String): List<Product>

    suspend fun getDelivererNameById(delivererId: String): String

}