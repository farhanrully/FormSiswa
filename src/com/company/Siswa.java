package com.company;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//Muhammad Farhan Rully Ferdian (124180054)
public class Siswa {
    private String NIS
            , nama
            , jurusan
            , JK
            , alamat;
    public Siswa() {}
    public Siswa(String NIS, String nama, String jurusan, String JK,
                 String alamat) {
        this.NIS = NIS;
        this.nama = nama;
        this.jurusan = jurusan;
        this.JK = JK;
        this.alamat = alamat;
    }
    public void addData() {
        try {
            String sql = "INSERT INTO siswa(nis, nama, jurusan, jk, alamat) VALUES ('"
                    + NIS + "','"
                    + nama + "','"
                    + jurusan + "','"
                    + JK + "','"
                    + alamat + "')";
            Connection connection = Koneksi.getCon();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
                        JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
        } catch ( Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void editData(){
        try {
            String sql = "UPDATE siswa SET "
                    + "nama = '" + nama
                    + "', jurusan = '" + jurusan
                    + "', jk = '" + JK
                    + "', alamat = '" + alamat
                    + "' WHERE NIS = '" + NIS + "'";
            Connection connection = Koneksi.getCon();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil diedit");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteData(String NIS) {
        try{
            if (NIS == null){
                JOptionPane.showMessageDialog(null, "Data belum dipilih", "Alert", JOptionPane.ERROR_MESSAGE);
            } else {
                String sql = "DELETE FROM siswa WHERE nis = '" + NIS +
                        "'";
                Connection connection = Koneksi.getCon();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql);
                preparedStatement.execute();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public ResultSet loadData() {
        try {
            String sql ="SELECT * FROM siswa";
            Connection connection = Koneksi.getCon();
            Statement statement = connection.createStatement();
            return statement.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
