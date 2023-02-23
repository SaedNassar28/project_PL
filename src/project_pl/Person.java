/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pl;
public class Person {

    protected int id ;
    protected int age;
    protected String fName;
    protected String lName;
    protected String userName;
    protected String pass;

    public Department myDepart ;
    FileManager fManger = new FileManager();
    Person(){
    }

    public Person(int id , int age, String fName, String lName, String userName, String pass, Department myDepart) {
        this.id = id;
        this.age = age;
        this.fName = fName;
        this.lName = lName;
        this.userName = userName;
        this.pass = pass;
        this.myDepart = myDepart;
    }

    //setters
    public void setID(int id  ) {
        this.id = id;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setFName(String fName) {
        this.fName = fName;
    }
    public void setLName(String lName) {
        this.lName = lName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public void setDept(Department myDepart) {
        this.myDepart = myDepart;
    }

    //getters
    public int getID() {
        return id;
    }
    public int getAge() {
        return age;
    }
    public String getFName() {
        return fName;
    }
    public String getLName() {
        return lName;
    }
    public String getUserName() {
        return userName;
    }
    public String getPass() {
        return pass;
    }
    public boolean login( String userName, String Pass) {
        return userName.equals("Admin@yahoo.com") && Pass.equals("12345678");
    }
}

