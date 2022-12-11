package adventofcode.year2022.day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Part2 {

    public static void main(String[] args) {
        List<Integer> sumsOfCalories = calculateSumsOfCalories(readFile("src/main/java/adventofcode/year2022/day01/input.txt"));
        sumsOfCalories.sort(Collections.reverseOrder());
        System.out.println(sumsOfCalories.get(0) + sumsOfCalories.get(1) + sumsOfCalories.get(2));
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
        sumsOfCalories.add(sum);
        return sumsOfCalories;
    }

    public static List<String> readFile(String file) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return lines;
    }
}
