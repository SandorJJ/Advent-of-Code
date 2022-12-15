package adventofcode.year2022.day01.part1;

import adventofcode.util.InputReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalorieCounting {

    public static void main(String[] args) {
        List<String> input = InputReader.readInputFile("day01");
        List<Integer> caloriesCarriedByElves = calculateCaloriesCarriedByElves(input);
        caloriesCarriedByElves.sort(Collections.reverseOrder());

        System.out.println("\nSolution:");
        System.out.println(caloriesCarriedByElves.get(0));
    }

    public static List<Integer> calculateCaloriesCarriedByElves(List<String> lines) {
        List<Integer> caloriesCarriedByElves = new ArrayList<>();
        int caloriesPerElf = 0;

        for (String line : lines) {
            if (line.isEmpty()) {
                caloriesCarriedByElves.add(caloriesPerElf);
                caloriesPerElf = 0;
                continue;
            }

            caloriesPerElf += Integer.parseInt(line);
        }
        caloriesCarriedByElves.add(caloriesPerElf);

        return caloriesCarriedByElves;
    }

}
