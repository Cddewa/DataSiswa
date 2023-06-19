/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author brillian
 */
import Database.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class ModelPerSiswa {
    Koneksi con = new Koneksi();
    public Object[][] newData = new Object[100][];
    public DefaultTableModel tbmodel = new DefaultTableModel();
    public String[] tabelHeader = {"Mapel", "S1", "S2", "S3", "NA Sumatif", "Sumatif AS", "Rapor"};
    public String nama, kelas;
    PreparedStatement pstm;
    
    
    public ModelPerSiswa(String nama){
        this.nama = nama;
        String query = "select kelas from siswa where nama = ?";
        
        try{
            con.statement = con.koneksi.createStatement();
            pstm = con.koneksi.prepareStatement(query);
            pstm.setString(1, nama);
            ResultSet rs = pstm.executeQuery();
            int indeks = 0;
            
            if (rs.next()) {
                kelas = rs.getString("kelas");
                
                query = "Select nama_mapel from daftar_mapel where kelas = ?";
                try{
                    con.statement = con.koneksi.createStatement();
                    PreparedStatement pstm3 = con.koneksi.prepareStatement(query);
                    pstm3.setString(1,kelas);
                    ResultSet rs3 = pstm3.executeQuery();
                  
                    while(rs3.next()){
                        String mapel = rs3.getString("nama_mapel");
                        
                        String query2 = "select s1, s2, s3, nas, sas, rapor from " + mapel + "_" + kelas + " where nama = ?";
                        PreparedStatement pstm2;
        
                        try{
                           con.statement = con.koneksi.createStatement();
                           pstm2 = con.koneksi.prepareStatement(query2);
                           pstm2.setString(1, nama);
                           ResultSet rs2 = pstm2.executeQuery();

                           while(rs2.next()){
                               
                               int s1 = rs2.getInt("s1");
                               int s2 = rs2.getInt("s2");
                               int s3 = rs2.getInt("s3");
                               double nas = rs2.getDouble("nas");
                               int sas = rs2.getInt("sas");
                               double rapor = rs2.getDouble("rapor");
                               Object[] data = {mapel, s1, s2, s3, nas, sas, rapor};
                               newData[indeks++] = data;
                           }

                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        } 
                    }       
                }catch(Exception m){
                    JOptionPane.showMessageDialog(null, "Data Mengambil Data \n" + m);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Siswa tidak ditemukan");
            }
            tbmodel.setDataVector(newData, tabelHeader);
        }
        catch(Exception m){
                JOptionPane.showMessageDialog(null, "Query Mengecek Gagal \n" + m);
        }
    }
}
