import model.Bonus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class BonusTest {
    Bonus bonus;

    @BeforeEach
    void setUp() {
        bonus = new Bonus(45);
    }

    @Test
    void 보너스_번호_확인_테스트() {
        int expected = 45;
        int actual = bonus.getNumber();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 보너스_범위_테스트(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        bonus = new Bonus(46)
                );
    }
}
