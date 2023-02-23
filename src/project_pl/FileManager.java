/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pl;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileManager implements Serializable {

    public boolean write(String FilePath, Object data) {

        try {
            System.out.print("\nwritting in ! " + FilePath);

            try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(FilePath))) {
                write.writeObject(data);
                
                System.out.println(" ... Done ! ");
            }
            return true;

        } catch (IOException e) {
            System.out.println("Can't write ...!\n" + e);
        }

        return false;
    }

    public Object read(String FilePath) {

        Object Result = null;

        try {
            System.out.println("Reading ! From " + FilePath);

            ObjectInputStream Reader = new ObjectInputStream(new FileInputStream(FilePath));

            Result = Reader.readObject();

        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Result;

    }

}

/*
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

    public boolean write(String query, String path, boolean append) {
        PrintWriter writer = null;
        try {
            System.out.println("writing" + path);
            writer = new PrintWriter(new FileWriter(new File(path), append));
            writer.println(query);
            return true;

        } catch (IOException e) {
            System.out.println(e);
        } finally {
            writer.close();
        }
        return false;
    }

    public ArrayList<Object> read(String path) {
        Scanner Reader = null;

        try {
            System.out.println("Reading ...from" + path);
            Reader = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        switch (path) {
/*            case "Student.txt": {
                ArrayList<Student> Students = new ArrayList<Student>();
                Student x;

                while (Reader.hasNext()) {

                    x = new Student();
                    String Line = Reader.nextLine();
                    String[] separated = Line.split("@");
                    x.setID(Integer.parseInt(separated[0]));
                    x.setAge(Integer.parseInt(separated[1]));
                    x.setFName(separated[2]);
                    x.setLName(separated[3]);
                    x.setLevel(separated[4]);
                    x.setGPA(separated[5]);

                    switch (separated[6]) {
                        case "CS" -> x.setDept(Main.cs);
                        case "IS" -> x.setDept(Main.is);
                        case "IT" -> x.setDept(Main.it);
                    }

                    x.setUserName(separated[7]);
                    x.setPass(separated[8]);

                    Students.add(x);

                    return (ArrayList<Object>) (Object) Students;
                }

                break;
            }
           case "Professor.txt": {
                ArrayList<Professor> Professors = new ArrayList<Professor>();
                Professor x;

                while (Reader.hasNext()) {

                    x = new Professor();
                    String Line = Reader.nextLine();
                    String[] separated = Line.split("@");
                    x.setID(Integer.parseInt(separated[0]));
                    x.setAge(Integer.parseInt(separated[1]));
                    x.setFName(separated[2]);
                    x.setLName(separated[3]);

                    switch (separated[4]) {
                        case "CS" -> x.setDept(Main.cs);
                        case "IS" -> x.setDept(Main.is);
                        case "IT" -> x.setDept(Main.it);
                    }

                    x.setUserName(separated[5]);
                    x.setPass(separated[6]);

                    x.setOfficeHours(separated[7]);
                    x.setSalary(Double.parseDouble(separated[8]));

                    Professors.add(x);

                    return (ArrayList<Object>) (Object) Professors;
                }
                break;
            }
/*            case "TA.txt": {
                ArrayList<TeachingAssistant> TAs = new ArrayList<TeachingAssistant>();
                TeachingAssistant x;

                while (Reader.hasNext()) {

                    x = new TeachingAssistant();
                    String Line = Reader.nextLine();
                    String[] separated = Line.split("@");
                    x.setID(Integer.parseInt(separated[0]));
                    x.setAge(Integer.parseInt(separated[1]));
                    x.setFName(separated[2]);
                    x.setLName(separated[3]);

                    switch (separated[4]) {
                        case "CS" -> x.setDept(Main.cs);
                        case "IS" -> x.setDept(Main.is);
                        case "IT" -> x.setDept(Main.it);
                    }

                    x.setUserName(separated[5]);
                    x.setPass(separated[6]);

                    x.setAcademicHours(separated[7]);
                    x.setsalary(Double.parseDouble(separated[8]));

                    TAs.add(x);

                    return (ArrayList<Object>) (Object) TeachingAssistant;
                }
                break;
            }
            case "Employee.txt": {
                ArrayList<StudentAffairs> Employees = new ArrayList<StudentAffairs>();
                StudentAffairs x;

                while (Reader.hasNext()) {

                    x = new StudentAffairs();
                    String Line = Reader.nextLine();
                    String[] separated = Line.split("@");
                    x.setID(Integer.parseInt(separated[0]));
                    x.setAge(Integer.parseInt(separated[1]));
                    x.setFName(separated[2]);
                    x.setLName(separated[3]);

                    switch (separated[4]) {
                        case "SA" -> x.setDept(Main.sa);
                    }

                    x.setUserName(separated[5]);
                    x.setPass(separated[6]);

                    x.setsalary(Double.parseDouble(separated[7]));

                    Employees.add(x);

                    return (ArrayList<Object>) (Object) StudentAffairs;
                }
                break;
            }
            case "Courses.txt": {

                ArrayList<Course> Courses = new ArrayList<Course>();
                Course x;

                while (Reader.hasNext()) {

                    x = new Course();
                    String Line = Reader.nextLine();
                    String[] separated = Line.split("@");

                    x.setCname(separated[0]);
                    x.setCId(separated[1]);
                    x.setCreditHours(Integer.parseInt(separated[2]));

                    Courses.add(x);
                }

                return (ArrayList<Object>) (Object) Courses;
            }
          default:
                return null;
        }
        return null;
    }
}
 */  