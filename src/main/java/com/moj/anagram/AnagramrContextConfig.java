package com.moj.anagram;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

import com.moj.anagram.service.AnagramService;

/**
 * @author Mian
 *
 */
@SpringBootApplication
@ComponentScan("com.moj.anagram")
public class AnagramrContextConfig implements CommandLineRunner {

	private AnagramService anagramService;

	@Value("${spring.application.dictionary.location}")
	private String dictionaryUrl;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new SpringApplicationBuilder(AnagramrContextConfig.class).web(true).run(args);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... strings) throws Exception {
		URL url = new URL(dictionaryUrl);
		anagramService = AnagramService.getInstance();

		InputStream is = url.openConnection().getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		Stream<String> stream = reader.lines();
		List<String> dictionary = stream.collect(Collectors.toList());

		anagramService.loadDictionary(dictionary);
		System.out.println("dictionary loaded");
	}
}
