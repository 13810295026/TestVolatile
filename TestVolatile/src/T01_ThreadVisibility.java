
public class T01_ThreadVisibility {
	private static /* volatile */ boolean flag = true;

	public static void main(String[] args) throws InterruptedException {

		new Thread(() -> {
			while (flag) {
				// 不加volatile永远退不出循环
			}
			System.out.println("end");
		}, "server").start();

		Thread.sleep(1000);
		flag = false;
	}
}
