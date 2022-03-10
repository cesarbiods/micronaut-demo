package com.cesarbiods

import io.micronaut.runtime.Micronaut.*

object Api {
}
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("com.cesarbiods")
		.start()
}

