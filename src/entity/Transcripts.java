package entity;

import java.io.Serializable;
import java.util.Arrays;

public class Transcripts implements Serializable {
    private static final long serialVersionUID = -5253360267266701102L;
    private Student student;
    private Subject[] subjectList;
    private int[] markList;

    public Transcripts(Student student, Subject[] subjectList, int[] pointList) {
        this.student = student;
        this.subjectList = subjectList;
        this.markList = pointList;
    }


    public Transcripts( ) {

    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject[] getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(Subject[] subjectList) {
        this.subjectList = subjectList;
    }

    public int[] getMarkList() {
        return markList;
    }

    public void setMarkList(int[] markList) {
        this.markList = markList;
    }

    @Override
    public String toString() {
        return "Transcripts{" +
                "student=" + student +
                ", subjectList=" + Arrays.toString(subjectList) +
                ", markList=" + Arrays.toString(markList) +
                '}';
    }
}
