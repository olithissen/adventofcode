package net.tonick.adventofcode.day02;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class Day02 {

	public static void main(String[] args) throws Exception {
		List<String> lines = Files.readAllLines(Paths.get(Day02.class.getResource("input.txt").toURI()));

		Stream<Integer> map = lines.stream().map(s -> s.split("\\s+")) // Split each line by whitespaces
				.map(s -> Arrays.stream(s)) // Convert to stream of single strings
				.map(s -> s.mapToInt(Integer::valueOf).boxed()
						// .collect(IntSummaryStatistics::new, IntSummaryStatistics::accept,
						// IntSummaryStatistics::combine))
						.collect(Coll::new, Coll::accept, Coll::combine))
				.map(s -> {
					return s.result;
				});
		
		int sum = map
				.mapToInt(Integer::intValue).sum();

		System.out.println(sum);
	}
}
