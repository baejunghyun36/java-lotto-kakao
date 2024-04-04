package model.dto;

import model.UserLotto;
import java.util.List;
import java.util.stream.Collectors;

public class UserLottoDTO {
    private final List<Integer> numbers;

    public UserLottoDTO(UserLotto userLotto) {
        this.numbers = userLotto.getLottoBallNumbers()
                .stream()
                .sorted()
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
