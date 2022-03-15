package com.cesarbiods

import com.cesarbiods.dto.CustomerV1
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post


@Controller("/customer")
class CustomerController (private val customerService: CustomerService) {

    @Post(produces = [MediaType.APPLICATION_JSON], consumes = [MediaType.APPLICATION_JSON])
    fun createCustomer(@Body customer: CustomerV1): CustomerV1 {
        return customerService.createCustomer(customer)
    }

    @Get(value = "/{id}", produces = [MediaType.APPLICATION_JSON])
    fun getCustomer(@PathVariable id: Long): CustomerV1 {
        return customerService.getCustomer(id)
    }

    @Delete(value = "/{id}")
    fun deleteCustomer(@PathVariable id: Long): Unit {
        customerService.deleteCustomer(id)
    }
}
