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

public class ModelPenilaian {
    Koneksi con = new Koneksi();
    public Object[][] newData = new Object[100][];
    public DefaultTableModel tbmodel = new DefaultTableModel();
    public String[] tabelHeader = {"No", "Nama", "S1", "S2", "S3", "NA Sumatif", "Sumatif AS", "Rapor"};
    public String namaTabel;
    
    public ModelPenilaian(String namaTabel){
        this.namaTabel = namaTabel;
        String query = "select * from " + namaTabel;
        PreparedStatement pstm;
        
        try{
           String s1str, s2str, s3str, nasstr, sasstr, raporstr;
           con.statement = con.koneksi.createStatement();
           pstm = con.koneksi.prepareStatement(query);
           ResultSet rs = pstm.executeQuery();
           int indeks = 0;
           
           while(rs.next()){
               
               String nama = rs.getString("nama");
               String s1 = rs.getString("s1");
               if(s1 == null){
                   s1 = "";
               }
               String s2 = rs.getString("s2");
               if(s2 == null){
                   s2 = "";
               }
               String s3 = rs.getString("s3");
               if(s3 == null){
                   s3 = "";
               }
               String nas = rs.getString("nas");
               if(nas == null){
                   nas = "";
               }
               String sas = rs.getString("sas");
               if(sas == null){
                   sas = "";
               }
               String rapor = rs.getString("rapor");
               if(rapor == null){
                   rapor = "";
               }
               Object[] data = {(indeks+1), nama, s1, s2, s3, nas, sas, rapor};
               
               newData[indeks++] = data;
           }
           tbmodel.setDataVector(newData, tabelHeader);
           
        }catch(Exception e){
            System.out.println(e.getMessage());
        } 
    }
}
