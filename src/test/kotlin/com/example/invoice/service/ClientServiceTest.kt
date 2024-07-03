package com.example.invoice.service

import com.example.invoice.entity.Client
import com.example.invoice.entity.Invoice
import com.example.invoice.repository.ClientRepository
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File
@SpringBootTest
class ClientServiceTest {
    @InjectMocks
    lateinit var clientService: ClientService

    @Mock
    lateinit var clientRepository: ClientRepository
    //Lee el archivo desde l ruta
    val jsonString = File("./src/test/resources/client/newClient.json").readText(Charsets.UTF_8)
    // convierte en objeto de tipo Client
    val clientMock = Gson().fromJson(jsonString, Client::class.java)

    @Test
    fun saveWhenClientIsCorrect() {
        Mockito.`when`(clientRepository.save(Mockito.any(Client::class.java))).thenReturn(clientMock)
        val response = clientService.save(clientMock)
        Assertions.assertEquals(response.id, clientMock.id)

    }
    @Test
    fun saveWhenNiuClientIsCorrect() {
        Mockito.`when`(clientRepository.save(Mockito.any(Client::class.java))).thenReturn(clientMock)
        val response = clientService.validateNiu(clientMock.niu)
        Assertions.assertEquals(true,response)
    }
    @Test
    fun saveWhenNiuClientIsIncorrect() {
        clientMock.niu= "1563244"
        Mockito.`when`(clientRepository.save(Mockito.any(Client::class.java))).thenReturn(clientMock)
        val response = clientService.validateNiu(clientMock.niu)
        Assertions.assertEquals(false,response)
    }
    @Test
    fun saveWhenNiuClientContainsLetters() {
        clientMock.niu= "15632448a"
        Mockito.`when`(clientRepository.save(Mockito.any(Client::class.java))).thenReturn(clientMock)
        val response = clientService.validateNiu(clientMock.niu)
        Assertions.assertEquals(false,response)
    }
    @Test
    fun saveWhenNiuClientContainsNull() {
        clientMock.niu= "null"
        Mockito.`when`(clientRepository.save(Mockito.any(Client::class.java))).thenReturn(clientMock)
        val response = clientService.validateNiu(clientMock.niu)
        Assertions.assertEquals(false,response)
    }


}