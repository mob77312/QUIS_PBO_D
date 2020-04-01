/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quis;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;

public class isi extends JFrame
            implements ActionListener{

String[][]data = new String[500][7];
String[]kolom = { "ID", "Judul","Tipe","Episode","Genre","Status","Rating"};
    private JLabel  judul;
    private JLabel  Genre;
    private JLabel  ID;
    private JLabel  Judul;
    private JLabel  Tipe;
    private JLabel  Episode;
    private JLabel  Rating;
    private JLabel  Status;
    private JTextField Tipe1;
    private JTextField judul1;
    private JTextField Episode1;
    private JTextField Genre1;
    private JTextField Rating1;
    private JTextField Search;
    private JTextField Status1;
    private JButton Search1;
    private JButton Exit;
    private JButton Refresh;
    private JButton Create;
    private JButton Update;
    private JButton Delete;
  
    String DBurl = "jdbc:mysql://localhost/quis";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;
    private ResultSet resultSet;
    private final JTable tabel;
    public isi() {
        setTitle("FILM BOS!");
        Status1 = new JTextField();
    Genre = new JLabel  ("Genre");
    Judul = new JLabel  ("Judul");
    judul = new JLabel  ("Judul");
    Tipe = new JLabel ("Tipe");
    Episode = new JLabel  ("Episode");
    Rating = new JLabel  ("Rating");
    Status = new JLabel  ("Status");
    Tipe1 = new  JTextField ();
    judul1= new JTextField ();
    Episode1 = new JTextField ();
    Genre1 = new JTextField ();
    Rating1 = new JTextField ();
    Search=new JTextField ();
    Search1 = new JButton ("Search") ;
    Exit = new JButton ("Exit");
    Refresh = new JButton ("Refresh") ;
    Create = new JButton ("Create");
    Update = new JButton ("Update");
    Delete = new JButton ("Delete") ;
    Tipe1.addActionListener(this);
    judul1.addActionListener(this);
     Episode1.addActionListener(this);
    Genre1.addActionListener(this);
    Rating1.addActionListener(this);
    Search.addActionListener(this);

    Search1.addActionListener(this);
    Exit.addActionListener(this);
    Refresh.addActionListener(this);
    Create.addActionListener(this);
    Update.addActionListener(this);
    Delete.addActionListener(this);
     try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,
                      DBusername, DBpassword);
            statement = koneksi.createStatement();
            String sql = "select * from crud";
            resultSet = statement.executeQuery(sql);
            int p = 0;
            while (resultSet.next()) {
                data[p][0] = resultSet.getString("id");
                data[p][1] = resultSet.getString("judul");
                data[p][2] = resultSet.getString("tipe");
                data[p][3] = resultSet.getString("episode");
                data[p][4] = resultSet.getString("genre");
                data[p][5] = resultSet.getString("status");
                data[p][6] = resultSet.getString("rating");
                p++;
            }
            statement.close();
            koneksi.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    tabel = new JTable(data, kolom);    
        setLayout(null);
        add(tabel);
        add(judul);
        add(judul1);
        add(Tipe);
        add(Tipe1);
        add(Episode);
        add(Episode1);
        add(Genre);
        add(Genre1);
        add(Refresh);
        add(Create);
        add(Update);
        add(Delete);
        add(Exit);
        add(Rating);
        add(Rating1);
        add(Search);
        add(Search1);
        add(Status);
        add(Status1);
        
        
        setSize(800,600);
        tabel.setBounds(100,10,500,100);
        judul.setBounds(100,200,125,30);
        judul1.setBounds(150,200,200,30);
        Tipe.setBounds(100, 250, 125, 30);
        Tipe1.setBounds(150, 250, 200, 30);
        Episode.setBounds(100, 300, 125, 30);
        Episode1.setBounds(150, 300, 200, 30);
        Genre.setBounds(100, 350, 125, 30);
        Genre1.setBounds(150, 350, 200, 30);
        Refresh.setBounds(100, 400, 100, 30);
        Create.setBounds(200, 400, 100, 30);
        Update.setBounds(300, 400, 100, 30);
        Delete.setBounds(400, 400, 100, 30);
        Exit.setBounds(500, 400, 100, 30);
        Rating.setBounds(400, 300, 125, 30);
        Rating1.setBounds(450, 300, 200, 30);
        Search.setBounds(400, 200, 125, 30);
        Search1.setBounds(550, 200, 80, 30);
        Status.setBounds(400, 250, 125, 30);
        Status1.setBounds(550, 250, 80, 30);
        setVisible(true);
        
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Create) {
         try{
        Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,
                      DBusername, DBpassword);
            statement = koneksi.createStatement();
             statement.executeUpdate("insert into mahasiswa values("+Rating1.getText()+ ","+ judul1.getText() + "," +  Tipe1.getText() + "," + Episode1.getText() + "," +  Genre1.getText() + "," +  Status1.getText() + "," +  Rating1.getText() + ")");
     JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!", "Hasil",JOptionPane.INFORMATION_MESSAGE);            
            statement.close();
            koneksi.close();
            new isi();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data GagalDisimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
         
        }
        if (e.getSource()==Delete) {
            hapus();
        }
         if (e.getSource()==Refresh) {
             new isi();
         }
    }

    private void hapus() {
         try{
           
        Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,
                      DBusername, DBpassword);
            statement = koneksi.createStatement();
             statement.executeUpdate("delete from crud where id ='"+Rating1.getText()+"'" );
     JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!", "Hasil",JOptionPane.INFORMATION_MESSAGE);            
            statement.close();
            koneksi.close();
            new isi();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data GagalDihapus!", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }
}
