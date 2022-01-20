package entity;

import java.io.Serializable;

public class Subject implements Serializable {
    private static final long serialVersionUID = -4579811909883165803L;
    private int id;
    private String name;
    private String type;
    private int totalUnit;

    public Subject(int id, String name, String type, int totalUnit) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.totalUnit = totalUnit;
    }
    public Subject( String name, String type, int totalUnit) {
        this.name = name;
        this.type = type;
        this.totalUnit = totalUnit;
    }

    public Subject() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotalUnit() {
        return totalUnit;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", totalUnit=" + totalUnit +
                '}';
    }

    public void setTotalUnit(int totalUnit) {
        this.totalUnit = totalUnit;
    }
}
