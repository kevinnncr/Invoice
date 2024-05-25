package com.example.invoice.controller

import com.example.invoice.entity.Detail
import com.example.invoice.service.DetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/detail")
class DetailController {
    @Autowired
    lateinit var detailService: DetailService

    @GetMapping
    fun list(): List<Detail> {
        val list = detailService.list()
        return list
    }

    @GetMapping
    fun save (detail: Detail): Detail {
        return detailService.save(detail)
    }
}