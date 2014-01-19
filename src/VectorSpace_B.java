//import Jama.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;

public class VectorSpace_B {

	/**
	 * @param args
	 */
	
	public VectorSpace_B() throws IOException {
		File doc1 = new File("paramore_happy_2013_12_08.txt");
		File doc2 = new File("paramore_love_2013_12_07.txt");
		File output = new File("output.txt");
		//FileUtils.write(output, doc1, doc2, true);
	}
	public static void main(String[] args) {
		ArrayList<Document> doclist = new ArrayList<Document>();
		HashMap<Integer,String> uniqueWordMap = new HashMap<Integer,String>();
		PrintWriter matrixFileWriter = null;
		
		try {
			File timeline = new File("paramore_2014_2014_01_02.txt"); //document input
			Scanner scan = new Scanner(timeline); //scanner from file
			//HashMap<String,Integer> word_to_id = new HashMap<String,Integer>(); //this map will assign an integer index to each word type in the entire corpus.
            //HashMap<Integer,Integer> wordindex_to_count = new HashMap<Integer,Integer>(); //this map will assign to the word index w_i(w) of word w the total count of the word type w in the corpus
            int wordListCounter = 0; //initialize the count of the word
            int documentId = 0; //initialize the documentID
            while(scan.hasNext()){//this scanner scans the document and puts it in the hashmap for wordfrequencies
            	
            	HashMap<String,Integer> wordFreq = new HashMap<String,Integer>();
            	String tweet = scan.nextLine(); //intializes each string as a new line from the scanner of timeline
            	documentId++; //adds 1 to each documentID for evey tweet
            	Matcher wordMatcher = Pattern.compile("([a-zA-Z](?:'\\s|'|\\s')?)+").matcher(tweet); //regex matches a tweet fits under the following criteria
            	while(wordMatcher.find()){ //wordmatcher looks in each tweet
            		int wordList = wordMatcher.groupCount(); //groupCount is an indicator to when it stops looping; wordList is total count of words for the given tweets
            		for(int i = 0; i < wordList; i++){ //wordList iterator checks to see if word
            			String word = wordMatcher.group(i);
            			if(wordFreq.containsKey(word)){
            				int count = wordFreq.get(word);
            				wordFreq.put(word,++count); //if the word is already in the map then it adds 1 to the count
            			}
            			else{
            				wordFreq.put(word,1); //else the word is initialized with 1 in the hashmap
            			}
            			if(!uniqueWordMap.containsValue(word)){ //adds ID to the word if it doesn't already have an ID; word unique list
            				uniqueWordMap.put(++wordListCounter,word);
            			}
            			
            		}
            	}
            	Document doc = new Document(documentId, wordFreq);				    
				doclist.add(doc);
            }
            
            matrixFileWriter = new PrintWriter("matrix-.txt", "UTF-8");
			
			matrixFileWriter.print("word");
			for(int i = 1; i <= doclist.size(); i++){
				matrixFileWriter.print("| D" + i);
			}
			
			matrixFileWriter.print(" \\end");
			matrixFileWriter.println();
			for(String word : uniqueWordMap.values())
			{
				matrixFileWriter.print(word);
				for(Document doc : doclist){
					matrixFileWriter.print(" " + doc.getWordFrequency(word));
				}
				matrixFileWriter.println();
			}
            
            
		}
		//catch (FileNotFoundException fnfe){fnfe.printStackTrace();}
		catch (Exception e){e.printStackTrace();}

	}
}