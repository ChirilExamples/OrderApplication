package com.example.anclinic.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class DelivererEntity(
    @PrimaryKey val delivererId: String,
    val name: String
)