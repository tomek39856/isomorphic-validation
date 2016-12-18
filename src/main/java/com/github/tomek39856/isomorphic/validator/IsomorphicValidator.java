package com.github.tomek39856.isomorphic.validator;

import com.github.tomek39856.isomorphic.annotation.IsomorphicValidate;
import com.github.tomek39856.isomorphic.script.ScriptInvoker;
import jdk.nashorn.api.scripting.NashornScriptEngine;

import javax.script.ScriptEngineManager;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.stream.Collectors;


/**
 * Created by Tomek on 2016-12-17.
 */
public class IsomorphicValidator implements ConstraintValidator<IsomorphicValidate, String> {
    private final NashornScriptEngine nashornScriptEngine = (NashornScriptEngine) new ScriptEngineManager().getEngineByName("nashorn");
    private final ScriptInvoker scriptInvoker = new ScriptInvoker();
    private String[] jsMethods;

    @Override
    public void initialize(IsomorphicValidate constraintAnnotation) {
        jsMethods = constraintAnnotation.jsMethods();
        scriptInvoker.evaluateValidationScript(constraintAnnotation.jsFile());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();

        return Arrays.stream(jsMethods)
                .filter((jsMethod) -> (!(Boolean)scriptInvoker.invokeJsMethod(jsMethod, value)))
                .peek((jsMethod) -> addConstraintViolation(context, jsMethod))
                .collect(Collectors.toList())
                .isEmpty();
    }

    private void addConstraintViolation(ConstraintValidatorContext context, String jsMethod) {
        context
                .buildConstraintViolationWithTemplate(jsMethod)
                .addConstraintViolation();
    }
}
