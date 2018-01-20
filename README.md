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
I merged everything together on [tio](https://tio.run/##7Vhbb9s2FH62fwXrYbDUumrXtyVN2iBYsQK9YWmxh7ZAaIm22ciUR1JJjM6/PTvkOdTNSp0E3R62BYhlk4fn8p0r9YWf84fFSqgv2dnPV1dyuSq0ZV9gNSmtzJMjrfn6lTR2f7i1d1zkuUitLFTP5jVn3q4cPc97tk5SrpTQPTtpodJSa6EsyAxff@Vm8Zqvbkq@k5TbYinT5Mg/fhMzAaup6DmjxVxcJq@5TRe92uL@O26t0IDMcLgqp7lMWZpzY9hrLhX7OhwOHt2/Pxyw@@yDyoTO11LNmbG6TG2pBSuNyJgtmClXnrtdCGa1EA2SYsY4@/o8l@qMvddSbBLHzv0/Au7GclvJdNtvikx4uSjYSX4PTM95XjquhQaB3AmShimg9SSP4LMDyNMTq0HXQzy532J4lOdOLadsupB5Bgc8LwNLwHvBz0UtgHEDBqy0mMlLOrVMKqktx5HMSWXIYcW/rcCxFtwK0wbGHdiwC2kXXrO5PAe10G5QSloUyvDz@YprvsRtXGn8EdMf/O6m0jUIiWIAeDAYOBMTFHDAlLhgXQgPI1XmebxfEVdoIf1WkMMJT71pw51lxpu00sW5zMCBF4XOmFQQOG65i0HL0PcF4@eFzFjqMPPRV04fGg80AOg8eS40ss95Clgp4JyJSwb@qwSCD22BDBfFBZtxPOH1WMDmVIBRVoPjNUR0wiKZiMRv77ExChtPkO8ee8KWgiuD7HzEjD2Bk1hxJWDyNZxif5TCuHoS9/nQkW@5sOIDGPEsax3wamydcHYty3QRIvsa24iTFpCcbhmcLxsHLly0ZwDZhBWwqC@kEQBXDp@RtIA3eCFbM3EJZVNkcRVbVDumRZEDNo5FxDAbPF@HnUXFKfhAaIR@OjjwJEku1NwuopgIBqSiD1AogEswXhyp7ERYH5YTfwqD08fbgOQpcWldHB0vwMvEG2IGvYgyyZXsAfsJGYTA9nJKK17OjqYG3Bc1mU1cVWMPD33s18mEHEjbitFctA/HicMkYNEU3k6W44VIzwz6RDZKInQACyXZ1Qxv0f858s/nSK8/Ap@thLkuN8LJ75sgLt5idg8KM@TGd0iKRkyHWSgpZm@AOZ/mIro@zuNkyVeR75wuVeCZVBZ3wz/2dgySQv8CgEUetp6ceAEnMI4dA@Oipe0MmCK0j/uqe9YB819JEZxQvpkkMK15E3wrrqlvnzIRHo935o6PTZyfCEI3b6O1YOayhPEPFqdrdOisVH5Od8pKleZl1hluuFpTDHgW3u/dkQl1q0e0OgN9ABjBdbqokg@pG@k3YV7H9vxo@pKSBHXTsi9dGjkaJ3L2TgvfXaifoAjfIGAlpuyrmxLuR3ECu4Iv4csMMoaDFa00I8tqi7w1pD92KUrpnfWBTNvVNm9bGWrLdyruhLSVd/puuleGegR1xaDn4qCLwobYBVNEsjUOswWMNDeYzzfdgt6W3ZqqHUsakutB4baTMSTElvhbtkUoukLbG8x8qqiHOzgEunRH802jwbVlfrPbdSdBQol0cTg1BqPHOwYiUliaXbreBavUCboBVLvhuUP/74Gl0zX7sHk7pZkQ@lfQkdpjW7mecun7Wl0pb9xM6CaMrW3sfo3jNmqc1W9c/PW/pR0e/DhGPtAO/TegHn@OtzMs8KnKcW/5JvR66na42YbXQ@GGOvAQdwrP46rgtOYfXGuWIFKPKpFvK0twRISyP35mXM@pZXQKlCtBW7dnLB9eptVrFtEbJmZSIqWF6GQNt65lIlVoNvT2BmJqueQqCz8PGH3z9xkJVXkUPXtKRIfRsz1IufhPeIYY8z8QjTj@9Mk8AHLnrsPkQTwiNC6gsMMt0KQJdP03UNjrlkd6FaVNVoCAjUaHI2o45CcIRWc3HHYt4RX8Ij8M6AUVAIjPg44xCW1EjkVoja4P36MNIjC1Olv65CrCjcFg9FKlBaCeWhiH@BxC8QMk7CkAwtDiU7pO0EVrwk6rUb9B4IuFKw28KklE5q7OoD07RTjZU4wuPAY9sTHH7pphAoYDx1oq9xprUDXugCyhBbgFPOa6KFfRiDY6jvDabtG61eDngQFlQPGIGARUUw5AjQCZ0R5q5ZzgW2oo4LUD@jyACrjRBYRHo5MyTYUxM5gb1vjKoSoSe@zjj@bziG74AYQNE@41xM0lvOAQsOF2uIs5PqbQVc72G@YG32/Z3KrOdzd8VpTqbzR8JtVdLcfwDXbvFvq7D@nWTQwFQjEULdETHMSo@KIyQZuGGpmY8TK3e//OlG4YuhnSx8Z1l83VFYYryPczS@NNQ1hqETwZklr2Lw), mess with the contents of the 'Input' area to have something like
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

