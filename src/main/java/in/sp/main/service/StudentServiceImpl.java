package in.sp.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.entities.Student;
import in.sp.main.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
     @Autowired
	 private StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudentDetailes() 
	{
		List<Student> StudentList = studentRepository.findAll();
		return StudentList;
	}

	@Override
	public Student AddStudent(Student student)
	{
		studentRepository.save(student);
		return studentRepository.save(student);
	}

	@Override
	public Student EditStudentDetailesById(int id)
	{
		
		return studentRepository.getById(id);
	}

	@Override
	public void deleteStudentById(int id) 
	{
	    studentRepository.deleteById(id);
		
	}

	

}
