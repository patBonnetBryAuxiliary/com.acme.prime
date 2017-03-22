package com.acme.prime.upper.provider;

import org.osgi.service.component.annotations.Component;

import com.acme.prime.upper.api.Upper;

/**
 * 
 */
@Component(name = "com.acme.prime.upper")
public class UpperImpl implements Upper {

	@Override
	public String upper(String input) {
		// return string.toLowerCase();
		return "! " + input.toUpperCase();
	}

}
