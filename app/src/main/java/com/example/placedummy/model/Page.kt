package com.example.placedummy.model

data class Page (
    val action: String,
    val canCreate: Boolean,
    val canCreateEnable: Boolean,
    val canDelete: Boolean,
    val canDeleteEnable: Boolean,
    val canUpdate: Boolean,
    val canUpdateEnable: Boolean,
    val canView: Boolean,
    val canViewEnable: Boolean,
    val controller: String,
    val icon: String,
    val isDropdown: Boolean,
    val isShowEmployeeCategory: Boolean,
    val menuName: String,
    val pageID: Int,
    val pageName: String,
    val pageParentID: Int
        )