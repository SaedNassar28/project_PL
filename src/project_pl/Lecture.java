/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pl;
import java.io.Serializable;
import java.util.ArrayList;


public class Lecture extends Course implements Serializable {
    private int CourseID;
    private String lecName;
    private int lecId;
    private String lecTime;
    private final String LectureFileName="Lecture.bin";
    public static ArrayList <Lecture> Lectures=new ArrayList <Lecture>();
    FileManager fManager = new FileManager();

    public Lecture() {
    }

    public Lecture(int CourseID,String lecName, int lecId, String lecTime) {
        this.lecName = lecName;
        this.lecId = lecId;
        this.lecTime = lecTime;
        super.CId=CourseID;
    }

   

   

    public String getLecName() {
        return lecName;
    }

    public void setLecName(String lecName) {
        this.lecName = lecName;
    }

    public int getLecId() {
        return lecId;
    }

    public void setLecId(int lecId) {
        this.lecId = lecId;
    }

    public String getLecTime() {
        return lecTime;
    }

    public void setLecTime(String lecTime) {
        this.lecTime = lecTime;
    }
    
      private String getLectureData(){
      return super.CId + "@" + this.lecId + "@" + this.lecName + "@" + this.lecTime + "@" ;
    }
       public boolean addLecture(){
           return fManager.write(LectureFileName, getLectureData());
    }
       public boolean commitToFile() {
        return FManager.write(LectureFileName, Courses);
    }
        private int getLectureIndex(int id){
        for (int i = 0; i < Lectures.size(); i++){
            if(Lectures.get(i).getLecId()==(id))
                return i;}
        
        return -1;
    }
         private void loadFromFile() {
            Lectures = (ArrayList<Lecture>) fManager.read(LectureFileName);
    }
           public String displayAllLectures() {
        loadFromFile();
        String S = "\nAll Lectures Data:\n";
        for (Lecture x : Lectures) {
            S = S + x.toString();
        }
        return S;
    }
           public String searchLecture(int id){
        loadFromFile();
        int index = getLectureIndex(id);
        if(index != -1)
            return "\nFound ...!" + Lectures.get(index).toString();
        else 
            return "\nNot Found ...!";
    }  
  
          public void updateCourse(int oldID, Lecture x){
        loadFromFile();
        int index = getLectureIndex(oldID);
        Lectures.set(index, x);
        commitToFile();
    } 
         @Override
    public String toString() {
     return "Lecture Name : " + lecName + "\nLecture ID : " + lecId + "\n Lecture Time : " + lecTime + "\n " ;
    } 
    
}
