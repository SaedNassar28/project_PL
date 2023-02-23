/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pl;

import java.io.Serializable;

public class Department implements Serializable {
    private String DeptID;
    private String Name;
    private String DeptDesc;
    private final String DeptFileName="Department.bin";
    FileManager fManager = new FileManager();
    public static Department Cs = new Department ("1","Cs","Computer Science") ;
    public static Department Is = new Department ("2","Is","Information System");
    public static Department It = new Department ("3","It","Information Technology");
    public static Department Sw = new Department ("4","Sw","Software Engineering");


    public Department() {
    }

    public Department(String DeptID, String Name, String DeptDEsc) {
        this.DeptID = DeptID;
        this.Name = Name;
        this.DeptDesc = DeptDEsc;
    }


    public String getDeptID() {
        return DeptID;
    }

    public void setDeptID(String DeptID) {
        this.DeptID = DeptID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDeptDEsc() {
        return DeptDesc;
    }

    public void setDeptDesc(String DeptDesc) {
        this.DeptDesc = DeptDesc;
    }
    private String getDeptData(){
     return this.DeptID + "@" + this.Name + "@" + this.DeptDesc + "@" ;
    }
    public boolean addDept(){
        return fManager.write(getDeptData(), DeptFileName);
    } 

    @Override
    public String toString() {
     return "Department Name : " + Name + "\nDepatment ID : " + DeptID + "\n Department Description : " + DeptDesc;

    }


}