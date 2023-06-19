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
import View.ViewUtama;
import javax.swing.*;

public class ControllerUpdate implements ActionListener{
    private JTextField nama, s1, s2, s3, sas;
    private String namaAwal, namaTabel;
    Koneksi con = new Koneksi();
    private DefaultTableModel model;
    private javax.swing.JButton simpan = new javax.swing.JButton();
    
    public ControllerUpdate(JTextField nama, JTextField s1, JTextField s2, JTextField s3, JTextField sas, DefaultTableModel model, String namaAwal, String namaTabel, JButton simpan){
        this.simpan = simpan;
        this.nama = nama;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.sas = sas;
        this.model = model;
        this.namaAwal  = namaAwal;
        this.namaTabel = namaTabel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String namaStr = this.nama.getText();
        String s1Str = this.s1.getText();
        String s2Str = this.s2.getText();
        String s3Str = this.s3.getText();
        String sasStr = this.sas.getText();
        
        if(!namaStr.equals("") && !s1Str.equals("") && !s2Str.equals("") && !s3Str.equals("") && !sasStr.equals("")){
            String query = "UPDATE " + namaTabel + " SET nama = ?, s1 = ?, s2 = ?, s3 = ?, nas = ?, sas = ?, rapor = ? WHERE nama = ?";
            PreparedStatement pstm;
            int s1 = Integer.parseInt(s1Str);
            int s2 = Integer.parseInt(s2Str);
            int s3 = Integer.parseInt(s3Str);
            int sas = Integer.parseInt(sasStr);
            double nas = (s1+s2+s3)/3;
            double rapor = (nas+sas)/2;
            
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
               pstm.setString(8, namaAwal);
               pstm.executeUpdate();
            }catch(Exception m){
                JOptionPane.showMessageDialog(null, "Data Gagal Diupdate \n" + m);
            }
            
            query = "UPDATE siswa SET nama = ? WHERE nama = ?";
            try{
               con.statement = con.koneksi.createStatement();
               pstm = con.koneksi.prepareStatement(query);
               pstm.setString(1, namaStr);
               pstm.setString(2, namaAwal);
               pstm.executeUpdate();
            }catch(Exception m){
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
