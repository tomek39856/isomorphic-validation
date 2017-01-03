package com.github.tomek39856.isomorphic.script;

import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Tomek on 2016-12-21.
 */
public class JsFileValidator {
    private static final ScriptInvoker scriptInvoker = new ScriptInvoker();

    public static boolean isValidationFromFilePassed(Object value,
                                                     String fileName,
                                                     List<String> validationMethods,
                                                     ConstraintValidatorContext context) {
        scriptInvoker.evaluateValidationScript(fileName);

        return validationMethods.stream()
                .filter((method) -> (!(Boolean) scriptInvoker.invokeJsMethod(method, String.valueOf(value))))
                .peek((method) -> addConstraintViolation(context, method))
                .collect(Collectors.toList())
                .isEmpty();
    }

    private static void addConstraintViolation(ConstraintValidatorContext context, String jsMethod) {
        context.disableDefaultConstraintViolation();
        context
                .buildConstraintViolationWithTemplate(jsMethod)
                .addConstraintViolation();
    }
}
