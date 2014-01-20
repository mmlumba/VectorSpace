	private static void printOutMatrix() throws FileNotFoundException, UnsupportedEncodingException {
		
		//PrintWriter matrixFileWriter = new PrintWriter("matrixrawr.txt", "UTF-8");
		System.out.print("word |");
		
		for(int i = 1; i <= documentMapSet.size(); i++){
			System.out.print("D" + i + "|");
		}
		System.out.println();
		
		for(String word : wordSet){
			System.out.print(word + " |" );
			Set<Integer> keys = documentMapSet.keySet(); //gets the ID for the document
			for(Integer key : keys){ //gets the word "key" within the set "keys"
				if(documentMapSet.get(key).containsKey(word)){
					System.out.print(documentMapSet.get(key).get(word)); //if document has word print out its frequency
				}
				else{
					System.out.print("0"); //else print 0
				}
				System.out.print("|");
				
			
			}
			System.out.println(); //prints matrix
			System.out.close();
		}
	}