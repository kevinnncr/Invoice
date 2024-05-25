package com.example.invoice.service

import com.example.invoice.entity.Detail
import com.example.invoice.repository.DetailRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DetailService {
    @Autowired
    lateinit var detailRepository : DetailRepository

    fun list () : List<Detail>{
        return detailRepository.findAll()
}
    fun save (detail: Detail): Detail{
        return detailRepository.save(detail)
    }

}
