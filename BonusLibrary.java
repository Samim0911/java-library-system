import java.util.ArrayList;
import java.util.Scanner;

public class BonusLibrary {
    public static void main(String[] args) {
        ArrayList<BonusBook> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Library System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Display Available Books");
            System.out.println("5. Search for a Book (BONUS)");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    // Using BonusBook constructor
                    int nextId = books.size() + 1;
                    books.add(new BonusBook(nextId, title));
                    System.out.println("Added: " + title + " (ID: " + nextId + ")");
                    break;
                case 2:
                    System.out.print("Enter title to borrow: ");
                    String bTitle = scanner.nextLine();
                    boolean foundBorrow = false;
                    for (BonusBook b : books) {
                        if (b.getTitle().equalsIgnoreCase(bTitle) && !b.isBorrowed()) {
                            b.borrowBook();
                            System.out.println("Success! You borrowed: " + b.getTitle());
                            foundBorrow = true;
                            break;
                        }
                    }
                    if (!foundBorrow) System.out.println("Book not available or not found.");
                    break;
                case 3:
                    System.out.print("Enter title to return: ");
                    String rTitle = scanner.nextLine();
                    boolean foundReturn = false;
                    for (BonusBook b : books) {
                        if (b.getTitle().equalsIgnoreCase(rTitle) && b.isBorrowed()) {
                            b.returnBook();
                            System.out.println("Success! You returned: " + b.getTitle());
                            foundReturn = true;
                            break;
                        }
                    }
                    if (!foundReturn) System.out.println("Could not return. Check title or status.");
                    break;
                case 4:
                    System.out.println("\n--- Available Books ---");
                    for (BonusBook b : books) {
                        if (!b.isBorrowed()) {
                            System.out.println("ID: " + b.getId() + " | Title: " + b.getTitle());
                        }
                    }
                    break;
                case 5:
                    System.out.print("Enter search keyword: ");
                    String search = scanner.nextLine().toLowerCase();
                    System.out.println("\n--- Search Results ---");
                    for (BonusBook b : books) {
                        if (b.getTitle().toLowerCase().contains(search)) {
                            String status = b.isBorrowed() ? "[Borrowed]" : "[Available]";
                            System.out.println("ID: " + b.getId() + " | " + b.getTitle() + " " + status);
                        }
                    }
                    break;
            }
        } while (choice != 6);
        
        System.out.println("Exiting Library System. Goodbye!");
        scanner.close();
    }
}