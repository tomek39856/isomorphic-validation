package com.github.tomek39856.isomorphic.validator.data;

/**
 * Created by Tomek on 2016-12-18.
 */
public class ObjectToValidate {
    @Password
    private final String testValue;
    @NotNull
    @Password
    private final String testValue2;
    @BiggerThan3
    private final int numercValue;

    public ObjectToValidate(String testValue, String testValue2, int numercValue) {
        this.testValue = testValue;
        this.testValue2 = testValue2;
        this.numercValue = numercValue;
    }
}
