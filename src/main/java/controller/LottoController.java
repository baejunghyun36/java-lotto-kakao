package controller;

import model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoController {
    private final LottoMachine lottoMachine = new LottoMachineImpl();
    private List<UserLotto> userLottos;

    public LottoController(int purchaseAmount, List<String> inputManualLottos) {
        userLottos = generateManualUserLottos(inputManualLottos);
        userLottos.addAll(generateAutoUserLotto(purchaseAmount));
    }

    private List<UserLotto> generateManualUserLottos(List<String> inputManualLottos) {
        return inputManualLottos.stream()
                .map(UserLotto::create)
                .collect(Collectors.toList());
    }

    private List<UserLotto> generateAutoUserLotto(int purchaseAmount) {
        return Stream.generate(lottoMachine::extractLottoNumbers)
                .limit(purchaseAmount)
                .collect(Collectors.toList());
    }

    public List<List<Integer>> getUserLottosForOutput() {
        return userLottos.stream()
                .map(o -> new ArrayList<>(o.getLottoBallNumbers()))
                .collect(Collectors.toList());
    }

    public List<UserLotto> getUserLottos() {
        return userLottos;
    }

}
