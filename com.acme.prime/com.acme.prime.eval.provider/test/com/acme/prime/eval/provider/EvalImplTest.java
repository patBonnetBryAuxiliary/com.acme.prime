package com.acme.prime.eval.provider;

import junit.framework.TestCase;

/*
 * The imported package junit.framework is embedded in bundle
 * osgi.enroute.junit.wrapper-4.12.0.jar, so this last bundle must be added to
 * the build-path for the purpose of tests only.
 * This is done by the following bnd instruction :
 *    -testpath: osgi.enroute.junit.wrapper;version=4.12
 *    
 * (see this in the bnd.bnd of the bundle embedding this current package)
 * 
 */

public class EvalImplTest extends TestCase {

	public void testSimple() throws Exception {
		final EvalImpl t = new EvalImpl();
		assertEquals(3.0, t.eval("1 + 2"));
	}
}
