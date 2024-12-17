import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement management = new StudentManagement();

        while (true) {
            try {
                System.out.println("\n=== MENU ===");
                System.out.println("1. Add student");
                System.out.println("2. Display student list");
                System.out.println("3. Update student score");
                System.out.println("4. Delete student");
                System.out.println("5. Search student");
                System.out.println("6. Sort students by score");
                System.out.println("7. Sort students by name");
                System.out.println("8. Exit");
                System.out.print("Choose an option (1-8): ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter student ID: ");
                        String id = scanner.nextLine();

                        String name;
                        while (true) {
                            System.out.print("Enter student name: ");
                            name = scanner.nextLine();
                            if (name.matches("[a-zA-Z ]+")) {  // Only letters and spaces are allowed
                                break;
                            } else {
                                System.out.println("Invalid input! Name must contain only letters.");
                            }
                        }

                        System.out.print("Enter student score: ");
                        double score = Double.parseDouble(scanner.nextLine());
                        management.addLast(new Student(id, name, score));
                        break;
                    case 2:
                        management.traverse();
                        break;
                    case 3:
                        System.out.print("Enter student ID to update: ");
                        id = scanner.nextLine();
                        System.out.print("Enter new score: ");
                        score = Double.parseDouble(scanner.nextLine());
                        management.updateStudent(id, score);
                        break;
                    case 4:
                        System.out.print("Enter student ID to delete: ");
                        id = scanner.nextLine();
                        management.deleteById(id);
                        break;
                    case 5:
                        System.out.print("Enter student ID to search: ");
                        id = scanner.nextLine();
                        Student student = management.searchById(id);
                        if (student != null) {
                            System.out.println(student);
                        } else {
                            System.out.println("Student not found!");
                        }
                        break;
                    case 6:
                        management.bubbleSortByScore();
                        break;
                    case 7:
                        management.insertionSortByName();
                        break;
                    case 8:
                        System.out.println("Exiting the program.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input error! Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}