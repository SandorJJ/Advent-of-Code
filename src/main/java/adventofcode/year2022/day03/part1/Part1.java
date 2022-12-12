package adventofcode.year2022.day03.part1;

import adventofcode.util.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Part1 {

    public static void main(String[] args) {
        List<String> contents = InputReader.readInputFile("day03");
        int prioritySum = 0;
        for (int priority : getPriorityValues(getMatches(pairContentsToRucksacks(contents)))) {
            prioritySum += priority;
        }

        System.out.println(prioritySum);
    }

    public static List<List<String[]>> pairContentsToRucksacks(List<String> contents) {
        List<String[]> rucksack;
        List<List<String[]>> rucksacks = new ArrayList<>();

        for (String content : contents) {
            String firstCompartment = content.substring(0, (content.length() / 2));
            String secondCompartment = content.substring((content.length() / 2));
            rucksack = new ArrayList<>();

            rucksack.add(firstCompartment.split(""));
            rucksack.add(secondCompartment.split(""));

            rucksacks.add(rucksack);
        }

        return rucksacks;
    }

    public static List<String> getMatches(List<List<String[]>> rucksacks) {
        List<String> matches = new ArrayList<>();

        for (List<String[]> rucksack : rucksacks) {
            String secondCompartment = String.join("", rucksack.get(1));
            for (String firstCompartmentPart : rucksack.get(0)) {
                if (secondCompartment.contains(firstCompartmentPart)) {
                    matches.add(firstCompartmentPart);
                    break;
                }
            }
        }

        return matches;
    }

    public static List<Integer> getPriorityValues(List<String> matches) {
        List<Integer> priorityValues = new ArrayList<>();

        for (String match : matches) {
            int asciiValue = match.charAt(0);

            if (asciiValue <= 90) {
                priorityValues.add(asciiValue - 38);
            } else {
                priorityValues.add(asciiValue - 96);
            }
        }

        return priorityValues;
    }

}
