package br.com.audsat.desafio.repository;

import br.com.audsat.desafio.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}
