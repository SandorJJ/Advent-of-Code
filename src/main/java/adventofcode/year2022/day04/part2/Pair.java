package adventofcode.year2022.day04.part2;

public class Pair {
    Section firstElf;
    Section secondElf;

    public Pair(Section firstElf, Section secondElf) {
        this.firstElf = firstElf;
        this.secondElf = secondElf;
    }

    public boolean doesRangeOverlapOther() {
       return (firstElf.getSmallestSectionID() >= secondElf.getSmallestSectionID() && firstElf.getSmallestSectionID() <= secondElf.getLargestSectionID())
               || (firstElf.getLargestSectionID() >= secondElf.getSmallestSectionID() && firstElf.getLargestSectionID() <= secondElf.getLargestSectionID())
               || (secondElf.getSmallestSectionID() >= firstElf.getSmallestSectionID() && secondElf.getSmallestSectionID() <= firstElf.getLargestSectionID())
               || (secondElf.getLargestSectionID() >= firstElf.getSmallestSectionID() && secondElf.getLargestSectionID() <= firstElf.getLargestSectionID());
    }
}
