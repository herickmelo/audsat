package br.com.audsat.desafio.controller;

import br.com.audsat.desafio.dto.InsuranceDTO;
import br.com.audsat.desafio.service.InsuranceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/insurance", produces = "application/json")
@Tag(name = "Insurance")
public class InsuranceController {
    @Autowired
    private InsuranceService service;

    @Operation(summary = "Consulta o orçamento do seguro", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a consulta"),
    })
    @GetMapping("/budget/{insuranceId}")
    public InsuranceDTO get(@PathVariable("insuranceId") Long id){
        return service.findById(id);
    }

    @Operation(summary = "Atualiza um orçamento com os dados fornecidos", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualização realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar atualização dos dados"),
    })
    @PutMapping("/budget/{insuranceId}")
    public InsuranceDTO update(@PathVariable("insuranceId") Long id, @RequestBody InsuranceDTO insurance){
        return service.updateById(id, insurance);
    }

    @Operation(summary = "Cadastra um orçamento com os dados fornecidos", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar cadastro dos dados"),
    })
    @PostMapping(path = "/budget", consumes = MediaType.APPLICATION_JSON_VALUE)
    public InsuranceDTO create(@RequestBody InsuranceDTO insurance){
        return service.create(insurance);
    }

    @Operation(summary = "Remove um orçamento com os dados fornecidos", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Remoção realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar remoção dos dados"),
    })
    @DeleteMapping("/budget/{insuranceId}")
    public void delete(@PathVariable("insuranceId") Long id){
        service.deleteById(id);
    }
}