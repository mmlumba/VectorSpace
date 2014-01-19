VectorSpace
============================

Purpose
This Java file uses VectorSpace.java to read tweet information from one or multiple text files (generated from the ReadTwitter repo: https://github.com/mmlumba/ReadTwitter)

----------------------

(General) Logic of how the program works:
* Put in all the documents from TwitterAPI (corpus)
* Scanner scans everything
* Hashmap associates each word count to the appropriate word
* String tweet scan function separates each document
* Matcher looks at the content in each document and distinguishes words from the document
* while loop and for count goes through each word and adds the word to the hashmap by 1 if it doesn't exist, otherwise it increments the word by 1 to increase its count
* Matrixwriter prints out the word counts, words, and documents into a matrix that's in a text file

----------------------

Prerequisites:

* Java JDK 1.7
* Java JRE 6 or 7
* Java IDE (Integrated Development Environment) such as Eclipse or Maven

----------------------

How this works (in main class):

* One (or multiple) lists of documents are defined as new File variables
* The array documents is initialized with these files
* The words used to populate the rows of the matrix are chosen from all the documents and given counts within the generateWord method
* The matrix is generated using the generateMatrixTable method and printed out

----------------------

Sample run:

```

coming soon!


```
