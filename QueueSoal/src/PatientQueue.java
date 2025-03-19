import java.util.ArrayList;
import java.util.List;

// Patient Queue implementation using the List interface
class PatientQueue {
    private List<Patient> queue;
    private int capacity;

    // Constructor
    public PatientQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new ArrayList<>(capacity);
    }

    // Add a patient to the queue
    public void enqueue(Patient patient) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot add more patients.");
            return;
        }
        queue.add(patient);
        //tambahkan codingan untuk menambahkan patient ke list patien
        
        System.out.println("Patient added successfully!");
        //tambakan codingan untuk menampilkan informasi pasien yang berhasil ditambakan

    }
    // Remove and return the patient at the front of the queue
    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No patients to process.");
            return null;
        }
        return queue.remove(0);
        //tambakan codingan untuk mengambil pasien dari queue dan return kan data pasien nya
    }

    // View the patient at the front without removing
    public Patient peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No patients to view.");
            return null;
        }
        return queue.get(0);
        //tambakan codingan untuk me return  pasien yang ada di antrian pertama
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
        //tambahkan codingan untuk me return apakah variabel queue kosong atau tidak
    }

    // Check if queue is full
    public boolean isFull() {
        return queue.size() >= capacity;
        //tambahkan codingan untuk me return apakah variabel isi variabel queue melebihi nilai variabel capacity
    }

    // Get the current size of the queue
    public int size() {
        return queue.size();
        //tambahkan codingan untuk me return jumlah pasien dalam queue
    }

    // Display all patients in the queue
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No patients to display.");
            return;
        }

        System.out.println("\n----- Current Patient Queue -----");
        System.out.println("Position | ID    | Name             | Age | Complaint");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < queue.size(); i++) {
            Patient p = queue.get(i);
            System.out.printf("%-9d| %-5s | %-16s | %-3d | %s\n",
                    (i+1), p.getId(), p.getName(), p.getAge(), p.getComplaint());
        }
        System.out.println("--------------------------------------------------");
    }
}