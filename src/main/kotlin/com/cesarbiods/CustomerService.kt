package com.cesarbiods

import com.cesarbiods.dto.CustomerV1
import com.cesarbiods.jpa.Customer
import com.cesarbiods.jpa.CustomerRepository
import com.cesarbiods.kafka.CustomerProducer
import jakarta.inject.Singleton

@Singleton
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val customerProducer: CustomerProducer
) {

    fun createCustomer(customer: CustomerV1): CustomerV1 {
        customerProducer.createCustomer(customer.hashCode(), customer)
        return customer
    }

    fun getCustomer(id: Long): CustomerV1 {
        val entity = customerRepository.findById(id).get()
        return CustomerV1(entity.firstName, entity.lastName, entity.age)
    }

    fun deleteCustomer(id: Long): Unit {
        customerRepository.deleteById(id)
    }
}
