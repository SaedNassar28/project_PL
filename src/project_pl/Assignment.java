/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pl;

import java.io.Serializable;
import java.util.ArrayList;

public class Assignment extends Course implements Serializable {
    private String AssignName;
    private final String AssignFileName ="assignments.bin";
    private int assignId;
    private String Dateline;
    private String AssignType;
    FileManager FManager = new FileManager();
    public static ArrayList <Assignment> assignments=new ArrayList <Assignment>();
    public Assignment() {
    }

    public Assignment(int courseID,String AssignName, int assignId, String Dateline, String AssignType) {
        super.CId=courseID;
        this.AssignName = AssignName;
        this.assignId = assignId;
        this.Dateline = Dateline;
        this.AssignType = AssignType;
    }

    public void setAssignName(String AssignName) {
        this.AssignName = AssignName;
    }

    public void setAssignId(int assignId) {
        this.assignId = assignId;
    }

    public void setDateline(String Dateline) {
        this.Dateline = Dateline;
    }

    public void setAssignType(String AssignType) {
        this.AssignType = AssignType;
    }

    public String getAssignName() {
        return AssignName;
    }


    public int getAssignId() {
        return assignId;
    }

    public String getDateline() {
        return Dateline;
    }

    public String getAssignType() {
        return AssignType;
    }
     private String getAssignmentData(){
     return super.CId+"@"+ this.AssignName+ "@" + this.assignId + "@" + this.Dateline + "@"+ this.AssignType + "@" ;
    }
       public boolean addAssignment(){
           return FManager.write(AssignFileName, getAssignmentData());
    } 
      public boolean commitToFile() {
        return FManager.write(AssignFileName, Courses);
    }
    
    private int getAssignmentIndex(int id){
        for (int i = 0; i < assignments.size(); i++){
            if(assignments.get(i).getAssignId()==(id))
                return i;}
        
        return -1;
    } 
           private void loadFromFile() {
            assignments = (ArrayList<Assignment>) FManager.read(AssignFileName);
    }
         public String searchAssignment(int id){
        loadFromFile();
        int index = getAssignmentIndex(id);
        if(index != -1)
            return "\nFound ...!" + assignments.get(index).toString();
        else 
            return "\nNot Found ...!";
    }   

    public void updateCourse(int oldID, Assignment x){
        loadFromFile();
        int index = getAssignmentIndex(oldID);
        assignments.set(index, x);
        commitToFile();
    }       
}

