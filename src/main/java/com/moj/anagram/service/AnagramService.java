package com.moj.anagram.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnagramService {
	private Map<String, List<String>> indexedDictionary;

	/**
	 * Private constructor to support Singleton Pattern
	 */
	private AnagramService() {
	}

	/**
	 * Singleton pattern Bill Pugh's solution
	 */
	public static AnagramService getInstance() {
		return SingletonHelper.INSTANCE;
	}
	/**
	 * 
	 * @param dictionary
	 */
	public void loadDictionary(List<String> dictionary) {
		this.indexedDictionary = dictionary.stream().collect(Collectors.groupingBy(s -> sort(s)));
	}

	/**
	 * 
	 * @param word
	 * @return
	 */
	public List<String> getAnagrams(String word) {
		return indexedDictionary.get(sort(word));
	}

	/**
	 * 
	 * @param word
	 * @return
	 */
	private String sort(String word) {
		char[] letters = word.toLowerCase().toCharArray();
		Arrays.sort(letters);
		return String.valueOf(letters);
	}
	/**
	 * 
	 * @return
	 */
	public Map<String, List<String>> getIndexedDictionary() {
		return indexedDictionary;
	}

	/**
	 * Singleton pattern Bill Pugh's solution
	 */
	private static class SingletonHelper {
		private static final AnagramService INSTANCE = new AnagramService();
	}

}
