package br.com.audsat.desafio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CarDriver {
    @Id
    private Long id;
    @ManyToOne
    private Driver driver;
    @ManyToOne
    private Car car;
    private Boolean isMainDriver;
}
