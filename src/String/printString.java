package String;

public class printString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printString.clearConsole();
		// for (int i = 0; i < 100; i++) {
		// // System.out.close();
		// System.out.println(i);
		// // printString.clearConsole();
		// }
	}

	// 并没有用
	public static void clearConsole() {
		try {
			String os = System.getProperty("os.name");
			System.out.println(os);
			if (os.contains("Windows")) {
				Runtime.getRuntime().exec("cls");
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (Exception exception) {
			// Handle exception.
		}
	}
}
