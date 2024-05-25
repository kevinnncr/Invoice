package com.example.invoice.controller

import com.example.invoice.entity.Invoice
import com.example.invoice.service.InvoiceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/invoice")
class InvoiceController {
    @Autowired
    lateinit var invoiceService: InvoiceService

    @GetMapping
    fun list(): List<Invoice> {
        val list = invoiceService.list()
        return list
    }

    @GetMapping
    fun save(invoice: Invoice):Invoice{
        return invoiceService.save(invoice)
    }
}