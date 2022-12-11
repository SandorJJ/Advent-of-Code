package adventofcode.year2022.day03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Part1 {

    public static void main(String[] args) {
        List<String> contents = readFile("src/main/java/adventofcode/year2022/day03/input.txt");
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
