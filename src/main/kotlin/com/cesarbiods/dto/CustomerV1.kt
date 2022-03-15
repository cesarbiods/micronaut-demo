package com.cesarbiods.dto

import io.micronaut.core.annotation.Introspected

@Introspected
data class CustomerV1(
    val firstName: String,
    val lastName: String,
    val age: Int
)
