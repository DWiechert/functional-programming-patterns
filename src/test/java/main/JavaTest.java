package main;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JavaTest {
	@Test
	public void testPass() {
		assertTrue(true);
	}

	@Test
	public void testFail() {
		assertTrue(false);
	}
}
