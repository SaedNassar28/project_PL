/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pl;
import java.io.Serializable;
import java.util.ArrayList;

public class ModelAns extends Exam implements Serializable {

    protected String modelAnsName;
    protected int modelAnsId;
    protected int examId;
    protected ArrayList<String> modelAns = new ArrayList<>();
    protected final String modelAnsFileName = "modelAns.bin";
    public ArrayList<ModelAns> ans =new ArrayList<>();

    FileManager fManager = new FileManager() ;

    public ModelAns(String modelAnsName, int modelAnsId, int examId) {

        super.EId = examId;
        this.modelAnsName = modelAnsName;
        this.modelAnsId = modelAnsId;
    }

    public ModelAns() {
    }

    public void setModelAnsId(int modelAnsId) {
        this.modelAnsId = modelAnsId;
    }

    public int getModelAnsId() {
        return modelAnsId;
    }

    public void commitToFile() {
        fManager.write( modelAnsFileName,ans.get(0).getModelAnsData());
        for (int i = 1; i < ans.size(); i++)
            fManager.write(modelAnsFileName,ans.get(i).getModelAnsData());
    }

    public void loadFromFile() {
        modelAns = (ArrayList<String>) fManager.read(modelAnsFileName);
    }
    public String getModelAnsData() {
        return  super.EId + "@" + this.modelAnsName +
                "@" + this.modelAnsId + "@" + this.modelAnsFileName + "@" + this.ans + "@";
    }

    private int getModelAnsIndex(int id) {

        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i).getModelAnsId() == id)
                return i;
        }
        return -1;
    }

    public void setModelAns(ArrayList<String> modelAns){
        this.modelAns = modelAns;
    }

    public ArrayList<String> getModelAns() {
        return modelAns;
    }

    public boolean addModelAns() {
        return fManager.write(modelAnsFileName, getModelAnsData());
    }

    public void deleteModelAns(int modelAnsId) {
        loadFromFile();
        int index = getModelAnsIndex(modelAnsId);
        ans.remove(index);
        commitToFile();
    }

    public void updateModelAns(int oldId, ModelAns x) {
        loadFromFile();
        int index = getModelAnsIndex(oldId);
        ans.set(index, x);
        commitToFile();
    }

    public boolean addModelAns(ArrayList<String> ans, int id){

        return fManager.write(modelAnsFileName, getModelAnsData());
    }

    public void deleteModelAns(String answer) {
        
        loadFromFile();
        ans.remove(answer);
        commitToFile();
    }

    public void updateAns(int oldId, ModelAns answer){

        loadFromFile();
        int index = getModelAnsIndex(oldId);
        ans.set(index, answer);
        commitToFile();
    }

    // @override
    public String toString() {
        return "Exam Name :" + modelAnsName + "\nE id :" + modelAnsFileName;
    }
}