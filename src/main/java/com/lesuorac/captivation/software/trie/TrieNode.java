package com.lesuorac.captivation.software.trie;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;

import javax.validation.constraints.NotNull;

/**
 * Underlying structure used to support the tree structure of a {@link Trie}.
 *
 */

class TrieNode {

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
	public boolean add(@NotNull String word, int index) {
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
	public boolean contains(@NotNull String word, int index) {
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
	@NotNull
	public void search(@NotNull String prefix, int index, @NotNull List<String> values) {
		if (index == prefix.length()) {
			Optional.ofNullable(value.get()).ifPresent(str -> values.add(str));

			children.values().stream().forEach(node -> node.search(prefix, index, values));
			return;
		}

		String nextNodeChar = prefix.substring(index, index + 1);
		Optional.ofNullable(children.get(nextNodeChar)).ifPresent(node -> node.search(prefix, index + 1, values));
	}

}
