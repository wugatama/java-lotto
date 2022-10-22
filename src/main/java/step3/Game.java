package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Game {
	public static void start(int input) {
		LottoAmount lottoMoney = new LottoAmount(input);

		Print.amount(lottoMoney.amountOfLottos());

		Result guestResult = startRaffle(lottoMoney);
		Print.winningNumber();
		Lotto winLotto = new Lotto(InputView.input().split(", "));
		Print.bonusBall();
		int bonus = Integer.parseInt(InputView.input());

		Print.rateOfWin(input, guestResult.results(winLotto, bonus));
	}

	public static Result startRaffle(LottoAmount lottoMoney) {
		LottoFactory lotto = new LottoFactory();
		List<Lotto> list = new ArrayList<>();
		for (int i = 1; i <= lottoMoney.amountOfLottos(); i++) {
			Lotto result = new Lotto(lotto.getRandomLotto());
			Print.result(result);
			list.add(result);
		}
		Print.newLine();
		return new Result(new Lottos(list));
	}
}
