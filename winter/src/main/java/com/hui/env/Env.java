package com.hui.env;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Env {

	static final String dir[] = {
			"app",
			"aspect/eclipse",
			"aspect/spring",
			"aspect/jboss",
			"aspect/poj",
			"aspect/libs",
			"archive/com/reuters/src",
			"archive/com/reuters/doc",
			"archive/com/advent/src",
			"archive/com/advent/doc",
			"home/ymss",
			"repo/cygwin",
			"repo/db",
			"repo/github",
			"repo/mvn",
			"tmp"
			};

	public static void main(String[] args) {
		List<String> dl = Arrays.asList(dir);
		Collections.sort(dl);
		for (String e : dl) {
			try {
				Files.createDirectories(Paths.get(e));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

}
