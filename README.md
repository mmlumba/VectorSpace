VectorSpace
============================
Logic of how the program works:
1. Put in all the documents from TwitterAPI (corpus)
2. Scanner scans everything
3. Hashmap associates each word count to the appropriate word
4. String tweet scan function separates each document
5. Matcher looks at the content in each document and distinguishes words from the document
6. while loop and for count goes through each word and adds the word to the hashmap by 1 if it doesn't exist, otherwise it increments the word by 1 to increase its count
7. Matrixwriter prints out the word counts, words, and documents into a matrix that's in a text file