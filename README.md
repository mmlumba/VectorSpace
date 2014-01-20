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

* A directory containing dataset files is initialized in the File doc variable 
* The generateWordSet method finds tweets, then passes those tweets into the addWordToUniqueSet class to find different words
* The matrix is generated using the generateMatrixTable method and printed out

----------------------

Sample run:

Note that this is only a snippet of what the program will generate. Actual file sizes are dependent on the number of unique words the program can find.

```

Are: 0 0 4 2 0 8 0 0 0 38 3
rQow: 0 0 1 0 0 0 0 0 0 0 0
rattling: 0 0 0 0 1 0 0 0 0 0 0
RADIO: 0 0 0 0 1 0 0 0 0 0 0
trytokeepitreal: 0 0 0 1 0 0 0 0 0 0 0
party: 0 0 0 0 1 0 0 0 0 0 0
King: 0 0 0 0 1 0 0 0 0 0 0
wuYzglVN: 0 0 0 0 1 0 0 0 0 0 0
twotplist: 0 0 0 0 0 0 0 0 0 1 0
paramoremusicom: 0 0 1 0 0 0 0 0 0 2 0
nailed: 0 0 0 0 0 0 0 0 0 1 0
thanks: 0 0 0 0 0 1 0 0 0 2 0
time: 0 0 4 0 0 0 0 0 0 1 2
You're: 0 0 0 1 0 0 0 0 0 0 0
UvyGJprOJu: 0 0 0 1 0 0 0 0 0 0 0
uDNpGBinWb: 0 0 0 0 0 0 0 0 0 0 1
DE: 0 0 0 0 0 0 0 0 0 1 0
amzing: 0 0 1 1 0 0 0 0 0 0 0
right: 0 0 0 0 1 1 0 0 0 1 1
LxTSLGiJNl: 0 0 0 0 0 0 0 0 0 1 0
BluJessica: 0 0 0 0 0 0 0 0 0 1 0
video: 0 0 0 0 4 0 0 0 0 0 0
ploughed: 0 0 0 0 2 0 0 0 0 0 0
essential: 0 0 0 0 1 0 1 0 0 0 0
ARE: 0 0 0 0 0 0 0 0 0 0 1
Exception' de: 0 0 0 0 1 0 0 0 0 0 0
jgL: 0 0 0 0 0 0 0 0 0 0 1
dawg: 0 0 0 0 0 0 0 0 0 6 2
meet: 0 0 2 0 0 1 0 0 0 1 0
maria: 0 0 0 0 0 0 0 0 0 5 1
EY: 0 0 3 0 4 0 0 0 0 2 1
shows: 0 0 0 0 0 0 0 0 0 1 0
few: 0 0 0 0 0 0 0 0 0 2 1
RiNe: 0 0 0 0 0 0 0 0 0 1 0
hits: 0 0 2 0 0 0 0 0 0 0 0
PROBABLY: 0 0 0 0 1 0 0 0 0 0 0
rge: 0 0 0 0 2 0 0 0 0 0 0
YOU: 0 0 3 0 0 0 0 0 0 0 0
big: 0 0 1 0 0 0 0 0 0 0 1
HjpVzLDj: 0 0 1 0 0 0 0 0 0 0 0
D: 0 0 9 3 12 1 0 0 0 17 12
F: 0 0 9 4 5 2 0 0 0 23 4
SammiMcshane: 0 0 1 0 0 0 0 0 0 1 0
G: 0 0 8 3 3 4 0 0 0 19 7
A: 0 0 19 3 19 8 0 0 0 57 12
truck: 0 0 0 0 2 0 0 0 0 0 0
B: 0 0 10 2 12 5 0 0 0 21 7
L: 0 0 11 5 13 3 0 0 0 25 5
Ey: 0 0 0 1 0 1 0 0 0 1 0
vdQWyUB: 0 0 0 0 0 1 0 0 0 0 0 


```
