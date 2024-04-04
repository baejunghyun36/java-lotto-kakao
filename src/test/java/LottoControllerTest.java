import controller.LottoController;
import model.LottoMachineImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoControllerTest {
    LottoController lottoController;

    @BeforeEach
    void setUp() {
        lottoController = new LottoController(10, new LottoMachineImpl());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 10, 15})
    void 구입한_로또_용지_개수_테스트(int purchaseAmount) {
        LottoController lottoGame = new LottoController(purchaseAmount, new LottoMachineImpl());

        assertThat(lottoGame.getUserLottos()).hasSize(purchaseAmount);
    }
}
