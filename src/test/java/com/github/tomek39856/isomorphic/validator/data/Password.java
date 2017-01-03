package com.github.tomek39856.isomorphic.validator.data;

import com.github.tomek39856.isomorphic.annotation.IsomorphicConstraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Tomek on 2016-12-21.
 */
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@IsomorphicConstraint(jsFilePath = "testValidator.js", jsMethods = {"validateLengthMin", "validateLengthMax"})
public @interface Password {
    String message() default "{isomorphic.validator.default}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
