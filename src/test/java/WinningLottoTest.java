import model.Bonus;
import model.WinningLotto;
import model.vo.LottoBall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.stream.IntStream;
import java.util.List;
import java.util.stream.Collectors;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class WinningLottoTest {
    WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = new WinningLotto("1,2,3,4,5,6", new Bonus(45));
    }

    @Test
    void 문자열_로또_당첨_번호_개수_테스트() {
        int actual = winningLotto.getBalls().size();
        int expected = 6;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로또_당첨_번호_원소값_테스트() {
        List<LottoBall> actual = winningLotto.getBalls();
        List<LottoBall> expected = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoBall::new)
                .collect(Collectors.toList());

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로또_보너스_번호_테스트(){
        Bonus actual = winningLotto.getBonus();

        assertThat(actual.getNumber()).isEqualTo(45);
    }

    @Test
    void 로또_당첨_번호_길이_익셉션_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        winningLotto = new WinningLotto("1,2,3,4,5,6,7", new Bonus(8))
                );
    }

    @Test
    void 로또_당첨_번호_유효성_익셉션_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        winningLotto = new WinningLotto("1,2,3,4,5,46", new Bonus(8))
                );
    }
}
