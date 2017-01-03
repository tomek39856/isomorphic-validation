package com.github.tomek39856.isomorphic.annotation;

import com.github.tomek39856.isomorphic.validator.IsomorphicConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Tomek on 2016-12-17.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Constraint(validatedBy = IsomorphicConstraintValidator.class)
@Repeatable(IsomorphicConstraints.class)
public @interface IsomorphicConstraint {
    String[] jsMethods();
    String jsFilePath();
    String message() default "{isomorphic.validator.default}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
