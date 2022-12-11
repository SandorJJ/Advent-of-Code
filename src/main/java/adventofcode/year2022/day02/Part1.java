package adventofcode.year2022.day02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Part1 {

    public static void main(String[] args) {
        List<String> games = readFile("src/main/java/adventofcode/year2022/day02/input.txt");
        int totalPoints = calculateOutcomePoints(games) + calculateShapePoints(games);
        System.out.println(totalPoints);
    }

    public static Integer calculateOutcomePoints(List<String> games) {
        int points = 0;

        for (String game : games) {
            if (game.equals("A X") || game.equals("B Y") || game.equals("C Z")) {
                points += 3;
            } else if (game.equals("A Y") || game.equals("B Z") || game.equals("C X")) {
                points += 6;
            }
        }

        return points;
    }

    public static Integer calculateShapePoints(List<String> games) {
        int points = 0;

        for (String game : games) {
            String[] moves = game.split(" ");

            switch (moves[1]) {
                case "X" -> points += 1;
                case "Y" -> points += 2;
                case "Z" -> points += 3;
                default -> throw new IllegalStateException();
            }
        }

        return points;
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
