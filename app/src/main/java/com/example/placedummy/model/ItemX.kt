package com.example.placedummy.model

data class ItemX(
    val name: String,
    val protocolProfileBehavior: ProtocolProfileBehavior,
    val request: Request,
    val response: List<Any>
)