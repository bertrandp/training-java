package fr.ebiz.cdb.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import fr.ebiz.cdb.service.exception.InputValidationException;
import fr.ebiz.cdb.service.validation.ComputerValidator;

import java.time.LocalDate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static fr.ebiz.cdb.service.validation.ComputerValidator.DATE_FORMAT_IS_INVALID;
import static fr.ebiz.cdb.service.validation.ComputerValidator.DATE_IS_NULL;
import static fr.ebiz.cdb.service.validation.ComputerValidator.DISCONTINUED_DATE_IS_BEFORE_INTRODUCED_DATE;
import static fr.ebiz.cdb.service.validation.ComputerValidator.DISCONTINUED_DATE_IS_SAME_AS_INTRODUCED_DATE;
import static fr.ebiz.cdb.service.validation.ComputerValidator.INTRODUCED_DATE_DOES_NOT_EXISTS;
import static fr.ebiz.cdb.service.validation.ComputerValidator.NAME_IS_EMPTY;
import static fr.ebiz.cdb.service.validation.ComputerValidator.NAME_IS_TOO_LONG;

/**
 * Created by bpestre on 22/02/17.
 */
public class ComputerValidatorTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void throwExceptionWhenValidateNameWithEmptyData() throws InputValidationException {
        thrown.expect(InputValidationException.class);
        thrown.expectMessage(NAME_IS_EMPTY);
        ComputerValidator.validateName("  ");
    }

    /*@Test
    public void throwExceptionWhenValidateComputerWithInvalidId() throws InputValidationException {
        thrown.expect(InputValidationException.class);
        thrown.expectMessage(ID_IS_NOT_A_VALID_NUMBER);
        ComputerValidator.validateId("invalid input");
    }

    @Test
    public void throwExceptionWhenValidateComputerWithEmptyId() throws InputValidationException {
        thrown.expect(InputValidationException.class);
        thrown.expectMessage(ID_IS_EMPTY);
        ComputerValidator.validateId("  ");
    }*/

    @Test
    public void throwExceptionWhenValidateNameWithInvalidData() throws InputValidationException {
        thrown.expect(InputValidationException.class);
        thrown.expectMessage(NAME_IS_TOO_LONG);
        ComputerValidator.validateName("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz ");
    }

    @Test
    public void validateNameWithValidData() throws InputValidationException {
        assertTrue(ComputerValidator.validateName("Valid name"));
    }

    @Test
    public void throwExceptionWhenValidateDiscontinuedDateWithSameDates() throws InputValidationException {
        thrown.expect(InputValidationException.class);
        thrown.expectMessage(DISCONTINUED_DATE_IS_SAME_AS_INTRODUCED_DATE);
        ComputerValidator.validateDiscontinuedDate(LocalDate.now(), LocalDate.now());
    }

    @Test
    public void throwExceptionWhenValidateDiscontinuedDateWithInvalidDate() throws InputValidationException {
        thrown.expect(InputValidationException.class);
        thrown.expectMessage(DISCONTINUED_DATE_IS_BEFORE_INTRODUCED_DATE);
        ComputerValidator.validateDiscontinuedDate(LocalDate.now(), LocalDate.MAX);
    }

    @Test
    public void throwExceptionWhenValidateDiscontinuedDateWithNullIntroducedDate() throws InputValidationException {
        thrown.expect(InputValidationException.class);
        thrown.expectMessage(INTRODUCED_DATE_DOES_NOT_EXISTS);
        ComputerValidator.validateDiscontinuedDate(LocalDate.now(), null);
    }

    @Test
    public void validateDiscontinuedDateWithValidDate() throws InputValidationException {
        assertTrue(ComputerValidator.validateDiscontinuedDate(LocalDate.now(), LocalDate.MIN));
    }

    @Test
    public void throwExceptionWhenValidateDateWithInvalidDate() throws InputValidationException {
        thrown.expect(InputValidationException.class);
        thrown.expectMessage(DATE_FORMAT_IS_INVALID);
        ComputerValidator.validateInputDate("invalid date");
    }

    @Test
    public void throwExceptionWhenValidateDateWithNull() throws InputValidationException {
        thrown.expect(InputValidationException.class);
        thrown.expectMessage(DATE_IS_NULL);
        ComputerValidator.validateInputDate(null);
    }

    @Test
    public void validateDateWithValidDate() throws InputValidationException {
        assertNotNull(ComputerValidator.validateInputDate("01/01/2000"));
    }

    /*@Test
    public void throwExceptionWhenValidateCompanyIdWithInvalidId() throws InputValidationException {
        thrown.expect(InputValidationException.class);
        thrown.expectMessage(ID_IS_NOT_A_VALID_NUMBER);
        ComputerValidator.validateCompanyId("invalid id");
    }

    @Test
    public void throwExceptionWhenValidateCompanyIdWithNull() throws InputValidationException {
        thrown.expect(InputValidationException.class);
        thrown.expectMessage(ID_IS_NULL);
        ComputerValidator.validateCompanyId(null);
    }

    @Test
    public void validateCompanyIdWithValidId() throws InputValidationException {
        assertNotNull(ComputerValidator.validateCompanyId("1"));
    }*/
}