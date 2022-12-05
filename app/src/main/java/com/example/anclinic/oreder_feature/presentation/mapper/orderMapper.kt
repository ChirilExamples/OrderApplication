package com.example.anclinic.oreder_feature.presentation.mapper

import com.example.anclinic.oreder_feature.domain.model.Order
import com.example.anclinic.oreder_feature.presentation.state.OrderDetailListItem
import com.example.anclinic.oreder_feature.presentation.state.OrderListItem

fun Order.toOrderDetailListItem():OrderDetailListItem{
    return OrderDetailListItem(
        orderId = orderId,
        delivererName = delivererName,
        orderDate = date,
        products = products.map {
            it.toProductListItem()
        }
    )
}

fun Order.toOrderListItem():OrderListItem{
    return  OrderListItem(
        orderId = orderId,
        delivererName = delivererName,
        orderDate = date,
        totalAmount = products.sumOf { (it.amount*it.pricePerAmount).toDouble() }
    )
}