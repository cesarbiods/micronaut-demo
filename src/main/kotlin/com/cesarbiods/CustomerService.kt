package com.cesarbiods

import com.cesarbiods.dto.CustomerV1
import com.cesarbiods.jpa.Customer
import com.cesarbiods.jpa.CustomerRepository
import jakarta.inject.Singleton

@Singleton
class CustomerService(private val customerRepository: CustomerRepository) {

    fun createCustomer(customer: CustomerV1): CustomerV1 {
        var entity = Customer(null, customer.firstName, customer.lastName, customer.age)
        entity = customerRepository.save(entity)
        println(entity)
        return CustomerV1(entity.firstName, entity.lastName, entity.age)
    }

    fun getCustomer(id: Long): CustomerV1 {
        val entity = customerRepository.findById(id).get()
        return CustomerV1(entity.firstName, entity.lastName, entity.age)
    }

    fun deleteCustomer(id: Long): Unit {
        customerRepository.deleteById(id)
    }
}
