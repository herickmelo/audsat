package br.com.audsat.desafio;

import br.com.audsat.desafio.util.AgeCalculator;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgeCalculatorTest {

    @Test
    public void testCalculateAge_Success() {
        // setup
        LocalDate birthDate = LocalDate.of(1961, 5, 17);
        // exercise
        int actual = AgeCalculator.calculateAge(birthDate, LocalDate.of(2016, 7, 12));
        // assert
        assertEquals(55, actual);
    }
}