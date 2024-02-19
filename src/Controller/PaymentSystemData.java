/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author matthewkormasela
 */
public class PaymentSystemData {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    private String sql;
    
    public String nim;
    public String nama;
    public String semester;
    public String jurusan;
    public String pembayaran;
    public String jumlah;
    
    public void simpan()throws SQLException{
        conn = DatabaseConnection.getDbConnection();
        sql ="INSERT INTO payment(nim,nama,semester,jurusan,pembayaran,jumlah)VALUES(?,?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1,nim);
        pst.setString(2,nama);
        pst.setString(3,semester);
        pst.setString(4,jurusan);
        pst.setString(5,pembayaran);
        pst.setString(6,jumlah);
        pst.execute();
        pst.close();
    }
    
    public void rubah()throws SQLException {
        conn = DatabaseConnection.getDbConnection();
        String sql = "UPDATE payment set nama=?,semester=?,jurusan=?,pembayaran=?,jumlah=?, where nim=";
        pst = conn.prepareStatement(sql);
        pst.setString(1,nim);
        pst.setString(2,nama);
        pst.setString(3,semester);
        pst.setString(4,jurusan);
        pst.setString(5,pembayaran);
        pst.setString(6,jumlah);
        pst.execute();
        pst.close();
    }
    
    public void hapus()throws SQLException{
        conn = DatabaseConnection.getDbConnection();
        String sql = "delete from payment where nim=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, nim);
            pst.execute();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
         }
    }
    
     public ResultSet UpdateJTable()throws SQLException{
        conn = DatabaseConnection.getDbConnection();
        sql = "select nim,nama,semester,jurusan,pembayaran,jumlah from payment";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
     }
}
