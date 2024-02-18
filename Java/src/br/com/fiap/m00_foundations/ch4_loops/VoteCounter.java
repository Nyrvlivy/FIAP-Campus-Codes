package br.com.fiap.m00_foundations.ch4_loops;

import java.util.Scanner;

public class VoteCounter {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String[] candidates = {
        "Daryl Dixon", "Rick Grimes", "Michonne Hawthorne",
        "Glenn Rhee", "Carol Peletier", "Negan", "Maggie Rhee"
    };

    public static int[] readVotes() {
        int[] votes = new int[candidates.length];
        while (true) {
            try {
                System.out.print("Enter your vote: ");
                int vote = scanner.nextInt();
                if (vote == 0) {
                    break;
                } else if (vote > 0 && vote <= candidates.length) {
                    votes[vote - 1]++;
                } else {
                    System.out.println("Invalid vote. Please enter a valid candidate number.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid candidate number.");
                scanner.next();
            }
        }
        return votes;
    }

    public static void printVotes(int[] votes) {
        System.out.println("\n-----------------------------");
        System.out.println("Vote Results");
        System.out.printf("%-21s %s %n", "Candidate", "Votes");
        System.out.println("-----------------------------");
        for (int i = 0; i < votes.length; i++) {
            System.out.printf("%-20s: %d %n", candidates[i], votes[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("==============================");
        System.out.println("Welcome to Vote Counter - The Walking Dead Edition");
        System.out.println("==============================\n");

        System.out.println("Who is the best character in The Walking Dead?");
        for (int i = 0; i < candidates.length; i++) {
            System.out.printf("    %-2d %s\n", i + 1, candidates[i]);
        }
        System.out.println("    0  Exit\n");

        printVotes(readVotes());
    }
}
