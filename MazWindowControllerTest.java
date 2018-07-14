package controller;

import static org.junit.Assert.*;

import org.junit.Test;

public class MazWindowControllerTest {

	MazWindowController test1 = new MazWindowController (430605);
	MazWindowController test2 = new MazWindowController (100000);
	

	@Test
	public void test() {

		MazWindowController expected = new MazWindowController(530605);
		MazWindowController result = test1.add(test2);
		assertTrue(expected.equals(result));
	}

}
