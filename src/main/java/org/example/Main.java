package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(
                DBConfig.getUrl(),
                DBConfig.getUser(),
                DBConfig.getPassword())){
            System.out.println("Conexión establecida con Oracle."); //Mediante Maven
            /**
             * Consulta cuantos empleados hay por salario,
             * los agrupa y ordena de forma descendente
             */
            String sql = "SELECT SALARIO, COUNT(*) " +
                            "FROM EMPLEADO " +
                            "GROUP BY SALARIO " +
                            "ORDER BY SALARIO DESC";
            PreparedStatement ps = conn.prepareStatement(sql);//Se podría usar Statement
            ResultSet rs = ps.executeQuery();
            /**
             * Muestra el resultado mientras rs.next tenga registros que mostrar
             */
            while(rs.next()){
                double salario = rs.getDouble("salario");
                int total = rs.getInt("count(*)");
                System.out.println(salario + " --> " + total);
            }

            /**
             * Muestra el salario medio total
             * Reutilizo la variable String sql con otro valor (consulta)
             */
            sql = "SELECT ROUND(AVG(SALARIO),2) AS MEDIA FROM EMPLEADO";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            /**
             * Como solo devuelve una fila, no se usa while
             */
            if (rs.next()) {
                double media = rs.getDouble("MEDIA");
                System.out.println(media);
            }

        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }
}