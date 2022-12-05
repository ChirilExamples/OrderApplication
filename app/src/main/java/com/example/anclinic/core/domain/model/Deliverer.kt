package com.example.anclinic.core.domain.model

import com.example.anclinic.core.domain.SelectAndSortableByName

data class Deliverer(
    val deliveverId:String,
    override val name:String,
    val products:List<Product>
):SelectAndSortableByName
