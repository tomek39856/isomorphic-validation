package com.github.tomek39856.isomorphic.annotation;

import com.github.tomek39856.isomorphic.validator.IsomorphicValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Tomek on 2016-12-17.
 */
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsomorphicValidator.class)
public @interface IsomorphicValidate {
    String message() default "{isomorphic.validator.default}";
    String[] jsMethods();
    String jsFile();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
