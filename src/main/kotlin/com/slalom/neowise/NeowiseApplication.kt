package com.slalom.neowise

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NeowiseApplication

fun main(args: Array<String>) {
	runApplication<NeowiseApplication>(*args)
}
