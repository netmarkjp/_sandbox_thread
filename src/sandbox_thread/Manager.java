package sandbox_thread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Manager {

	private int parallel = 4;

	private ConcurrentLinkedQueue<String> jobQueue = new ConcurrentLinkedQueue<String>();

	public void go() {
		List<Thread> threads = new LinkedList<Thread>();
		for (int i = 0; i < getParallel(); i++) {
			threads.add(new Thread(new Worker(this, i)));
		}

		for (Thread thread : threads) {
			thread.start();
		}

	}

	public void addJob(String job) {
		getJobQueue().add(job);
	}

	public String pollJob() {
		return getJobQueue().poll();
	}

	public int getParallel() {
		return parallel;
	}

	public void setParallel(int parallel) {
		this.parallel = parallel;
	}

	private ConcurrentLinkedQueue<String> getJobQueue() {
		return jobQueue;
	}

	private void setJobQueue(ConcurrentLinkedQueue<String> jobQueue) {
		this.jobQueue = jobQueue;
	}

}
