package br.com.audsat.desafio;

import br.com.audsat.desafio.repository.ClaimRepository;
import br.com.audsat.desafio.repository.InsuranceRepository;
import br.com.audsat.desafio.service.InsuranceService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static br.com.audsat.desafio.creator.InsuranceCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class InsuranceServiceTest {
    @InjectMocks
    private InsuranceService service;

    @Mock
    private ClaimRepository claimRepository;

    @Mock
    InsuranceRepository insuranceRepository;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateInsurance_whenSuccess(){
        when(insuranceRepository.save(any())).thenReturn(insurance);
        assertEquals(insuranceDTO, service.create(insuranceDTO));
    }

    @Test
    public void testGetInsurance_whenSuccess(){
        when(insuranceRepository.findById(any())).thenReturn(Optional.ofNullable(insurance));
        when(claimRepository.findByCarId(any())).thenReturn(Optional.ofNullable(claim));
        when(claimRepository.findByDriverId(any())).thenReturn(Optional.ofNullable(claim));
        assertEquals(insuranceDTO, service.findById(1L));
    }

    @Test
    public void testUpdateInsurance_whenSuccess(){
        when(insuranceRepository.findById(any())).thenReturn(Optional.of(insurance));
        when(insuranceRepository.save(any())).thenReturn(insurance);
        assertEquals(insuranceDTO, service.updateById(1L, insuranceDTO));
    }

    @Test
    public void testDeleteInsurance_whenSuccess(){
        when(insuranceRepository.findById(any())).thenReturn(Optional.of(insurance));
        service.deleteById(insurance.getId());
        verify(insuranceRepository, times(1)).deleteById(any());
    }
}
