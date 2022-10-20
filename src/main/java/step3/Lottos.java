package step3;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Lottos {

	private final List<Set<Integer>> lottos;

	public Lottos(List<Set<Integer>> lotto) {
		this.lottos = lotto;
	}

	public int results(Set<Integer> lottos, Set<Integer> winningNumbers, int bonus) {
		int count = 0;
		Iterator<Integer> itr = winningNumbers.iterator();
		while (itr.hasNext()) {
			count = checkContains(lottos, count, itr);
		}
		if (count == 4) {
			return checkBonus(lottos, count, bonus);
		}
		return count;
	}

	private int checkBonus(Set<Integer> lottos, int count, int bonus) {
		if (lottos.contains(bonus)) {
			return count + 3;
		}
		return count;
	}

	private int checkContains(Set<Integer> guestLotto, int count, Iterator<Integer> itr) {
		if (guestLotto.contains(itr.next())) {
			count++;
		}
		return count;
	}

	public List<Set<Integer>> getLottos() {
		return lottos;
	}
}