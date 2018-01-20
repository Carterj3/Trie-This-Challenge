package com.lesuorac.captivation.software;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * All of the files merged together for Try-It-Online.
 */
@Deprecated
public class TIO {

	/**
	 * Underlying structure used to support the tree structure of a {@link Trie}.
	 *
	 */

	static class TrieNode {

		/**
		 * The value stored at this node
		 */
		AtomicReference<String> value;

		/**
		 * All of the children nodes that have this node as a prefix of them.
		 */
		ConcurrentMap<String, TrieNode> children;

		/**
		 * Creates a {@link TrieNode} with the given value at it.
		 * 
		 * @param value
		 *            {@link #value}
		 */
		TrieNode() {
			this.value = new AtomicReference<>(null);
			this.children = new ConcurrentHashMap<>();
		}

		/**
		 * Adds the provided word into the {@link TrieNode}.
		 * 
		 * To avoid creating sub-strings all over the place an index is provided as to
		 * how far the word has been traversed. (i.e. word: 'string', index: 2 means
		 * that 'ring' is the word currently in question).
		 * 
		 * @param word
		 *            the word to add
		 * @param index
		 *            how much of the word has been traversed
		 * @return true if the word was added, otherwise false (it already existed)
		 */
		public boolean add( String word, int index) {
			if (index == word.length()) {
				return value.compareAndSet(null, word);
			}

			String nextNodeChar = word.substring(index, index + 1);
			children.computeIfAbsent(nextNodeChar, str -> new TrieNode());
			return children.get(nextNodeChar).add(word, index + 1);
		}

		/**
		 * Checks if this TrieNode contains a word.
		 * 
		 * To avoid creating sub-strings all over the place an index is provided as to
		 * how far the word has been traversed. (i.e. word: 'string', index: 2 means
		 * that 'ring' is the word currently in question).
		 * 
		 * @param word
		 *            the word to add
		 * @param index
		 *            how much of the word has been traversed
		 * @return true if this TrieNode contains the word, otherwise false
		 */
		public boolean contains( String word, int index) {
			if (index == word.length()) {
				return value.get() != null;
			}

			String nextNodeChar = word.substring(index, index + 1);

			return Optional.ofNullable(children.get(nextNodeChar)).map(node -> node.contains(word, index + 1))
					.orElse(false);
		}

		/**
		 * Finds all words in this TrieNode starting with the word
		 * 
		 * To avoid creating sub-strings all over the place an index is provided as to
		 * how far the word has been traversed. (i.e. word: 'string', index: 2 means
		 * that 'ring' is the word currently in question).
		 * 
		 * @param prefix
		 *            the word to use as the prefix
		 * @param index
		 *            how much of the word (prefix) has been traversed
		 * @return values a provided List that is mutated by this function to include
		 *         any words that start with the given prefix.
		 */
		
		public void search( String prefix, int index,  List<String> values) {
			if (index == prefix.length()) {
				Optional.ofNullable(value.get()).ifPresent(str -> values.add(str));

				children.values().stream().forEach(node -> node.search(prefix, index, values));
				return;
			}

			String nextNodeChar = prefix.substring(index, index + 1);
			Optional.ofNullable(children.get(nextNodeChar)).ifPresent(node -> node.search(prefix, index + 1, values));
		}

	}

	static class ConcurrentTrie {

		/**
		 * The root of the trie.
		 */
		TrieNode head;

		/**
		 * Creates a {@link Trie}
		 */
		public ConcurrentTrie() {
			this.head = new TrieNode();
		}

		/**
		 * Adds the provided word into this {@link Trie}
		 * 
		 * @param word
		 *            the word to insert
		 * @return true if the word was not already inside the {@link Trie}, otherwise
		 *         false
		 */
		public boolean add( String word) {
			return head.add(word, 0);
		}

		/**
		 * Checks if the word is already inside the {@link Trie}
		 * 
		 * @param word
		 *            the word to check
		 * @return true if the word was inside the {@link Trie}, otherwise false
		 */
		public boolean contains( String word) {
			return head.contains(word, 0);
		}

		/**
		 * Obtains all the words in the {@link Trie} that start with this prefix.
		 * 
		 * @param prefix
		 *            the prefix (i.e. 'pref')
		 * @return a Collection of all the words (i.e. ['prefix', 'prefect'])
		 */
		public Collection<String> search( String prefix) {
			List<String> values = new ArrayList<>();
			head.search(prefix, 0, values);

			return values;
		}

	}

	public static void main(String[] args) {
		ConcurrentTrie trie = new ConcurrentTrie();

		try (Scanner sc = new Scanner(System.in)) {
			Pattern commandPattern = Pattern.compile("(?<command>(?:add)|(?:contains)|(?:search))\\s+(?<word>.+)");

			while (sc.hasNext()) {
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
					if (trie.add(word)) {
						System.out.println(String.format("Successfully added the word: [%s]", word));
					} else {
						System.out.println(String.format("Failed to add the word: [%s]", word));
					}
					break;
				case "contains":
					if (trie.contains(word)) {
						System.out.println(String.format("Successfully found the word: [%s]", word));
					} else {
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
