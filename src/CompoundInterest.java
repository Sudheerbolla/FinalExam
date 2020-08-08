import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
/*
 * Created by JFormDesigner on Sat Aug 08 11:21:08 PDT 2020
 */



/**
 * @author sudheer
 */
public class CompoundInterest  {

    private void tableCustomersMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void buttonAddActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void buttonEditActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void buttonDeleteActionPerformed(ActionEvent e) {
        // TODO add your code here
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
        tableCustomers = new JTable();
        scrollPane2 = new JScrollPane();
        tableCalculatedSavings = new JTable();
        buttonAdd = new JButton();
        buttonEdit = new JButton();
        buttonDelete = new JButton();

        //======== CompundInterest ========
        {
            CompundInterest.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
            EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing
            . border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ),
            java. awt. Color. red) ,CompundInterest. getBorder( )) ); CompundInterest. addPropertyChangeListener (new java. beans. PropertyChangeListener( )
            { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () ))
            throw new RuntimeException( ); }} );

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

                //---- tableCustomers ----
                tableCustomers.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        tableCustomersMouseClicked(e);
                        tableCustomersMouseClicked(e);
                    }
                });
                scrollPane1.setViewportView(tableCustomers);
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
    private JTable tableCustomers;
    private JScrollPane scrollPane2;
    private JTable tableCalculatedSavings;
    private JButton buttonAdd;
    private JButton buttonEdit;
    private JButton buttonDelete;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
