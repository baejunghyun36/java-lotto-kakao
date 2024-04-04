import controller.LottoController;
import model.*;
import model.dto.UserLottoDTOs;
import model.vo.PurchaseAmount;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = inputPurchaseAmount();
        LottoController lottoController = generateRandomLotto(purchaseAmount);
        WinningLotto winningLotto = settingWinningNumbers();
        lottoResult(lottoController, winningLotto);
    }

    private static PurchaseAmount inputPurchaseAmount() {
        int paymentAmount = InputView.readPaymentAmount();
        PurchaseAmount purchaseAmount = new PurchaseAmount(paymentAmount);
        OutputView.printPaymentAmount(purchaseAmount.getAmount());
        return purchaseAmount;
    }

    private static LottoController generateRandomLotto(PurchaseAmount purchaseAmount){
        LottoController lottoController = new LottoController(purchaseAmount.getAmount(), new LottoMachineImpl());
        OutputView.printLottosNumbers(new UserLottoDTOs(lottoController.getUserLottos()));
        return lottoController;
    }

    private static WinningLotto settingWinningNumbers() {
        String winningNumbersUserInput = InputView.readWinningNumbers();
        Bonus bonus = new Bonus(InputView.readBonusNumber());
        return new WinningLotto(winningNumbersUserInput, bonus);
    }

    private static void lottoResult(LottoController lottoController, WinningLotto winningLotto) {
        Statistics statistics = new Statistics(lottoController.getUserLottos(), winningLotto);
        OutputView.printResultList(statistics.getResult());
        OutputView.printResultRate(statistics.getStatistics());
    }
}
