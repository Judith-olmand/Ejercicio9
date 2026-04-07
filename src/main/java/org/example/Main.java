package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String letra = "a";

        try (Connection conn = DriverManager.getConnection(
                DBConfig.getUrl(),
                DBConfig.getUser(),
                DBConfig.getPassword()); Statement statement = conn.createStatement()){
            System.out.println("Conexión establecida con Oracle.");
           String sql = "SELECT SALARIO, COUNT(*) " +
                            "FROM EMPLEADO " +
                            "GROUP BY SALARIO " +
                            "ORDER BY SALARIO DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                double salario = rs.getDouble("salario");
                int total = rs.getInt("count(*)");
                System.out.println(salario + " --> " + total);
            }

            sql = "SELECT ROUND(AVG(SALARIO),2) AS MEDIA FROM EMPLEADO";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                double media = rs.getDouble("MEDIA");
                System.out.println(media);
            }

        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }
}