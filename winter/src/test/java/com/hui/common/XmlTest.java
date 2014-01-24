package com.hui.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class XmlTest {

	@Test
	public void xmlInvalidChar() throws IOException {
		byte[] ba2 = new byte[] { 60, 114, 62, 60, 99, 32, 100, 61, 34, 115,
				34, 32, 110, 61, 34, 106, 31, 34, 62, 60, 47, 99, 62, 60, 47,
				114, 62 };

		String ba2Str = new String(ba2);
		
		Files.write(Paths.get(".\\invalid.xml"), ba2);

	}
}
