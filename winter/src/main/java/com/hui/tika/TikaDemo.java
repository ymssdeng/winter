package com.hui.tika;

import java.io.InputStream;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;

public class TikaDemo {

	public static void main(String[] args) throws Exception {
		AutoDetectParser parser = new AutoDetectParser();
		BodyContentHandler handler = new BodyContentHandler(50000);

		TikaDemo demo = new TikaDemo();
		InputStream fis = demo.getClass()
				.getResourceAsStream("Tamale Server Refactor Investigation.docx");
		Metadata  metadata = new Metadata ();
		parser.parse(fis, handler, metadata);
		
		System.out.println(handler);
		return;
	}

}
