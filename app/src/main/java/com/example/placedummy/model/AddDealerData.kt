package com.example.placedummy.model

data class AddDealerData(
    val dealerId: Int,
    val dealerCompanyId: Int,
    val dealerCompany :String,
    val dcDealerCompany: String?=null,
    val profileImagePath: Any,
    val name: String,
    val email: String,
    val phoneNumber1: String,
    val phoneNumber2: String,
    val address1: String,
    val address2: String,
    val gender: String,
    val cnic: String,
    val password: String,
    val rePassword: String,
    val isSubDealer: Boolean?=false,
    val createdDate: String? =null,
    val isCreatedByEmployee : Boolean? = false,
    val createdBy: Int?=null,
    val modifiedDate: String?=null,
    val modifiedBy: Int?=null
    )