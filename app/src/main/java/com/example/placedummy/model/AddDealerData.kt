package com.example.placedummy.model

data class AddDealerData(
    val dealerId: Int,
    val dealerCompanyId: Int,
    val dealerCompany :String,
    val dcDealerCompany: String,
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
    val passwordHash : String,
    val dataOfRegistration: String,
    val isSubDealer: Boolean,
    val createdDate: String,
    val isCreatedByEmployee : Boolean,
    val createdBy: Int,
    val modifiedDate: String,
    val modifiedBy: Int
    )