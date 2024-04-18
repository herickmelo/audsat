package br.com.audsat.desafio.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @ManyToOne
    private Car car;
    private Boolean isActive;
}
