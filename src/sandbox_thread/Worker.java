package sandbox_thread;

public class Worker implements Runnable {

	private int id;
	private long wait = 1;
	private Manager manager;

	public Worker(Manager manager, int id) {
		this.manager = manager;
		this.id = id;
	}

	@Override
	public void run() {
		String job;
		while ((job = manager.pollJob()) != null) {
			System.out.println("th" + this.id + ":\t" + space(this.id) + job);
			try {
				Thread.sleep(wait);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	static String space(int times) {
		String result = "";
		for (int i = 0; i < times; i++) {
			result = result + "\t";
		}
		return result;
	}
}
