package com.lesuorac.captivation.software.trie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.NotNull;

/**
 * Basic implementation of a Trie.</br>
 * </br>
 * {@link #add(String)} adds a word into the Trie and returns true if the word
 * did not already exist.</br>
 * </br>
 * {@link #contains(String)} checks if a word exists inside of the Trie</br>
 * </br>
 * {@link #search(String)} obtains a list of all words inside the Trie that
 * start with the provided prefix</br>
 * </br>
 *
 */
public class ConcurrentTrie {

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
	public boolean add(@NotNull String word) {
		return head.add(word, 0);
	}

	/**
	 * Checks if the word is already inside the {@link Trie}
	 * 
	 * @param word
	 *            the word to check
	 * @return true if the word was inside the {@link Trie}, otherwise false
	 */
	public boolean contains(@NotNull String word) {
		return head.contains(word, 0);
	}

	/**
	 * Obtains all the words in the {@link Trie} that start with this prefix.
	 * 
	 * @param prefix
	 *            the prefix (i.e. 'pref')
	 * @return a Collection of all the words (i.e. ['prefix', 'prefect'])
	 */
	public Collection<String> search(@NotNull String prefix) {
		List<String> values = new ArrayList<>();
		head.search(prefix, 0, values);

		return values;
	}

}
