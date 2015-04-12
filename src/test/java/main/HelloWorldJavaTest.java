package main;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HelloWorldJavaTest {
	@Test
	public void pass() {
		assertTrue(true);
	}

	@Test
	public void fail() {
		assertTrue(false);
	}
}
