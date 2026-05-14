package in.sp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import in.sp.main.entities.Student;
import in.sp.main.service.StudentService;

@Controller
public class MyController 
{
	
  @Autowired	
  private StudentService studentService;	
	
  @GetMapping("/home")
   public String openIndexPage()
   {
	   return "home";
   }
  
// GET all Student <- show All students list   
//------------------------------------------------------------------------------  
  @GetMapping("/getStudent") 
  public String getAllStudentPage(Model model)
  {
	  model.addAttribute("students", studentService.getAllStudentDetailes());
	  return "GetStudents";
  }
  
  
  @GetMapping("AddStudentPage/new")
  public String addStudentPage(Model model)
  {
	  model.addAttribute("AddStudent", new Student());
	  return "CreateStudent";
  }
  
//single Student Registration form  
//--------------------------------------------------------------------------------
  @PostMapping("/AddStdForm")
  public String addStudentFormPage(@ModelAttribute("AddStudent") Student student)
  {
	   studentService.AddStudent(student);
	  return "redirect:/getStudent";
  }
  
//--------------------------------------------------------------------  
// Update part (Use GetById method) 
  @GetMapping("/student/edit/{id}")
  public String editStudentPage(@PathVariable int id ,Model model)
  {
	 model.addAttribute("AddStudent", studentService.EditStudentDetailesById(id));
	  return "edit-student";
  }
  
  @PostMapping("/student/edit/{id}")
  public String editStudentForm(@PathVariable int id ,@ModelAttribute("AddStudent") Student student)
  {
	  Student existingStudent  = studentService.EditStudentDetailesById(id);
	  existingStudent.setFirst_Name(student.getFirst_Name());
	  existingStudent.setLast_Name(student.getLast_Name());
	  existingStudent.setEmail(student.getEmail());
	  
	  studentService.AddStudent(existingStudent);
	  return "redirect:/getStudent";
  }
  
// ------------------------------------------------------------------------
 // DELETE Student (Delete By Id)
  
   @GetMapping("/student/delete/{id}")
   public String deleteStudentPage(@PathVariable int id , Model modele)
   {
	   studentService.deleteStudentById(id);
	   return "redirect:/getStudent";
   }
  
}
