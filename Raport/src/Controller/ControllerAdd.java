/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author brillian
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import Database.Koneksi;
import java.sql.PreparedStatement;
import Model.ModelPenilaian;
import java.sql.ResultSet;
import javax.swing.*;

public class ControllerAdd implements ActionListener{
    
    private JTextField nama, s1, s2, s3, sas;
    private String mapel, kelas, namaTabel;
    Koneksi con = new Koneksi();
    private DefaultTableModel model;
    private boolean isEnabled = true;
    private javax.swing.JButton simpan = new javax.swing.JButton();
    
    public ControllerAdd(JTextField nama, JTextField s1, JTextField s2, JTextField s3, JTextField sas, DefaultTableModel model, String mapel, String kelas, JButton simpan){
        this.simpan = simpan;
        this.nama = nama;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.sas = sas;
        this.model = model;
        this.mapel = mapel;
        this.kelas = kelas;
        this.isEnabled = isEnabled;
    }
    
    @Override
    
    public void actionPerformed(ActionEvent e) {
        
        namaTabel = mapel + "_" + kelas;
        String namaStr = this.nama.getText();
        String s1Str = this.s1.getText();
        String s2Str = this.s2.getText();
        String s3Str = this.s3.getText();
        String sasStr = this.sas.getText();
        
        if(!namaStr.equals("") && !s1Str.equals("") && !s2Str.equals("") && !s3Str.equals("") && !sasStr.equals("")){
            String query = "INSERT INTO " + namaTabel + "(nama, s1, s2, s3, nas, sas, rapor)" + " VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstm;
            int s1 = Integer.parseInt(s1Str);
            int s2 = Integer.parseInt(s2Str);
            int s3 = Integer.parseInt(s3Str);
            int sas = Integer.parseInt(sasStr);
            double nas = (s1+s2+s3)/3.0;
            double rapor = (nas+sas)/2.0;
            
            try{
               con.statement = con.koneksi.createStatement();
               pstm = con.koneksi.prepareStatement(query);
               pstm.setString(1, namaStr);
               pstm.setInt(2, s1);
               pstm.setInt(3, s2);
               pstm.setInt(4, s3);
               pstm.setDouble(5, nas);
               pstm.setInt(6, sas);
               pstm.setDouble(7, rapor);
               pstm.executeUpdate();
            }catch(Exception m){
                System.out.println("satu");
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan \n" + m);
            }
            
            query = "INSERT INTO siswa(nama, kelas)"+ " VALUES(?, ?)";
            
            try{
               con.statement = con.koneksi.createStatement();
               pstm = con.koneksi.prepareStatement(query);
               pstm.setString(1, namaStr);
               pstm.setString(2, kelas);
               pstm.executeUpdate();
            }catch(Exception m){
                System.out.println("dua");
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan \n" + m);
            }
            
            query = "SELECT DISTINCT nama_mapel FROM daftar_mapel WHERE kelas = ? AND nama_mapel NOT LIKE '%" + mapel + "'";
            
            try{
                con.statement = con.koneksi.createStatement();
                pstm = con.koneksi.prepareStatement(query);
                pstm.setString(1, kelas);
                ResultSet rs = pstm.executeQuery();

                while(rs.next()){
                   
                   String mapel2 = rs.getString("nama_mapel");
                   String query2 = "INSERT INTO " + mapel2 + "_" + kelas + "(nama) VALUES (?)";
                   con.statement = con.koneksi.createStatement();
                   PreparedStatement pstm4 = con.koneksi.prepareStatement(query2);
                   pstm4.setString(1, namaStr);
                   pstm4.executeUpdate();      
               }
            }catch(Exception m){
                System.out.println("tiga");
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan \n" + m);
            }
            
            ModelPenilaian modelan = new ModelPenilaian(namaTabel);
            model.setDataVector(modelan.newData, modelan.tabelHeader);
            simpan.removeActionListener(this);
        }
        else{
            JOptionPane.showMessageDialog(null, "Data Tdk Boleh Ada yg Kosong");
        }
    }
}