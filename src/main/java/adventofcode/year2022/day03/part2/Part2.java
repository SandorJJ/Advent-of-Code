package adventofcode.year2022.day03.part2;

import adventofcode.util.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Part2 {

    public static void main(String[] args) {
        List<String> contents = InputReader.readInputFile("day03");
        int prioritySum = 0;
        for (int priority : getPriorityValues(getMatches(getGroups(contents)))) {
            prioritySum += priority;
        }

        System.out.println(prioritySum);
    }

    public static List<List<String>> getGroups(List<String> rucksacks) {
        List<String> group = new ArrayList<>();
        List<List<String>> groups = new ArrayList<>();

        for (String rucksack : rucksacks) {
            if (group.size() == 3) {
                groups.add(group);
                group = new ArrayList<>();
            }

            group.add(rucksack);
        }
        groups.add(group);

        return groups;
    }

    public static List<String> getMatches(List<List<String>> groups) {
        List<String> matches = new ArrayList<>();

        for (List<String> group : groups) {
            String secondElfsRucksack = group.get(1);
            String thirdElfsRucksack = group.get(2);

            for (String firstElfsRucksacksParts : group.get(0).split("")) {
                if (secondElfsRucksack.contains(firstElfsRucksacksParts) && thirdElfsRucksack.contains(firstElfsRucksacksParts)) {
                    matches.add(firstElfsRucksacksParts);
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
