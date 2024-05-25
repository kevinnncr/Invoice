package com.example.invoice.service

import com.example.invoice.entity.Invoice
import com.example.invoice.repository.InvoiceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class InvoiceService {
    @Autowired
    lateinit var invoiceRepository: InvoiceRepository

    fun list(): List<Invoice> {
        return invoiceRepository.findAll()
    }

    fun save(invoice: Invoice): Invoice {
        return invoiceRepository.save(invoice)
    }

}