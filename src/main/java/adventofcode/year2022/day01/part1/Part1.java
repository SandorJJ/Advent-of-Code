package adventofcode.year2022.day01.part1;

import adventofcode.util.InputReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Part1 {

    public static void main(String[] args) {
        List<Integer> sumsOfCalories = calculateSumsOfCalories(InputReader.readInputFile("day01"));
        sumsOfCalories.sort(Collections.reverseOrder());
        System.out.println(sumsOfCalories.get(0));
    }

    public static List<Integer> calculateSumsOfCalories(List<String> lines) {
        List<Integer> sumsOfCalories = new ArrayList<>();
        int sum = 0;

        for (String line : lines) {
            if (line.isEmpty()) {
                sumsOfCalories.add(sum);
                sum = 0;
                continue;
            }

            sum += Integer.parseInt(line);
        }
        return sumsOfCalories;
    }

}
