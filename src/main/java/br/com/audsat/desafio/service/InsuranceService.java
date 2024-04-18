package br.com.audsat.desafio.service;

import br.com.audsat.desafio.dto.InsuranceDTO;
import br.com.audsat.desafio.entity.Insurance;
import br.com.audsat.desafio.repository.ClaimRepository;
import br.com.audsat.desafio.repository.InsuranceRepository;
import br.com.audsat.desafio.util.AgeCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private ClaimRepository claimRepository;

    public InsuranceDTO create(InsuranceDTO insuranceDTO){
        var insurance = this.convertDTOToEntity(insuranceDTO, null);
        insurance = insuranceRepository.save(insurance);
        return convertEntityToDTO(insurance, null);
    }

    public InsuranceDTO findById(Long id){
        Optional<Insurance> optInsurance = insuranceRepository.findById(id);
        if (optInsurance.isPresent()){
            var insurance = optInsurance.get();
            var fipeValue = insurance.getCar().getFipeValue();
            var new_budget = calculateBaseBudget(insurance, fipeValue);
            new_budget = calculateBudgetAge(insurance, new_budget, fipeValue);
            new_budget = calculateBudgetDriverClaim(insurance, new_budget, fipeValue);
            new_budget = calculateBudgetCarClaim(insurance, new_budget, fipeValue);
            return convertEntityToDTO(insurance, new_budget);
        }else {
            return null;
        }
    }

    private Double calculateBaseBudget(Insurance insurance, Float fipeValue) {
        return ((double)6/100) * fipeValue;
    }

    private Double calculateBudgetCarClaim(Insurance insurance, Double new_budget, Float fipeValue) {
        var car = insurance.getCar();
        var optClaimCar = claimRepository.findByCarId(car.getId());
        if (optClaimCar.isPresent()) { // Se o veiculo possui sinistro
            new_budget += (((double) 2 / 100) * fipeValue);
        }
        return new_budget;
    }

    private Double calculateBudgetDriverClaim(Insurance insurance, Double new_budget, Float fipeValue) {
        var driver = insurance.getCustomer().getDriver();
        var optClaimDriver = claimRepository.findByDriverId(driver.getId());
        if (optClaimDriver.isPresent()) { // Se o motorista possui sinistro em seu nome
            new_budget += (((double) 2 / 100) * fipeValue);
        }
        return new_budget;
    }

    private Double calculateBudgetAge(Insurance insurance, Double new_budget, Float fipeValue){
        var age = AgeCalculator.calculateAge(insurance.getCustomer().getDriver().getBirthDate(), LocalDate.now());
        if (age >= 18 && age <= 25) { // Se o motorista encontra-se na faixa dos 18 a 25
            new_budget += (((double) 2 / 100) * fipeValue);
        }
        return new_budget;
    }

    public InsuranceDTO updateById(Long id, InsuranceDTO insuranceDTO) {
        Optional<Insurance> optInsurance = insuranceRepository.findById(id);
        if (optInsurance.isPresent()){
            var insurance = optInsurance.get();
            insurance = insuranceRepository.save(convertDTOToEntity(insuranceDTO, id));
            return convertEntityToDTO(insurance, null);
        }
        return null;
    }

    public void deleteById(Long id) {
        Optional<Insurance> optInsurance = insuranceRepository.findById(id);
        if (optInsurance.isPresent()) {
            insuranceRepository.deleteById(id);
        }
    }

    private InsuranceDTO convertEntityToDTO(Insurance entity, Double new_budget){
        return InsuranceDTO.builder()
                .customer(entity.getCustomer())
                .car(entity.getCar())
                .createdDate(entity.getCreatedDate())
                .updatedDate(entity.getUpdatedDate())
                .isActive(entity.getIsActive())
                .budget(new_budget == null? entity.getBudget(): new_budget)
                .build();
    }

    private Insurance convertDTOToEntity(InsuranceDTO dto, Long id){
        return Insurance.builder()
                .id(id)
                .customer(dto.getCustomer())
                .car(dto.getCar())
                .createdDate(dto.getCreatedDate())
                .updatedDate(dto.getUpdatedDate())
                .isActive(dto.getIsActive())
                .budget(dto.getBudget())
                .build();
    }
}
