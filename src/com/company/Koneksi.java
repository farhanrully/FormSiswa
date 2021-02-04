package com.company;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
//Muhammad Farhan Rully Ferdian (124180054)
public class Koneksi {
    public static Connection con;
    public static Statement stm;
    public static Connection getCon() {

        try {
            String url ="jdbc:mysql://localhost/sekolah";
            String user="root";
            String pass="";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);
            stm = con.createStatement();
            System.out.println("Koneksi berhasil;");
        } catch (Exception e) {
            System.err.println("Koneksi gagal" +e.getMessage());
        }
        return con;}
}
