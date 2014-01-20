import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class VectorSpace {

	/**
	 * @param args
	 */
	
	private static HashSet<String> wordSet = new HashSet<String>();
	private static HashMap<Integer, HashMap<String, Integer>> documentMapSet = new  HashMap<Integer, HashMap<String, Integer>>(); 
	
	
	
	public static void main(String[] args) {
		
		File doc1 = new File("C:\\Users\\Marian\\Dropbox\\TwitterAPI\\2014tour\\paramore_australia_2014_01_02.txt");
		
		File doc2 = new File("C:\\Users\\Marian\\Dropbox\\TwitterAPI\\2014tour\\paramorefb_australia_2014_01_02.txt");
		
		File doc3 = new File("C:\\Users\\Marian\\Dropbox\\TwitterAPI\\2014tour\\schzimmydeanie_australia_2014_01_02.txt");
		
		File doc4 = new File("C:\\Users\\Marian\\Dropbox\\TwitterAPI\\2014tour\\tayloryorkyall_australia_2014_01_02.txt");
		
		File doc5 = new File("C:\\Users\\Marian\\Dropbox\\TwitterAPI\\2014tour\\yelyahwilliams_australia_2014_01_02.txt");
		
		
		//File[] documents = doc1.listFiles(); //Method that lists all the files within a given directory
		
		File[] documents = {doc1, doc2, doc3, doc4, doc5}; //Static array that lists all files separately
		
		try {
			generateWordSet(documents);
			generateMatrixTable(documents);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void generateMatrixTable(File[] documents) throws IOException {
		
		generateDocumentWordMap(documents); //for a given document, populate words and their given frequencies
		printOutMatrix();
	}

	private static void printOutMatrix() {
		
		for(String word : wordSet){
			//System.out.print(word + ": " );
			Set<Integer> keys = documentMapSet.keySet(); //gets the ID for the document
			for(Integer key : keys){ //gets the word "key" within the set "keys"
				if(documentMapSet.get(key).containsKey(word)){
					System.out.print(documentMapSet.get(key).get(word)); //if document has word print out its frequency
				}
				else{
					System.out.print("0"); //else print 0
				}
				System.out.print(" ");
				
			
			}
			System.out.println(); //prints matrix
		}
	}

	private static void generateDocumentWordMap(File[] documents)
			throws FileNotFoundException, IOException {
		Integer count = 1;
		
		for(File doc : documents){
			
			BufferedReader reader = new BufferedReader(new FileReader(doc.getAbsolutePath())); //BufferedReader reads absolute path from document array OR document listFiles
			ArrayList<String> tweetList = new ArrayList<String>(); //cache of tweets for a document
			
			String tweet = ""; //initializes tweet variable
			
			while(((tweet = reader.readLine()) != null )){
				tweetList.add(tweet); //captures each line for analyzing
			}
			
			
			HashMap<String, Integer> wordCount = new HashMap<String, Integer>(); //word frequency in general; variable to hold word frequencies
			
			try {
				
				getWordCountFromTweetDocument(tweetList, wordCount); //lists all word counts for a given document
				
				/*for(String key : wordCount.keySet()){
					if(wordCount.get(key) > 0)
					System.out.println(key + ": " + wordCount.get(key));
				}*/
				//System.out.println(wordCount.size());
				documentMapSet.put(count, wordCount); //puts entry for document and its word frequency
				count++;

				
			}
			finally{
				reader.close(); //closes BufferedReader to prevent OutofMemory error :)
			}		
		
		}
	}

	private static void getWordCountFromTweetDocument(
			ArrayList<String> tweetList, HashMap<String, Integer> wordCount) {
		for(String word : wordSet){ //for each word in wordset
			
			for(String tweet : tweetList){
				if(tweet.contains(word)){ //if word is in wordset then increment by 1
					if(wordCount.containsKey(word))
						wordCount.put(word, wordCount.get(word) + 1);
					else{
						wordCount.put(word, 1); //else put 1
					}
				}
			}
		}
	}

	private static void generateWordSet(File[] documents) throws IOException  { //creates wordset
		// TODO Auto-generated method stub
		//goes through each document and aggregates a wordset from all documents
		for(File doc : documents){//populates from documents
			
			BufferedReader reader = new BufferedReader(new FileReader(doc.getAbsolutePath()));
			String tweet = "";
			
			try { //for each tweet, apply a pattern matcher to find a word
				while(((tweet = reader.readLine()) != null )){
					addWordToUniqueSet(tweet);	            	
				}
			}
			finally{
				reader.close();
				//System.out.println(wordSet.size() + " Total list");
			}		
		
		}		
	}
	

	private static void addWordToUniqueSet(String tweet) { //word is defined within wordMatcher from regex
		Matcher wordMatcher = Pattern.compile("([a-zA-Z](?:'\\s|'|\\s')?)+").matcher(tweet); //regex matches a tweet fits under the following criteria
		while(wordMatcher.find()){
			wordSet.add(wordMatcher.group(0)); //makes sure that unique words are NOT added multiple times for the columns
		}
	}
}