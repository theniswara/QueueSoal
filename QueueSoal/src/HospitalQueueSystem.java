import java.util.Scanner;



// Main class with menu-driven interface
public class HospitalQueueSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientQueue queue = new PatientQueue(10); // Create a queue with capacity 10
        int patientCounter = 1;
        boolean running = true;

        System.out.println("===== Welcome to Hospital Queue System =====");

        while (running) {
            displayMenu();

            System.out.print("Enter your choice: ");
            int choice = getIntInput(scanner);

            switch (choice) {

                case 1: // Add a new patient
                    if (queue.isFull()) {
                        System.out.println("Sorry, the queue is full. Cannot add more patients.");
                    } else {
                        System.out.println("\n----- Adding New Patient -----");
                        String id = "P" + String.format("%03d", patientCounter++);

                        System.out.print("Enter patient name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter patient age: ");
                        int age = getIntInput(scanner);

                        System.out.print("Enter chief complaint: ");
                        String complaint = scanner.nextLine();

                        Patient newPatient = new Patient(id, name, age, complaint);
                        queue.enqueue(newPatient);
                    }
                    break;

                case 2: // Process next patient
                    Patient nextPatient = queue.dequeue();
                    if (nextPatient != null) {
                        System.out.println("\n----- Processing Patient -----");
                        System.out.println("Now serving: " + nextPatient.getName() + " (ID: " + nextPatient.getId() + ")");
                        System.out.println("Age: " + nextPatient.getAge());
                        System.out.println("Complaint: " + nextPatient.getComplaint());
                    }
                    break;

                case 3: // View next patient
                    Patient peekPatient = queue.peek();
                    if (peekPatient != null) {
                        System.out.println("\n----- Next Patient in Queue -----");
                        System.out.println("Next patient: " + peekPatient.getName() + " (ID: " + peekPatient.getId() + ")");
                    }
                    break;

                case 4: // Display all patients
                    queue.displayQueue();
                    break;
                    
                case 5: // Display queue statistics
                    System.out.println("\n----- Queue Statistics -----");
                    System.out.println("Total patients in queue: " + queue.size());
                    System.out.println("Queue capacity: 10");
                    System.out.println("Available slots: " + (10 - queue.size()));
                    break;

                case 6: // Exit
                    System.out.println("\nThank you for using the Hospital Queue System. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    // Helper method to display the menu
    private static void displayMenu() {
        System.out.println("\n===== Hospital Queue System Menu =====");
        System.out.println("1. Add a new patient");
        System.out.println("2. Process next patient");
        System.out.println("3. View next patient");
        System.out.println("4. Display all patients");
        System.out.println("5. Display queue statistics");
        System.out.println("6. Exit");
    }

    // Helper method to safely get integer input
    private static int getIntInput(Scanner scanner) {
        int input = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }

        return input;
    }
}