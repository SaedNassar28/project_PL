/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pl;

public abstract class Staff extends Person {

    protected double salary;

    //Constructors
    public Staff(){
    }
    public Staff(int id  , int age, String fName, String lName, String userName,
                 String pass, Department myDepart, double salary) {
        super(id, age, fName, lName, userName, pass, myDepart);
        this.salary = salary;
    }

    //Getters
    public double getSalary() {
        return salary;
    }
    public String getDeptName(){
        return this.myDepart.getName();
    }

    //Setters
    public void setSalary(double salary) {
        this.salary = salary;
    }

    //toString
    @Override
    public abstract String toString();

    //overRidingTheEqualsMethods
    @Override
    public boolean equals(Object a){
        Staff temp = (Staff) a;
        return (id== temp.id&& fName.equals(temp.fName)&& lName.equals(temp.lName) &&
                age== temp.age && userName== temp.userName && pass== temp.pass&&
                salary==temp.salary&& myDepart.getName().equals(temp.myDepart.getName())) ;
    }
}
