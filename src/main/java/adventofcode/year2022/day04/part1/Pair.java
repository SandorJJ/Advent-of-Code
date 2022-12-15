package adventofcode.year2022.day04.part1;

public class Pair {
    Section firstElf;
    Section secondElf;

    public Pair(Section firstElf, Section secondElf) {
        this.firstElf = firstElf;
        this.secondElf = secondElf;
    }

    public boolean doesRangeContainOther() {
        return (firstElf.getSmallestSectionID() >= secondElf.getSmallestSectionID() && firstElf.getLargestSectionID() <= secondElf.getLargestSectionID())
                || (firstElf.getSmallestSectionID() <= secondElf.getSmallestSectionID() && firstElf.getLargestSectionID() >= secondElf.getLargestSectionID());
    }
}
