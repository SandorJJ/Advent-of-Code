package adventofcode.year2022.day02.part1;

import adventofcode.util.InputReader;

import java.util.List;

public class Part1 {

    public static void main(String[] args) {
        List<String> games = InputReader.readInputFile("day02");
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


}
