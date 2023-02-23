/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pl;



import java.io.Serializable;
import java.util.ArrayList;

public class Professor  extends  Staff implements Serializable {
    //dataFields
    private final String professorFileName = "Professor.bin";
    public  String officeHours;
    public ArrayList<Professor> Professors= new ArrayList<>();

    //constructors
    public Professor() {}
    public Professor(int id  , int age, String fName, String lName, String userName,
                     String pass, Department myDepart, double salary, String officeHours) {
        super(id, age, fName, lName, userName, pass, myDepart, salary);
        this.officeHours = officeHours;
    }

    //Setters
    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public String getOfficeHours() {
        return officeHours;
    }
    

    //writesANewProfessorDataToTheFile
    public boolean addProfessor(){
        loadDataFromFile();
        Professors.add(this);
        return commitToFile();
    }

    //deleteProfessor
    public boolean  deleteProfessor(int id  ){
        loadDataFromFile();
        int index = getProfIndex(id);
      if (index != -1) {
            Professors.remove(index);

            return commitToFile();
        }

        return false;
    } 

    //updateProfessor
    public boolean updateProfessor(){
        loadDataFromFile();
        int index = getProfIndex(this.getID());

        if (index != -1) {
            Professors.set(index, this);

            return commitToFile();
        }

        return false;
    }

    //convertTheDataToAStringSeparatedBy@
    private  String getProfData() {
        return id+"@" +age+"@"+fName+"@"+lName+"@"+myDepart.getName()+"@"+
                userName+"@"+pass+"@"+officeHours+"@"+salary ;
    }
    public ArrayList<Professor> listProfessors() {
        loadDataFromFile();
        return Professors;
    }

    //committingTheListOfProfessorsToAFile
     public boolean commitToFile() {
        return fManger.write(professorFileName, Professors);
    }

    //loadDataFromFile
    private void loadDataFromFile(){
        Professors=(ArrayList<Professor>) fManger.read(professorFileName);
    }

    //searchingForTheIndexOfSpecificProfessorID
    private int getProfIndex( int id  ){
        for (int index = 0; index < Professors.size(); index++)
            if(Professors.get(index).getID() == id)
                return index;
        return -1;
    }

    //searchingForAProfessor
    public String searchingForAProfessor(int id  ){
        loadDataFromFile();
        int index= getProfIndex(id);
        return index != -1 ? "Professor Found\n" + Professors.get(index).toString() : "Professor Not Found\n";
    }

    //displayAllProfessorsData
    public String displayAllProfessorsData(){
        loadDataFromFile();
        String S ="\nAll Professor Data\n";
        for (Professor x : Professors) S = S + x.toString();
        return S;
    }
       public Professor searchProfById(int id) {
        Professor temp = new Professor();
        loadDataFromFile();
        int index = getProfIndex(id);
        if (index != -1) {
            return Professors.get(index);
        } else {
            return temp;
        }
    }

    //convertTheDataToAFormattedString
    @Override
    public String toString() {
        return "I'm Prof. : "+fName+" "+lName+"\nID: "+id+" Age: " +age+" Salary: "+salary+
                "\nDept: "+myDepart.getName()+
                " UserName: "+userName+" Password: "+pass+" OfficeHours: "+officeHours+".\n";
    }
    @Override
    public boolean login(String userName, String Pass) {
        loadDataFromFile();
        for (Professor x : Professors) {
            if (userName.equals(x.userName) && Pass.equals(x.pass)) return true;
        }
        return false;
    }
}

