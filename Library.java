import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Library System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Display Available Books");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    books.add(new Book(title));
                    break;
                case 2:
                    System.out.print("Enter title to borrow: ");
                    String bTitle = scanner.nextLine();
                    for (Book b : books) {
                        if (b.getTitle().equalsIgnoreCase(bTitle) && !b.isBorrowed()) {
                            b.borrowBook();
                            System.out.println("You borrowed " + bTitle);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter title to return: ");
                    String rTitle = scanner.nextLine();
                    for (Book b : books) {
                        if (b.getTitle().equalsIgnoreCase(rTitle)) {
                            b.returnBook();
                            System.out.println("You returned " + rTitle);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Available Books:");
                    for (Book b : books) {
                        if (!b.isBorrowed()) System.out.println("- " + b.getTitle());
                    }
                    break;
            }
        } while (choice != 5);
        scanner.close();
    }
}