package com.example.placedummy.model.forProject

public data class ProjectX(
    val actualenddate: String,
    val actualstartdate: String,
    val address: String,
    val area: Area,
    val areaId: Int?=null,
    val createdBy: Int?=null,
    val createdDate: String,
    val expectedenddate: String,
    val expectedstartdate: String,
    val isActive: Boolean,
    val modifiedBy: Int?=null,
    val modifiedDate: String,
    val name: String,
    val projectId: Int?=null,
    val projectPropertyTypes: List<ProjectPropertyType>,
    val sProjectPropertyTypes: String,
    val totalsize: Int?=null
)