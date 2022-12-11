package adventofcode.year2022.day03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Part2 {

    public static void main(String[] args) {

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
