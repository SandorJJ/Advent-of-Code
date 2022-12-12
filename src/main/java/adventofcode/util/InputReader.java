package adventofcode.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public final class InputReader {

    private InputReader() {
    }

    public static List<String> readExampleInputFile(String day) {
        String fileLocation = "src/main/java/adventofcode/year2022/" + day + "/example-input.txt";
        List<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lines;
    }

    public static List<String> readInputFile(String day) {
        String fileLocation = "src/main/java/adventofcode/year2022/" + day + "/input.txt";
        List<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation))) {
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
