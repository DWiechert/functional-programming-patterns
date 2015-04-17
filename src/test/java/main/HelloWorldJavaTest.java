package main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class HelloWorldJavaTest {
	@Test
	public void pass() {
		assertTrue(true);
	}

	@Ignore
	@Test
	public void fail() {
		assertEquals(1, 2);
	}
}
