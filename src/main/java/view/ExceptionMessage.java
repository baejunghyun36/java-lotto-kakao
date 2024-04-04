package view;
import static constant.LottoConstants.*;

public class ExceptionMessage {
    private static final String NOT_NUMBER_RANGE = "[ERROR] 숫자는 " + NUMBER_LOWER_BOUND + "부터 " + NUMBER_UPPER_BOUND + " 사이의 숫자여야 합니다.";
    private static final String NOT_NUMBER_SIZE = "[ERROR] 당첨 번호는 6개 입력 가능합니다.";
    private static final String INPUT_TYPE_ERROR = "[ERROR] 숫자만 입력해 주세요.";
    private static final String INPUT_PRICE_ERROR = "[ERROR] 1000단위로 입력해 주세요.";
    private static final String NOT_NATURAL_NUMBER_ERROR = "[ERROR] 금액은 0 초과이어야 합니다.";

    public static void rangeException() {
        System.out.println(NOT_NUMBER_RANGE);
    }

    public static void sizeException() {
        System.out.println(NOT_NUMBER_SIZE);
    }

    public static void typeException() {
        System.out.println(INPUT_TYPE_ERROR);
    }

    public static void naturalNmberException(){
        System.out.println(NOT_NATURAL_NUMBER_ERROR);
    }

    public static void inputPriceException(){
        System.out.println(INPUT_PRICE_ERROR);
    }
}
