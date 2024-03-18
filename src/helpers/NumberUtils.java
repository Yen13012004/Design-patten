package helpers;

public class NumberUtils {
	public static boolean isNumeric(String inputString) {
		if (inputString == null || inputString.length() == 0) {
			return false;
		} else {
			for (char c : inputString.toCharArray()) {
				if (!Character.isDigit(c)) {
					return false;
				}
			}
		}
		return true;
	}
}
