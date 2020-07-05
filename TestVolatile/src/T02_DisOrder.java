
public class T02_DisOrder {
	private static int x = 0, y = 0;
	private static int a = 0, b = 0;

	public static void main(String[] args) throws InterruptedException {
		int i = 0;
		for (;;) {
			i++;
			x = 0; y = 0;
			a = 0; b = 0;
			Thread one = new Thread(new Runnable() {
				@Override
				public void run() {
					a = 1;
					x = b;
				}
			});

			Thread other = new Thread(new Runnable() {
				@Override
				public void run() {
					b = 1;
					y = a;
				}
			});

			one.start(); other.start();
			one.join(); other.join();
			String result = "第" + i + "次（" + x + "," + y + ")";
			if (x == 0 && y == 0) {
				//只有发生乱序x=b优先于a=1或者y=a优先于b=1先执行，才会出现x,y都等于0
				System.err.println(result);
				break;
			} else {
//			System.out.println(result);
			}
		}
	}
}
