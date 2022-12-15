package adventofcode.year2022.day04.part1;

public class Section {
    String sectionIDs;

    public Section(String sectionIDs) {
        this.sectionIDs = sectionIDs;
    }

    public int getSmallestSectionID() {
        String[] rangeOfIDs = sectionIDs.split("-");
        return Integer.parseInt(rangeOfIDs[0]);
    }

    public int getLargestSectionID() {
        String[] rangeOfIDs = sectionIDs.split("-");
        return Integer.parseInt(rangeOfIDs[1]);
    }
}
