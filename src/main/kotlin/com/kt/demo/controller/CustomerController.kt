package com.kt.demo.controller

import com.kt.demo.model.Customer
import com.kt.demo.repository.CustomerRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController(val customerRepository: CustomerRepository) {

    @GetMapping
    fun findAll() = customerRepository.findAll()

    @PostMapping
    fun addCustomer(@RequestBody customer: Customer) = customerRepository.save(customer)

    @PutMapping("/{id}")
    fun updateCustomer(@PathVariable id: Long, @RequestBody customer: Customer) {
        assert(customer.id == id)
        customerRepository.save(customer)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = customerRepository.findById(id)


    @DeleteMapping("/{id}")
    fun removeCustomer(@PathVariable id: Long) = customerRepository.deleteById(id)

}