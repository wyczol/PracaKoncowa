package controller;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestUnit {

	MazWindowController test1 = new MazWindowController (430605);
	MazWindowController test2 = new MazWindowController (100000);
	
	@Test
	public void testSimpleAdd() {
		
		MazWindowController expected = new MazWindowController(530605);
		MazWindowController result = test1.add(test2);
		assertTrue(expected.equals(result));
	}
	
}
