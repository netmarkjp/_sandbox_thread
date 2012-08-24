package sandbox_thread;

public class Main {

	public static void main(String[] args) {
		Manager manager = new Manager();
		manager.setParallel(4);
		for (int i = 0; i < 100; i++) {
			manager.addJob("JOB" + i);
		}
		manager.go();
	}

}
