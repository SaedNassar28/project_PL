/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pl;
import java.io.Serializable;
import java.util.ArrayList;
public class Student extends Person implements Serializable {
    public int level;
    public double GPA;
    private final String studentFileName = "Student.bin";
    public ArrayList<Student>Students=new ArrayList<Student>();

    public Student() {}

    public Student(int id , int age, String fName, String lName, String userName, String pass, Department myDepart, int level, double GPA) {
        super(id, age, fName, lName, userName, pass, myDepart);
        this.level = level;
        this.GPA = GPA;
    }

    public boolean addStudent(){
        loadFromFile();
        Students.add(this);
        return commitToFile();
    }
    public void loadFromFile(){
        Students=(ArrayList<Student>) fManger.read(studentFileName);
    }
    public boolean commitToFile() {
        return fManger.write(studentFileName, Students);
    }
    private int getStudentindex(int id ){
        for(int i=0; i<Students.size(); i++)
            if(Students.get(i).getID()==id)
                return i;
        return -1;
    }
    public String displayAllStudents(){
        loadFromFile();
        String S = "\nAll Student Data:\n";
        for (Student x : Students) {
            S = S + x.toString();
        }
        return S;
    }
    public ArrayList<Student> listStudents() {
        loadFromFile();
        return Students;
    }
    public Student searchStudent(int id ){
        Student temp = new Student();
        loadFromFile();
        int index = getStudentindex(id);
        if (index != -1) {
            return Students.get(index);
        } else {
            return temp;
        }
    }
 
    public boolean deleteStudent(int id ){
        loadFromFile();
        int index = getStudentindex(id);
        if (index != -1) {
            Students.remove(index);
            return commitToFile();
        }

        return false;
    }
    public boolean updateStudent(){
        loadFromFile();
        int index = getStudentindex(this.getID());

        if (index != -1) {
            Students.set(index, this);

            return commitToFile();
        }

        return false;
    }

    private String getStudData() {
        return this.id+"@"+this.age+"@"+this.fName+"@"+this.lName+"@"+this.level+"@"+this.GPA;
    }

    @Override
    public String toString() {
        return "\nI'm Eng : " + fName + " " + lName + "\n" + "ID : " + id + " Age : " + age + "\n"
                + "Level : " + level + " GPA : " + GPA + "\nDept: " + myDepart.getName() + "\nUserName: " + userName + "\t Password: " + pass + "\n";
    }
    public void study() {
        System.out.println("I'm Studying Undergraduate Courses @ FCIH :) ");
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public int getLevel() {
        return level;
    }

    public double getGPA() {
        return GPA;
    }
 public Student searchStudentById(int id ) {
        Student temp = new Student();
        loadFromFile();
        int index = getStudentindex(id);
        if (index != -1) {
            return Students.get(index);
        } else {
            return temp;
        }
    }
   
    
    @Override
    public boolean login(String userName, String Pass) {
        loadFromFile();
        for (Student x : Students) {
            if (userName.equals(x.userName) && Pass.equals(x.pass)) {
                return true;
            }
        }
        return false;
    }
}