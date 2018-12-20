package com.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzBuzzController {

	@RequestMapping("/fizzbuzz")
	public String fizzBuzz() {
		return FizzBuzz.getOutput().toString();
	}

	@RequestMapping("/envdetails")
	public String envDetails() throws IOException {
		
		StringBuffer sb = new StringBuffer();
		
		//Create an absolute path using ${HOME} and read from there
		String homePath = System.getenv("HOME");
		sb.append("HOME [").append(homePath).append("]");

		String propertiesFilePath = "/my-resources/test/fizzbuzz.properties";
		File propertiesFile = new File(propertiesFilePath);
		
		sb.append("PROPERTIES_FILE [").append(propertiesFile.getCanonicalPath()).append("]");
		sb.append("CONTENTS").append(new String(Files.readAllBytes(Paths.get(homePath, propertiesFilePath))));
		
		return sb.toString();
		
		
	}

}
