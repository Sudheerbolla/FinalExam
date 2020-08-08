package com.finalexam;/*
 * Created by JFormDesigner on Sat Aug 08 09:28:25 PDT 2020
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.Vector;

/**
 * @author unknown
 */
public class CompoundInterest extends JFrame {
    Connection connection;
    PreparedStatement preparedStatement;

    public CompoundInterest() {
        initComponents();
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    public void setUpTableData() {
        String[] cols = {"Customer Number", "Customer Name", "Initial Deposit", "Number of Years", "Type of Savings"};
        String[][] data = {{"d1.1", "d1.2", "d1.3", "d1.4", "d1.5"}, {"d2.1", "d2.2", "d2.3", "d2.4", "d2.5"}};
        DefaultTableModel model = new DefaultTableModel(data, cols);
        tableRecords.setModel(model);
    }

    public void getDataFromDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/savings", "root", "");
            preparedStatement = connection.prepareStatement("Select * from savingstable");
            ResultSet rs = preparedStatement.executeQuery();

            int count;

            ResultSetMetaData res = rs.getMetaData();
            count = res.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) tableRecords.getModel();

            df.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int a = 1; a <= count; a++) {
                    v2.add(rs.getObject(a));
                }
                df.addRow(v2);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    private void buttonAddActionPerformed(ActionEvent event) {
        try {
            String custName, custNo, deposit, savingsType, noOfYears;

            custName = textFieldCustomerName.getText();
            custNo = textFieldCustomerNumber.getText();
            deposit = textFieldInitialDeposit.getText();
            noOfYears = textFieldNoOfYears.getText();
            savingsType = comboBoxSavingsType.getSelectedItem().toString();

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/savings", "root", "");

            preparedStatement = connection.prepareStatement("Select * from savingstable where custno = ?");
            preparedStatement.setString(1, custNo);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.isBeforeFirst()) {          //res.isBeforeFirst() is true if the cursor
                JOptionPane.showMessageDialog(null, "The record you are trying to enter already exists.");
                textFieldCustomerNumber.setText("");
                textFieldCustomerName.setText("");
                textFieldInitialDeposit.setText("");
                textFieldNoOfYears.setText("");
                textFieldCustomerNumber.requestFocus();
                return;
            }

            preparedStatement = connection.prepareStatement("insert into savingstable values(?,?,?,?,?)");

            preparedStatement.setString(1, custNo);
            preparedStatement.setString(2, custName);
            preparedStatement.setString(3, deposit);
            preparedStatement.setString(4, noOfYears);
            preparedStatement.setString(5, savingsType);

            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Record added");
            textFieldCustomerNumber.setText("");
            textFieldCustomerName.setText("");
            textFieldInitialDeposit.setText("");
            textFieldNoOfYears.setText("");
            textFieldCustomerNumber.requestFocus();

            getDataFromDB();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void buttonEditActionPerformed(ActionEvent event) {
        try {
            String custName, custNo, deposit, savingsType, noOfYears;

            custName = textFieldCustomerName.getText();
            custNo = textFieldCustomerNumber.getText();
            deposit = textFieldInitialDeposit.getText();
            noOfYears = textFieldNoOfYears.getText();
            savingsType = comboBoxSavingsType.getSelectedItem().toString();

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/savings", "root", "");

            preparedStatement = connection.prepareStatement("update savingstable set custno=?,custname=?,cdep=?,nyears=?,savtype=? where custno =?");

            preparedStatement.setString(1, custNo);
            preparedStatement.setString(2, custName);
            preparedStatement.setString(3, deposit);
            preparedStatement.setString(4, noOfYears);
            preparedStatement.setString(5, savingsType);

            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Record Updated");

            textFieldCustomerNumber.setText("");
            textFieldCustomerName.setText("");
            textFieldInitialDeposit.setText("");
            textFieldNoOfYears.setText("");
            textFieldCustomerNumber.requestFocus();

            getDataFromDB();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void buttonDeleteActionPerformed(ActionEvent event) {
        try {
            String custNo;
            custNo = textFieldCustomerNumber.getText();

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/savings", "root", "");

            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Delete",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {

                preparedStatement = connection.prepareStatement("delete from savingstable where custno =?");
                preparedStatement.setString(1, custNo);

            }


            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Record Deleted");

            textFieldCustomerNumber.setText("");
            textFieldCustomerName.setText("");
            textFieldInitialDeposit.setText("");
            textFieldNoOfYears.setText("");
            textFieldCustomerNumber.requestFocus();

            getDataFromDB();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void tableCustomersMouseClicked(MouseEvent event) {

        DefaultTableModel df = (DefaultTableModel) tableRecords.getModel();
        int index1 = tableRecords.getSelectedRow();

        textFieldCustomerNumber.setText(df.getValueAt(index1, 0).toString());
        textFieldCustomerName.setText(df.getValueAt(index1, 1).toString());
        textFieldInitialDeposit.setText(df.getValueAt(index1, 2).toString());
        textFieldNoOfYears.setText(df.getValueAt(index1, 3).toString());

        calculateSavings();
    }

    private void calculateSavings() {

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - sudheer
        CompundInterest = new JPanel();
        labelCustNo = new JLabel();
        textFieldCustomerNumber = new JTextField();
        labelCustName = new JLabel();
        textFieldCustomerName = new JTextField();
        labelInitDeposit = new JLabel();
        textFieldInitialDeposit = new JTextField();
        labelYears = new JLabel();
        textFieldNoOfYears = new JTextField();
        labelSavingsType = new JLabel();
        comboBoxSavingsType = new JComboBox();
        scrollPane1 = new JScrollPane();
        tableRecords = new JTable();
        scrollPane2 = new JScrollPane();
        tableCalculatedSavings = new JTable();
        buttonAdd = new JButton();
        buttonEdit = new JButton();
        buttonDelete = new JButton();
        comboBoxSavingsType.addItem("Savings-Deluxe");
        comboBoxSavingsType.addItem("Savings-Regular");

        //======== CompundInterest ========
        {
            CompundInterest.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax
                    .swing.border.EmptyBorder(0, 0, 0, 0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax.swing
                    .border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.
                    Font("D\u0069alog", java.awt.Font.BOLD, 12), java.awt.Color.red
            ), CompundInterest.getBorder()));
            CompundInterest.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                @Override
                public void propertyChange(java.beans.PropertyChangeEvent e) {
                    if ("\u0062order".equals(e.getPropertyName(
                    ))) throw new RuntimeException();
                }
            });

            //---- labelCustNo ----
            labelCustNo.setText("Enter the Customer Number");
            labelCustNo.setFont(new Font("Segoe UI", Font.BOLD, 12));

            //---- labelCustName ----
            labelCustName.setText("Enter the Customer Name");
            labelCustName.setFont(new Font("Segoe UI", Font.BOLD, 12));

            //---- labelInitDeposit ----
            labelInitDeposit.setText("Enter the Initial Deposit");
            labelInitDeposit.setFont(new Font("Segoe UI", Font.BOLD, 12));

            //---- labelYears ----
            labelYears.setText("Enter the number of years");
            labelYears.setFont(new Font("Segoe UI", Font.BOLD, 12));

            //---- labelSavingsType ----
            labelSavingsType.setText("Choose the type of Savings");
            labelSavingsType.setFont(new Font("Segoe UI", Font.BOLD, 12));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(tableRecords);
            }

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(tableCalculatedSavings);
            }

            //---- buttonAdd ----
            buttonAdd.setText("Add");
            buttonAdd.addActionListener(e -> buttonAddActionPerformed(e));

            //---- buttonEdit ----
            buttonEdit.setText("Edit");
            buttonEdit.addActionListener(e -> buttonEditActionPerformed(e));

            //---- buttonDelete ----
            buttonDelete.setText("Delete");
            buttonDelete.addActionListener(e -> buttonDeleteActionPerformed(e));

            tableRecords.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    tableCustomersMouseClicked(e);
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            GroupLayout CompundInterestLayout = new GroupLayout(CompundInterest);
            CompundInterest.setLayout(CompundInterestLayout);
            CompundInterestLayout.setHorizontalGroup(
                    CompundInterestLayout.createParallelGroup()
                            .addGroup(CompundInterestLayout.createSequentialGroup()
                                    .addGap(34, 34, 34)
                                    .addGroup(CompundInterestLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addGroup(CompundInterestLayout.createSequentialGroup()
                                                    .addComponent(buttonAdd, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(42, 42, 42)
                                                    .addComponent(buttonEdit)
                                                    .addGap(37, 37, 37)
                                                    .addComponent(buttonDelete)
                                                    .addGap(12, 12, 12))
                                            .addGroup(CompundInterestLayout.createParallelGroup()
                                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(labelCustNo, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(labelCustName, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(labelInitDeposit, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(labelYears, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(labelSavingsType, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(CompundInterestLayout.createParallelGroup()
                                            .addGroup(CompundInterestLayout.createSequentialGroup()
                                                    .addGroup(CompundInterestLayout.createParallelGroup()
                                                            .addComponent(textFieldCustomerNumber)
                                                            .addComponent(textFieldCustomerName)
                                                            .addComponent(textFieldInitialDeposit)
                                                            .addComponent(textFieldNoOfYears)
                                                            .addComponent(comboBoxSavingsType, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                                                    .addContainerGap())
                                            .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)))
            );
            CompundInterestLayout.setVerticalGroup(
                    CompundInterestLayout.createParallelGroup()
                            .addGroup(CompundInterestLayout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addGroup(CompundInterestLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(textFieldCustomerNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelCustNo))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(CompundInterestLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(textFieldCustomerName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelCustName))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(CompundInterestLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(textFieldInitialDeposit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelInitDeposit))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(CompundInterestLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(textFieldNoOfYears, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelYears))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(CompundInterestLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(comboBoxSavingsType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelSavingsType))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(CompundInterestLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(CompundInterestLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(buttonAdd)
                                            .addComponent(buttonEdit)
                                            .addComponent(buttonDelete))
                                    .addContainerGap(8, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - sudheer
    private JPanel CompundInterest;
    private JLabel labelCustNo;
    private JTextField textFieldCustomerNumber;
    private JLabel labelCustName;
    private JTextField textFieldCustomerName;
    private JLabel labelInitDeposit;
    private JTextField textFieldInitialDeposit;
    private JLabel labelYears;
    private JTextField textFieldNoOfYears;
    private JLabel labelSavingsType;
    private JComboBox comboBoxSavingsType;
    private JScrollPane scrollPane1;
    private JTable tableRecords;
    private JScrollPane scrollPane2;
    private JTable tableCalculatedSavings;
    private JButton buttonAdd;
    private JButton buttonEdit;
    private JButton buttonDelete;

    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
