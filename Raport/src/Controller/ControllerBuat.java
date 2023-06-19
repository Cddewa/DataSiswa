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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import Database.Koneksi;
import java.sql.PreparedStatement;
import Model.ModelPenilaian;
import View.ViewUtama;
import java.sql.ResultSet;

public class ControllerBuat implements ActionListener{
    private String kelas, mapel;
    Koneksi con = new Koneksi();
    public Object[][] newData = new Object[100][];
    
    public ControllerBuat(String mapel, String kelas){
        this.mapel = mapel;
        this.kelas = kelas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String query = "SELECT * FROM daftar_mapel WHERE nama_mapel = ? AND kelas = ?";
        PreparedStatement pstm;
        try{
               System.out.println("ini satu");
               con.statement = con.koneksi.createStatement();
               pstm = con.koneksi.prepareStatement(query);
               pstm.setString(1, mapel);
               pstm.setString(2, kelas);
               ResultSet rs = pstm.executeQuery();
               
               if (rs.next()) {
                   System.out.println("ini dua");
                    ViewUtama VUT  = new ViewUtama();
                    VUT.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Penilaian tidak bisa dibuat karena sudah ada !");
                } 
               else {
                   System.out.println("ini tiga");
                    String query2 = "CREATE TABLE " + mapel + "_" + kelas + " (nama VARCHAR(40), s1 int, s2 int, s3 int, nas double, sas int, rapor double)";
                    try{
                        System.out.println("jarwo");
                        con.statement = con.koneksi.createStatement();
                        PreparedStatement pstm2 = con.koneksi.prepareStatement(query2);
                        pstm2.executeUpdate();
                            
                    }catch(Exception m){
                        JOptionPane.showMessageDialog(null, "Gagal Membuat Database \n" + m);
                    }
                    
                    query2 = "INSERT INTO daftar_mapel(nama_mapel, kelas)" + " VALUES(?, ?)";
                    try{
                        con.statement = con.koneksi.createStatement();
                        PreparedStatement pstm2 = con.koneksi.prepareStatement(query2);
                        pstm2.setString(1, mapel);
                        pstm2.setString(2, kelas);
                        pstm2.executeUpdate();
                            
                    }catch(Exception m){
                        JOptionPane.showMessageDialog(null, "Data Gagal Disimpan \n" + m);
                    }
                    
                    query2 = "SELECT * FROM siswa WHERE kelas = ?";
                    try{
                        con.statement = con.koneksi.createStatement();
                        PreparedStatement pstm2 = con.koneksi.prepareStatement(query2);
                        pstm2.setString(1, kelas);
                        ResultSet rs2 = pstm2.executeQuery();
                        
                        if(rs2.next()){
                            String query3 = "SELECT nama FROM siswa WHERE kelas = ?";
                            try{
                                con.statement = con.koneksi.createStatement();
                                PreparedStatement pstm3 = con.koneksi.prepareStatement(query3);
                                pstm3.setString(1, kelas);
                                ResultSet rs3 = pstm3.executeQuery();

                                while(rs3.next()){
                                    String nama = rs3.getString("nama");

                                    String query4 = "INSERT INTO " + mapel + "_" + kelas + "(nama) VALUES (?)";
                                    try{
                                        con.statement = con.koneksi.createStatement();
                                        PreparedStatement pstm4 = con.koneksi.prepareStatement(query4);

                                        pstm4.setString(1, nama);
                                        pstm4.executeUpdate();
                                        
                                    }catch(Exception m){
                                        JOptionPane.showMessageDialog(null, "Data Gagal Disimpan \n" + m);
                                    }
                                }       
                            }catch(Exception m){
                                JOptionPane.showMessageDialog(null, "Data Mengambil Data \n" + m);
                            }
                        }   
                    }catch(Exception m){
                        JOptionPane.showMessageDialog(null, "Data Gagal Disimpan \n" + m);
                    }
                    
                 ModelPenilaian modelan = new ModelPenilaian((mapel + "_" + kelas));
                 ViewUtama VU =  new ViewUtama();
                 VU.model = modelan;
                 switch(mapel)
                {
                    case "matematika" :{
                        mapel = "Matematika"; break;
                    }
                    case "ipa" :{
                        mapel = "IPA"; break;
                    }
                    case "ips" :{
                        mapel = "IPS"; break;
                    }
                    case "pkn" :{
                        mapel = "Pkn"; break;
                    }
                    case "bhs_indo" :{
                        mapel = "Bhs Indonesia"; break;
                    }
                    case "pjok" :{
                        mapel = "PJOK"; break;
                    }
                    case "bhs_inggris" :{
                        mapel = "Bhs Inggris";
                    }
                }
                 JComboBox<String> comboBox1 = VU.getComboBox1();
                 comboBox1.setSelectedItem(mapel);
                 VU.setComboBox1(comboBox1);
                 
                 switch(kelas)
                 {
                    case "ia" :{
                        kelas = "I-a"; break;
                    }
                    case "ib" :{
                        kelas = "I-b"; break;          
                    }
                    case "iia" :{
                        kelas = "II-a"; break;
                    }
                    case "iib" :{
                        kelas = "II-b"; break;
                    }
                    case "iiia" :{
                        kelas = "III-a"; break;
                    }
                    case "iiib" :{
                        kelas = "III-b"; break;
                    }
                    case "iva" :{
                        kelas = "IV-a"; break;
                    }
                    case "ivb" :{
                        kelas = "IV-b"; break;
                    }
                    case "va" :{
                        kelas = "V-a"; break;
                    }
                    case "vb" :{
                        kelas = "V-b"; break;
                    }
                    case "via" :{
                        kelas = "VI-a"; break;
                    }
                    case "vib" :{
                        kelas = "VI-b";
                    }
                }
                 JComboBox<String> comboBox2 = VU.getComboBox2();
                 comboBox2.setSelectedItem(kelas);
                 VU.setComboBox2(comboBox2);
                 VU.setVisible(true);
                }  
            }
         catch(Exception m){
                JOptionPane.showMessageDialog(null, "Query Mengecek Gagal \n" + m);
         }
    }   
}
