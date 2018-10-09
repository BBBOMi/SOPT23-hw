package org.sopt;

import org.sopt.model.Department;
import org.sopt.model.Professor;
import org.sopt.model.Student;
import org.sopt.model.University;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // 제네릭을 사용해 각 타입의 ArrayList 생성
	    final ArrayList<University> universityList = new ArrayList<>();
        final ArrayList<Department> departmentList = new ArrayList<>();
        final ArrayList<Professor> professorList = new ArrayList<>();
        final ArrayList<Student> studentList = new ArrayList<>();

	    // 각각 3개의 객체 생성
	    final University university1 = new University();
	    final University university2 = new University();
	    final University university3 = new University();

        final Department department1 = new Department();
        final Department department2 = new Department();
        final Department department3 = new Department();

        final Professor professor1 = new Professor();
        final Professor professor2 = new Professor();
        final Professor professor3 = new Professor();

        final Student student1 = new Student();
        final Student student2 = new Student();
        final Student student3 = new Student();

	    // ArrayList에 객체 add
        universityList.add(university1);
        universityList.add(university2);
        universityList.add(university3);

        departmentList.add(department1);
        departmentList.add(department2);
        departmentList.add(department3);

        professorList.add(professor1);
        professorList.add(professor2);
        professorList.add(professor3);

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        // ArrayList를 돌면서 각 객체의 toString 메소드 실행
        for(final University u : universityList) {
            System.out.println(u.toString());
        }

        for(final Department d : departmentList) {
            System.out.println(d.toString());
        }

        for(final Professor p : professorList) {
            System.out.println(p.toString());
        }

        for(final Student s : studentList) {
            System.out.println(s.toString());
        }
    }
}
