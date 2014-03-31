package org.apache.commons.io;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VectorSpace {
	
	//public static List<String> readLines(yelp, UTF-8);
	
	public static void main(String[] args) {
		
		ArrayList<Document> docList = new ArrayList<Document>();
		HashMap<Integer, String> uniqueWordMap = new HashMap<Integer, String>();
		
		try{
			File yelp = new File("yelp_reviews.txt"); //imports yelp file
			Scanner scan = new Scanner(yelp); //scans file
			
			
			HashMap<Integer,Integer> review_to_rating = new HashMap<Integer,Integer>();
			HashMap<String,Integer> word_to_id = new HashMap<String,Integer>(); //this map will assign an integer index to each word type in the entire corpus.
			HashMap<Integer,Integer> wordindex_to_count = new HashMap<Integer,Integer>(); //this map will assign to the word index w_i(w) of word w the total count of the word type w in the corpus
			int wordListCounter = 0;
			
			while(scan.hasNextLine())
			{
				HashMap<String, Integer> wordFreq = new HashMap<String, Integer>();
				String line = scan.nextLine();
				/**Example Match: ($*$*$*$*$ 9142 5)**/
				Matcher r = Pattern.compile("(?:\\$\\*?)+(\\s\\d+)(\\s\\d{1,5})").matcher(line);
				
				if(r.matches()){
				
					int id = Integer.parseInt(r.group(1).trim());
				    int rating = Integer.parseInt(r.group(2).trim());
				    	
				   // System.out.println(id + ": " + rating);
				    			    
				    //Read next line of input as this contains the actually review
				    String review = scan.nextLine();
				    Matcher wordMatcher = Pattern.compile("([a-zA-Z]+[^\\s'])").matcher(review);
				    
				    while(wordMatcher.find())
				    {
					    int wordList = wordMatcher.groupCount();
					    for(int i = 0; i < wordList; i++){
					    	String word = wordMatcher.group(i);
					    	
					    	//if HashMap already contains word update count; otherwise add it
					    	if(wordFreq.containsKey(word)){
					    		int count = wordFreq.get(word);
					    		wordFreq.put(word, ++count);
					    	}
					    	else{
					    		wordFreq.put(word, 1);
					    	}
					    	
					    	if(!uniqueWordMap.containsValue(word)){   		
					    		uniqueWordMap.put(++wordListCounter, word);
					    	}
					    } 
				    } 
				    
				    Document doc = new Document(id, rating, wordFreq);				    
				    docList.add(doc);
				    
				    // Debugging purpose only
				  /*  for(String key : wordFreq.keySet()){
				    	System.out.println(key + ": " + wordFreq.get(key));
				    }*/
				}
			}
					
		//	System.out.println(docList.size());
			/*
			int n = 1; //n remembers the largest assigned index to any word
			String w = ""; //word
			int nwt; // total number of distinct word types in the corpus
			int nr; //total number of reviews in the corpus
			int count = 0;
			ArrayList<Integer> wordid = new ArrayList<Integer>();
			
			while(scan.hasNextLine()){
				String line=scan.next(); //scans for divider; not important
				int id=Integer.parseInt(scan.next()); //review ID
				int rating=Integer.parseInt(scan.next()); //review rating
				scan.nextLine(); //skips whitespace line
				String review=scan.nextLine(); //reads review
				String words[]=review.split(" ");
				//String joinedString = StringUtils.join(new Object[]{review}, " ");
				//String[] elements = review.split(" "); //splits words from each review
				//System.out.println(Arrays.toString(elements));
				for(int j = 0; j < words.length; j++){
					if(!w.equals(words[j])){
						word_to_id.put(w,n);
						for(int k = 0; k < words.length; k++){
							wordindex_to_count.put(n, count++);
						}
						n++;
						System.out.println(word_to_id);
						//System.out.println(elements[i]);
					}
					if(word_to_id.get(w).toString().equals(wordindex_to_count.get(w).toString())){
						count++;
					}
					else{
						
					}
				}
				//String rev = elements[0];
				//String rawr = elements.length > 1 ? elements[1]: null;
				//System.out.println(Arrays.toString(elements));
				//System.out.println("Number of Words in Review ID " + id +": " + elements.length);
				review_to_rating.put(id,rating);
				
				
				//String[] words = elements.split(" ");
				//ArrayList<String> rev = new ArrayList<String>(Arrays.asList(review));
				//System.out.println(rev);
				
				/*StringTokenizer st = new StringTokenizer(review);
				while(st.hasMoreElements()){
					System.out.println(st.nextElement());
				}
				ArrayList<String> rev = new ArrayList<String>(Arrays.asList(elements));*/
				/*List <String> reviews = FileUtils.readLines(yelp, "UTF-8");
				for(String yelprev: reviews){
					System.out.println(yelprev);
				}
				
				//String review2 = scan.next();
				//System.out.println(id);
				//System.out.println(rating);
				//System.out.println(review);
				//String something = Arrays.toString(rev);

				
			}*/
			
		//	System.out.println(review_to_rating);
			
			//System.out.println(rev);
			//System.out.println(rawr);
			
		}
		catch(FileNotFoundException fnfe){fnfe.printStackTrace();}
		catch(Exception e){e.printStackTrace();}
		}

	}
