package com.example.anclinic.oreder_feature.domain.model

import com.example.anclinic.core.domain.model.Product

data class Order(
    val orderId:String,
    val date:String,
    val delivererTime:String,
    val delivererName:String,
    val products:List<BoughtProducts>
)
