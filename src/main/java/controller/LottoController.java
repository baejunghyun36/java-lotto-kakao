package controller;

import model.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoController {
    private LottoMachine lottoMachine;
    private List<UserLotto> userLottos;

    public LottoController(int purchaseAmount, LottoMachineImpl lottoMachine) {
        this.lottoMachine = lottoMachine;
        userLottos = generateLotto(purchaseAmount);
    }

    public LottoController(List<UserLotto> userLottoList, LottoMachineImpl lottoMachine) {
        userLottos = userLottoList;
        this.lottoMachine = lottoMachine;
    }

    private List<UserLotto> generateLotto(int purchaseAmount) {
        return Stream.generate(lottoMachine::extractLottoNumbers)
                .limit(purchaseAmount)
                .collect(Collectors.toList());
    }

    public List<UserLotto> getUserLottos() {
        return userLottos;
    }
}
