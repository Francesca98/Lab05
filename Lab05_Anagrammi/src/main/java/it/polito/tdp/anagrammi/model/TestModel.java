package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		Model model = new Model();
		List<Character> car = new LinkedList<>();
		String string = "EAT";
		for(int i=0 ; i<string.length();i++)
    	{
    		car.add(string.charAt(i));
    		//System.out.println(string.charAt(i));
    	}
		List<String> result =	model.anagrammi(car);
		for(String s : result)
		System.out.println(s);
		
		

	}

}
