/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pl;

import java.io.Serializable;
import java.util.ArrayList;

public class Questions extends Exam implements Serializable {

    private int QId;
    int examId;
    protected final String questionFileName = "question.bin";
    public ArrayList<Questions> questions = new ArrayList<>();
    ModelAns modelAns;
    public Questions() {
    }

    public Questions(int QId, int examId) {
        super.EId=examId;
        this.QId = QId;
        this.examId = examId;
    }

    public void setQId(int QId) {
        this.QId = QId;
    }

    public int getQId() {
        return QId;
    }

    public String getQuesData() {
        return super.EId + "@" + this.QId + "@" + this.questions + "@";
    }

    private int getQuesIndex(int id) {

        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).getQId() == id)
                return i;
        }
        return -1;
    }

    public boolean addQuestions() {
        return FManager.write(questionFileName, getQuesData());
    }

    public void updateQuestions(int oldId, Exam x) {
        loadFromFile();
        int index = getQuesIndex(oldId);
        exams.set(index, x);
        commitToFile();
    }

    public void deleteQuestion(int QId) {
        loadFromFile();
        int index = getQuesIndex(EId);
        exams.remove(index);
        commitToFile();
    }

    public double correct(ArrayList <String> stdAns){
        int score = 0;
        if (super.EId == modelAns.modelAnsId) {
            for (int i = 0; i < questions.size(); i++)
                if (stdAns.get(i).equals(modelAns.getModelAns().get(i)))
                    score++;
        }
        return score;
    }

    private void loadFromFile() {
        questions = (ArrayList < Questions >) FManager.read(questionFileName);
    }

    public void commitToFile() {
        FManager.write(questionFileName,questions.get(0).getQuesData());
        for (int i = 1; i < questions.size(); i++)
            FManager.write(questionFileName,questions.get(i).getQuesData());

    }

}
