package com.acme.prime.eval.provider;

//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

import org.osgi.service.component.annotations.Component;

import com.acme.prime.eval.api.Eval;

import osgi.enroute.debug.api.Debug;
import parsii.eval.Parser;

/*
 * Info :
 * - packages org.osgi.service.component.annotations.Component and
 *   osgi.enroute.debug.api.Debug are already embedded in bundle osgi.enroute.base.api
 * - package com.acme.prime.eval.api is embedded in bundle
 *   com.acme.prime.eval.api
 *   
 * Consequently, to compile this current package, the only bundles that must be added
 * to the build-path of the bundle embedding it are :
 *   osgi.enroute.base.api
 *   com.acme.prime.eval.api
 *   
 * parsii is a super fast and lightweight parser and expression evaluator
 */

/**
 *
 */
// @Component(name = "com.acme.prime.eval", property = { Debug.COMMAND_SCOPE +
// "=test", Debug.COMMAND_FUNCTION + "=eval" })
@Component(name = "com.acme.prime.eval.simple", property = { Debug.COMMAND_SCOPE + "=test",
		Debug.COMMAND_FUNCTION + "=eval" })
public class EvalImpl implements Eval {
	/*
	 * Pattern EXPR = Pattern.compile(
	 * "\\s*(?<left>\\d+)\\s*(?<op>\\+|-|\\*|/)\\s*(?<right>\\d+)\\s*");
	 */

	@Override
	public double eval(String expression) throws Exception {
		/*
		 * // System.out.println(expression); final Matcher m =
		 * EXPR.matcher(expression); // System.out.println(m.toString());
		 * 
		 * if (!m.matches()) throw new IllegalArgumentException(
		 * "Invalid expression " + expression); final double left =
		 * Double.valueOf(m.group("left")); final double right =
		 * Double.valueOf(m.group("right")); switch (m.group("op")) { case "+":
		 * return left + right; case "-": return left - right; case "*": return
		 * left * right; case "/": return left / right; } return Double.NaN;
		 */

		return Parser.parse(expression).evaluate();
	}

}

/*
 * WARNING about the "*" character used as an operator : When debugging i
 * checked that the regex is correct but when using an
 * org.apache.felix.gogo.shell bundle in order to call this method, in a
 * debugging phase, i observed that expecting an expression with the "*"
 * character as the 'operator' implies to input is as "\*", i.e. to escape it.
 * 
 * The other 'operator' characters, "+", "-", "/" can be inputed as expected ->
 * correct
 * 
 * While using parsii, the expression is tokenized, so some other
 * non-alphanumeric characters are expected, like "(" and ")". These characters
 * cause also problem to the shell, they must be escaped
 * 
 * So, if we expect to input the following command :
 * 
 * test:eval sin(pi)
 * 
 * we must instead input :
 * 
 * test:eval sin\(pi\)
 * 
 * TODO : try to find a solution to avoid having to escape the special characters
 * when inputing the command string with this shell
 */
