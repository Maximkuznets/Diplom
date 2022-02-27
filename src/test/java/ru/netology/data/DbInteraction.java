package ru.netology.data;

import java.sql.*;

public class DbInteraction {
    public static Connection getConnection() throws SQLException {
        var connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/app", "app", "pass");
        return connection;
    }

    public static String getPaymentId() throws SQLException {
        String payment_id = null;
        var idSQL = "SELECT payment_id FROM order_entity order by created desc limit 1;";
        try (var conn = getConnection();
             var statusStmt = conn.prepareStatement(idSQL)) {
            try (var rs = statusStmt.executeQuery()) {
                if (rs.next()) {
                    payment_id = rs.getString("payment_id");
                }
            }
        }
        return payment_id;
    }

    public static String getStatusDebitCard(String payment_id) throws SQLException {
        String status = null;
        String statusSQL = "SELECT status FROM payment_entity WHERE transaction_id =?; ";

        try (var conn = getConnection();
             var statusStmt = conn.prepareStatement(statusSQL)) {
            statusStmt.setString(1, payment_id);
            try (var rs = statusStmt.executeQuery()) {
                if (rs.next()) {
                    status = rs.getString("status");
                }
            }
        }
        return status;
    }


    public static String getStatusCreditCard(String payment_id) throws SQLException {
        String status = null;
        String statusSQL = "SELECT status FROM credit_request_entity WHERE bank_id =?; ";

        try (var conn = getConnection();
             var statusStmt = conn.prepareStatement(statusSQL)) {
            statusStmt.setString(1, payment_id);
            try (var rs = statusStmt.executeQuery()) {
                if (rs.next()) {
                    status = rs.getString("status");
                }
            }
        }
        return status;
    }

}
