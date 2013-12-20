package com.hui;

import static org.junit.Assert.*;

import org.junit.Test;

public class GeneralTest {

	@Test
	public void integerTest()
	{
		int i =3;
		Integer i3 = i;
		Integer i32 = 3;
		assertTrue(i3==i32);
	}
}
