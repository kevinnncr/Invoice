package com.example.invoice.entity

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "invoice_view")
class InvoiceView {
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Id
@Column(updatable = false)
    var id: Long? = null
    var code: String? = null
    @Column(name = "create_at")
    var createAt: Date? = null
    var total: Double? = null

    var fullname: String? = null
}