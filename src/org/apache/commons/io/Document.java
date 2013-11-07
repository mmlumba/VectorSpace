package org.apache.commons.io;

import java.util.HashMap;

public class Document {
	private int id;
	private int rating;
	private HashMap<String, Integer> wordFrequnecy;

	public Document(int id, int rating, HashMap<String, Integer> wordFrequnecy){
		this.id = id;
		this.rating = rating;
		this.wordFrequnecy = wordFrequnecy;					
	}
	
	public int getId(){
		return this.id;
	}
	
	public int getRating(){
		return this.rating;
	}
	
	public int getWordFrequnecy(String word){
		return this.wordFrequnecy.get(word);
	}		
}