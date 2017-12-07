package net.tonick.adventofcode.day02;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.function.IntConsumer;

class Coll implements IntConsumer {
	private List<Integer> numbers = new ArrayList<>();
	int result = 0;

	public void accept(int i) {
		numbers.add(i);

		Optional<Integer> first = numbers.stream().filter((Integer s) -> {
			return s.intValue() != i;
		}).filter((Integer s) -> {
			return s.intValue() % i == 0 || i % s.intValue() == 0;
		}).map(s -> {
			return s;
		}).distinct().findFirst();

		if (first.isPresent() && result == 0) {
			if (first.get() > i) {
				result = first.get() / i;
			} else {
				result = i / first.get();
			}
		}
	}

	public void combine(Coll other) {
	}
}
