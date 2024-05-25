package com.example.invoice.controller

import com.example.invoice.entity.Product
import com.example.invoice.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/product")
class ProductController {
    @Autowired
    lateinit var productService: ProductService

    @GetMapping
    fun list(): List<Product>{
        val list = productService.list()
        return list
    }

    @GetMapping
    fun save (product: Product):Product{
        return productService.save(product)
    }
}