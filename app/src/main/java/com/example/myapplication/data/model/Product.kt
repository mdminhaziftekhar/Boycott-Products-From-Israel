package com.example.myapplication.data.model

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    val data: List<Product>
)

data class Product(
    val id: Int,
    val attributes: ProductAttributes
)

data class ProductAttributes(
    val name: String,
    @SerializedName("imageUrl") val imageUrl: String,
    val proof: String,
    val priority: Boolean,
    val createdAt: String,
    val updatedAt: String,
    val publishedAt: String,
    val proofUrl: String,
    val tags: String?,
    val filename: String,
    val alternative: AlternativeWrapper
)

data class AlternativeWrapper(
    val data: Any?
)
