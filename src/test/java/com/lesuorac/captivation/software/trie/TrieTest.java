package com.lesuorac.captivation.software.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TrieTest {

	@Test
	public void test_add() {
		Trie trie = new Trie();

		List<String> set1 = Arrays.asList("triel", "tried", "tire", "trie");
		Assert.assertTrue(set1.stream().allMatch(word -> trie.add(word)));

		Assert.assertTrue(set1.stream().allMatch(word -> !trie.add(word)));

		List<String> set2 = Arrays.asList("TRIEL", "TRIED", "TIRE", "TRIE");
		Assert.assertTrue(set2.stream().allMatch(word -> trie.add(word)));

		Assert.assertTrue(set2.stream().allMatch(word -> !trie.add(word)));

		List<String> set3 = Arrays.asList("ATRIEL", "ATRIED", "ATIRE");
		Assert.assertTrue(set3.stream().allMatch(word -> trie.add(word)));

		Assert.assertTrue(set3.stream().allMatch(word -> !trie.add(word)));
	}

	@Test
	public void test_contains() {
		Trie trie = new Trie();

		List<String> set1 = Arrays.asList("triel", "tried", "tire", "trie");
		Assert.assertTrue(set1.stream().allMatch(word -> !trie.contains(word)));
		Assert.assertTrue(set1.stream().allMatch(word -> trie.add(word)));

		Assert.assertTrue(set1.stream().allMatch(word -> !trie.add(word)));
		Assert.assertTrue(set1.stream().allMatch(word -> trie.contains(word)));

		List<String> set2 = Arrays.asList("TRIEL", "TRIED", "TIRE", "TRIE");
		Assert.assertTrue(set2.stream().allMatch(word -> !trie.contains(word)));
		Assert.assertTrue(set2.stream().allMatch(word -> trie.add(word)));

		Assert.assertTrue(set2.stream().allMatch(word -> !trie.add(word)));
		Assert.assertTrue(set2.stream().allMatch(word -> trie.contains(word)));

		List<String> set3 = Arrays.asList("ATRIEL", "ATRIED", "ATIRE");
		Assert.assertTrue(set3.stream().allMatch(word -> !trie.contains(word)));
		Assert.assertTrue(set3.stream().allMatch(word -> trie.add(word)));

		Assert.assertTrue(set3.stream().allMatch(word -> !trie.add(word)));
		Assert.assertTrue(set1.stream().allMatch(word -> trie.contains(word)));
	}

	@Test
	public void test_search() {
		Trie trie = new Trie();

		Assert.assertEquals(0, trie.search("t").size());

		List<String> set1 = Arrays.asList("triel", "tried", "tire", "trie");
		Assert.assertTrue(set1.stream().allMatch(word -> trie.add(word)));

		Assert.assertEquals(0, trie.search("T").size());
		Assert.assertEquals(0, trie.search("trieds").size());
		Assert.assertEquals(1, trie.search("tried").size());
		Assert.assertEquals(4, trie.search("t").size());

		List<String> set2 = Arrays.asList("TRIEL", "TRIED", "TIRE", "TRIE");
		Assert.assertTrue(set2.stream().allMatch(word -> trie.add(word)));

		List<String> set3 = Arrays.asList("ATRIEL", "ATRIED", "ATIRE");
		Assert.assertTrue(set3.stream().allMatch(word -> trie.add(word)));

		Assert.assertEquals(4, trie.search("T").size());
		Assert.assertEquals(0, trie.search("trieds").size());
		Assert.assertEquals(1, trie.search("tried").size());
		Assert.assertEquals(4, trie.search("t").size());
		
		trie.add("w");
		trie.add("wo");
		Assert.assertTrue(trie.search("w").contains("w"));
		Assert.assertTrue(trie.search("w").contains("wo"));
	}

	// @Test
	public void test_threadSafety() throws Throwable {
		// Spoiler Alert: it isn't, splitting strings to make new nodes isn't very safe :/
		List<String> truth = new ArrayList<>();
		List<Thread> threads = new ArrayList<>();
		List<Throwable> unexpectedExceptions = new ArrayList<>();
		AtomicBoolean running = new AtomicBoolean(true);
		
		Trie trie = new Trie();
		
		for(int i=0;i< 20;i++) {
			Thread t = new Thread( () -> {
				while(running.get()) {
					String newWord = UUID.randomUUID().toString();
					if(trie.add(newWord)) {
						truth.add(newWord);
					}else {
						Assert.assertTrue(truth.contains(newWord));
					}
					
					// Smoke test to verify that search doesn't throw an exception
					Collection<String> values = trie.search(newWord.substring(0, 4));
					if(!values.contains(newWord)) {
						System.out.println(String.format("newWord: [%s], values: [%s]", newWord, values));
						Assert.assertTrue(values.contains(newWord));
					}
				}
			});
			
			t.setUncaughtExceptionHandler((thread, error) -> {
				unexpectedExceptions.add(error);
				error.printStackTrace();
			});
			
			threads.add(t);
			t.start();
		}
		
		Thread.sleep(TimeUnit.MINUTES.toMillis(1L));
		
		for(Thread t: threads) {
			Assert.assertTrue(t.isAlive());
		}
		
		running.set(false);
		for(Thread t: threads) {
			t.join();
		}
		
		Assert.assertTrue(unexpectedExceptions.isEmpty());
	}
}
