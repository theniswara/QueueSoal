// Patient class with simplified properties
class Patient {
    private String id;
    private String name;
    private int age;
    private String complaint;

    public Patient(String id, String name, int age, String complaint) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.complaint = complaint;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getComplaint() {
        return complaint;
    }
}