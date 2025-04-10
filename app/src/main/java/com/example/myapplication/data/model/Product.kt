package com.example.myapplication.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    val data: List<Product>
)

@Serializable
data class Product(
    val id: Int,
    @SerialName("attributes") val attributes: ProductAttributes
)

@Serializable
data class ProductAttributes(
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String
)