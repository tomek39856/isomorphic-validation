package com.github.tomek39856.isomorphic.validator.data;

import com.github.tomek39856.isomorphic.annotation.IsomorphicConstraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Tomek on 2016-12-24.
 */
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@IsomorphicConstraint(jsFilePath = "testValidator2.js", jsMethods = {"validateBiggerThan3"})
public @interface BiggerThan3 {
    String message() default "{isomorphic.validator.default}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
