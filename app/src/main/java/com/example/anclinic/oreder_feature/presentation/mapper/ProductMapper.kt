package com.example.anclinic.oreder_feature.presentation.mapper

import com.example.anclinic.oreder_feature.domain.model.BoughtProducts
import com.example.anclinic.oreder_feature.presentation.state.ProductListItem

fun BoughtProducts.toProductListItem():ProductListItem{
    return ProductListItem(
        id = productId,
        name = name,
        pricePerAmount = pricePerAmount,
        selectedAmount = amount,
        isExpanded = false
    )
}