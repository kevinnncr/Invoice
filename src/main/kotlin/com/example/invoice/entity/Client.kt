package com.example.invoice.entity

import jakarta.persistence.*

@Entity
@Table(name = "client")
class Client {
@GeneratedValue( strategy = GenerationType.IDENTITY )
@Id
@Column( updatable = false)
    var id: Long? = null
    var niu: String? = null
    var fullname: String? = null
    var email: String? = null
}