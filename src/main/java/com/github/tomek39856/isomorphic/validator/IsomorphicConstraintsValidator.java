package com.github.tomek39856.isomorphic.validator;

import com.github.tomek39856.isomorphic.annotation.IsomorphicConstraints;
import com.github.tomek39856.isomorphic.script.JsFileValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Tomek on 2016-12-21.
 */
public class IsomorphicConstraintsValidator implements ConstraintValidator<IsomorphicConstraints, Object> {
    Map<String, List<String>> validationFiles = new HashMap<>();

    @Override
    public void initialize(IsomorphicConstraints constraintAnnotation) {
       validationFiles =
                Arrays.stream(constraintAnnotation.value())
                .collect(Collectors.toMap(
                        (validationFile) -> validationFile.jsFilePath(),
                        (validationFile) -> Arrays.asList(validationFile.jsMethods())
                ));
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();

        return validationFiles.entrySet().stream()
                .filter(
                        (file) -> !JsFileValidator.isValidationFromFilePassed(
                                value, file.getKey(), file.getValue(), context
                        )
                )
                .collect(Collectors.toList())
                .isEmpty();
    }
}
