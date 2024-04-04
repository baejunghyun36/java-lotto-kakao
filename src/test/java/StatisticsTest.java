import constant.Reward;
import model.Bonus;
import model.Statistics;
import model.UserLotto;
import model.WinningLotto;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StatisticsTest {
    UserLotto userLotto;

    @BeforeEach
    void setUp() {
        userLotto = new UserLotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {
            "FIRST : 1, 2, 3, 4, 5, 6 : 7",
            "SECOND : 1, 2, 3, 4, 5, 7 : 6",
            "THIRD : 1, 2, 3, 4, 5, 7 : 8",
            "FOURTH : 1, 2, 3, 4, 7, 8 : 9",
            "FIFTH : 1, 2, 3, 7, 8, 9 : 10",
    })
    void 사용자_로또_한장과_비교해_결과를_반환(ArgumentsAccessor argumentsAccessor) {
        Reward result = Reward.valueOf(argumentsAccessor.getString(0));
        String winningNumbers = argumentsAccessor.getString(1);
        int bonusNumber = argumentsAccessor.getInteger(2);

        WinningLotto winningLotto = new WinningLotto(winningNumbers, new Bonus(bonusNumber));
        Map<Reward, Integer> actual = new Statistics(userLotto, winningLotto).getResult();

        AssertionsForClassTypes.assertThat(actual.get(result)).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {
            "FIRST : 1, 2, 3, 4, 5, 6 : 7",
            "SECOND : 1, 2, 3, 4, 5, 7 : 6",
            "THIRD : 1, 2, 3, 4, 5, 7 : 8",
            "FOURTH : 1, 2, 3, 4, 7, 8 : 9",
            "FIFTH : 1, 2, 3, 7, 8, 9 : 10",
    })
    void 사용자_로또_여러장과_비교해_결과를_반환(ArgumentsAccessor argumentsAccessor) {
        Reward result = Reward.valueOf(argumentsAccessor.getString(0));
        String winningNumbers = argumentsAccessor.getString(1);
        int bonusNumber = argumentsAccessor.getInteger(2);

        WinningLotto winningLotto = new WinningLotto(winningNumbers, new Bonus(bonusNumber));
        List<UserLotto> userLottos = new ArrayList<>();
        userLottos.add(new UserLotto(List.of(1, 2, 3, 4, 5, 6)));
        userLottos.add(new UserLotto(List.of(1, 2, 3, 4, 5, 6)));
        Map<Reward, Integer> actual = new Statistics(userLottos, winningLotto).getResult();

        AssertionsForClassTypes.assertThat(actual.get(result)).isEqualTo(2);
    }
}
