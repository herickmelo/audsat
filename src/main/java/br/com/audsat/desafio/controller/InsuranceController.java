package br.com.audsat.desafio.controller;

import br.com.audsat.desafio.dto.InsuranceDTO;
import br.com.audsat.desafio.entity.Driver;
import br.com.audsat.desafio.entity.Insurance;
import br.com.audsat.desafio.repository.DriverRepository;
import br.com.audsat.desafio.repository.InsuranceRepository;
import br.com.audsat.desafio.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {
    @Autowired
    private InsuranceService service;

    @GetMapping("/budget/{insuranceId}")
    public InsuranceDTO get(@PathVariable("insuranceId") Long id){
        return service.findById(id);
    }

    @PutMapping("/budget/{insuranceId}")
    public InsuranceDTO update(@PathVariable("insuranceId") Long id, @RequestBody InsuranceDTO insurance){
        return service.updateById(id, insurance);
    }

    @PostMapping("/budget")
    public InsuranceDTO create(@RequestBody InsuranceDTO insurance){
        return service.create(insurance);
    }

    @DeleteMapping("/budget/{insuranceId}")
    public void delete(@PathVariable("insuranceId") Long id){
        service.deleteById(id);
    }
}