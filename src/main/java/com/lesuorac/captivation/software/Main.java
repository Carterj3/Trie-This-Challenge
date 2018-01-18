package com.lesuorac.captivation.software;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.lesuorac.captivation.software.trie.Trie;

public class Main {

	public static void main(String[] args) {
		Trie trie = new Trie();
		
		try (Scanner sc = new Scanner(System.in)) {
			Pattern commandPattern = Pattern.compile("(?<command>(?:add)|(?:contains)|(?:search))\\s+(?<word>.+)");

			while(sc.hasNext()) {
				System.out.print(">");
				String line = sc.nextLine();
				Matcher matcher = commandPattern.matcher(line);

				if (!matcher.matches()) {
					System.out.println(
							"Incorrect usage. Use `add <word>` to add a word, `contains <word>` to check if a word is contained, and `search <prefix>` to get all words that start with the given prefix");
					continue;
				}

				String command = matcher.group("command");
				String word = matcher.group("word");

				switch (command) {
				case "add":
					if(trie.add(word)) {
						System.out.println(String.format("Successfully added the word: [%s]", word));
					}else {
						System.out.println(String.format("Failed to add the word: [%s]", word));
					}
					break;
				case "contains":
					if(trie.contains(word)) {
						System.out.println(String.format("Successfully found the word: [%s]", word));
					}else {
						System.out.println(String.format("Failed to find the word: [%s]", word));
					}
					break;
				case "search":
					System.out.println(String.format("Words starting with: [%s] are: [%s]", word, trie.search(word)));
					break;
				default:
					System.out.println(
							"Incorrect usage. Use `add <word>` to add a word, `contains <word>` to check if a word is contained, and `search <prefix>` to get all words that start with the given prefix");
					break;
				}
			}
		}
	}
}
