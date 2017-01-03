package com.github.tomek39856.isomorphic.annotation;

import com.github.tomek39856.isomorphic.validator.IsomorphicConstraintsValidator;

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
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Constraint(validatedBy = IsomorphicConstraintsValidator.class)
public @interface IsomorphicConstraints {
    IsomorphicConstraint[] value();
    String message() default "{isomorphic.validator.default}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
