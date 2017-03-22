package com.acme.prime.eval.api;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface Eval {
	/**
	 * Evaluate an expression and return the result.
	 */
	double eval(String expression) throws Exception;

}
