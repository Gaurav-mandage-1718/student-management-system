package in.sp.main.service;

import java.util.List;

import in.sp.main.entities.Student;

public interface StudentService 
{
   public List<Student> getAllStudentDetailes();
   public Student AddStudent(Student student);
   public Student EditStudentDetailesById(int id);
   public void deleteStudentById(int id);
}
