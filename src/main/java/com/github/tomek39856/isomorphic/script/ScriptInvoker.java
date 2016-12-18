package com.github.tomek39856.isomorphic.script;

import jdk.nashorn.api.scripting.NashornScriptEngine;

import javax.script.Invocable;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by Tomek on 2016-12-17.
 */
public class ScriptInvoker {
    private final NashornScriptEngine nashornScriptEngine = (NashornScriptEngine) new ScriptEngineManager().getEngineByName("nashorn");

    public void evaluateValidationScript(String validationScript) {
        try {
            nashornScriptEngine.eval(readFile(validationScript));
        } catch (ScriptException e) {
            throw new RuntimeException(e);
        }
    }

    public Object invokeJsMethod(String method, String argument) {
        try {
            return nashornScriptEngine.invokeFunction(method, argument);
        } catch (ScriptException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private Reader readFile(String path) {
        InputStream in = getClass().getClassLoader().getResourceAsStream(path);
        return new InputStreamReader(in);
    }
}
