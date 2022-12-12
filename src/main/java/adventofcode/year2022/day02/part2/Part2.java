package adventofcode.year2022.day02.part2;

import adventofcode.util.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Part2 {

    public static void main(String[] args) {
        List<String> games = InputReader.readInputFile("day02");
        int totalPoints = calculateOutcomePoints(games) + calculateShapePoints(getShapesToUse(games));
        System.out.println(totalPoints);
    }

    public static Integer calculateOutcomePoints(List<String> games) {
        int points = 0;

        for (String game : games) {
            String[] moveAndOutcome = game.split(" ");
            if (moveAndOutcome[1].equals("Y")) {
                points += 3;
            } else if (moveAndOutcome[1].equals("Z")) {
                points += 6;
            }
        }

        return points;
    }

    public static List<String> getShapesToUse(List<String> games) {
        List<String> yourMoves = new ArrayList<>();

        for (String game : games) {
            String[] moveAndOutcome = game.split(" ");
            switch(moveAndOutcome[1]) {
                case "X" -> yourMoves.add(getLosingShape(moveAndOutcome[0]));
                case "Y" -> yourMoves.add(moveAndOutcome[0]);
                case "Z" -> yourMoves.add(getWinningShape(moveAndOutcome[0]));
                default -> throw new IllegalStateException();
            }
        }

        return yourMoves;
    }

    private static String getLosingShape(String opponentsMove) {
        return switch (opponentsMove) {
            case "A" -> "C";
            case "B" -> "A";
            case "C" -> "B";
            default -> throw new IllegalStateException();
        };

    }

    private static String getWinningShape(String opponentsMove) {
        return switch (opponentsMove) {
            case "A" -> "B";
            case "B" -> "C";
            case "C" -> "A";
            default -> null;
        };
    }

    public static Integer calculateShapePoints(List<String> yourMoves) {
        int points = 0;

        for (String move : yourMoves) {

            switch (move) {
                case "A" -> points += 1;
                case "B" -> points += 2;
                case "C" -> points += 3;
                default -> throw new IllegalStateException();
            }
        }

        return points;
    }

}