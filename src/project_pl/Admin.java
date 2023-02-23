/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pl;
public class Admin extends Staff{
//constructors
    public Admin(int id , int age, String fName, String lName, String userName, String pass, Department myDepart, double salary) {
        super(id, age, fName, lName, userName, pass, myDepart, salary);
    }

    public Admin() {
    }

    //Students
    //AddingANewStudent
    public String addNewStudent(String user, String pass, int id  , String fName, String lName, int age, int level, double GPA, Department dept) {
        Student x = new Student(id,age, fName,lName,userName,pass,myDepart,level,GPA);
        return x.addStudent() ? (x + "Added Successfully ... !") : ("Failed to insert ... !");
    }
    //displayAllStudents
    public String displayStudents() {
        Student x = new Student();
        return(x.displayAllStudents());
    }
    //toSearchForAStudent
    public Student searchForStudent(int id  ) {
        Student x = new Student();
        return(x.searchStudent(id));
    }
    //toUpdateStudent
    public String updateStudent(int oldID, Student newStudentValues) {
        Student x = new Student();
        x.updateStudent();
        return("Updated Successfully ... !");
    }
    //toDelete
    public String deleteStudent(int Id) {
        Student x = new Student();
        x.deleteStudent(Id);
        return("deleted Successfully ... !");
    }

    //Professors
    //toAddAProfessor
    public String addNewProf(String user, String pass, int id  , String fname, String lname, int age, double salary, String officeHours, Department dept) {
        Professor x = new Professor(id, age, fName, lName, userName, pass, myDepart,salary,officeHours);
        return x.addProfessor() ? (x + "Added Successfully ... !") : ("Failed to insert ... !");
    }
    //toDisplayProfessors
    public String displayProfs() {
        Professor x = new Professor();
        return(x.displayAllProfessorsData());
    }
    //toSearchForAProf
    public String  searchForProf(int id  ) {
        Professor x = new Professor();
        return(x.searchingForAProfessor(id));
    }
    //toUpdateAProf
    public String updateProf(int oldID, Professor newProfValues) {
        Professor x = new Professor();
        x.updateProfessor();
        return("Updated Successfully ... !");
    }
    //toDeleteAProf
    public String deleteProf(int Id) {
        Professor x = new Professor();
        x.deleteProfessor(Id);
        return("deleted Successfully ... !");
    }

    //TA's
    //addNewTA
    public String addNewTA(String user, String pass, int id  , String fname, String lname, int age, double salary, String academicHours, Department dept) {
        TeachingAssistant x = new TeachingAssistant(id,age,fName,lName,userName,pass,myDepart,salary,academicHours);
        return x.addTA() ? (x + "Added Successfully ... !") : ("Failed to insert ... !");
    }
    //displayAllTA's
    public String displayTAs() {
        TeachingAssistant x = new TeachingAssistant();
        return(x.displayAllTAs());
    }
    //searchForTA
    public String searchForTA(int id  ) {
        TeachingAssistant x = new TeachingAssistant();
        return(x.searchTA(id));
    }
    //updateTA
    public String updateTA(int oldID, TeachingAssistant newTAValues) {
        TeachingAssistant x = new TeachingAssistant();
        x.updateTA();
        return("Updated Successfully ... !");
    }
    //deleteTA
    public String deleteTA(int Id) {
        TeachingAssistant x = new TeachingAssistant();
        x.deleteTA(Id);
        return("deleted Successfully ... !");
    }

    //Courses
    // addNewCourse
    public String addNewCourse(String Cname, int CreditHours,int CId,Department Depart) {
        Course x = new Course(Cname,CreditHours,CId,Depart);
        return x.addCourse() ? (x + "Added Successfully ... !") : ("Failed to insert ... !");
    }
    //displayCourses
    public String displayCourses() {
        Course x = new Course();
        return(x.displayAllCourses());
    }
    //searchForCourse
    public String searchForCourse(int id ) {
        Course x = new Course();
        return(x.searchCourse(id));
    }
    //updateCourse
    public String updateCourse(int oldID, Course newCourseValues) {
        Course x = new Course();
        x.updateCourse();
        return("Updated Successfully ... !");
    }
    //deleteCourse
    public String deleteCourse(int Id) {
        Course x = new Course();
        x.deleteCourse(Id);
        return("deleted Successfully ... !");
    }

    //toString
    @Override
    public String toString() {
        return "I'm Manager : " + fName + " " + lName + "\n" + "ID : " + id + " Age : " + age + " Salary : " + salary + "\n" + "Dept. : " + myDepart.getName() + "\nUserName: " + userName + "\t Password: " + pass + "\n";
    }

    @Override
    public boolean login(String userName, String Pass) {
        return userName.equals("Admin@yahoo.com") && Pass.equals("12345678");
    }
}
