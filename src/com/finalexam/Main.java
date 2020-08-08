package com.finalexam;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CompoundInterest inv = new CompoundInterest();
        inv.setUpTableData();
        inv.getDataFromDB();
        inv.setVisible(true);
    }

}
