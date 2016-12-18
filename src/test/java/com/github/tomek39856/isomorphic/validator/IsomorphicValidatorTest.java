package com.github.tomek39856.isomorphic.validator;

import com.github.tomek39856.isomorphic.annotation.IsomorphicValidate;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Tomek on 2016-12-18.
 */
public class IsomorphicValidatorTest {
    private Validator validator;

    @Before
    public void init() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void shouldPassForCorrectValues() {
        //given:
        ObjectToValidate objectToValidate = new ObjectToValidate("correctValue");

        //when:
        Set<ConstraintViolation<ObjectToValidate>> constraintViolations = validator.validate(objectToValidate);

        //then:
        assertTrue(constraintViolations.isEmpty());
    }

    @Test
    public void shouldFailForIncorrectValue() {
        //given:
        ObjectToValidate objectToValidate = new ObjectToValidate("incorrectValue");

        //when:
        Set<ConstraintViolation<ObjectToValidate>> constraintViolations = validator.validate(objectToValidate);

        //then:
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void shouldFailForIncorrectValuesAndReturnCorrectNumberOfViolations() {
        //given:
        ObjectToValidate objectToValidate = new ObjectToValidate(null);

        //when:
        Set<ConstraintViolation<ObjectToValidate>> constraintViolations = validator.validate(objectToValidate);

        //then:
        assertEquals(2, constraintViolations.size());
    }
}
