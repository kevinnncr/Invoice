package com.example.invoice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class InvoiceApplication

fun main(args: Array<String>) {
	runApplication<InvoiceApplication>(*args)
}
