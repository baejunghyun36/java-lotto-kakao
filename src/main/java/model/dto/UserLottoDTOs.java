package model.dto;

import model.UserLotto;

import java.util.List;
import java.util.stream.Collectors;

public class UserLottoDTOs {
    private final List<UserLottoDTO> balls;

    public UserLottoDTOs(List<UserLotto> balls) {
        this.balls = balls.stream()
                .map(UserLottoDTO::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<UserLottoDTO> getBalls() {
        return balls;
    }
}
