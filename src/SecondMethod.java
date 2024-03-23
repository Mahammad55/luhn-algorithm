public class SecondMethod {
    public static void main(String[] args) {
        System.out.println(isValidCardNumber("4169 7388 6029 3152"));
    }

    private static boolean isValidCardNumber(String cardNumber) {
        cardNumber = cardNumber.replaceAll("\\s+", "");
        if (cardNumber.length() != 16) return false;

        int sum = 0;

        for (int i = 0; i < cardNumber.length(); i++) {
            int digit = Character.getNumericValue(cardNumber.charAt(i));
            if (i % 2 != 0) {
                sum += digit;
            } else {
                sum += digit * 2 < 10 ? digit * 2 : getSum(digit);
            }
        }

        return sum % 10 == 0;
    }

    private static int getSum(int number) {
        int multiply = number * 2;
        return multiply / 10 + multiply % 10;
    }
}
