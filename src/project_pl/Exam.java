/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pl;

import java.io.Serializable;
import java.util.ArrayList;

public class Exam implements Serializable {

    protected String EName;
    protected Double maxGrade;
    protected int EId;
    protected double score = 0;
    public ArrayList<Questions> questions=new ArrayList<Questions>();
    protected final String ExamsFileName = "Exams.bin";

    public ArrayList<Exam> exams= new ArrayList<>();

    FileManager FManager = new FileManager() ;

    public Exam(String EName, int EId, double maxGrade) {

        this.EName = EName;
        this.EId = EId;
        this.maxGrade = maxGrade;
    }

    public Exam() {
    }

    public void setEId(int EId) {
        this.EId = EId;
    }

    public int getEId() {
        return EId;
    }

    public String getExamData() {

        return this.EName + "@" + this.EId + "@" + this.ExamsFileName + "@";
    }

    private void loadFromFile() {
        exams = (ArrayList <Exam>) FManager.read(ExamsFileName);
    }

    private int getExamIndex(int id) {

        for (int i = 0; i < exams.size(); i++) {
            if (exams.get(i).getEId() == id)
                return i;
        }
        return -1;
    }

    public void commitToFile() {
        FManager.write(ExamsFileName,exams.get(0).getExamData());
        for (int i = 1; i < exams.size(); i++)
            FManager.write( ExamsFileName,exams.get(i).getExamData());

    }

    public boolean addExam() {
        return FManager.write(ExamsFileName, getExamData());
    }

    public void deleteExam(int EId) {
        loadFromFile();
        int index = getExamIndex(EId);
        exams.remove(index);
        commitToFile();
    }

    public void updateExam(int oldId, Exam x) {
        loadFromFile();
        int index = getExamIndex(oldId);
        exams.set(index, x);
        commitToFile();
    }

    public void  stdAns(ArrayList<String > stdAns){
        ArrayList<String> studAns = stdAns;
    }   //ab3tha l sa3id

    public ArrayList<Questions> getQuestions() {
        return questions;
    }


    public String getGrade() {

        String grade = "";
        if (score < 65)
            grade = "F";
        else if (score >= 65 && score <= 69)
            grade = "E";

        else if (score >= 70 && score <= 74)
            grade = "D";

        else if (score >=75 && score <= 79)
            grade = "C";

        else if (score >= 80 && score <= 84)
            grade = "B";

        else if (score >= 85 && score <= 100)
            grade = "A";

        return "Grade is: " + grade;
    }

    public String passPercentage() {

        return "pass percentage is: " + (score / maxGrade) * 100 + "%";
    }

    // @override
    public String toString() {
        return "Exam Name :" + EName + "\nMax Grade :" + maxGrade + "\nE id :" + EId + "\nscore :" + score;
    }
}