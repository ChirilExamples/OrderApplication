package com.example.anclinic.oreder_feature.domain.use_case

import com.example.anclinic.core.domain.SelectAndSortableByName

class FilterListByNameUseCase {

    operator fun <T> invoke(
        list: List<T>,
        name: String
    ): List<T> where T : SelectAndSortableByName {
        return list.filter {
            it.name.lowercase().contains(name.lowercase())
        }
    }
}