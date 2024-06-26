package com.example.invoice.repository

import com.example.invoice.entity.Client
import com.example.invoice.entity.Product
import com.example.invoice.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository <UserEntity, Long?> {
        fun findByUsername(username: String): UserEntity?

}