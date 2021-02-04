package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//Muhammad Farhan Rully Ferdian (124180054)
public class View {
     DefaultTableModel tableModel;
     JScrollPane scrollPane;
     JTable tbSiswa;
    JFrame frame = new JFrame ("Form Siswa");
    JPanel panel = new JPanel();
    JLabel lnis = new JLabel ("NIS");
    final JTextField tfNIS = new JTextField(10);
    JLabel lnama = new JLabel ("Nama");
    final JTextField tfNama = new JTextField(10);
    JLabel ljurusan = new JLabel ("Jurusan");
    String [] cbJurusan = {"","Rekayasa Perangkat Lunak","Jaringan"};
    JComboBox cbjur = new JComboBox (cbJurusan);
    JLabel ljk = new JLabel ("JK");
    String [] cbJK = {"","Laki - Laki", "Perempuan"};
    JComboBox cbjk = new JComboBox (cbJK);
    JLabel lalamat = new JLabel ("Alamat");
    final JTextField tfAlamat = new JTextField (50);
    JButton tambah = new JButton();
    JButton hapus = new JButton();
    JButton update = new JButton();
    JButton reset = new JButton();
    Object colum[] = {"NIS","Nama","Jurusan","Jenis Kelamin","Alamat"};
    public View(){
        tambah.setText ("Tambah");
        hapus.setText ("Hapus");
        update.setText ("Update");
        reset.setText("Reset");


        tableModel = new DefaultTableModel(colum,0);
        tbSiswa = new JTable(tableModel);
        scrollPane = new JScrollPane(tbSiswa);

        frame.add(lnis);
        frame.add(tfNIS);
        frame.add(lnama);
        frame.add(tfNama);
        frame.add(ljurusan);
        frame.add(cbjur);
        frame.add(ljk);
        frame.add(cbjk);
        frame.add(lalamat);
        frame.add(tfAlamat);
        frame.add(tambah);
        frame.add(hapus);
        frame.add(update);
        frame.add(reset);
        frame.add(scrollPane);

        lnis.setBounds(10,10,120,20);
        tfNIS.setBounds(150,10,200,20);
        lnama.setBounds(10,35,120,20);
        tfNama.setBounds(150,35,200,20);
        ljurusan.setBounds(10,60,120,20);
        cbjur.setBounds(150,60,200,20);
        ljk.setBounds(10,85,150,20);
        cbjk.setBounds(150,85,200,20);
        lalamat.setBounds(10,110,120,20);
        tfAlamat.setBounds(150,110,200,80);
        tambah.setBounds(150,200,97,20);
        hapus.setBounds(250,200,98,20);
        update.setBounds(150,230,97,20);
        reset.setBounds(250,230,98,20);
       scrollPane.setBounds(400,10,500,245);


        initComponent();

        frame.add(panel);
        frame.setSize(930, 300);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    private void initComponent() {
        tbSiswa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tableClicked(e);

                }catch (Exception es){
                    System.out.println(es);
                }
            }
        });
    }
    private void tableClicked(MouseEvent event) {
        int row = tbSiswa.rowAtPoint(event.getPoint());
        String NIS = tbSiswa.getValueAt(row, 0).toString();
        String nama = tbSiswa.getValueAt(row, 1).toString();
        String jurusan = tbSiswa.getValueAt(row, 2).toString();
        String JK = tbSiswa.getValueAt(row, 3).toString();
        String alamat = tbSiswa.getValueAt(row, 4).toString();
        tfNIS.setText(NIS);
        tfNama.setText(nama);
        cbjk.setSelectedItem(JK);
        cbjur.setSelectedItem(jurusan);
        tfAlamat.setText(alamat);
    }
    public DefaultTableModel getTableModel() {
        return tableModel;
    }
    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }
    public JTextField getTfNIS() {
        return tfNIS;
    }
    public JTextField getTfNama() {
        return tfNama;
    }
    public JTextField getTfAlamat() {
        return tfAlamat;
    }
    public JTable getTbSiswa() {
        return tbSiswa;
    }
    public JButton getBtnAdd() {
        return tambah;
    }
    public JButton getBtnEdit() {
        return update;
    }
    public JButton getBtnDelete() {
        return hapus;
    }
    public JComboBox getCbJK() {
        return cbjk;
    }
    public JComboBox getCbJurusan() {
        return cbjur;
    }
    public JButton getBtnReset() {
        return reset;
    }
}

