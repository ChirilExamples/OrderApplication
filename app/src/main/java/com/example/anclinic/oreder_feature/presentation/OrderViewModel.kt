package com.example.anclinic.oreder_feature.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anclinic.oreder_feature.domain.model.BoughtProducts
import com.example.anclinic.oreder_feature.domain.model.Order
import com.example.anclinic.oreder_feature.domain.repository.OrderRepository
import com.example.anclinic.oreder_feature.presentation.mapper.toOrderDetailListItem
import com.example.anclinic.oreder_feature.presentation.mapper.toOrderListItem
import com.example.anclinic.oreder_feature.presentation.state.OrderDetailListItem
import com.example.anclinic.oreder_feature.presentation.state.OrderListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val orderRepository: OrderRepository
) : ViewModel() {

    private lateinit var orders: List<Order>

    var orderList by mutableStateOf<List<OrderListItem>>(emptyList())
        private set

    var isOrderDialogShown by mutableStateOf(false)
        private set

    var clickOrderedItem by mutableStateOf<OrderDetailListItem?>(null)
        private set

    init {
        viewModelScope.launch {
            orders = orderRepository.getOrders()
            setUpOrderList()
//            orderRepository.insertOrder(
//                Order(
//                    "1",
//                    "2022.10.15 12:05:12",
//                    delivererTime = "As fast as possible",
//                    "Paper Factory Ltd",
//                    listOf(
//                        BoughtProducts(
//                            "1",
//                            "Note book",
//                            1.23f,
//                            2
//                        )
//                    )
//                )
//            )
        }
    }

    fun onOrderClicked(orderId: String) {
        iniOrderForDialog(orderId)
        isOrderDialogShown = true
    }

    private fun iniOrderForDialog(orderId: String) {
        clickOrderedItem = orders.firstOrNull { it.orderId == orderId }?.toOrderDetailListItem()
    }

    fun onDismissOrderDialog() {
        isOrderDialogShown = false
        clickOrderedItem = null
    }

    private fun setUpOrderList() {
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm:ss")

        orderList = orders.map {
            it.toOrderListItem()
        }.sortedByDescending {
            LocalDateTime.parse(it.orderDate, formatter)
        }
    }
}