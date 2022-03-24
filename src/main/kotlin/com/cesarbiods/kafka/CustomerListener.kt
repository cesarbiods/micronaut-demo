package com.cesarbiods.kafka

import com.cesarbiods.dto.CustomerV1
import com.cesarbiods.jpa.Customer
import com.cesarbiods.jpa.CustomerRepository
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
class CustomerListener(private val customerRepository: CustomerRepository) {

    @Topic("customers")
    fun receive(@KafkaKey hashCode: Int, customer: CustomerV1): Unit {
        val entity = Customer(null, customer.firstName, customer.lastName, customer.age)
        customerRepository.save(entity)
    }
}
