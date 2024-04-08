package model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static constant.LottoConstants.*;

public class LottoMachineImpl implements LottoMachine {
    private static final List<Integer> lottoNumbers = IntStream.rangeClosed(NUMBER_LOWER_BOUND, NUMBER_UPPER_BOUND)
            .boxed()
            .collect(Collectors.toList());

    @Override
    public UserLotto extractLottoNumbers () {
        Collections.shuffle(lottoNumbers);
        return new UserLotto(lottoNumbers.subList(ZERO, LOTTO_BALLS_COUNT));
    }
}
