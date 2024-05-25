package com.example.invoice.service

import com.example.invoice.entity.Client
import com.example.invoice.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ClientService {
    @Autowired
    lateinit var clientRepository: ClientRepository

    fun list(): List<Client> {
        return clientRepository.findAll()
    }

    fun getById(id: Long): Client {
        return clientRepository.findById(id).orElseThrow { RuntimeException("Client not found") }
    }

    fun save(client: Client): Client {
        return clientRepository.save(client)
    }

    fun update(id: Long, client: Client): Client {
        val existingClient = clientRepository.findById(id).orElseThrow { RuntimeException("Client not found") }
        existingClient.niu = client.niu
        existingClient.fullname = client.fullname
        existingClient.address = client.address
        existingClient.email = client.email

        return clientRepository.save(existingClient)
    }

    fun delete(id: Long) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id)
        } else {
            throw RuntimeException("Client not found")
        }
    }
}
