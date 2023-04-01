package com.example.placedummy.model.forProperty

data class PropertyView(
    val additionalAmount: Int,
    val address: String,
    val customerId: Int,
    val description: String,
    val features: String,
    val investorId: Int,
    val investorName: String,
    val isHold: Boolean,
    val isSold: Boolean,
    val projectId: Int,
    val projectName: String,
    val projectPropertyTypeId: Int,
    val propertyCode: String,
    val propertyId: Int,
    val propertySubTypeId: Int,
    val purchasingAmount: Int,
    val saleDealerId: Int,
    val saleEmployeeId: Int,
    val sellingAmountDealer: Int,
    val sellingAmountEmployee: Int,
    val subType: String,
    val totalSellingAmountDealer: Int,
    val totalSellingAmountEmployee: Int
)