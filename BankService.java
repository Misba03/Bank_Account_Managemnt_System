package com.bank;

import java.sql.*;

public class BankService {

    Connection con = DBConnection.getConnection();

    public void createAccount(Account acc) {

        try {
            String sql = "INSERT INTO account VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, acc.getAccNo());
            ps.setString(2, acc.getName());
            ps.setDouble(3, acc.getBalance());

            ps.executeUpdate();

            System.out.println("Account Created Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deposit(int accNo, double amount) {

        try {
            String sql = "UPDATE account SET balance = balance + ? WHERE acc_no = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, amount);
            ps.setInt(2, accNo);

            ps.executeUpdate();

            System.out.println("Amount Deposited Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void withdraw(int accNo, double amount) {

        try {
            String sql = "UPDATE account SET balance = balance - ? WHERE acc_no = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, amount);
            ps.setInt(2, accNo);

            ps.executeUpdate();

            System.out.println("Amount Withdrawn Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkBalance(int accNo) {

        try {
            String sql = "SELECT * FROM account WHERE acc_no = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, accNo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Account Number: " + rs.getInt("acc_no"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Balance: " + rs.getDouble("balance"));
            } else {
                System.out.println("Account Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(int accNo) {

        try {
            String sql = "DELETE FROM account WHERE acc_no = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, accNo);

            ps.executeUpdate();

            System.out.println("Account Deleted Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}