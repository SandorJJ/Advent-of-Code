package adventofcode.year2022.day04.part2;

import adventofcode.util.InputReader;

import java.util.ArrayList;
import java.util.List;

public class CampCleanup {
    public static void main(String[] args) {
        System.out.println("Solution:");
        List<String> input = InputReader.readInputFile("day04");
        List<Pair> pairs = getPairs(input);
        int numberOfRangesFullyContained = getNumberOfRangesOverlapping(pairs);
        System.out.println(numberOfRangesFullyContained);
    }

    public static List<Pair> getPairs(List<String> lines) {
        List<Pair> pairs = new ArrayList<>();

        for (String line : lines) {
            String[] sectionsOfPairs = line.split(",");
            Pair pair = new Pair(new Section(sectionsOfPairs[0]), new Section(sectionsOfPairs[1]));
            pairs.add(pair);
        }

        return pairs;
    }

    public static int getNumberOfRangesOverlapping(List<Pair> pairs) {
        int numberOfRangesFullyContained = 0;

        for (Pair pair : pairs) {
            if (pair.doesRangeOverlapOther()) {
                numberOfRangesFullyContained++;
            }
        }

        return numberOfRangesFullyContained;
    }
}
