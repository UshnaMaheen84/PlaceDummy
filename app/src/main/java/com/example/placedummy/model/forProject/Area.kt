package com.example.placedummy.model.forProject

data class Area(
    val areaId: Int,
    val areaName: String,
    val city: Any,
    val cityId: Int,
    val createdBy: Int,
    val createdDate: String,
    val isActive: Boolean,
    val isByDefault: Boolean,
    val modifiedBy: Int,
    val stateId: Int
)