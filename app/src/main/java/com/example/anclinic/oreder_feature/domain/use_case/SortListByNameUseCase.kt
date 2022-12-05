package com.example.anclinic.oreder_feature.domain.use_case

import com.example.anclinic.core.domain.SelectAndSortableByName

class SortListByNameUseCase {
        operator fun <T> invoke(list: List<T>):List<T> where T:SelectAndSortableByName{
            return list.sortedBy {
                it.name
            }
        }
}