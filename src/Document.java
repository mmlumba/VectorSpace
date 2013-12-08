//port Jama.*;
import java.util.HashMap;
public class Document {
	private int id;
	private HashMap<String,Integer> wordFrequency;
	
	public Document(int id, HashMap<String,Integer> wordFrequency){
		this.id=id;
		this.wordFrequency = wordFrequency;
	}
	
	public int getId(){
		return this.id;
	}
	
	public int getWordFrequency(String word){
		
		if(this.wordFrequency.containsKey(word)){
			return this.wordFrequency.get(word);
		}
		return 0;
	}
}
