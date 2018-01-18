package com.lesuorac.captivation.software.trie;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TrieLock implements AutoCloseable {

	Lock lock;

	public TrieLock() {
		this.lock = new ReentrantLock(true);
	}

	public TrieLock open() {
		lock.lock();
		return this;
	}

	@Override
	public void close() {
		lock.unlock();
	}

}
