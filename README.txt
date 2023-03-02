There are two separate Java projects contained - Client and Server.
The Server needs to be run first before the Client can connect to it.
To run either program, run the Controller.java file in the "src/se311" folder contained within either of the project directories.
The main() method is included here for both.

If a Client is run and no search request is made within 5 minutes, the Server will disconnect from that client.
Additionally, if the Server is shut down while a Client is running, performing a search will result in an error.
This also goes for running a Client when the Server itself is not running.

Notes for grader:
	
	The only hiccup I encountered that persisted in my submitted program is using the object loader for the search decorators in the Client.
	I could not get this to work with the provided object loader since the constructors of the decorators require parameters.
	The abstract decorator class and footer decorator constructors take one parameter & the header takes three.
	The provided object loader does not give an option to accept constructors with parameters.
	Also, because the Output Decorator is abstract, using an object loader will not allow me to access the extended methods of the header and footer.
	I tried many methods and am quite unfamiliar with object loaders and decorators.
	I expect this will dock my grade, but I can explain what issues I was getting if you would like for clarification.
	I have included comments in the Controller.java file where this occurred in the Client project.

	I used Java 13 (Project SDK) while developing both of these projects.

config.properites:

	The config.properties file contains all the settings for input and output.
	This file can be found in the "src" directory within both projects.
	The Client and Server both have different properties.

	The config file for the Server gives the option to set the file names for file input/output and choosing the input/output type itself for KWIC.

	The InputFileName and OutputFileName values can be set to change what files the program reads from and writes to for KWIC.
	By default, these values are "SampleInputFile.txt" anb "SampleOutputFile.txt" respectively.
	I have provided both of these files, but the content or the file names themselves can be changed.

	If you would like to use files, change the Input and Output values to "FileInput" and "FileOutput" respectively.
	However, if you would like to input and output to console, change the Input and Output values to "ConsoleInput" and "ConsoleOutput" respectively.
	These values can be mixed-and-matched.

	The config file for the Client gives the option to decide whether or not output decorators are used for search.

	The search output can be decorated with a header and/or footer.
	To choose whether to decorate or not, set the value of AddHeader and AddFooter to "true" or "false" respectively.
	These can be mixed-and-matched.

Case-sensitivity and punctuation:

	The alphabetizing sorter implemented in kwic.Sorter.java for the Server ignores case-sensitivity to sort the lines.
	This means that uppercase and lowercase letters are treated equally.

	However, the search implementation in search.KeywordSearch.java for the Server is case-sensitive.
	This means, for example, that searching for the keyword "hello" when lines contains "Hello" will not provide any results.

	Additionally, certain punctuation is stripped from the stored lines during KWIC for the Server.
	This punctuation includes a period, comma, semicolon, question mark, and exclamation point [.,;?!].
	For example, "hello, how are you?" will be changed to "hello how are you".
	So, when searching for entered words, this specific punctuation can be omitted.

Soruces used to assist development:

	Java Serialization: https://www.studytonight.com/java/serialization-and-deserialization.php
	Array to ArrayList: https://www.geeksforgeeks.org/conversion-of-array-to-arraylist-in-java/
	String to Array: https://www.java67.com/2017/09/how-to-convert-comma-separated-string-to-ArrayList-in-java-example.html
	Regex replace in String: https://www.tutorialspoint.com/javaregex/javaregex_matcher_replaceall.htm
	Scanner for file input: https://www.digitalocean.com/community/tutorials/java-read-file-line-by-line
	Swapping elements in an ArrayList: https://howtodoinjava.com/java/collections/arraylist/swap-two-elements-arraylist/
	FileWriter for file output: https://www.geeksforgeeks.org/filewriter-class-in-java/
	Keyword highlighting: https://www.geeksforgeeks.org/how-to-print-colored-text-in-java-console/amp/
	Decorator Patterns in Java: https://www.developer.com/design/implementing-decorator-patterns-in-java/
	Get Time and Date in Java: https://www.javatpoint.com/java-get-current-date