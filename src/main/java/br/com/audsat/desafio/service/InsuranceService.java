package br.com.audsat.desafio.service;

import br.com.audsat.desafio.dto.InsuranceDTO;
import br.com.audsat.desafio.entity.Insurance;
import br.com.audsat.desafio.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;

    public InsuranceDTO create(InsuranceDTO insuranceDTO){
        var insurance = this.convertDTOToEntity(insuranceDTO, null);
        insurance = insuranceRepository.save(insurance);
        return convertEntityToDTO(insurance);
    }

    public InsuranceDTO findById(Long id){
        Optional<Insurance> optInsurance = insuranceRepository.findById(id);
        if (optInsurance.isPresent()){
            var insurance = optInsurance.get();
            return this.convertEntityToDTO(insurance);
        }else {
            return null;
        }
    }

    public List<Insurance> getAll(){
        return insuranceRepository.findAll();
    }

    public InsuranceDTO updateById(Long id, InsuranceDTO insuranceDTO) {
        Optional<Insurance> optInsurance = insuranceRepository.findById(id);
        if (optInsurance.isPresent()){
            var insurance = optInsurance.get();
            insurance = insuranceRepository.save(convertDTOToEntity(insuranceDTO, id));
            return convertEntityToDTO(insurance);
        }
        return null;
    }

    public void deleteById(Long id) {
        Optional<Insurance> optInsurance = insuranceRepository.findById(id);
        if (optInsurance.isPresent()) {
            insuranceRepository.deleteById(id);
        }
    }

    private InsuranceDTO convertEntityToDTO(Insurance entity){
        return InsuranceDTO.builder()
                .customer(entity.getCustomer())
                .car(entity.getCar())
                .createdDate(entity.getCreatedDate())
                .updatedDate(entity.getUpdatedDate())
                .isActive(entity.getIsActive())
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
                .build();
    }
}