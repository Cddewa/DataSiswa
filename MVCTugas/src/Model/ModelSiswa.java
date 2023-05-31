/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author brillian
 */
import Connector.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class ModelSiswa{
    Koneksi con = new Koneksi();
    public Object[][] newData = new Object[100][];
    public DefaultTableModel tbmodel = new DefaultTableModel();
    public String[] tabelHeader = {"NISN", "Nama", "Nilai"};
    
    public ModelSiswa (){   
        String query = "select * from tugas_mvc";
        PreparedStatement pstm;
        
        
        try{
           con.statement = con.koneksi.createStatement();
           pstm = con.koneksi.prepareStatement(query);
           ResultSet rs = pstm.executeQuery();
           int indeks = 0;         
           
           while(rs.next()){
               String nisn = rs.getString("nisn");
               String nama = rs.getString("nama");
               double nilai = rs.getDouble("nilai");
               Object[] data = {nisn, nama, nilai};
               
               newData[indeks++] = data;
           }
           tbmodel.setDataVector(newData, tabelHeader);
           
        }catch(Exception e){
            System.out.println(e.getMessage());
        } 
    }
}
