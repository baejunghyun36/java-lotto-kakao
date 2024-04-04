package model;

import model.vo.LottoBall;
import view.InputValidator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private final List<LottoBall> balls;
    private final Bonus bonus;

    public WinningLotto(String numbers, Bonus bonus) {
        this.balls = createWinningNumbers(numbers);
        this.bonus = bonus;
    }

    public List<LottoBall> createWinningNumbers(String input) {
        List<LottoBall> balls = Arrays.stream(input.replaceAll(" ", "").split(","))
                .map(s -> new LottoBall(Integer.parseInt(s)))
                .collect(Collectors.toList());

        validateNumbers(balls);

        return balls;
    }

    private void validateNumbers(List<LottoBall> balls) {
        InputValidator.lottoBallSizeCheck(balls);

        for (LottoBall ball : balls) {
            InputValidator.rangeNumberCheck(ball.getNumber());
        }
    }

    public List<LottoBall> getBalls() {
        return balls;
    }

    public Bonus getBonus() {
        return bonus;
    }

}
