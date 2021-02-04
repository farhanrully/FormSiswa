package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
//Muhammad Farhan Rully Ferdian (124180054)
public class Controller {
    private Siswa siswa ;
    private final View view ;
    public Controller() {
        siswa = new Siswa();
        view = new View();
        initController();
    }
    public void initController() {
        loadTable();
        view.getBtnAdd().addActionListener(e -> {
            insertData();
        });
        view.getBtnEdit().addActionListener(e -> {
            editData();
        });
        view.getBtnDelete().addActionListener(e -> {
            deleteData();
        });
        view.getBtnReset().addActionListener(e -> {
            resetForm();
        });
    }
    private void resetForm() {
        view.getTfNIS().setText(null);
        view.getTfNama().setText(null);
        view.getCbJurusan().setSelectedIndex(0);
        view.getCbJK().setSelectedIndex(0);
        view.getTfAlamat().setText(null);
    }
    private void loadTable() {
        int i=0;
        view.setTableModel(new DefaultTableModel());
        view.getTableModel().addColumn("NIS");
        view.getTableModel().addColumn("Nama");
        view.getTableModel().addColumn("Jurusan");
        view.getTableModel().addColumn("Jenis Kelamin");
        view.getTableModel().addColumn("Alamat");
        String a[][] = new String[99][99];
        try {
            ResultSet resultSet = siswa.loadData();
            while (resultSet.next()) {
                        a[i][0] = resultSet.getString(1);
                        a[i][1] = resultSet.getString(2);
                        a[i][2] = resultSet.getString(3);
                        a[i][3] = resultSet.getString(4);
                        a[i][4] = resultSet.getString(5);
                        i++;
            }
            view.tbSiswa.setModel(new JTable(a,view.colum).getModel());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    private void insertData() {
        String NIS = view.getTfNIS().getText();
        String nama = view.getTfNama().getText();
        String jurusan =
                Objects.requireNonNull(view.getCbJurusan().getSelectedItem()).toString
                        ();
        String JK =
                Objects.requireNonNull(view.getCbJK().getSelectedItem()).toString();
        String alamat = view.getTfAlamat().getText();
        siswa = new Siswa(NIS, nama, jurusan, JK, alamat);
        siswa.addData();
        loadTable();
        resetForm();
    }
    private void editData() {
        String NIS = view.getTfNIS().getText();
        String nama = view.getTfNama().getText();
        String jurusan =
                Objects.requireNonNull(view.getCbJurusan().getSelectedItem()).toString();
        String JK =
                Objects.requireNonNull(view.getCbJK().getSelectedItem()).toString();
        String alamat = view.getTfAlamat().getText();
        siswa = new Siswa(NIS, nama, jurusan, JK, alamat);
        siswa.editData();
        loadTable();
        resetForm();
    }
    private void deleteData() {
        String NIS = view.getTfNIS().getText();
        siswa.deleteData(NIS);
        loadTable();
        resetForm();
    }
}