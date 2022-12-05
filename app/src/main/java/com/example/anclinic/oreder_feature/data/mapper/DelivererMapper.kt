package com.example.anclinic.oreder_feature.data.mapper

import com.example.anclinic.core.domain.model.Deliverer
import com.example.anclinic.oreder_feature.presentation.state.DelivererListItem

fun Deliverer.toDelivererListItem():DelivererListItem{
    return DelivererListItem(
        delivererId = deliveverId,
        name = name
    )
}
