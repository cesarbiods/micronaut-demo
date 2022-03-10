package com.cesarbiods

import com.cesarbiods.dto.Customer
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces


@Controller("/customer")
class CustomerController (private val customerService: CustomerService) {

    @Post(produces = [MediaType.APPLICATION_JSON], consumes = [MediaType.APPLICATION_JSON])
    fun createCustomer(@Body customer: Customer): Customer {
        return customerService.createCustomer(customer)
    }
}
