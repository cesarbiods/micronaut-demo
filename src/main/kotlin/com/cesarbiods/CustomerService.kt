package com.cesarbiods

import com.cesarbiods.dto.Customer
import jakarta.inject.Singleton
import java.util.*

@Singleton
class CustomerService {

    fun createCustomer(customer: Customer): Customer {
        // pretend this is getting persisted somewhere
        println(customer)
        return customer
    }
}
