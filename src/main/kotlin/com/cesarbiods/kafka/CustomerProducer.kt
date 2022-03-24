package com.cesarbiods.kafka

import com.cesarbiods.dto.CustomerV1
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaClient
interface CustomerProducer {

    @Topic("customers")
    fun createCustomer(@KafkaKey hashCode: Int, customer: CustomerV1)
}
