/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pl;
import java.io.Serializable;
import java.util.*;

public class Course implements Serializable {
    private String Cname;
    public int CreditHours;
    private final String CourseFileName ="Courses.bin";
    protected int CId;
    public static ArrayList <Course> Courses=new ArrayList <Course>();
    FileManager FManager = new FileManager();
    public Department Depart;
    Assignment assign;
    public Course() {
    }
    public Course(String Cname, int CreditHours, int CId, Department Depart) {
        this.Cname = Cname;
        this.CreditHours = CreditHours;
        this.CId = CId;
        this.Depart = Depart;
    }

    public String getCname() {
        return Cname;
    }

    public void setDepart(Department Depart) {
        this.Depart = Depart;
    }

    public Department getDepart() {
        return Depart;
    }

    public void setCname(String Cname) {
        this.Cname = Cname;
    }

    public int getCreditHours() {
        return CreditHours;
    }

    public void setCreditHours(int CreditHours) {
        this.CreditHours = CreditHours;
    }

    public int getCId() {
        return CId;
    }

    public void setCId(int CId) {
        this.CId = CId;
    }
    private String getCourseData(){
     return this.CId + "@" + this.Cname + "@" + this.CreditHours + "@"+ this.Depart + "@" ;
    }
    public boolean addCourse(){
        return FManager.write(CourseFileName, getCourseData());
    }
    public Course searchCourseById(int id) {
        Course temp = new Course();
        loadFromFile();
        int index = getCourseIndex(id);
        if (index != -1) {
            return Courses.get(index);
        } else {
            return temp;
        }
    }
     public boolean commitToFile() {
        return FManager.write(CourseFileName, Courses);
    }
        public ArrayList<Course> listCourses() {
        loadFromFile();
        return Courses;
    }
    
    private int getCourseIndex(int id){
        for (int i = 0; i < Courses.size(); i++){
            if(Courses.get(i).getCId()==id)
                return i;}

        return -1;
    }
        private void loadFromFile() {
            Courses = (ArrayList<Course>) FManager.read(CourseFileName);
    }
      public String displayAllCourses() {
        loadFromFile();
        String S = "\nAll Courses Data:\n";
        for (Course x : Courses) {
            S = S + x.toString();
        }
        return S;
    }

    public String searchCourse(int id){
        loadFromFile();
        int index = getCourseIndex(id);
        if(index != -1)
            return "\nFound ...!" + Courses.get(index).toString();
        else
            return "\nNot Found ...!";
    }
    public boolean deleteCourse(int id){
        loadFromFile();
        int index = getCourseIndex(id);
     
        if (index != -1) {
            Courses.remove(index);

            return commitToFile();
        }
            return false;
    }
    public boolean updateCourse(){
        loadFromFile();
        int index = getCourseIndex(this.CId);

        if (index != -1) {
            Courses.set(index, this);

            return commitToFile();
        }

        return false;
    }
     @Override
    public String toString() {
     return "Course Name : " + Cname + "\nCourse ID : " + CId + "\n Credit hours : " + CreditHours+ "\n Department : " + Depart + "\n" ;
    }


}