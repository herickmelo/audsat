package br.com.audsat.desafio.dto;

import br.com.audsat.desafio.entity.Car;
import br.com.audsat.desafio.entity.Customer;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class InsuranceDTO {
    private Customer customer;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private Car car;
    private Boolean isActive;
}