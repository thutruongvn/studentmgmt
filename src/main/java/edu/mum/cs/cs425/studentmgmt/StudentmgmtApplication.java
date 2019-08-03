package edu.mum.cs.cs425.studentmgmt;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repository.ClassroomRepository;
import edu.mum.cs.cs425.studentmgmt.repository.StudentRepository;
import edu.mum.cs.cs425.studentmgmt.repository.TranscriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class StudentmgmtApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private TranscriptRepository transcriptRepository;

    public static void main(String[] args) {
        SpringApplication.run(StudentmgmtApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Task 1
        Student s1 = new Student("000-61-0004", "Lan", "Lynn", "Huynh",  3.95f, LocalDate.of(2019,5,24));
        Student savedS1 = studentRepository.save(s1);
        System.out.println( "Saved Student!" + savedS1.toString() );

        // Task 2
        Student s2 = new Student("000-61-0004", "Anna", "Lynn", "Nguyen",  3.45f, LocalDate.of(2019,5,21));
        Transcript t2 = new Transcript("BS Computer Science", s2);
        Transcript savedT2 = transcriptRepository.save(t2);
        System.out.println( "Saved transcript!" + savedT2.toString() );

        Classroom c = new Classroom("McLaughlin building", "M105");
        Student s3 = new Student("000-61-0004", "Van", "Lynn", "Le",  4.00f, LocalDate.of(2019,5,28),c);
        c.addStudent(s3);
        Classroom savedC = classroomRepository.save(c);
        System.out.println( "Saved Classroom!" + savedC.toString() );

        savedS1.setClassroom(savedC);
        Student savedS1again = studentRepository.save(savedS1);
        System.out.println( "Saved Student again!" + savedS1again.toString() );
    }

}
