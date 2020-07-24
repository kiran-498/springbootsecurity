package com.org;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Invoke Script Method Example
 *
 * @author Krishna
 *
 */
public class Main {
	public static void main(String[] args) throws ScriptException,
			NoSuchMethodException {
		//Write script with two methods
		String str = "function testFn(){" + "println('hi')}"
				+ "function add(a,b){print('Add Function : ');println(a + b)}";

		//Create ScriptEngineManager
		ScriptEngineManager engineManager = new ScriptEngineManager();

		//Create ScriptEngine
		ScriptEngine engine = engineManager.getEngineByExtension("js");

		//Evaluate script
		engine.eval(str);

		//Create Invocable instance
		Invocable invocable = (Invocable) engine;

		//Invoke the methods without parameter
		invocable.invokeFunction("testFn");

		//Invoke the methods with parameters
		invocable.invokeFunction("add", 10, 20);
	}
}
