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
import Connector.Koneksi;
import java.sql.PreparedStatement;
import Model.ModelSiswa;

public class ControllerAdd implements ActionListener{

    private JTextField nisn, nama, nilai;
    Koneksi con = new Koneksi();
    
    private DefaultTableModel model;
    
    public ControllerAdd(JTextField nisn, JTextField nama, JTextField nilai, DefaultTableModel model){
        this.nama = nama;
        this.nisn = nisn;
        this.nilai = nilai;
        this.model = model;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String nisnStr = this.nisn.getText();
        String namaStr = this.nama.getText();
        String nilaiStr = this.nilai.getText();
        
        if(!nisnStr.equals("") && !namaStr.equals("") && !nilaiStr.equals("")){
            String query = "INSERT INTO tugas_mvc(nisn, nama, nilai)"
                + " VALUES(?, ?, ?)";
            PreparedStatement pstm;
            double nilaiInt = Double.parseDouble(nilaiStr);
            
            try{
               con.statement = con.koneksi.createStatement();
               pstm = con.koneksi.prepareStatement(query);
               pstm.setString(1, nisnStr);
               pstm.setString(2, namaStr);
               pstm.setDouble(3, nilaiInt);
               pstm.executeUpdate();
            }catch(Exception m){
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan \n" + m);
            }
            ModelSiswa modelan = new ModelSiswa();
            model.setDataVector(modelan.newData, modelan.tabelHeader);
        }
        else{
            JOptionPane.showMessageDialog(null, "Data Tdk Boleh Ada yg Kosong");
        }
    }
    
}
