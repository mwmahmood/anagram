package com.moj.anagram.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.moj.anagram.service.AnagramService;

public class AnagramServiceTest {

	@Test
	public void testConstructor() {
		List<String> dictionary = new ArrayList<String>(Arrays.asList("one", "two", "tow", "three", "four", "there"));
		AnagramService service = AnagramService.getInstance();
		service.loadDictionary(dictionary);

		assertEquals(4, service.getIndexedDictionary().size());

	}

	@Test
	public void testGetAnnagram() {
		List<String> dictionary = new ArrayList<String>(Arrays.asList("one", "two", "tow", "three", "four", "there"));

		AnagramService service = AnagramService.getInstance();
		service.loadDictionary(dictionary);
		assertEquals(2, service.getAnagrams("two").size());
		assertEquals(2, service.getAnagrams("tow").size());
		assertEquals(2, service.getAnagrams("there").size());
		assertEquals(2, service.getAnagrams("three").size());
		assertEquals(1, service.getAnagrams("one").size());
		assertEquals(1, service.getAnagrams("four").size());
		assertNull(service.getAnagrams("xxxx"));

	}
	
	@Test
	public void testGetAnnagramWithCaptials() {
		List<String> dictionary = new ArrayList<String>(Arrays.asList("one", "two", "Tow", "three", "four", "There"));

		AnagramService service = AnagramService.getInstance();
		service.loadDictionary(dictionary);

		assertEquals(2, service.getAnagrams("two").size());
		assertEquals(2, service.getAnagrams("tow").size());
		assertEquals(2, service.getAnagrams("there").size());
		assertEquals(2, service.getAnagrams("three").size());
		assertEquals(1, service.getAnagrams("one").size());
		assertEquals(1, service.getAnagrams("four").size());
		assertNull(service.getAnagrams("xxxx"));

	}
	
	@Test
	public void testGetAnnagramWithSpecials() {
		List<String> dictionary = new ArrayList<String>(Arrays.asList("one's", "two's", "tows", "two", "three", "four", "There"));

		AnagramService service = AnagramService.getInstance();
		service.loadDictionary(dictionary);

		assertNull(service.getAnagrams("one"));
		assertEquals(1, service.getAnagrams("one's").size());
		assertEquals(1, service.getAnagrams("two").size());
		assertEquals(1, service.getAnagrams("two's").size());
		assertEquals(1, service.getAnagrams("tows").size());
		assertEquals(2, service.getAnagrams("there").size());
		assertEquals(2, service.getAnagrams("three").size());
		assertEquals(1, service.getAnagrams("four").size());

	}

}
