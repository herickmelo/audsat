package br.com.audsat.desafio.controller;

import br.com.audsat.desafio.entity.Customer;
import br.com.audsat.desafio.entity.Driver;
import br.com.audsat.desafio.repository.CustomerRepository;
import br.com.audsat.desafio.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private DriverRepository driverRepository;

    @GetMapping("/{id}")
    public Driver getCustomer(@PathVariable("id") Long id){
        return driverRepository.findById(id).get();
    }
}
