package entity;

import java.io.Serializable;

public class Student extends Person implements Serializable {
    private int id;
    private String collegeClass;

    public Student(String name, String address, String phone, int id, String collegeClass) {
        super(name, address, phone);
        this.id = id;
        this.collegeClass = collegeClass;
    }
    public Student(String name, String address, String phone, String collegeClass) {
        super(name, address, phone);
        this.collegeClass = collegeClass;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollegeClass() {
        return collegeClass;
    }

    public void setCollegeClass(String collegeClass) {
        this.collegeClass = collegeClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", collegeClass='" + collegeClass + '\'' +
                "} " + super.toString();
    }
}

