package com.example.invoice.repository

import com.example.invoice.entity.Invoice
import com.example.invoice.entity.InvoiceView
import com.example.invoice.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface InvoiceViewRepository: JpaRepository <InvoiceView, Long?> {


}