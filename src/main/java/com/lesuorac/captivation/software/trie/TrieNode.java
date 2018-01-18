package com.lesuorac.captivation.software.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

/**
 * Underlying structure used to support the tree structure of a {@link Trie}.
 *
 */
class TrieNode {

	/**
	 * The value stored at this node
	 */
	String value;

	/**
	 * If this node is an inserted word
	 */
	boolean isWord;

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
	TrieNode(@NotNull String value) {
		this(value, false, new ConcurrentHashMap<>());
	}

	/**
	 * Creates a {@link TrieNode} with the given value at it that could also be a
	 * word
	 * 
	 * @param value
	 *            {@link #value}
	 * @param isWord
	 *            {@link #isWord}
	 */
	TrieNode(@NotNull String value, boolean isWord) {
		this(value, isWord, new ConcurrentHashMap<>());
	}

	/**
	 * Creates a {@link TrieNode} with the given value at it that could also be a
	 * word and has the provided children
	 * 
	 * @param value
	 *            {@link #value}
	 * @param isWord
	 *            {@link #isWord}
	 * @param children
	 *            {@link #children}
	 */
	TrieNode(@NotNull String value, boolean isWord, @NotNull ConcurrentMap<String, TrieNode> children) {
		this.value = value;
		this.isWord = isWord;
		this.children = children;
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
		int similarLength = lengthOfEqualStartingString(word, index, value);

		if (similarLength == value.length()) {

			if (similarLength + index == word.length()) {
				/*
				 * The word is stored at this node.
				 * 
				 * word: trie, index: 2
				 * 
				 * value: ie
				 */
				if (isWord) {
					return false;
				} else {
					isWord = true;
					return true;
				}
			}

			/*
			 * A prefix is stored at this node so need to check the children.
			 * 
			 * word: trie, index: 2
			 * 
			 * value: i
			 */
			String childValue = word.substring(index + similarLength, index + similarLength + 1);
			TrieNode child = children.get(childValue);

			if (child == null) {
				children.put(childValue, new TrieNode(word.substring(index + similarLength), true));
				return true;
			} else {
				return child.add(word, index + similarLength);
			}

		}

		/*
		 * A substring of the word is stored in this node but this node needs to be
		 * split.
		 * 
		 * The 'i' is a substring
		 * 
		 * word: trie, index: 2
		 * 
		 * value: il
		 */
		TrieNode child1 = new TrieNode(value.substring(similarLength), this.isWord, this.children);
		int child2ValueLength = word.length() - (similarLength + index);

		/*
		 * This causes Thread unsafety, a ReadWriteLock could probably mitigate the
		 * problem by having this.value modifcation count as a write and just using
		 * this.value counts as a read.
		 */
		this.value = value.substring(0, similarLength);
		this.isWord = false;
		this.children = new ConcurrentHashMap<>();

		this.children.put(child1.value.substring(0, 1), child1);

		if (child2ValueLength > 0) {
			return add(word, index);
		} else {
			this.isWord = true;
			return false;
		}
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
		int similarLength = lengthOfEqualStartingString(word, index, value);

		if (similarLength == value.length()) {
			if (index + similarLength == word.length()) {
				return isWord;
			} else {
				TrieNode child = children.getOrDefault(word.substring(index + similarLength, index + similarLength + 1),
						null);

				if (child == null) {
					return false;
				}

				return child.contains(word, index + similarLength);
			}
		}

		return false;
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
	 * @return previousValues {@link #value}s that have been previously traversed
	 *         and correspond to words that exist in this Trie
	 */
	@NotNull
	public Collection<String> search(@NotNull String prefix, int index, @NotNull Deque<String> previousValues) {
		int similarLength = lengthOfEqualStartingString(prefix, index, value);
		previousValues.addLast(value);

		if (index + similarLength == prefix.length()) {
			/*
			 * Traversed the tree enough to find where the prefix ended and need to obtain
			 * words
			 * 
			 * prefix: trie, index: 2
			 * 
			 * value: ied
			 */
			List<String> values = new ArrayList<>();

			if (this.isWord) {
				values.add(prefix + this.value.substring(similarLength));
			}

			for (TrieNode child : this.children.values()) {
				values.addAll(child.search(previousValues));
			}

			return values;
		}

		TrieNode child = children.getOrDefault(prefix.substring(index + similarLength, index + similarLength + 1),
				null);

		if (child == null) {
			return Arrays.asList();
		}

		return child.search(prefix, index + similarLength, previousValues);
	}

	/**
	 * Obtains every word in this TrieNode and below and prepends the previousValues
	 * to these words
	 * 
	 * @param previousValues
	 *            {@link #value}s that have been previously traversed and correspond
	 *            to words that exist in this Trie
	 * @return every word in the TrieNode
	 */
	@NotNull
	private List<String> search(@NotNull Deque<String> previousValues) {
		List<String> values = new ArrayList<>();
		previousValues.addLast(value);

		if (this.isWord) {
			/*
			 * Since each TireNode only stores the value of itself in that the word 'trie'
			 * might be stored across 4 nodes as 't', 'r', 'i', 'e' so they are sown back
			 * together because 't','r','i' get passed in as previousValue and 'e' got added
			 * at the beginning of this function.
			 */
			values.add(previousValues.stream().collect(Collectors.joining()));
		}

		for (TrieNode child : this.children.values()) {
			values.addAll(child.search(previousValues));
		}

		previousValues.removeLast();
		return values;
	}

	/**
	 * Gets how long the two provided strings have a similar sub-strings.</br>
	 * </br>
	 * The offset is provided from str1 to avoid string duplication all over the
	 * place.
	 * 
	 * @param str1
	 *            a string to check
	 * @param str1Offset
	 *            the initial position to start from in str1
	 * @param str2
	 *            the other string to check
	 * @return how long the two provided strings have a similar sub-strings.
	 */
	private int lengthOfEqualStartingString(@NotNull String str1, int str1Offset, @NotNull String str2) {
		int length = Math.min(str1.length() - str1Offset, str2.length());

		int i = 0;
		for (; i < length; i++) {
			if (str1.charAt(str1Offset + i) != str2.charAt(i)) {
				break;
			}
		}

		return i;
	}

}
