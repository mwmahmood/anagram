package com.moj.anagram.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moj.anagram.service.AnagramService;

@RestController
public class AnagramRestController {

	private AnagramService anagramService;
  
    @RequestMapping(path = "/{words}", method = GET)
    @ResponseBody
    public Map<String, List<String>> getAnagrams(@PathVariable String words) {
    	
    	anagramService = AnagramService.getInstance();
    	
    	List<String> data = new ArrayList<String>(Arrays.asList(words.split(",")));
    	
    	Map<String, List<String>> anagrams = data.stream()
    											 .collect(Collectors.toMap(s-> s, s -> anagramService.getAnagrams(s)));
    	return anagrams;
    }

}
