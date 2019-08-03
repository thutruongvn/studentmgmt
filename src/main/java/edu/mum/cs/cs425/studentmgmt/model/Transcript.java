package edu.mum.cs.cs425.studentmgmt.model;

import javax.persistence.*;


@Entity
@Table(name = "transcripts")
public class Transcript {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long transcriptId;

    private String degreeTitle;

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "studentId", nullable = false)
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Transcript() { }

    public Transcript(String degreeTitle, Student student) {
        this.degreeTitle = degreeTitle;
        this.student = student;
    }

    @Override
    public String toString() {
        return "Transcript{" +
                "transcriptId=" + transcriptId +
                "degreeTitle=" + degreeTitle + '\'' +
                "student=" + student.toString() + '\'' +
                '}';
    }
}
