package com.cesarbiods.jpa

import javax.persistence.*

@Entity
@Table(name = "customer")
data class Customer(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long?,

    @Column(name = "first_name", nullable = false)
    val firstName: String,

    @Column(name = "last_name", nullable = false)
    val lastName: String,

    @Column(name = "age", nullable = false)
    val age: Int
) {

}
