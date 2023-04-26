import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private String gender;
    private String className;
    private String email;
    private String address;
    private double average;

    public Student() {
    }

    public Student(int id, String name, String gender, String className, String email, String address, double average) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.className = className;
        this.email = email;
        this.address = address;
        this.average = average;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-20s %-15s %-15s %-15s %-15s %-15s" ,
                getId(), getName(), getGender(), getClassName(), getEmail(), getAddress(), getAverage());
    }
}
