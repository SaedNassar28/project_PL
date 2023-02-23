/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pl;
import java.io.Serializable;
import java.util.ArrayList;

public class TeachingAssistant extends Staff implements Serializable {
    //dataFields
    private String academicHours;
    private final String TAFileName = "TA.bin";
    public static ArrayList<TeachingAssistant> TAs = new ArrayList<>();

    //Constructor
  public ArrayList<TeachingAssistant> listTAs() {
        loadFromFile();
        return TAs;
    }

    public TeachingAssistant() {
    }

    public TeachingAssistant(int id  , int age, String fName, String lName, String userName, String pass, Department myDepart, double salary, String academicHours) {
        super(id, age, fName, lName, userName, pass, myDepart, salary);
        this.academicHours = academicHours;
    }

    //setters
    public void setAcademicHours(String academicHours) {
        this.academicHours = academicHours;
    }

    //getters
    public String getAcademicHours() {
        return academicHours;
    }

    //toGetTheIndexOfTheTAInTheArray
    private int getTAIndex(int id  ){
        for (int index = 0; index < TAs.size(); index++)
            if(TAs.get(index).getID() == id)
                return index;
        return -1;
    }

    //toAddTAToAFile
    public boolean addTA() {
        return fManger.write(TAFileName, getTAData());
    }

    //toUpdateTAs
    public boolean updateTA(){
        loadFromFile();
        int index = getTAIndex(this.id);

        if (index != -1) {
            TAs.set(index, this);

            return commitToFile();
        }

        return false;
    }

    //deleteTA
    public boolean deleteTA(int id  ){
        loadFromFile();
     int index = getTAIndex(id);

        if (index != -1) {
            TAs.remove(index);

            return commitToFile();
        }
           return false;
    }
    //ToGetTADataAsAString
    private String getTAData() {
        return this.id + "@" + this.fName + "@" + this.lName + "@" + this.age + "@" + this.salary + "@" + this.academicHours + "@" + this.myDepart.getName() + "@" + this.userName + "@" + this.pass + "@";
    }

    //ToCommitTheTADataToAFile
     public boolean commitToFile() {
        return fManger.write(TAFileName, TAs);
    }


    //toLoadTheDataFromTheFile
    private void loadFromFile() {
        TAs = (ArrayList<TeachingAssistant>) fManger.read(TAFileName);
    }
public TeachingAssistant searchTAsById(int id) {
        TeachingAssistant temp = new TeachingAssistant();
        loadFromFile();
        int index = getTAIndex(id);
        if (index != -1) {
            return TAs.get(index);
        } else {
            return temp;
        }
    }
//toViewAllTAsData
public String displayAllTAs() {
    loadFromFile();
    String S = "\nAll TAs Data:\n";
    for (TeachingAssistant x : TAs) S = S + x.toString();
    return S;
}

//toSearchForATA
public String searchTA(int id  ){
    loadFromFile();
    int index = getTAIndex(id);
    return index != -1 ? "\nFound ...!" + TAs.get(index).toString() : "\nNot Found ...!";
}

//toString
    @Override
    public String toString() {
        return "\nI'm Teaching Assistant : " + fName + " " + lName + "\n" + "ID : " + id +
                " Age : " + age + " Salary : " + salary + "\n" + "Dept. : " + myDepart.getName() +
                "\nUserName: " + userName + "\t Password: " + pass + "\n";
    }

    @Override
    public boolean login(String userName, String Pass) {
        loadFromFile();
        for (TeachingAssistant x : TAs) {
            if (userName.equals(x.userName) && Pass.equals(x.pass)) return true;
        }
        return false;
    }


}
