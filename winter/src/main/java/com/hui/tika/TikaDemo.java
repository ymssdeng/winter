package com.hui.tika;

import java.io.FileInputStream;
import java.nio.file.Paths;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.junit.Test;




public class TikaDemo {

	@Test
	public void testExt() throws Exception {
		AutoDetectParser parser = new AutoDetectParser();
		BodyContentHandler handler = new BodyContentHandler(50);

		FileInputStream fis = new FileInputStream(Paths.get("E:\\tmp\\Tamale Server Refactor Investigation.docx").toFile());
		Metadata  metadata = new Metadata ();
		parser.parse(fis, handler, metadata);
		
		return;
	}
}
