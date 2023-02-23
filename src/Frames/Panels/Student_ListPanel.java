/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frames.Panels;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import project_pl.*;

/**
 *
 * @author besho
 */
public class Student_ListPanel extends javax.swing.JPanel {

    /**
     * Creates new form Student_ListPanel
     */
    public Student_ListPanel() {
       // addRowsTojTable();
        initComponents();

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Beshoy", "Ibrahim", "2", "3.39", "cs"},
                {"2", "Thomas", "Armanious", "1", "1.5", "is"},
                {"3", "thaowpista", "said", "3", "4", "it"},
                {null, "", null, null, "", null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Lname", "Fname", "Level", "GPA", "Dept"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    public void addRowsTojTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object rowData[] = new Object[6];

        Student stu = new Student();
        ArrayList<Student> students = new ArrayList<Student>();

        students = stu.listStudents();

        for (Student x : students) {
            rowData[0] = x.getID();
            rowData[1] = x.getFName();
            rowData[2] = x.getLName();
            rowData[3] = x.getLevel();
            rowData[4] = x.getGPA();
            rowData[5] = x.myDepart.getName();

            model.addRow(rowData);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
