package model;

import java.time.*;

public class Depense {
	
	public static int totalDep;
	
	private float cout;
	private LocalDate dateDep;
	private Employe emp;
	private String description;
	private int id;
	
	public Depense(Employe e, String c, float p, LocalDate d) {
		description =c;
		cout = p;
		emp = e;
		dateDep = d;
		id = totalDep;
		totalDep++;
	}
	
	public Employe getEmp() {
		return emp;
	}
	
	public int getId() {
    	return id;
    }
	
    public String getDescription() {
    	return description;
    }
    
	public void setDescription(String s) {
		description = s;
	}
    
    public float getCout() {
    	return cout;
    }
    
    public void setCout(float s) {
    	cout = s;
    }
    
    public LocalDate getDate() {
    	return dateDep;
    }
    
    public void setDate(LocalDate d) {
    	dateDep = d;
    }
    
    public Employe getEmploye() {
    	return emp;
    }
    
    public void setEmploye(Employe e) {
    	emp = e;
    }
}
