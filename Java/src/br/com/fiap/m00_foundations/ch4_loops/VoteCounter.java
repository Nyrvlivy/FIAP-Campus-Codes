package br.com.fiap.m00_foundations.ch4_loops;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class VoteCounter {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Integer> votesMap = new LinkedHashMap<>();

    public static void main(String[] args) {
        initializeVotesMap();
        printWelcomeMessage();
        printCharacters();
        readVotes();
        printVotes();
    }

    private static void initializeVotesMap() {
        String[] characters = {"Daryl Dixon", "Rick Grimes", "Michonne Hawthorne", "Glenn Rhee", "Carol Peletier", "Negan", "Maggie Rhee"};
        for (String character : characters) {
            votesMap.put(character, 0);
        }
    }

    private static void printWelcomeMessage() {
        System.out.println("==============================");
        System.out.println("Welcome to Vote Counter - The Walking Dead Edition");
        System.out.println("==============================\n");
        System.out.println("Who is the best character in The Walking Dead?");
    }

    private static void printCharacters() {
        int index = 1;
        for (String character : votesMap.keySet()) {
            System.out.printf("    %-2d %s\n", index++, character);
        }
        System.out.println("    0  Exit\n");
    }

    private static void readVotes() {
        while (true) {
            System.out.print("Enter your vote: ");
            if (scanner.hasNextInt()) {
                int vote = scanner.nextInt();
                if (vote == 0) break;
                else if (vote > 0 && vote <= votesMap.size()) {
                    String character = new ArrayList<>(votesMap.keySet()).get(vote - 1);
                    votesMap.put(character, votesMap.get(character) + 1);
                } else {
                    System.out.println("Invalid vote. Please enter a valid character number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid character number.");
                scanner.next();
            }
        }
    }

    private static void printVotes() {
        System.out.println("\n-----------------------------");
        System.out.println("Vote Results");
        System.out.printf("%-20s| %s %n", "Characters", "Votes");
        System.out.println("-----------------------------");
        votesMap.forEach((character, voteCount) -> System.out.printf("%-20s: %d %n", character, voteCount));
    }
}
