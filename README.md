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
I merged everything together on [tio](https://tio.run/##7Vptbxu5Ef4s/QqeD4VWsbK@BP1Sv92l9w7kpYBzvQ@5AKFWlMRktdSRXDtG6t@ezgzJJfdFtuKg16Jt4EjaJTmceWb4zJC7b/klf6i2onq7ePeXjx/HY7nZKm3ZW7if11aW@ROt@fVTaezJjjYz0PCtKktRWKmqgcbvxO@1GLi/Y5JCVUWttagsiA0/f@Jm/Yxv9@0@3NVYLfgmKKs0WLLDxl0q3w@AF1ts4OXQdBcFryqhB0ZpsRLv82fcFutb2v/GrRUaZh2Pt/W8lAUrSm4Me8ZlxT6MR/6msdzC16WSC7aBpuzCalmtXr1mXK/MFHuOXmopmMWPM1aJK4bX2fQEWuDP6muWeWWZKXwXfyO7uDZWbHJZTZ2okVeLFWqz4dUiXJ4x/wvcttnKUmQH2denvtN59vUxXyym/4Bv8KoFNQ1dGMF1sZ5Of/vNHEL3K6UX5/nh9AB0w7mu1iCIZabI19w8F@9tFrQYeb1UbfMt2Guzg/MDsgiaCABWygrthcEVjHwKV5nv4JEHuNz3WceY3DdkKMKrMpJLln3hG3wHE9Xp6VNWmWsYjQ5@rgoFwVtYVhu@Ejn7xQj2BgBhzuI3zCqGl5zh9Yy9CSClHWDC4h0DNVwvJg3z3QQMAe3ZGwcnO91qsZTv3bCVsIyXJY0xzK65xZCBeLuSdg3Xgq3kpaiYGxMwHKFoWeFSwaubcYqsRwtwC3istKq32YFv6DiCtO31xbvBzyMDyoDimRcQUC04AHUAyBwcO63kMsMwzuFWhgIi/kMOcPPnS6Vh7uzgoi4KYcyyLstrhFssyHyUc8xe/cm8PpgxJ9RjcCNKmH//CX7gEK6L4Mw7ZLuvOfDWu5PE2OD5rsXh/meavVR19a8zeymr@9rtQjdYffekv1I4UyRTjEEwuwmB9kRr6hkxX@4m8PAFbRI1FmLJ69Ie/3cu58RQ8gB@wH9Y1@Px0YMHY/aA/ZUbyCOQjEqxgUTLMbMxhfphushPj@b6HPs1Pz58A/z4jn2Ji9F5Z3qDdpvGpAoURpUo/6BJWthaAw5W1wJtD7HCFpC9KoWmgaKLaybeQwlxy5zNcmgmJjxNAiiJgBuVkQuBhgRNdkv1MdLIVHPnNg7JxFgCo4Hey23MG3LFVqtLiTzjvNGf@LmyEKwv1xJDWdcFoCMwEhAKu0YoHhq@FDn0hb@jsU/2vhKgeWGdjkfowhHIewmTaqVsMNdGz2HzrxLUn4tgb6hevhSbrb3OwOAaSL9MIpJYMsexR@NR6H6K8z5XC3HO1qAhUniY/1tQ2QoEzE@BXW/8eF@wuOKD@MWC4TnKgPQQpOdemROKzkbykwWFe4JpGmKgandCRh/fbLnmG9e3CTYYAt4T2rouLij7MXnFTSsmE4@nk82Yglv6SgILLDlQZ9vcuVKl4BVCmbEkIzoE/NyIARQV26wCWNnDc4bfTZabsa@m01zp70H4j8JmgB50IYLugqeWWSjw0ENZIMBaeM5LjMXrmy7O3zbLqMEB4@B2CO7Gm1bn3XB/HsQNKeyP84cEE8K8lWcReIeSRz@j2buYvQg0AasrmIO29OwYIAkA15FD3gPR3fdBTz8zmUO6meDVZNpCk7O4Twk8FVVx415NnJjJzImA3pPX0zaUUcqpw/CceVIMmDoZe0SvH@f6A5Iz2lfETdjpOZTPDbBu/5Vzg3vHbOohpvwUEtQv1ULo8hqViGRZG1d6mHpLuyjHekIkXSiHpW7o0mlkU1wzYFmbUC95WaM8pWEqbp3T0EQPnQeGuqVk@PMydqVFVHna8eTlh4folQZrmlTAE3CiJ/ICdkIL2P@SMJ/31/xSJDNwpF0fKG7UJjB3a/vsHTtjkcaD9DupHLvfdEsNhw8oJG0/iKmRbiT/Qr6lxpAeGs5K8Yx5IqPrmVv/LpZ6hwgUUl1Cu48dDuBC1SV4vDQKkyYnccFx9zEydHee3tXftd6Kyoy1g6aPkrv/74WJKj7YuLfTdoi1PwzEMKA18cCQ0P5JyM/YvmsrqXgcgmeBMfxdJxBuByLw95ulf5as00@ojUTPo8kqfQk7FTo6KtD/RK31/KEhK1xCU5dCO@ElL4QjsYV4zyhx@enQx4rkrdUVrFAdszr6fy4E5nugKw1snft05PaIEzcX5CQSe8wesw3Aa0gahdeE2nG@RqgHvMSChEEqMZiwpvlgGdJ1d1qVQIHVCinUoNsfLdrUsA1Ty9usuru2oVq6V8kAGJ1dj1hMd1eQSWGDiFmns4stvDRyI0uun4pqBYv2jJX048Xy@99rXl743bITkgUhIGDm2ZaOY/CkqyPHx2ruxLljr/FoqOuhDw8YgvJbI3D3efSAvnxqDfXlQHLNQ7/w7eIFdzQxVrp9SMtjJoW/cdQc3aVEGUs@coHfFrP02KNZjKFQ7pfOzU563JiFazGk4GGrGJBkJUSsiVvZPR9Hc26xOPYI9o6jteGMDkX@3RMNeQIWtltrmfPQYTtY/BTd23D9yO0cmvqIRCdslK9gTxLn82d6CLrvecaquiybQ70wbFunw2ast3G5S@Vpa2fT80/Lo76R5ks2VsNyTxrH0gc5l3zbKNRig@hqqvmDq@d16nj0OtIk8IaTZrYlFUzenX5FTCRRHY9TpT12RETTHuKhHId4aHvtUfIAgGB2yzri3MM3ZiZ/0eSzE085dOMx@bChndbSZw93kISLlH5KTPSBXUPfNe102azhbrbcWfvEafux@CgfUOERIOFaI0P2zT6H3WJrQ9kJM7eVTIKybUcTt11uutm9Q5fJtqU5ZHTHN/9P8n9Ykh/0QhDzqWcX/0EZPqTOwbywK8F7dGIR2@bhW7PIC/2dO4XPPjdjzfxpPSWe5AneYEYaqgbG/azRORq6NXV4CR3B6TL@Acab1nlyJ5JazzaacPpfWdWuirptXdeGzjzi8dj9VnkWDrTuWO7Q7VKq2hDjm87GND2RIRmhN9jZFhf@4d6YHiOZrarInuSJDu0DWhHhSWOPc7rWMV3CIDPmTt1C97Y99@OXOEmLYUajtnCst55yY7MOBe0kFn8i2qGWpsZ@GRCNp32iUvVq3TyDvALGFenJqago2KEpVN/u2U5SaZt2ae0G7ld@o2@bAhwPMBuUL120nMWzT2oORQjBkJQBgZEuG9w8xoBSrJN21mtJ4TpaKs2yDtset0s4Jy15iyFO@6QsHVcmx7hpuKQz@QXiBp8E6tuT6L2rP5vqI9HvonmvZueg@aRD1V2jY3z3depgsuOpgIBYvQ4nMh2Ox4CcixJ4CX@BvK2omrOcVLjjVDrOMSKEa58yuyN2nqTtRVgdkuqR8R6c1dBnFwXRgBCpTctLbgVrLSDvibu5a@9lty879ZdlQ0AXsoJ8KjikkpdSO1eqCqCjbaDzn9vRQKaR1ohy6azmNiaeCTLLxEvcyNXa4vFpODMotDKG/dmf90Nqmlh8bqPxQ@KHmOBZAki7xjce4PdVxeYcH7KNXKzAMsOXm@ai4JgqcTwOxw0mvkSw5ca4HSs3bUDJ7Sh/hQ8/8dTKy/Taz8VKVlWzCQZvL@uKclGe0GCbwlK83ct62RQKKkpiWXxtL3@rJErO/CsatDLvwWSfSGQ0TUdLLTZQP1FgUJ8uy6VL/UdhDVUXpQJUKCldqVhjhZqMVhsPLJKWa8kz@vgLjwPUcmnAWWnFttRqgyIf0eaGKkB/JrGot1AbuBc30vqPpFEN2K@zUFB3YfMgsP3gNg54QVoNFWfgPSt5ybbKSNIDH83R805SG6KtmTDKezwkiXZNw4qEx46fA3jYhXnOwcrntkrHV1WovKupIgwzFhsfxzqqDAXUM27X@UZWGQ5JD0VSETg21juOg7Byg/FfnYQ1cALXp14w/D48TDZpJLxYc/3EZlEwnrRM2RdnTr5vlk2@j28FdXcsMj5/vfn40b3OBkFIO5BkixtutTo8HvsXl@w/AQ), mess with the contents of the 'Input' area to have something like
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

