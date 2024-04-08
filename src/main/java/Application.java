import controller.LottoController;
import model.*;
import model.vo.ManualPurchaseAmount;
import model.vo.PurchaseAmount;
import view.InputView;
import view.OutputView;
import java.util.List;
import static constant.LottoConstants.LOTTO_PRICE;

public class Application {
    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = inputPurchaseAmount();
        ManualPurchaseAmount manualPurchaseAmount = inputManualPurchaseAmount();

        List<String> manualUserLottos = generateManualLotto(manualPurchaseAmount.getAmount());
        LottoController lottoController = generateRandomLotto(purchaseAmount, manualUserLottos);

        OutputView.printPurchaseAmount(purchaseAmount.getAmount(), manualPurchaseAmount.getAmount());
        OutputView.printLottosNumbers(lottoController.getUserLottosForOutput());

        WinningLotto winningLotto = settingWinningNumbers();
        Statistics statistics = generateStatistics(lottoController, winningLotto);

        OutputView.printResultList(statistics.getResult());
        OutputView.printResultRate(statistics.getStatistics());
    }

    private static ManualPurchaseAmount inputManualPurchaseAmount() {
        return new ManualPurchaseAmount(InputView.readManualPurchaseAmount());
    }

    private static List<String> generateManualLotto(int manualPurchaseAmount) {
        return InputView.readManualLotto(manualPurchaseAmount);
    }

    private static PurchaseAmount inputPurchaseAmount() {
        return new PurchaseAmount(InputView.readPaymentAmount()/LOTTO_PRICE);
    }

    private static LottoController generateRandomLotto(PurchaseAmount purchaseAmount, List<String> inputManualLottos){
        return new LottoController(purchaseAmount.getAmount() - inputManualLottos.size(), inputManualLottos);
    }

    private static WinningLotto settingWinningNumbers() {
        String winningNumbersUserInput = InputView.readWinningNumbers();
        Bonus bonus = new Bonus(InputView.readBonusNumber());
        return new WinningLotto(winningNumbersUserInput, bonus);
    }

    private static Statistics generateStatistics(LottoController lottoController, WinningLotto winningLotto) {
        return new Statistics(lottoController.getUserLottos(), winningLotto);
    }
}
