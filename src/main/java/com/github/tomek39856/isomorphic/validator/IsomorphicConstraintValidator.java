package com.github.tomek39856.isomorphic.validator;

import com.github.tomek39856.isomorphic.annotation.IsomorphicConstraint;
import com.github.tomek39856.isomorphic.script.JsFileValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;


/**
 * Created by Tomek on 2016-12-17.
 */
public class IsomorphicConstraintValidator implements ConstraintValidator<IsomorphicConstraint, Object> {
    private String[] jsMethods;
    private String jsFile;

    @Override
    public void initialize(IsomorphicConstraint constraintAnnotation) {
        jsMethods = constraintAnnotation.jsMethods();
        jsFile = constraintAnnotation.jsFilePath();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return JsFileValidator.isValidationFromFilePassed(value, jsFile, Arrays.asList(jsMethods), context);
    }
}
