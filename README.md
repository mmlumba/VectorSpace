VectorSpace
============================
Logic of how the program works:
* Put in all the documents from TwitterAPI (corpus)
* Scanner scans everything
* Hashmap associates each word count to the appropriate word
* String tweet scan function separates each document
* Matcher looks at the content in each document and distinguishes words from the document
* while loop and for count goes through each word and adds the word to the hashmap by 1 if it doesn't exist, otherwise it increments the word by 1 to increase its count
* Matrixwriter prints out the word counts, words, and documents into a matrix that's in a text file