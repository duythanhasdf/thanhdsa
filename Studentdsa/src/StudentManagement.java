public class StudentManagement {
    private Node head; // Head of the linked list

    // Constructor
    public StudentManagement() {
        this.head = null;
    }

    // 1. Add student to the beginning of the list
    public void addFirst(Student student) {
        Node newNode = new Node(student);
        newNode.next = head;
        head = newNode;
        System.out.println("Student added.");
    }

    // 2. Add student to the end of the list
    public void addLast(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
            System.out.println("Student added.");
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // 3. Delete student from the beginning of the list
    public void deleteFirst() {
        if (head == null) {
            System.out.println("The list is empty!");
            return;
        }
        head = head.next;
    }

    // 4. Delete student from the end of the list
    public void deleteLast() {
        if (head == null) {
            System.out.println("The list is empty!");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    // 5. Traverse the list and print student information
    public void traverse() {
        if (head == null) {
            System.out.println("The list is empty!");
            return;
        }
        Node current = head;
        System.out.println("\nStudent List:");
        System.out.println(String.format("%-10s %-20s %-5s %-10s", "Student ID", "Student Name", "Score", "Rank"));
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // 6. Search for a student by ID
    public Student searchById(String id) {
        Node current = head;
        while (current != null) {
            if (current.data.getId().equalsIgnoreCase(id)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    // 7. Update a student's score by ID
    public void updateStudent(String id, double newScore) {
        Node current = head;
        while (current != null) {
            if (current.data.getId().equalsIgnoreCase(id)) {
                current.data = new Student(id, current.data.getName(), newScore);
                System.out.println("Updated the score for student " + id);
                return;
            }
            current = current.next;
        }
        System.out.println("Student not found with ID: " + id);
    }

    // 8. Delete student by ID
    public void deleteById(String id) {
        if (head == null) {System.out.println("The list is empty!");
            return;
        }
        if (head.data.getId().equalsIgnoreCase(id)) {
            head = head.next;
            System.out.println("Deleted student " + id);
            return;
        }
        Node current = head;
        while (current.next != null && !current.next.data.getId().equalsIgnoreCase(id)) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Student not found with ID: " + id);
        } else {
            current.next = current.next.next;
            System.out.println("Deleted student " + id);
        }
    }

    // 9. Sort students by score (bubble sort)
    public void bubbleSortByScore() {
        if (head == null || head.next == null) return;
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.data.getScore() > current.next.data.getScore()) {
                    // Swap data between two nodes
                    Student temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println("The list has been sorted by score in ascending order.");
    }

    // 10. Sort students by name (Insertion Sort)
    public void insertionSortByName() {
        if (head == null || head.next == null) return;
        Node sorted = null;

        Node current = head;
        while (current != null) {
            Node next = current.next;

            // Insert node into the sorted list
            if (sorted == null || sorted.data.getName().compareToIgnoreCase(current.data.getName()) >= 0) {
                current.next = sorted;
                sorted = current;
            } else {
                Node temp = sorted;
                while (temp.next != null && temp.next.data.getName().compareToIgnoreCase(current.data.getName()) < 0) {
                    temp = temp.next;
                }
                current.next = temp.next;
                temp.next = current;
            }
            current = next;
        }
        head = sorted;
        System.out.println("The list has been sorted by name from A-Z.");
    }
}