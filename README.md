# Scrabble-Words-Finder
This applications takes a scrabble rack as user input, and creates a list of all legal words that 
can be formed from the letters on that rack.  The list is displayed as the output. 
The problem uses a dictionary to validate words.
For example, if input rack had the letters C M A L, possible words will be calm or clam, and also shorter words from a subset of the 
letters, e.g., lam or ma. 
The program will display all such words, with the corresponding Scrabble score for each word, in decreasing order by score. For words 
with the same scrabble score, the words must appear in alphabetical order. Here are the results for a rack consisting of "cmal" (using
the sowpods dictionary):

Rack? cmal
We can make 11 words from "aclm"
All of the words with their scores (sorted by score):
8: calm
8: clam
7: cam
7: mac
5: lac
5: lam
5: mal
4: am
4: ma
2: al
2: la

Note that "aclm" above is just a version of the rack with the letters rearranged in alphabetical order.

The program takes an optional command-line argument for the dictionary file name. If that argument is left off, it will use 
the Scrabble dictionary file sowpods.txt (see assignment files) from the same directory as of the program. If the dictionary
file specified (either explicitly or the default one) does not exist, the program will print an informative error message 
(that includes the file name) and exit.

The initial program output will be the message:

Type . to quit.

Then the program will run in a loop on the console, printing the prompt "Rack? " (as seen in the earlier example) and reading and 
processing the rack user entered, until user tell it to exit. User can tell the program to exit by typing in "." at the prompt
(i.e., a period). 
I am not using a command such as "quit" as the sentinel, since that could be a legal rack.

The program works on both lower-and-upper case versions of dictionaries, but all processing will be case-sensitive. 
E.g., if the dictionary given has only upper-case versions of words, it will find words from a rack such as "CMAL",
but won't be able to find any words from the rack "cmal".

The Scrabble Scores are decided on the basis of the following table
(1 point)-A, E, I, O, U, L, N, S, T, R
(2 points)-D, G
(3 points)-B, C, M, P
(4 points)-F, H, V, W, Y
(5 points)-K
(8 points)- J, X
(10 points)-Q, Z
