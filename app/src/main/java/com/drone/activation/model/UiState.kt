package com.drone.activation.model

data class UiState(

    val ip: String = "192.168.144.1",

    val serialNumber: String = "未获取",

    val verifyStatus: String = "未验证",

    val activationStatus: String = "未激活"

)