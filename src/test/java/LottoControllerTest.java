import controller.LottoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LottoControllerTest {
    LottoController lottoController;

    List<String> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>();
        input.add("1,2,3,4,5,6");
        lottoController = new LottoController(2, input);
    }


    @Test
    void 사용자_수동_로또_번호_유효성_익셉션_테스트() {
        input.add("ak,s,1,2,3,4");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        lottoController = new LottoController(10, input)
                );
    }
}
