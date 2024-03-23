import java.util.Arrays;

public class FirstMethod {
    public static void main(String[] args) {
        System.out.println(isValidCardNumber("4539 4508 4324 8976"));
    }

    private static boolean isValidCardNumber(String cardNumber) {
        cardNumber = cardNumber.replaceAll("\\s+", "");
        if (cardNumber.length() != 16) return false;

        int[] numbers = new int[16];
        int index = 0;

        for (Character digit : cardNumber.toCharArray()) {
            if (!Character.isDigit(digit)) return false;
            numbers[index++] = Character.getNumericValue(digit);
        }

        for (int i = 0; i <= index - 2; i += 2) {
            int multiply = numbers[i] * 2;
            numbers[i] = multiply < 10 ? multiply : multiply - 9;
        }

        return Arrays.stream(numbers).sum() % 10 == 0;
    }
}
