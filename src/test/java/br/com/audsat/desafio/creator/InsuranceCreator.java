package br.com.audsat.desafio.creator;

import br.com.audsat.desafio.dto.InsuranceDTO;
import br.com.audsat.desafio.entity.*;

import java.time.LocalDate;

public class InsuranceCreator {

    public static Car car = Car.builder()
            .fipeValue(10F)
            .build();

    public static Driver driver = Driver.builder()
            .id(1L)
            .birthDate(LocalDate.now())
            .build();

    public static Customer customer = Customer.builder()
            .driver(driver)
            .build();

    public static InsuranceDTO insuranceDTO = InsuranceDTO.builder()
            .customer(customer)
            .car(car)
            .budget(1.4)
            .build();

    public static Claim claim = Claim.builder()
            .id(1L)
            .car(car)
            .driver(driver)
            .build();

    public static Insurance insurance = Insurance.builder()
            .id(1L)
            .customer(customer)
            .car(car)
            .budget(1.4)
            .build();
}
