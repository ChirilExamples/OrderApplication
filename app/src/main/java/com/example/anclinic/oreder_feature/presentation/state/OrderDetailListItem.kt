package com.example.anclinic.oreder_feature.presentation.state

data class OrderDetailListItem(
    var orderId:String,
    val delivererName:String,
    val orderDate:String,
    val products:List<ProductListItem>
)
