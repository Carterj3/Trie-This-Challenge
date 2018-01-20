# "Trie" This Challenge

Build a simple autocomplete application based on a [Trie](https://en.wikipedia.org/wiki/Trie) data structure.
 
### Requirements
Create an implementation of a Trie, implementing the algorithms required to support the following interface:
* `add(word)` => adds *word* to the trie, returning `true` if the word was successfully added and `false` if the word was already present.
* `contains(word)` => returns `true` if the trie contains *word* and `false` if it does not.
* `search(prefix)` => returns the list of all words in the trie that begin with *prefix*. 
 
### Guidelines
* The trie implementation only needs to support lowercase words
* Clever solutions are welcome and encouraged
* Implement in a language of your choice
* Include instructions as to how to run your solution
* A User Interface is not required for successful completion of this task (no penalty if you include one, however)

Fork this repository to implement your solution. When you are finished, submit a pull request containing your Trie implementation and any supporting code. 


### Instructions

#### Set-up

Install the Java9 JDK
https://docs.oracle.com/javase/9/install/overview-jdk-9-and-jre-9-installation.htm#JSJIG-GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A

Install Maven
http://maven.apache.org/install.html

Navigate to the root of the project (where pom.xml is stored) and use maven to package the application
> mvn package

Then use java to run the application
> java -jar target/trie-this-challenge-0.0.1-SNAPSHOT.jar

In the prompt type things like
`add word` to add a word to the Trie
`contains word` to check if a word is inside the Trie
`search w` to find all words beginning with 'w'


#### Can I just have a link?
I merged everything together on [tio](https://tio.run/##y0osS9TNL0jNy0rJtvz/v6A0KSczWSE5J7G4WME3MTNPoZqLEypYXJJYAqTK8jNTFHKBUhrBJUWZeenRsQqJRenFmiCVnMGVxSWpuXr5pSV6BUDJkpw8DSWP1JycfB2F8PyinBRFJU1rLs5artr//wE), mess with the contents of the 'Input' area to have something like
```
add this word
contains this word
add this word2
search t
```

And then after hitting the big run button that looks like a Cog the output will look like
```
>Successfully added the word: [this word]
>Successfully found the word: [this word]
>Successfully added the word: [this word2]
>Words starting with: [t] are: [[this word, this word2]]
```

