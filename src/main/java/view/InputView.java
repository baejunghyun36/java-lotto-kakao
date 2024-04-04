package view;

import java.util.Scanner;
import static constant.LottoConstants.*;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int readPaymentAmount() {
        System.out.println(INPUT_PAYMENT_AMOUNT);
        String input = SCANNER.nextLine();
        int paymentAmount = InputValidator.checkTypeNumber(input);
        InputValidator.checkZeroNumber(paymentAmount);
        InputValidator.checkUnitNumber(paymentAmount);
        return paymentAmount;
    }

    public static String readWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        return SCANNER.nextLine();
    }

    public static String readBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return SCANNER.nextLine();
    }
}
