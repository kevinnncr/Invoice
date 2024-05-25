package com.example.invoice.controller

import com.example.invoice.entity.Invoice
import com.example.invoice.service.InvoiceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/invoice")
class InvoiceController {
    @Autowired
    lateinit var invoiceService: InvoiceService

    @GetMapping
    fun list(): List<Invoice> {
        return invoiceService.list()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Invoice {
        return invoiceService.getById(id)
    }

    @PostMapping
    fun save(@RequestBody invoice: Invoice): Invoice {
        return invoiceService.save(invoice)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody invoice: Invoice): Invoice {
        return invoiceService.update(id, invoice)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): String {
        invoiceService.delete(id)
        return "Invoice with id $id deleted successfully"
    }
}
