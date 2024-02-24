package br.com.fiap.m00_foundations.ch6_contact_book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactBookMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String[][] contacts = new String[10][3];

    public static void main(String[] args) {
        while (true) {
            printMenu();
            handleOption(readOption());
        }
    }

    private static void printMenu() {
        System.out.println("""

            ***** Contact Book Menu *****

            Please select an option:\s
              1. Add contact (max 10)
              2. Edit contact
              3. Search contact by name
              4. Show all contacts
              5. Delete contact by name
              6. Clear Contact Book
              7. Exit
            """);
    }

    private static void handleOption(int option) {
        switch (option) {
            case 1 -> manageContact("add");
            case 2 -> manageContact("edit");
            case 3 -> manageContact("search");
            case 4 -> showAllContactsAndOption();
            case 5 -> manageContact("delete");
            case 6 -> clearContactsAndOptionToAdd();
            case 7 -> exitProgram();
        }
    }

    private static void manageContact(String action) {
        switch (action) {
            case "add" -> addContact();
            case "edit", "delete" -> editOrDeleteContact(action);
            case "search" -> searchAndDisplayContacts();
            case "clear" -> deleteAllContacts();
        }
    }

    private static void addContact() {
        if (isContactBookFull()) {
            System.out.println("Contact book is full.");
            if (confirm("Do you want clear the contact book? (Y/N) ")) {
                deleteAllContacts();
            }
            return;
        }

        do {
            String[] contactInfo = readContactInfo();
            addContactInMatrix(contactInfo[0], contactInfo[1], contactInfo[2]);
            System.out.println("Contact added successfully!");
        } while (!isContactBookFull() && confirm("\nDo you want to add another contact? (Y/N) "));
    }

    private static String[] readContactInfo() {
        System.out.println("\nPlease enter the contact information:");
        String name = readString("Name  : ");
        String phone = readString("Phone : ");
        String email = readString("Email : ");
        return new String[]{name, phone, email};
    }

    private static void editOrDeleteContact(String action) {
        boolean continueAction;
        do {
            String name = readString("Enter the name of the contact to " + action + ": ");
            List<Integer> foundIndexes = searchContactByName(name);

            if (foundIndexes.isEmpty()) {
                System.out.println("No contact found with the name: " + name);
                continueAction = confirm("Do you want to try another name? (Y/N) ");
            } else {
                if ("edit".equals(action)) {
                    int indexToEdit = chooseContact(foundIndexes);
                    editContactAtIndex(indexToEdit);
                    continueAction = confirm("Do you want to edit another contact? (Y/N) ");
                } else {
                    deleteContacts(foundIndexes, name);
                    continueAction = confirm("Do you want to delete another contact? (Y/N) ");
                }
            }
        } while (continueAction);
    }


    private static void searchAndDisplayContacts() {
        do {
            String name = readString("Enter the name to search: ");
            List<Integer> foundIndexes = searchContactByName(name);
            displayContacts(foundIndexes, name);
        } while (confirm("Do you want to search for another contact? (Y/N) "));
    }

    private static void displayContacts(List<Integer> foundIndexes, String name) {
        if (foundIndexes.isEmpty()) {
            System.out.println("No contact found with the name: " + name);
        } else {
            System.out.println(foundIndexes.size() + " contact(s) found:");
            foundIndexes.forEach(index -> {
                System.out.println("--------------------------------");
                contactInfo(contacts[index]);
            });
            System.out.println("--------------------------------");
        }
    }

    private static void showAllContactsAndOption() {
        boolean hasContacts = showAllContacts();
        if (!hasContacts) {
            if (confirm("Would you like to add a new contact? (Y/N) ")) {
                addContact();
            }
        } else {
            if (confirm("Would you like to perform an individual search? (Y/N) ")) {
                searchAndDisplayContacts();
            }
        }
    }

    private static boolean showAllContacts() {
        System.out.println("All contacts:");
        boolean hasContacts = false;
        for (String[] contact : contacts) {
            if (contact[0] != null) {
                hasContacts = true;
                System.out.println("--------------------------------");
                contactInfo(contact);
            }
        }
        if (!hasContacts) {
            System.out.println("No contacts found.");
            return false;
        } else {
            System.out.println("--------------------------------");
            return true;
        }
    }

    private static void deleteContacts(List<Integer> foundIndexes, String name) {
        if (foundIndexes.size() == 1) {
            deleteContactAtIndex(foundIndexes.get(0));
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println(foundIndexes.size() + " contacts found with the name '" + name + "':");
            for (int i = 0; i < foundIndexes.size(); i++) {
                int index = foundIndexes.get(i);
                System.out.printf("%d. %s - %s - %s\n", i + 1, contacts[index][0], contacts[index][1], contacts[index][2]);
            }
            int choice = readInt("Enter the number of the contact to choose: ", foundIndexes.size(), "Invalid choice.") - 1;
            if (choice >= 0 && choice < foundIndexes.size()) {
                deleteContactAtIndex(foundIndexes.get(choice));
                System.out.println("Contact deleted successfully.");
            } else {
                System.out.println("Invalid selection. No contact deleted.");
            }
        }
    }

    private static void clearContactsAndOptionToAdd() {
        deleteAllContacts();
        if (confirm("Would you like to add a new contact? (Y/N) ")) {
            addContact();
        }
    }

    private static void deleteAllContacts() {
        if (confirm("This will delete all contacts. Confirm delete all: (Y/N) ")) {
            Arrays.stream(contacts).forEach(contact -> Arrays.fill(contact, null));
            System.out.println("All contacts have been deleted.\n");
        }
    }

    private static void exitProgram() {
        System.out.println("\nThank you for using our Contact Book!\n");
        System.exit(0);
    }

    private static int readOption() {
        return readInt("Enter your option: ", 7, "Invalid option. Please enter a valid option.");
    }

    private static String readString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    private static int readInt(String message, int max, String errorMsg) {
        int number;
        do {
            System.out.print(message);
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next();
            }
            number = scanner.nextInt();
            scanner.nextLine();
            if (number < 1 || number > max) {
                System.out.println(errorMsg);
            }
        } while (number < 1 || number > max);
        return number;
    }

    private static boolean confirm(String message) {
        String input;
        while (true) {
            System.out.print(message);
            input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("Y")) {
                return true;
            } else if (input.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        }
    }

    private static boolean isContactBookFull() {
        return Arrays.stream(contacts).allMatch(contact -> contact[0] != null);
    }

    private static void addContactInMatrix(String name, String phone, String email) {
        for (String[] contact : contacts) {
            if (contact[0] == null) {
                contact[0] = name;
                contact[1] = phone;
                contact[2] = email;
                return;
            }
        }
    }

    private static void editContactAtIndex(int index) {
        String[] contactInfo = readContactInfo();
        contacts[index][0] = contactInfo[0];
        contacts[index][1] = contactInfo[1];
        contacts[index][2] = contactInfo[2];
        System.out.println("Contact updated successfully.");
    }

    private static List<Integer> searchContactByName(String name) {
        List<Integer> foundIndexes = new ArrayList<>();
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i][0] != null && contacts[i][0].equalsIgnoreCase(name)) {
                foundIndexes.add(i);
            }
        }
        return foundIndexes;
    }

    private static int chooseContact(List<Integer> foundIndexes) {
        if (foundIndexes.size() == 1) {
            return foundIndexes.get(0);
        } else {
            System.out.println("Multiple contacts found:");
            for (int i = 0; i < foundIndexes.size(); i++) {
                int index = foundIndexes.get(i);
                System.out.printf("%d. %s - %s - %s\n", i + 1, contacts[index][0], contacts[index][1], contacts[index][2]);
            }
            return foundIndexes.get(readInt("Enter the number of the contact to choose: ", foundIndexes.size(), "Invalid choice.") - 1);
        }
    }

    private static void contactInfo(String[] contact) {
        System.out.println("Name  : " + contact[0] + "\nPhone : " + contact[1] + "\nEmail : " + contact[2]);
    }

    private static void deleteContactAtIndex(int index) {
        Arrays.fill(contacts[index], null);
    }
}
