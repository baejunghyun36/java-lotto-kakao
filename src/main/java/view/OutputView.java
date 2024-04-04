package view;

import constant.Reward;
import model.dto.UserLottoDTOs;
import java.util.Map;

import static constant.LottoConstants.*;

public class OutputView {

    private OutputView() {
    }

    public static void printPaymentAmount(int amount) {
        System.out.println(amount + AMOUNT_MESSAGE + "\n");
    }

    public static void printLottosNumbers(UserLottoDTOs userLottoDTOs) {
        userLottoDTOs.getBalls()
                        .forEach(userLottoDTO -> System.out.println(userLottoDTO.getNumbers().toString()));
        System.out.println("\n");
    }

    public static void printResultList(Map<Reward, Integer> result) {
        System.out.println(STATISTICS_MESSAGE);
        System.out.printf(RESULT_LIST_MESSAGE, 3, Reward.FIFTH.getPrice(), result.get(Reward.FIFTH));
        System.out.printf(RESULT_LIST_MESSAGE, 4, Reward.FOURTH.getPrice(), result.get(Reward.FOURTH));
        System.out.printf(RESULT_LIST_MESSAGE, 5, Reward.THIRD.getPrice(), result.get(Reward.THIRD));
        System.out.printf(RESULT_LIST_MESSAGE, 5, Reward.SECOND.getPrice(), result.get(Reward.SECOND));
        System.out.printf(RESULT_LIST_MESSAGE, 6, Reward.FIRST.getPrice(), result.get(Reward.FIRST));
    }

    public static void printResultRate(double rate) {
        System.out.printf(RESULT_REWARD_RATE, rate);
    }
}
