package br.com.audsat.desafio.repository;

import br.com.audsat.desafio.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {

    Optional<Claim> findByDriverId(Long id);

    Optional<Claim> findByCarId(Long id);
}
