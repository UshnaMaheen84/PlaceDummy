package com.example.placedummy.model

data class AddDealerData(
    val address1: String,
    val address2: Any,
    val cnic: String,
    val createdBy: Int,
    val createdDate: String,
    val dataOfRegistration: String,
    val dealerCompanyId: Int,
    val dealerId: Int,
    val email: String,
    val gender: String,
    val isCreatedByEmployee: Boolean,
    val isSubDealer: Boolean,
    val modifiedBy: Int,
    val modifiedDate: String,
    val name: String,
    val password: String,
    val phoneNumber1: String,
    val phoneNumber2: String,
    val profileImagePath: Any,
    val rePassword: String
)