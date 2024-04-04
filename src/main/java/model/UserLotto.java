package model;

import model.vo.LottoBall;
import view.InputValidator;
import java.util.List;
import java.util.stream.Collectors;

public class UserLotto {
    private List<LottoBall> balls;

    public UserLotto(List<Integer> numbers) {
        validateNumbers(numbers);

        this.balls = numbers.stream()
                .map(LottoBall::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<LottoBall> getBalls() {
        return balls;
    }

    private void validateNumbers(List<Integer> numbers) {
        InputValidator.numberSizeCheck(numbers);

        for (int number : numbers) {
            InputValidator.rangeNumberCheck(number);
        }
    }

    public List<Integer> getLottoBallNumbers() {
        return balls.stream()
                .map(LottoBall::getNumber)
                .collect(Collectors.toUnmodifiableList());
    }
}
