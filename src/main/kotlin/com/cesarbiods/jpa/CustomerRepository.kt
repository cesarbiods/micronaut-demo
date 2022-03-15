package com.cesarbiods.jpa

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface CustomerRepository : CrudRepository<Customer, Long?> {
}
