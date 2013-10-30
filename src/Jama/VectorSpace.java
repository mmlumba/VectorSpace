package Jama;

import java.io.*;
import java.util.*;
//import java.text.*;

public class VectorSpace {
	
	//public static List<String> readLines(yelp, UTF-8);
	
	public static void main(String[] args) {
		
		try{
			File yelp = new File("yelp_reviews"); //imports yelp file
			Scanner scan = new Scanner(yelp); //scans file
			
			HashMap<Integer,Integer> review_to_rating = new HashMap<Integer,Integer>();
			HashMap<String,Integer> word_to_id = new HashMap<String,Integer>(); //this map will assign an integer index to each word type in the entire corpus.
			HashMap<Integer,Integer> wordindex_to_count = new HashMap<Integer,Integer>(); //this map will assign to the word index w_i(w) of word w the total count of the word type w in the corpus
			int n = 1; //n remembers the largest assigned index to any word
			String w = ""; //word
			//int nwt; // total number of distinct word types in the corpus
			//int nr; //total number of reviews in the corpus
			//int count = 0;
			int id = 0;
			int rating = 0;
			//String nf;
			//ArrayList<Integer> wordid = new ArrayList<Integer>();
			while(scan.hasNextLine()){
				String line=scan.next(); //scans for divider; not important
				id=Integer.parseInt(scan.next()); //review ID
				rating=Integer.parseInt(scan.next()); //review rating
				scan.nextLine(); //skips whitespace line
				String review=scan.nextLine(); //reads review
				String words[]=review.split(" ");
				//String joinedString = StringUtils.join(new Object[]{review}, " ");
				//String[] elements = review.split(" "); //splits words from each review
				//System.out.println(Arrays.toString(elements));
				for(int j = 0; j < words.length; j++){
					w = words[j];

					if(!word_to_id.containsKey(w)){
						word_to_id.put(w,n);
						n++;
					}
					
					if(!wordindex_to_count.containsKey(word_to_id.get(w))){
						wordindex_to_count.put(word_to_id.get(w),1);
					}
					else{
						wordindex_to_count.put(word_to_id.get(w),wordindex_to_count.get(word_to_id.get(w))+1);
					}
				}

				review_to_rating.put(id,rating);
				
			}
			
			//System.out.println(review_to_rating);
			System.out.println(word_to_id);
			//System.out.println(wordindex_to_count);
			scan=new Scanner(yelp);
			
			//Matrix p; 
			int y = id+1;
			int z = word_to_id.get(w)+1;
			Matrix m = new Matrix(id, n);
			while(scan.hasNextLine()){
				String line=scan.next(); //scans for divider; not important
				id=Integer.parseInt(scan.next()); //review ID
				rating=Integer.parseInt(scan.next()); //review rating
				scan.nextLine(); //skips whitespace line
				String review=scan.nextLine(); //reads review
				String words[]=review.split(" ");
				for(int q = 0; q<words.length; q++){
					w = words[q];
					//m.put(id,word_to_id.get(w))=m.get((id,word_to_id.get(w)))+1; 
					//m.set(id,word_to_id.get(w));
					//m.set(id,word_to_id.get(w))+1;
					m.print(2, 20);
				}
				//double s = 0;
				//p = new Matrix(0,z);
				/*nf = NumberFormat.getInstance();
				for(int r = 0; r<words.length; r++){
					System.out.println(nf.format(words[r])+";");
				}
				NumberFormat nfz = NumberFormat.getInstance();
				nf = NumberFormat.getInstance().format(id);
				String idz = Integer.toString(id);
				Number nf2 = nfz.parse(idz);*/
				//m.plusEquals(p);
				
				//System.out.println("Review ID: " + id + "\nWord: " + word_to_id.get(w));
			}

			
			
		}
		catch(FileNotFoundException fnfe){fnfe.printStackTrace();}
		catch(Exception e){e.printStackTrace();}
		}

	}
