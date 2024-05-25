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

    fun getById(id: Long): Invoice {
        return invoiceRepository.findById(id).orElseThrow { RuntimeException("Invoice not found") }
    }

    fun save(invoice: Invoice): Invoice {
        return invoiceRepository.save(invoice)
    }

    fun update(id: Long, invoice: Invoice): Invoice {
        val existingInvoice = invoiceRepository.findById(id).orElseThrow { RuntimeException("Invoice not found") }
        existingInvoice.code = invoice.code
        existingInvoice.createAt = invoice.createAt
        existingInvoice.total = invoice.total
        existingInvoice.client = invoice.client
        return invoiceRepository.save(existingInvoice)
    }

    fun delete(id: Long) {
        if (invoiceRepository.existsById(id)) {
            invoiceRepository.deleteById(id)
        } else {
            throw RuntimeException("Invoice not found")
        }
    }
}
