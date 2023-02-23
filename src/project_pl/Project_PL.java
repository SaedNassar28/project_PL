
package project_pl;
import GUI.LoginFrame;
import java.io.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
public class Project_PL {

      public static void main(String[] args)throws InvocationTargetException, InterruptedException {

        String projectPath = System.getProperty("user.dir");
        System.out.println("Project Path: " + projectPath);
        File currentDir = new File(projectPath); // current directory				
        checkDirectoryContents(currentDir);

        new LoginFrame().setVisible(true);
    }

    public static void checkDirectoryContents(File dir) {
        File[] files = dir.listFiles();
        boolean studentFileName = true;
        boolean professorFileName = true;
        boolean TAFileName = true;
        boolean CourseFileName = true;

        for (File file : files) {

            if (file.getName().contains("Students.bin")) {
                studentFileName = false;
            } else if (file.getName().contains("Professor.bin")) {
                professorFileName = false;
            } else if (file.getName().contains("TA.bin")) {
                TAFileName = false;
            } else if (file.getName().contains("Courses.bin")) {
                CourseFileName = false;
            }
        }
        if (studentFileName) {
            Student x = new Student();
            x.commitToFile();
        }
        if (professorFileName) {
            Professor x = new Professor();
            x.commitToFile();
        }
        if (TAFileName) {
            TeachingAssistant x = new TeachingAssistant();
            x.commitToFile();
        }
        if (CourseFileName) {
            Course x = new Course();
            x.commitToFile();
        }
     
    }

}