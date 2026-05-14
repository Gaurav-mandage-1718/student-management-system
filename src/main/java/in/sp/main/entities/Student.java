package in.sp.main.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Student 
{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private int id;	
  
  @Column(name="first_name")
  private String first_Name;
  
  @Column(name="last_name")
  private String last_Name;
  
  @Column
  private String email;



  public int getId() {
	return id;
  }

  public void setId(int id) {
	this.id = id;
  }

  public String getFirst_Name() {
	return first_Name;
  }

  public void setFirst_Name(String first_Name) {
	this.first_Name = first_Name;
  }

  public String getLast_Name() {
	return last_Name;
  }

  public void setLast_Name(String last_Name) {
	this.last_Name = last_Name;
  }

  public String getEmail() {
	return email;
  }

  public void setEmail(String email) {
	this.email = email;
  }
  
  
}
