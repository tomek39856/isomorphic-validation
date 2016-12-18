package com.github.tomek39856.isomorphic.validator;

import com.github.tomek39856.isomorphic.annotation.IsomorphicValidate;

/**
 * Created by Tomek on 2016-12-18.
 */
public class ObjectToValidate {
    @IsomorphicValidate(jsFile = "testValidator.js", jsMethods = {"validateString", "notNull"})
    private final String testValue;

    public ObjectToValidate(String testValue) {
        this.testValue = testValue;
    }
}
