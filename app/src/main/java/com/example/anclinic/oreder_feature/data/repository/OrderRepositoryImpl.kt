package com.example.anclinic.oreder_feature.data.repository

import com.example.anclinic.core.data.local.DelivererDao
import com.example.anclinic.core.data.local.OrderDao
import com.example.anclinic.core.data.local.ProductDao
import com.example.anclinic.core.data.local.entities.OrderProductEntity
import com.example.anclinic.core.data.mapper.toDeliverer
import com.example.anclinic.core.data.mapper.toProduct
import com.example.anclinic.core.domain.model.Deliverer
import com.example.anclinic.core.domain.model.Product
import com.example.anclinic.oreder_feature.data.mapper.toOrder
import com.example.anclinic.oreder_feature.data.mapper.toOrderEntity
import com.example.anclinic.oreder_feature.domain.model.Order
import com.example.anclinic.oreder_feature.domain.repository.OrderRepository
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(
    private val orderDao: OrderDao,
    private val delivererDao: DelivererDao,
    private val productDao: ProductDao
):OrderRepository {
    override suspend fun insertOrder(order: Order) {
        orderDao.insertOrder(order.toOrderEntity(order.delivererName))
        val orderProductEntities = order.products.map {
            OrderProductEntity(order.orderId, it.productId, it.amount)
        }
        orderDao.insertOrderProductEntities(orderProductEntities)
    }

    override suspend fun getOrders(): List<Order> {
        return orderDao.getOrderWithProducts().map {
            it.toOrder()
        }
    }

    override suspend fun getDeliverer(): List<Deliverer> {
        return delivererDao.getDeliverers().map {
            it.delivererEntity.toDeliverer(
                it.products.map {
                    it.toProduct()
                }
            )
        }
    }

    override suspend fun getProductsForDeliverer(delivererId: String): List<Product> {
        return productDao.getProductsForDeliverer(delivererId).map {
            it.toProduct()
        }
    }

    override suspend fun getDelivererNameById(delivererId: String): String {
        return delivererDao.getDelivererNameById(delivererId)
    }
}