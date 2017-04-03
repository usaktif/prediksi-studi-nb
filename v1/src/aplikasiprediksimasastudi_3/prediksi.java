/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplikasiprediksimasastudi_3;

import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import koneksi.koneksi;
import net.proteanit.sql.DbUtils;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author aspire
 */
public class prediksi extends javax.swing.JFrame {
    String header[] = {"no","angkatan", "jenis kelamin", "kota", "ipk", "konsentrasi", "status kelulusan"};
    String header2[] = {"uraian data","jumlah"};
    String header3[] =  {"no","angkatan", "jenis kelamin", "kota", "ipk", "konsentrasi", "status1","Tepat","Lambat","status2","hasil"};
      
Connection con;
  Statement st;
  aplikasiprediksimasastudi_3.koneksi kon = new aplikasiprediksimasastudi_3.koneksi();
    private DefaultTableModel tabMode3;
     private DefaultTableModel tabMode2;
    private DefaultTableModel tabMode;
  String query;

  
  private void TampilDataTabel(){
      int error=0;
      removeTable();
      removeTable3();
      jumlah_klasifikasi_benar=0;
      jumlah_data_uji=0;
      T=0;

          try{
          con=kon.open();
          st=con.createStatement();
          query="SELECT * FROM data_uji";
          ResultSet rs=st.executeQuery(query);
          while(rs.next()){
              jumlah_data_uji++;
          }
          }
          catch(Exception ee){}
      System.out.println("==================================================================");
      int no=0;
       //try{
          con=kon.open();
        try {
            st=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(prediksi.class.getName()).log(Level.SEVERE, null, ex);
        }
          query="SELECT * FROM data_uji order by kode_uji asc";
          System.out.println("query="+query);
          ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(prediksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next()){
                //String kodetraining=rs.getString("kode_training");
                String angkatan=rs.getString("angkatan");
                String jeniskelamin=rs.getString("jenis_kelamin");
                String kota=rs.getString("kota");
                String ipk=rs.getString("ipk");
                String konsentrasi=rs.getString("konsentrasi");
                String status_kelulusan=rs.getString("status_kelulusan");
                
                no++;
                String data[] = {String.valueOf(no), angkatan, jeniskelamin, kota, ipk, konsentrasi, status_kelulusan};
                tabMode.addRow(data);
                
             
                
                double T=jumlah_tepat/jumlah_data;
                double L=jumlah_terlambat/jumlah_data;
                
                double aT=0;double aL=0;
                if(angkatan.equalsIgnoreCase("2001")){
                    aT=(j2001T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2001L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2002")){
                    aT=(j2002T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2002L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2003")){
                    aT=(j2003T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2003L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2004")){
                    aT=(j2004T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2004L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2005")){
                    aT=(j2005T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2005L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2006")){
                    aT=(j2006T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2006L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2007")){
                    aT=(j2007T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2007L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2008")){
                    aT=(j2008T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2008L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2009")){
                    aT=(j2009T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2009L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2010")){
                    aT=(j2010T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2010L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2011")){
                    aT=(j2011T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2011L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2012")){
                    aT=(j2012T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2012L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2013")){
                    aT=(j2013T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2003L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2014")){
                    aT=(j2014T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2014L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                
                
                double pT=0;double pL=0;
                if(jeniskelamin.equalsIgnoreCase("laki-laki")){
                    pT=(jpriaT+(varian_sampel*atribut_jeniskelamin))/(jumlah_tepat+varian_sampel);
                    pL=(jpriaL+(varian_sampel*atribut_jeniskelamin))/(jumlah_tepat+varian_sampel);
                }
                else{
                    pT=(jwanitaT+(varian_sampel*atribut_jeniskelamin))/(jumlah_tepat+varian_sampel);
                    pL=(jwanitaL+(varian_sampel*atribut_jeniskelamin))/(jumlah_tepat+varian_sampel);
                }
                
                double koT=0;double koL=0;
                if(kota.equalsIgnoreCase("kotamadya")){
                    koT=(jkotamadyaT+(varian_sampel*atribut_kota))/(jumlah_tepat+varian_sampel);
                    koL=(jkotamadyaL+(varian_sampel*atribut_kota))/(jumlah_tepat+varian_sampel);
                }
                else{
                    koT=(jkabupatenT+(varian_sampel*atribut_kota))/(jumlah_tepat+varian_sampel);
                    koL=(jkabupatenL+(varian_sampel*atribut_kota))/(jumlah_tepat+varian_sampel);
                }
                
                double rplT=0;double rplL=0;
                if(konsentrasi.equalsIgnoreCase("1")){
                    rplT=(j1T+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                    rplL=(j1L+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                }
                else   if(konsentrasi.equalsIgnoreCase("2")){
                    rplT=(j2T+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                    rplL=(j2L+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                }
                else   if(konsentrasi.equalsIgnoreCase("3")){
                    rplT=(j3T+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                    rplL=(j3L+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                }
                else {
                    rplT=(j4T+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                    rplL=(j4L+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                }
                
                double ipkT=0;double ipkL=0;
                if(ipk.equalsIgnoreCase("sangat_baik")){
                    ipkT= (jsangat_baikT+(varian_sampel*atribut_ipk))/(jumlah_tepat+varian_sampel);
                    ipkL=(jsangat_baikL+(varian_sampel*atribut_ipk))/(jumlah_tepat+varian_sampel);
                }
                else   if(ipk.equalsIgnoreCase("baik")){
                    ipkT=(jbaikT+(varian_sampel*atribut_ipk))/(jumlah_tepat+varian_sampel);
                    ipkL=(jbaikL+(varian_sampel*atribut_ipk))/(jumlah_tepat+varian_sampel);
                }
                else  {
                    ipkT=(jcukupT+(varian_sampel*atribut_ipk))/(jumlah_tepat+varian_sampel);
                    ipkL=(jcukupL+(varian_sampel*atribut_ipk))/(jumlah_tepat+varian_sampel);
                }
                
              //double sbT = (jcukupT+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
              //double sbL = (jcukupT+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                
                
                double hitung_probabilitasT=T*aT*pT*koT*rplT*ipkT;//*sbT
                double hitung_probabilitasL=L*aL*pL*koL*rplL*ipkL;//*sbL
                

                String hasil="NO";

                String status_kelulusan2="Tepat";
                if(hitung_probabilitasL > hitung_probabilitasT){status_kelulusan2="Terlambat";}
                
                if(status_kelulusan2.equalsIgnoreCase(status_kelulusan)){error=error+0;hasil="YES";jumlah_klasifikasi_benar++;}
                else{error=error+1;}
                
                
                System.out.println("T:"+T);
                System.out.println("L:"+L);
                
                System.out.println("\tANGK:"+angkatan+":T/L:"+aT+"/"+aL);
                System.out.println("\tGEND:"+jeniskelamin+":T/L:"+pT+"/"+pL);
                System.out.println("\tKOTA:"+kota+":T/L:"+koT+"/"+koL);
                System.out.println("\tKONS:"+konsentrasi+":T/L:"+rplT+"/"+rplL);
                System.out.println("\tIPK::"+ipk+":T/L:"+ipkT+"/"+ipkL);
                
                System.out.println("\t\tTEPAT:"+T+"*"+aT+"*"+pT+"*"+koT+"*"+rplT+"*"+ipkT);
                System.out.println("\t\tTEPAT::T*aT*pT*koT*rplT*ipkT=="+hitung_probabilitasT);
                
                System.out.println("\t\tLAMBAT:"+L+"*"+aL+"*"+pL+"*"+koL+"*"+rplL+"*"+ipkL);
                System.out.println("\t\tLAMBAT::L*aL*pL*koL*rplL*ipkL=="+hitung_probabilitasL);
                System.out.println("STATUS:"+status_kelulusan2);
                System.out.println("==================================================================");
                
                String data3[] = {String.valueOf(no), angkatan, jeniskelamin, kota, ipk, konsentrasi, status_kelulusan,String.valueOf(hitung_probabilitasT),String.valueOf(hitung_probabilitasL),status_kelulusan2,hasil};
                tabMode3.addRow(data3);
            }//while
            //double totals=T+L;
            //double pros=(error/totals) *100;
            
            //if (error==0){pros=100;}
            //double benar=totals-error;
            
            
//               double jumlah_tepat=210;
//   double jumlah_terlambat=210;
//   double jumlah_data=420;
//   
//   double jumlah_klasifikasi_benar=80;
//   double jumlah_data_uji=106;
            //=======MENGHITUNG AKURASI===============//
            double totals=T+L;
            double pros=(jumlah_klasifikasi_benar/jumlah_data_uji) *100;
            
            if (error==0){pros=100;}
            double benar=jumlah_data_uji-jumlah_klasifikasi_benar;
            
            lbl_hasil.setText(pros +" %");
            double akurasi=(jumlah_klasifikasi_benar/jumlah_data_uji) *100;
            
            System.out.println("akurasi::(jumlah_klasifikasi_benar/jumlah_data_uji) *100=");
            System.out.println("akurasi:"+akurasi);
            
            //lbl_hasil.setText("akurasi:"+akurasi);
            //lblUraian.setText("akurasi::(jumlah_klasifikasi_benar/jumlah_data_uji) *100=");
            
            
            
//      }catch(SQLException sqle){
//          //JOptionPane.showMessageDialog(null,"Data Gagal Masuk Tabel"+sqle);
//      }  
        } catch (SQLException ex) {
            Logger.getLogger(prediksi.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
  
   
    public prediksi() {
        initComponents();
         bacadt();
        TampilDataTabel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btn_exit = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        myTabel = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        lbl_hasil = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_nama = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_nim = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmb_angkatan = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        cmb_jeniskelamin = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        cmb_kota = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        cmb_ipk = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        cmb_konsentrasi = new javax.swing.JComboBox();
        btn_proses = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        lblUraian = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtOut = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtProses = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        cmb_statuskelulusan = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        simpan = new javax.swing.JButton();
        lbl_background = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        txtKeterangan = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Lora", 1, 36)); // NOI18N
        jLabel2.setText("Prediksi Kelulusan");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, -1, -1));

        btn_exit.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btn_exit.setText("Close");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });
        jPanel1.add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 660, 80, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("2 : Jaringan Komputer/Keamanan Informasi");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, -1, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Keterangan Kode Konsentrasi :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("3 : Grafika Komputer");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 70, -1, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("1 : Rekayasa Perangkat Lunak");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("4 : Sistem Informasi");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 90, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 50));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1020, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/prediksi3.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        tabMode2=new DefaultTableModel(null,header2);
        jTable1.setModel(tabMode2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, -1, 130));

        myTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        myTabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myTabelMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(myTabel);
        tabMode=new DefaultTableModel(null,header);
        myTabel.setModel(tabMode);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 600, 150));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Data Uji");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(jTable2);
        tabMode3=new DefaultTableModel(null,header3);
        jTable2.setModel(tabMode3);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 640, 120));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Tingkat Akurasi :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 130, -1));

        lbl_hasil.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_hasil.setText("100 %");
        jPanel1.add(lbl_hasil, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, 190, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Nama");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, 50, 20));
        jPanel1.add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 200, 190, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("NIM");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 250, -1, -1));
        jPanel1.add(txt_nim, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 240, 140, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Angkatan");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 280, -1, -1));

        cmb_angkatan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_angkatan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014" }));
        jPanel1.add(cmb_angkatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 280, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Jenis Kelamin");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 310, -1, -1));

        cmb_jeniskelamin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_jeniskelamin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "laki-laki", "perempuan" }));
        jPanel1.add(cmb_jeniskelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 310, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Kota");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, -1, -1));

        cmb_kota.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_kota.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "kotamadya", "kabupaten", "-" }));
        jPanel1.add(cmb_kota, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 340, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("IPK");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 370, -1, -1));

        cmb_ipk.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_ipk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "sangat_baik", "baik", "cukup", "-" }));
        jPanel1.add(cmb_ipk, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 370, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Konsentrasi");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 400, -1, 20));

        cmb_konsentrasi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_konsentrasi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "-" }));
        cmb_konsentrasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_konsentrasiActionPerformed(evt);
            }
        });
        jPanel1.add(cmb_konsentrasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 400, -1, -1));

        btn_proses.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_proses.setText("Proses");
        btn_proses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prosesActionPerformed(evt);
            }
        });
        jPanel1.add(btn_proses, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 490, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel17.setText("Hasil Data Pengujian");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, -1, -1));

        lblUraian.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblUraian.setText("Uraian Jumlah Data");
        jPanel1.add(lblUraian, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 560, 360, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Keterangan Status IPK :");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("cukup          = 2.00 - 2.55");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("baik             = 2.56 - 3.00");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("sangat_baik = > 3.00");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        txtOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOutActionPerformed(evt);
            }
        });
        jPanel1.add(txtOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 660, 180, 30));

        txtProses.setColumns(20);
        txtProses.setRows(5);
        jScrollPane1.setViewportView(txtProses);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 530, 320, 110));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel23.setText("Input Data Uji");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 150, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Status_kelulusan");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 440, -1, -1));

        cmb_statuskelulusan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_statuskelulusan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "tepat", "terlambat", "-", " " }));
        cmb_statuskelulusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_statuskelulusanActionPerformed(evt);
            }
        });
        jPanel1.add(cmb_statuskelulusan, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 440, -1, -1));

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 660, 30, 20));

        simpan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        simpan.setText("Save");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        jPanel1.add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 490, -1, -1));

        lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/background.png"))); // NOI18N
        jPanel1.add(lbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 780));

        txtStatus.setText("jTextField1");
        jPanel1.add(txtStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 190, -1, -1));

        txtKeterangan.setText("jTextField1");
        jPanel1.add(txtKeterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, -1, -1));

        jLabel26.setText("jLabel26");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 680, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        new menuawal_admin(query).show();
        this.dispose();
    }//GEN-LAST:event_btn_exitActionPerformed

    private void myTabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myTabelMouseClicked
    //Lihat();        // TODO add your handling code here:
    }//GEN-LAST:event_myTabelMouseClicked

    private void btn_prosesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prosesActionPerformed

        String hsl="";
        String nim=txt_nim.getText().toString();
        String nama=txt_nama.getText().toString();
        
                String angkatan=cmb_angkatan.getSelectedItem().toString();
                String jeniskelamin=cmb_jeniskelamin.getSelectedItem().toString();
                String kota=cmb_kota.getSelectedItem().toString();
                String ipk=cmb_ipk.getSelectedItem().toString();
                String konsentrasi=cmb_konsentrasi.getSelectedItem().toString();
               
                
                double T=jumlah_tepat/jumlah_data;
                double L=jumlah_terlambat/jumlah_data;
                
                double aT=0;double aL=0;
                if(angkatan.equalsIgnoreCase("2001")){
                    aT=(j2001T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2001L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2002")){
                    aT=(j2002T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2002L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2003")){
                    aT=(j2003T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2003L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2004")){
                    aT=(j2004T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2004L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2005")){
                    aT=(j2005T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2005L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2006")){
                    aT=(j2006T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2006L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2007")){
                    aT=(j2007T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2007L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2008")){
                    aT=(j2008T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2008L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2009")){
                    aT=(j2009T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2009L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2010")){
                    aT=(j2010T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2010L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2011")){
                    aT=(j2011T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2011L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2012")){
                    aT=(j2012T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2012L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2013")){
                    aT=(j2013T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2003L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2014")){
                    aT=(j2014T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2014L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                
                
                double pT=0;double pL=0;
                if(jeniskelamin.equalsIgnoreCase("laki-laki")){
                    pT=(jpriaT+(varian_sampel*atribut_jeniskelamin))/(jumlah_tepat+varian_sampel);
                    pL=(jpriaL+(varian_sampel*atribut_jeniskelamin))/(jumlah_tepat+varian_sampel);
                }
                else{
                    pT=(jwanitaT+(varian_sampel*atribut_jeniskelamin))/(jumlah_tepat+varian_sampel);
                    pL=(jwanitaL+(varian_sampel*atribut_jeniskelamin))/(jumlah_tepat+varian_sampel);
                }
                
                double koT=0;double koL=0;
                if(kota.equalsIgnoreCase("kotamadya")){
                    koT=(jkotamadyaT+(varian_sampel*atribut_kota))/(jumlah_tepat+varian_sampel);
                    koL=(jkotamadyaL+(varian_sampel*atribut_kota))/(jumlah_tepat+varian_sampel);
                }
                else if(kota.equalsIgnoreCase("kabupaten")){
                    koT=(jkabupatenT+(varian_sampel*atribut_kota))/(jumlah_tepat+varian_sampel);
                    koL=(jkabupatenL+(varian_sampel*atribut_kota))/(jumlah_tepat+varian_sampel);
                }
                else if(kota.equalsIgnoreCase("-")){
                    koT=1;
                    koL=1;
                }
                
                double rplT=0;double rplL=0;
                if(konsentrasi.equalsIgnoreCase("1")){
                    rplT=(j1T+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                    rplL=(j1L+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                }
                else   if(konsentrasi.equalsIgnoreCase("2")){
                    rplT=(j2T+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                    rplL=(j2L+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                }
                else   if(konsentrasi.equalsIgnoreCase("3")){
                    rplT=(j3T+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                    rplL=(j3L+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                }
                else   if(konsentrasi.equalsIgnoreCase("4")){
                    rplT=(j4T+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                    rplL=(j4L+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                }
                else   if(konsentrasi.equalsIgnoreCase("-")){
                    rplT=1;
                    rplL=1;
                //else {
                   // rplT=(j4T+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                   // rplL=(j4L+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                }
                
                
                double ipkT=0;double ipkL=0;
                if(ipk.equalsIgnoreCase("sangat_baik")){
                    ipkT= (jsangat_baikT+(varian_sampel*atribut_ipk))/(jumlah_tepat+varian_sampel);
                    ipkL=(jsangat_baikL+(varian_sampel*atribut_ipk))/(jumlah_tepat+varian_sampel);
                }
                else   if(ipk.equalsIgnoreCase("baik")){
                    ipkT=(jbaikT+(varian_sampel*atribut_ipk))/(jumlah_tepat+varian_sampel);
                    ipkL=(jbaikL+(varian_sampel*atribut_ipk))/(jumlah_tepat+varian_sampel);
                }
                else if (ipk.equalsIgnoreCase("cukup")){
                    ipkT=(jcukupT+(varian_sampel*atribut_ipk))/(jumlah_tepat+varian_sampel);
                    ipkL=(jcukupL+(varian_sampel*atribut_ipk))/(jumlah_tepat+varian_sampel);
                }
                else if (ipk.equalsIgnoreCase("-")){
                    ipkT=1;
                    ipkL=1;
                }
                
              //double sbT = (jcukupT+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
              //double sbL = (jcukupT+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                
                
                double hitung_probabilitasT=T*aT*pT*koT*rplT*ipkT;//*sbT
                double hitung_probabilitasL=L*aL*pL*koL*rplL*ipkL;//*sbL
                
                

                String hasil="NO";

                String status_kelulusan2="Tepat";
                if(hitung_probabilitasL > hitung_probabilitasT){status_kelulusan2="Terlambat";}
                
                System.out.println("T:"+T);
                System.out.println("L:"+L);
                
                System.out.println("\tANGK:"+angkatan+":T/L:"+aT+"/"+aL);
                System.out.println("\tGEND:"+jeniskelamin+":T/L:"+pT+"/"+pL);
                System.out.println("\tKOTA:"+kota+":T/L:"+koT+"/"+koL);
                System.out.println("\tKONS:"+konsentrasi+":T/L:"+rplT+"/"+rplL);
                System.out.println("\tIPK::"+ipk+":T/L:"+ipkT+"/"+ipkL);
                
                System.out.println("\t\tTEPAT:"+T+"*"+aT+"*"+pT+"*"+koT+"*"+rplT+"*"+ipkT);
                System.out.println("\t\tTEPAT::T*aT*pT*koT*rplT*ipkT=="+hitung_probabilitasT);
                
                System.out.println("\t\tLAMBAT:"+L+"*"+aL+"*"+pL+"*"+koL+"*"+rplL+"*"+ipkL);
                System.out.println("\t\tLAMBAT::L*aL*pL*koL*rplL*ipkL=="+hitung_probabilitasL);
                System.out.println("\t\tSTATUS:"+status_kelulusan2);
                System.out.println("==================================================================");
                
        txtOut.setText("ANDA BERPOTENSI "+status_kelulusan2);

        hsl=hsl+"T:"+T+"\n"+"L:"+L+"\n\tANGK:"+angkatan+":T/L:"+aT+"/"+aL+"\n";
        hsl=hsl+"T:"+T+"\n"+"L:"+L+"\n\tGEND:"+jeniskelamin+":T/L:"+pT+"/"+pL+"\n";
        hsl=hsl+"T:"+T+"\n"+"L:"+L+"\n\tKOTA:"+kota+":T/L:"+koT+"/"+koL+"\n";
        hsl=hsl+"T:"+T+"\n"+"L:"+L+"\n\tKONS:"+konsentrasi+":T/L:"+rplT+"/"+rplL+"\n";
        hsl=hsl+"T:"+T+"\n"+"L:"+L+"\n\tIPK:"+ipk+":T/L:"+ipkT+"/"+ipkL+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n";
        
        hsl=hsl+"T:"+T+"\n\t\t\tTEPAT:"+T+"*"+aT+"*"+pT+"*"+koT+"*"+rplT+"*"+ipkT;
        hsl=hsl+"T:"+T+"\n\tTEPAT::T*aT*pT*koT*rplT*ipkT=="+hitung_probabilitasT;
        
        hsl=hsl+"L:"+L+"\n\t\tLAMBAT:"+L+"*"+aL+"*"+pL+"*"+koL+"*"+rplL+"*"+ipkL+"\n";
         hsl=hsl+"L:"+L+"\n\t\tLAMBAT::L*aL*pL*koL*rplL*ipkL=="+hitung_probabilitasL+"\n";
        
        
        hsl=hsl+"\t\tSTATUS:"+status_kelulusan2;
        
//        hsl=hsl"==================================================================");
        
        txtOut.setText("ANDA BERPOTENSI "+status_kelulusan2);
        txtProses.setText(hsl);
       
        
            //String value1 = cmb_angkatan.getSelectedItem().toString();
            //String value2 = cmb_jeniskelamin.getSelectedItem().toString();
            //String value3 = cmb_kota.getSelectedItem().toString();
            //String value4 = cmb_ipk.getSelectedItem().toString();
            //String value5 = cmb_konsentrasi.getSelectedItem().toString();
            //String value6 = cmb_statuskelulusan.getSelectedItem().toString();

        //try{
          // kon.QUERY("INSERT INTO `data_mahasiswa` (`kode_training`, `angkatan`, `jenis_kelamin`, `kota`, `ipk`, `konsentrasi`, `status_kelulusan`) VALUES (NULL, '"+value1+"', '"+value2+"', '"+value3+"', '"+value4+"', '"+value5+"', '"+value6+"')","Simpan"); 
           
           
         
     // }catch (Exception sqle){
       // JOptionPane.showMessageDialog(rootPane,"Data Gagalllllll");
    	// } 
        
        //Icon icon = new ImageIcon("/gambar/abu.png");
        //jLabel25.setIcon(new ImageIcon("/gambar/abu.png"));
        
        
        
     //   ImageIcon icon = new ImageIcon("gambar/Check-icon.png","this is a caption");
      // ImageIcon icon = createImageIcon("C:\\Users\\aspire\\Documents\\NetBeansProjects\\AplikasiPrediksiMasaStudi_3\\build\\classes\\gambar");
       
        //bacadt();
        //if(value6.equalsIgnoreCase(status_kelulusan2)){jLabel25.setText("");}
       //else{jLabel25.setText("");}
       
        reset();
        bacadt();
        TampilDataTabel();
    }//GEN-LAST:event_btn_prosesActionPerformed
void reset(){
j2001=0;
j2001T=0;
j2001L=0;

j2002=0;
j2002T=0;
j2002L=0;
   
   j2003=0;
   j2003T=0;
   j2003L=0;
  
   j2004=0;
   j2004T=0;
   j2004L=0;
   
   j2005=0;
   j2005T=0;
   j2005L=0;
  
   j2006=0;
   j2006T=0;
   j2006L=0;
   
   j2007=0;
   j2007T=0;
  j2007L=0;
   
   j2008=0;
   j2008T=0;
   j2008L=0;
   
   j2009=0;
   j2009T=0;
   j2009L=0;
   
   j2010=0;
   j2010T=0;
   j2010L=0;
    
   j2011=0;
   j2011T=0;
   j2011L=0;
   
   j2012=0;
   j2012T=0;
   j2012L=0;
   
   j2013=0;
   j2013T=0;
   j2013L=0;
   
   j2014=0;
   j2014T=0;
   j2014L=0;
   
   jpria=0;
   jpriaT=0;
   jpriaL=0;
   
   jwanita=0;
   jwanitaT=0;
   jwanitaL=0;
   
   jkotamadya=0;
   jkotamadyaT=0;
   jkotamadyaL=0;
   
   jkabupaten=0;
   jkabupatenT=0;
   jkabupatenL=0;
   
   jsangat_baik=0;
   jsangat_baikT=0;
   jsangat_baikL=0;
   
   jbaik=0;
   jbaikT=0;
   jbaikL=0;
   
   jcukup=0;
   jcukupT=0;
   jcukupL=0;
   
   jipk=0;
   dn=0;
   ipkT=0;
   ipkL=0;
   
   j1=0;
   j1T=0;
   j1L=0;
   
   j2=0;
   j2T=0;
   j2L=0;
   
   j3=0;
   j3T=0;
   j3L=0;
   
   j4=0;
   j4T=0;
   j4L=0;
   
   //int jumlah_tepat=0;
   //int jumlah_terlambat=0;
   //int jumlah_data=0;
    
   varian_sampel=2;
   atribut_angkatan=0.1;
   atribut_jeniskelamin=0.5;  
   atribut_kota=0.5;
   atribut_konsentrasi=0.25;
   atribut_ipk=0.3;
   
   jumlah_tepat=210;
   jumlah_terlambat=210;
   jumlah_data=420;
   
   jumlah_klasifikasi_benar=80;
   jumlah_data_uji=106;
   
   T=0;
   L=0;

   hitung_probabilitasT=0;
   hitung_probabilitasL=0;
   hasil=0;
}
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOutActionPerformed

    private void cmb_konsentrasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_konsentrasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_konsentrasiActionPerformed

    private void cmb_statuskelulusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_statuskelulusanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_statuskelulusanActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        String hsl="";
        String nim=txt_nim.getText().toString();
        String nama=txt_nama.getText().toString();
        
                String angkatan=cmb_angkatan.getSelectedItem().toString();
                String jeniskelamin=cmb_jeniskelamin.getSelectedItem().toString();
                String kota=cmb_kota.getSelectedItem().toString();
                String ipk=cmb_ipk.getSelectedItem().toString();
                String konsentrasi=cmb_konsentrasi.getSelectedItem().toString();
               
                
                double T=jumlah_tepat/jumlah_data;
                double L=jumlah_terlambat/jumlah_data;
                
                double aT=0;double aL=0;
                if(angkatan.equalsIgnoreCase("2001")){
                    aT=(j2001T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2001L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2002")){
                    aT=(j2002T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2002L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2003")){
                    aT=(j2003T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2003L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2004")){
                    aT=(j2004T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2004L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2005")){
                    aT=(j2005T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2005L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2006")){
                    aT=(j2006T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2006L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2007")){
                    aT=(j2007T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2007L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2008")){
                    aT=(j2008T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2008L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                else if(angkatan.equalsIgnoreCase("2009")){
                    aT=(j2009T+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                    aL=(j2009L+(varian_sampel*atribut_angkatan))/(jumlah_tepat+varian_sampel);
                }
                
                
                double pT=0;double pL=0;
                if(jeniskelamin.equalsIgnoreCase("laki-laki")){
                    pT=(jpriaT+(varian_sampel*atribut_jeniskelamin))/(jumlah_tepat+varian_sampel);
                    pL=(jpriaL+(varian_sampel*atribut_jeniskelamin))/(jumlah_tepat+varian_sampel);
                }
                else{
                    pT=(jwanitaT+(varian_sampel*atribut_jeniskelamin))/(jumlah_tepat+varian_sampel);
                    pL=(jwanitaL+(varian_sampel*atribut_jeniskelamin))/(jumlah_tepat+varian_sampel);
                }
                
                double koT=0;double koL=0;
                if(kota.equalsIgnoreCase("kotamadya")){
                    koT=(jkotamadyaT+(varian_sampel*atribut_kota))/(jumlah_tepat+varian_sampel);
                    koL=(jkotamadyaL+(varian_sampel*atribut_kota))/(jumlah_tepat+varian_sampel);
                }
                else if(kota.equalsIgnoreCase("kabupaten")){
                    koT=(jkabupatenT+(varian_sampel*atribut_kota))/(jumlah_tepat+varian_sampel);
                    koL=(jkabupatenL+(varian_sampel*atribut_kota))/(jumlah_tepat+varian_sampel);
                }
                else if(kota.equalsIgnoreCase("-")){
                    koT=1;
                    koL=1;
                }
                
                double rplT=0;double rplL=0;
                if(konsentrasi.equalsIgnoreCase("1")){
                    rplT=(j1T+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                    rplL=(j1L+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                }
                else   if(konsentrasi.equalsIgnoreCase("2")){
                    rplT=(j2T+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                    rplL=(j2L+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                }
                else   if(konsentrasi.equalsIgnoreCase("3")){
                    rplT=(j3T+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                    rplL=(j3L+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                }
                else   if(konsentrasi.equalsIgnoreCase("4")){
                    rplT=(j4T+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                    rplL=(j4L+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                }
                else   if(konsentrasi.equalsIgnoreCase("-")){
                    rplT=1;
                    rplL=1;
                //else {
                   // rplT=(j4T+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                   // rplL=(j4L+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                }
                
                
                double ipkT=0;double ipkL=0;
                if(ipk.equalsIgnoreCase("sangat_baik")){
                    ipkT= (jsangat_baikT+(varian_sampel*atribut_ipk))/(jumlah_tepat+varian_sampel);
                    ipkL=(jsangat_baikL+(varian_sampel*atribut_ipk))/(jumlah_tepat+varian_sampel);
                }
                else   if(ipk.equalsIgnoreCase("baik")){
                    ipkT=(jbaikT+(varian_sampel*atribut_ipk))/(jumlah_tepat+varian_sampel);
                    ipkL=(jbaikL+(varian_sampel*atribut_ipk))/(jumlah_tepat+varian_sampel);
                }
                else  {
                    ipkT=(jcukupT+(varian_sampel*atribut_ipk))/(jumlah_tepat+varian_sampel);
                    ipkL=(jcukupL+(varian_sampel*atribut_ipk))/(jumlah_tepat+varian_sampel);
                }
                
              //double sbT = (jcukupT+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
              //double sbL = (jcukupT+(varian_sampel*atribut_konsentrasi))/(jumlah_tepat+varian_sampel);
                
                
                double hitung_probabilitasT=T*aT*pT*koT*rplT*ipkT;//*sbT
                double hitung_probabilitasL=L*aL*pL*koL*rplL*ipkL;//*sbL
                
                

                String hasil="NO";

                String status_kelulusan2="Tepat";
                if(hitung_probabilitasL > hitung_probabilitasT){status_kelulusan2="Terlambat";}
                
                System.out.println("T:"+T);
                System.out.println("L:"+L);
                
                System.out.println("\tANGK:"+angkatan+":T/L:"+aT+"/"+aL);
                System.out.println("\tGEND:"+jeniskelamin+":T/L:"+pT+"/"+pL);
                System.out.println("\tKOTA:"+kota+":T/L:"+koT+"/"+koL);
                System.out.println("\tKONS:"+konsentrasi+":T/L:"+rplT+"/"+rplL);
                System.out.println("\tIPK::"+ipk+":T/L:"+ipkT+"/"+ipkL);
                
                System.out.println("\t\tTEPAT:"+T+"*"+aT+"*"+pT+"*"+koT+"*"+rplT+"*"+ipkT);
                System.out.println("\t\tTEPAT::T*aT*pT*koT*rplT*ipkT=="+hitung_probabilitasT);
                
                System.out.println("\t\tLAMBAT:"+L+"*"+aL+"*"+pL+"*"+koL+"*"+rplL+"*"+ipkL);
                System.out.println("\t\tLAMBAT::L*aL*pL*koL*rplL*ipkL=="+hitung_probabilitasL);
                System.out.println("\t\tSTATUS:"+status_kelulusan2);
                System.out.println("==================================================================");
                
        txtOut.setText("ANDA BERPOTENSI "+status_kelulusan2);

        hsl=hsl+"T:"+T+"\n"+"L:"+L+"\n\tANGK:"+angkatan+":T/L:"+aT+"/"+aL+"\n";
        hsl=hsl+"T:"+T+"\n"+"L:"+L+"\n\tGEND:"+jeniskelamin+":T/L:"+pT+"/"+pL+"\n";
        hsl=hsl+"T:"+T+"\n"+"L:"+L+"\n\tKOTA:"+kota+":T/L:"+koT+"/"+koL+"\n";
        hsl=hsl+"T:"+T+"\n"+"L:"+L+"\n\tKONS:"+konsentrasi+":T/L:"+rplT+"/"+rplL+"\n";
        hsl=hsl+"T:"+T+"\n"+"L:"+L+"\n\tIPK:"+ipk+":T/L:"+ipkT+"/"+ipkL+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n";
        
        hsl=hsl+"T:"+T+"\n\t\t\tTEPAT:"+T+"*"+aT+"*"+pT+"*"+koT+"*"+rplT+"*"+ipkT;
        hsl=hsl+"T:"+T+"\n\tTEPAT::T*aT*pT*koT*rplT*ipkT=="+hitung_probabilitasT;
        
        hsl=hsl+"L:"+L+"\n\t\tLAMBAT:"+L+"*"+aL+"*"+pL+"*"+koL+"*"+rplL+"*"+ipkL+"\n";
         hsl=hsl+"L:"+L+"\n\t\tLAMBAT::L*aL*pL*koL*rplL*ipkL=="+hitung_probabilitasL+"\n";
        
        
        hsl=hsl+"\t\tSTATUS:"+status_kelulusan2;
        
//        hsl=hsl"==================================================================");
        
        txtOut.setText("ANDA BERPOTENSI "+status_kelulusan2);
        txtProses.setText(hsl);
       
        
            String value1 = cmb_angkatan.getSelectedItem().toString();
            String value2 = cmb_jeniskelamin.getSelectedItem().toString();
            String value3 = cmb_kota.getSelectedItem().toString();
            String value4 = cmb_ipk.getSelectedItem().toString();
            String value5 = cmb_konsentrasi.getSelectedItem().toString();
            String value6 = cmb_statuskelulusan.getSelectedItem().toString();

        try{
           kon.QUERY("INSERT INTO `data_mahasiswa` (`kode_training`, `angkatan`, `jenis_kelamin`, `kota`, `ipk`, `konsentrasi`, `status_kelulusan`) VALUES (NULL, '"+value1+"', '"+value2+"', '"+value3+"', '"+value4+"', '"+value5+"', '"+value6+"')","Simpan"); 
           
           
         
      }catch (Exception sqle){
        JOptionPane.showMessageDialog(rootPane,"Data Gagalllllll");
    	 } 
        
        //Icon icon = new ImageIcon("/gambar/abu.png");
        //jLabel25.setIcon(new ImageIcon("/gambar/abu.png"));
        
        
        
     //   ImageIcon icon = new ImageIcon("gambar/Check-icon.png","this is a caption");
      // ImageIcon icon = createImageIcon("C:\\Users\\aspire\\Documents\\NetBeansProjects\\AplikasiPrediksiMasaStudi_3\\build\\classes\\gambar");
       
        bacadt();
        if(value6.equalsIgnoreCase(status_kelulusan2)){jLabel25.setText("");}
        else{jLabel25.setText("");}
       
        reset();
        bacadt();
        TampilDataTabel();
               // TODO add your handling code here:
    }//GEN-LAST:event_simpanActionPerformed

    //public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       // try {
           // for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               // if ("Nimbus".equals(info.getName())) {
                  //  javax.swing.UIManager.setLookAndFeel(info.getClassName());
                  //  break;
               // }
           // }
       // } catch (ClassNotFoundException ex) {
         //   java.util.logging.Logger.getLogger(prediksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      //  } catch (InstantiationException ex) {
         //   java.util.logging.Logger.getLogger(prediksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       // } catch (IllegalAccessException ex) {
         //   java.util.logging.Logger.getLogger(prediksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       // } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         //   java.util.logging.Logger.getLogger(prediksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       // }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
       // java.awt.EventQueue.invokeLater(new Runnable() {
            //public void run() {
               // new prediksi().setVisible(true);
            //}
       // });
    //}

  void bacadt(){
        jumlah_tepat=0;
        jumlah_terlambat=0;
        jumlah_data=0;
      
        
    removeTable2();
      try{
          con=kon.open();
          st=con.createStatement();
          query="SELECT * FROM data_mahasiswa order by kode_training asc";
          ResultSet rs=st.executeQuery(query);
          while(rs.next()){
            String kode_training=rs.getString("kode_training");
            String angkatan=rs.getString("angkatan");  
            String jenis_kelamin=rs.getString("jenis_kelamin");
            String kota=rs.getString("kota");
            String ipk=rs.getString("ipk");
            String konsentrasi=rs.getString("konsentrasi");
        
            try{
            dn=Double.parseDouble(ipk);
            }
            catch(Exception ee){dn=0;}

            
            String status_kelulusan=rs.getString("status_kelulusan");
            
     
        
           if(status_kelulusan.equalsIgnoreCase("tepat")){jumlah_tepat++;}
                if(status_kelulusan.equalsIgnoreCase("terlambat")){jumlah_terlambat++;}
                jumlah_data++;
                
            if(angkatan.equalsIgnoreCase("2001")){
                j2001++;
                if(status_kelulusan.equalsIgnoreCase("tepat")){j2001T++;}
                else if(status_kelulusan.equalsIgnoreCase("terlambat")){j2001L++;}
            }
            
            if(angkatan.equalsIgnoreCase("2002")){
                j2002++;
                if(status_kelulusan.equalsIgnoreCase("tepat")){j2002T++;}
                else if(status_kelulusan.equalsIgnoreCase("terlambat")){j2002L++;}
            }
            
            if(angkatan.equalsIgnoreCase("2003")){
                j2003++;
                if(status_kelulusan.equalsIgnoreCase("tepat")){j2003T++;}
                else if(status_kelulusan.equalsIgnoreCase("terlambat")){j2003L++;}
            }
            
            if(angkatan.equalsIgnoreCase("2004")){
                j2004++;
                if(status_kelulusan.equalsIgnoreCase("tepat")){j2004T++;}
                else if(status_kelulusan.equalsIgnoreCase("terlambat")){j2004L++;}
            }
            
            if(angkatan.equalsIgnoreCase("2005")){
                j2005++;
                if(status_kelulusan.equalsIgnoreCase("tepat")){j2005T++;}
                else if(status_kelulusan.equalsIgnoreCase("terlambat")){j2005L++;}
            }
            
            if(angkatan.equalsIgnoreCase("2006")){
                j2006++;
                if(status_kelulusan.equalsIgnoreCase("tepat")){j2006T++;}
                else if(status_kelulusan.equalsIgnoreCase("terlambat")){j2006L++;}    
            }
            
            if(angkatan.equalsIgnoreCase("2007")){
                j2007++;
                if(status_kelulusan.equalsIgnoreCase("tepat")){j2007T++;}
                else if(status_kelulusan.equalsIgnoreCase("terlambat")){j2007L++;}    
            }
            
            if(angkatan.equalsIgnoreCase("2008")){
                j2008++;
                if(status_kelulusan.equalsIgnoreCase("tepat")){j2008T++;}
                else if(status_kelulusan.equalsIgnoreCase("terlambat")){j2008L++;}    
            }
            
            if(angkatan.equalsIgnoreCase("2009")){
                j2009++;
                if(status_kelulusan.equalsIgnoreCase("tepat")){j2009T++;}
                else if(status_kelulusan.equalsIgnoreCase("terlambat")){j2009L++;}    
            }
            
             if(jenis_kelamin.equalsIgnoreCase("perempuan")){
                jwanita++;
                if(status_kelulusan.equalsIgnoreCase("tepat")){jwanitaT++;}
                else if(status_kelulusan.equalsIgnoreCase("terlambat")){jwanitaL++;}
            }
            
             if(jenis_kelamin.equalsIgnoreCase("laki-laki")){
                jpria++;
                if(status_kelulusan.equalsIgnoreCase("tepat")){jpriaT++;}
                else if(status_kelulusan.equalsIgnoreCase("terlambat")){jpriaL++;}    
             }
             
            if(kota.equalsIgnoreCase("kotamadya")){
                jkotamadya++;
                if(status_kelulusan.equalsIgnoreCase("tepat")){jkotamadyaT++;}
                else if(status_kelulusan.equalsIgnoreCase("terlambat")){jkotamadyaL++;}
            } 
            
            if(kota.equalsIgnoreCase("kabupaten")){
                jkabupaten++;
                if(status_kelulusan.equalsIgnoreCase("tepat")){jkabupatenT++;}
                else if(status_kelulusan.equalsIgnoreCase("terlambat")){jkabupatenL++;}
            } 
           
            /* if(dn>40){
               jipk++;
               if(status_kelulusan.equalsIgnoreCase("tepat")){ipkT++;}
               else if(status_kelulusan.equalsIgnoreCase("terlambat")){ipkL++;}   
            }
             else              if(dn>30){
               jipk++;
               if(status_kelulusan.equalsIgnoreCase("tepat")){ipkT++;}
               else if(status_kelulusan.equalsIgnoreCase("terlambat")){ipkL++;}   
            }
             else  {
               jipk++;
               if(status_kelulusan.equalsIgnoreCase("tepat")){ipkT++;}
               else if(status_kelulusan.equalsIgnoreCase("terlambat")){ipkL++;}   
            }*/
            
            if(ipk.equalsIgnoreCase("sangat_baik")){
               jsangat_baik++;
               if(status_kelulusan.equalsIgnoreCase("tepat")){jsangat_baikT++;}
               else if(status_kelulusan.equalsIgnoreCase("terlambat")){jsangat_baikL++;}
            }
           
           if(ipk.equalsIgnoreCase("baik")){
               jbaik++;
               if(status_kelulusan.equalsIgnoreCase("tepat")){jbaikT++;}
               else if(status_kelulusan.equalsIgnoreCase("terlambat")){jbaikL++;}
            }
           
           if(ipk.equalsIgnoreCase("cukup")){
               jcukup++;
               if(status_kelulusan.equalsIgnoreCase("tepat")){jcukupT++;}
               else if(status_kelulusan.equalsIgnoreCase("terlambat")){jcukupL++;}
            }

            if(konsentrasi.equalsIgnoreCase("1")){
               j1++;
               if(status_kelulusan.equalsIgnoreCase("tepat")){j1T++;}
               else if(status_kelulusan.equalsIgnoreCase("terlambat")){j1L++;}
            }
             
            if(konsentrasi.equalsIgnoreCase("2")){
               j2++;
               if(status_kelulusan.equalsIgnoreCase("tepat")){j2T++;}
               else if(status_kelulusan.equalsIgnoreCase("terlambat")){j2L++;}
            }
            
            if(konsentrasi.equalsIgnoreCase("3")){
               j3++;
               if(status_kelulusan.equalsIgnoreCase("tepat")){j3T++;}
               else if(status_kelulusan.equalsIgnoreCase("terlambat")){j3L++;}
            }
            
            if(konsentrasi.equalsIgnoreCase("4")){
               j4++;
               if(status_kelulusan.equalsIgnoreCase("tepat")){j4T++;}
               else if(status_kelulusan.equalsIgnoreCase("terlambat")){j4L++;}
            }
            //String data[] = {kode_training,angkatan, jenis_kelamin, kota, ipk, konsentrasi, status_kelulusan};
            //tabMode2.addRow(data);
          }
      }catch(SQLException sqle){
          JOptionPane.showMessageDialog(null,"Data Gagal Masuk Tabel"+sqle);
      } 
     String mdata1[] = {"Jumlah 2001" ,String.valueOf(j2001)};
        tabMode2.addRow(mdata1);
      String mdata2[] = {"Jumlah 2001 Tepat" ,String.valueOf(j2001T)};
        tabMode2.addRow(mdata2);
      String mdata3[] = {"Jumlah 2001 Terlambat" ,String.valueOf(j2001L)};
        tabMode2.addRow(mdata3);
      String mdata4[] = {"Jumlah 2002" ,String.valueOf(j2002)};
        tabMode2.addRow(mdata4);
      String mdata5[] = {"Jumlah 2002 Tepat" ,String.valueOf(j2002T)};
        tabMode2.addRow(mdata5);
      String mdata6[] = {"Jumlah 2002 Terlambat" ,String.valueOf(j2002L)};
        tabMode2.addRow(mdata6);
      String mdata7[] = {"Jumlah 2003" ,String.valueOf(j2003)};
        tabMode2.addRow(mdata7); 
      String mdata8[] = {"Jumlah 2003 Tepat" ,String.valueOf(j2003T)};
        tabMode2.addRow(mdata8);  
      String mdata9[] = {"Jumlah 2003 Terlambat" ,String.valueOf(j2003L)};
        tabMode2.addRow(mdata9); 
      String mdata10[] = {"Jumlah 2004" ,String.valueOf(j2004)};
        tabMode2.addRow(mdata10); 
      String mdata11[] = {"Jumlah 2004 Tepat" ,String.valueOf(j2004T)};
        tabMode2.addRow(mdata11); 
      String mdata12[] = {"Jumlah 2004 Terlambat" ,String.valueOf(j2004L)};
        tabMode2.addRow(mdata12);  
      String mdata13[] = {"Jumlah 2005" ,String.valueOf(j2005)};
        tabMode2.addRow(mdata13);  
      String mdata14[] = {"Jumlah 2005 Tepat" ,String.valueOf(j2005T)};
        tabMode2.addRow(mdata14); 
     String mdata15[] = {"Jumlah 2005 Terlambat" ,String.valueOf(j2005L)};
        tabMode2.addRow(mdata15);  
     String mdata16[] = {"Jumlah 2006" ,String.valueOf(j2006)};
        tabMode2.addRow(mdata16);  
     String mdata17[] = {"Jumlah 2006 Tepat" ,String.valueOf(j2006T)};
        tabMode2.addRow(mdata17);
     String mdata18[] = {"Jumlah 2006 Terlambat" ,String.valueOf(j2006L)};
        tabMode2.addRow(mdata18); 
    String mdata19[] = {"Jumlah 2007" ,String.valueOf(j2007)};
        tabMode2.addRow(mdata19);      
    String mdata20[] = {"Jumlah 2007 Tepat" ,String.valueOf(j2007T)};
        tabMode2.addRow(mdata20);   
    String mdata21[] = {"Jumlah 2007 Terlambat" ,String.valueOf(j2007L)};
        tabMode2.addRow(mdata21); 
    String mdata22[] = {"Jumlah 2008" ,String.valueOf(j2008)};
        tabMode2.addRow(mdata22); 
    String mdata23[] = {"Jumlah 2008 Tepat" ,String.valueOf(j2008T)};
        tabMode2.addRow(mdata23);
    String mdata24[] = {"Jumlah 2008 Terlambat" ,String.valueOf(j2008L)};
        tabMode2.addRow(mdata24);
    String mdata25[] = {"Jumlah 2009" ,String.valueOf(j2009)};
        tabMode2.addRow(mdata25);
    String mdata26[] = {"Jumlah 2009 Tepat" ,String.valueOf(j2009T)};
        tabMode2.addRow(mdata26);
    String mdata27[] = {"Jumlah 2009 Terlambat" ,String.valueOf(j2009L)};
        tabMode2.addRow(mdata27);
    String mdata28[] = {"Jumlah 2010" ,String.valueOf(j2010)};
        tabMode2.addRow(mdata28);
    String mdata29[] = {"Jumlah 2010 Tepat" ,String.valueOf(j2010T)};
        tabMode2.addRow(mdata29);
    String mdata30[] = {"Jumlah 2010 Terlambat" ,String.valueOf(j2010L)};
        tabMode2.addRow(mdata30);
    String mdata31[] = {"Jumlah 2011" ,String.valueOf(j2011)};
        tabMode2.addRow(mdata31);
    String mdata32[] = {"Jumlah 2011 Tepat" ,String.valueOf(j2011T)};
        tabMode2.addRow(mdata32);
    String mdata33[] = {"Jumlah 2011 Terlambat" ,String.valueOf(j2011L)};
        tabMode2.addRow(mdata33);
    String mdata34[] = {"Jumlah 2012" ,String.valueOf(j2012)};
        tabMode2.addRow(mdata34);
    String mdata35[] = {"Jumlah 2012 Tepat" ,String.valueOf(j2012T)};
        tabMode2.addRow(mdata35);
    String mdata36[] = {"Jumlah 2012 Terlambat" ,String.valueOf(j2012L)};
        tabMode2.addRow(mdata36);
    String mdata37[] = {"Jumlah 2013" ,String.valueOf(j2013)};
        tabMode2.addRow(mdata37);
    String mdata38[] = {"Jumlah 2013 Tepat" ,String.valueOf(j2013T)};
        tabMode2.addRow(mdata38);
    String mdata39[] = {"Jumlah 2013 Terlambat" ,String.valueOf(j2013L)};
        tabMode2.addRow(mdata39);
    String mdata40[] = {"Jumlah 2014" ,String.valueOf(j2014)};
        tabMode2.addRow(mdata40);
    String mdata41[] = {"Jumlah 2014 Tepat" ,String.valueOf(j2014T)};
        tabMode2.addRow(mdata41);
    String mdata42[] = {"Jumlah 2014 Terlambat" ,String.valueOf(j2014L)};
        tabMode2.addRow(mdata42);
    String mdata43[] = {"Jumlah laki-laki" ,String.valueOf(jpria)};
        tabMode2.addRow(mdata43);
    String mdata44[] = {"Jumlah laki-laki Tepat" ,String.valueOf(jpriaT)};
        tabMode2.addRow(mdata44);
    String mdata45[] = {"Jumlah laki-laki Terlambat" ,String.valueOf(jpriaL)};
        tabMode2.addRow(mdata45);
    String mdata46[] = {"Jumlah perempuan" ,String.valueOf(jwanita)};
        tabMode2.addRow(mdata46);
    String mdata47[] = {"Jumlah perempuan Tepat" ,String.valueOf(jwanitaT)};
        tabMode2.addRow(mdata47);
    String mdata48[] = {"Jumlah  perempuan Terlambat" ,String.valueOf(jwanitaL)};
        tabMode2.addRow(mdata48);
    String mdata49[] = {"Jumlah kotamadya" ,String.valueOf(jkotamadya)};
        tabMode2.addRow(mdata49);
    String mdata50[] = {"Jumlah kotamadya Tepat" ,String.valueOf(jkotamadyaT)};
        tabMode2.addRow(mdata50);
    String mdata51[] = {"Jumlah kotamadya Terlambat" ,String.valueOf(jkotamadyaL)};
        tabMode2.addRow(mdata51);
    String mdata52[] = {"Jumlah kabupaten" ,String.valueOf(jkabupaten)};
        tabMode2.addRow(mdata52);
    String mdata53[] = {"Jumlah kabupaten Tepat" ,String.valueOf(jkabupatenT)};
        tabMode2.addRow(mdata53);
    String mdata54[] = {"Jumlah kabupaten Terlambat" ,String.valueOf(jkabupatenL)};
        tabMode2.addRow(mdata54);
     String mdata55[] = {"Jumlah sangat_baik" ,String.valueOf(jsangat_baik)};
        tabMode2.addRow(mdata55);
    String mdata56[] = {"Jumlah sangat_baik Tepat" ,String.valueOf(jsangat_baikT)};
        tabMode2.addRow(mdata56);
    String mdata57[] = {"Jumlah sangat_baik Terlambat" ,String.valueOf(jsangat_baikL)};
        tabMode2.addRow(mdata57);
    String mdata58[] = {"Jumlah baik" ,String.valueOf(jbaik)};
        tabMode2.addRow(mdata58);
    String mdata59[] = {"Jumlah baik Tepat" ,String.valueOf(jbaikT)};
        tabMode2.addRow(mdata59);
    String mdata60[] = {"Jumlah baik Terlambat" ,String.valueOf(jbaikL)};
        tabMode2.addRow(mdata60);
    String mdata61[] = {"Jumlah cukup" ,String.valueOf(jcukup)};
        tabMode2.addRow(mdata61);
    String mdata62[] = {"Jumlah cukup Tepat" ,String.valueOf(jcukupT)};
        tabMode2.addRow(mdata62);
    String mdata63[] = {"Jumlah cukup Terlambat" ,String.valueOf(jcukupL)};
        tabMode2.addRow(mdata63);
    String mdata64[] = {"Jumlah 1" ,String.valueOf(j1)};
        tabMode2.addRow(mdata64);
    String mdata65[] = {"Jumlah 1 Tepat" ,String.valueOf(j1T)};
        tabMode2.addRow(mdata65);
    String mdata66[] = {"Jumlah 1 Terlambat" ,String.valueOf(j1L)};
        tabMode2.addRow(mdata66);
    String mdata67[] = {"Jumlah 2" ,String.valueOf(j2)};
        tabMode2.addRow(mdata67);
    String mdata68[] = {"Jumlah 2 Tepat" ,String.valueOf(j2T)};
        tabMode2.addRow(mdata68);
    String mdata69[] = {"Jumlah 2 Terlambat" ,String.valueOf(j2L)};
        tabMode2.addRow(mdata69);
    String mdata70[] = {"Jumlah 3" ,String.valueOf(j3)};
        tabMode2.addRow(mdata70);
    String mdata71[] = {"Jumlah 3 Tepat" ,String.valueOf(j3T)};
        tabMode2.addRow(mdata71);
    String mdata72[] = {"Jumlah 3 Terlambat" ,String.valueOf(j3L)};
        tabMode2.addRow(mdata72);
    String mdata73[] = {"Jumlah 4" ,String.valueOf(j4)};
        tabMode2.addRow(mdata73);
    String mdata74[] = {"Jumlah 4 Tepat" ,String.valueOf(j4T)};
        tabMode2.addRow(mdata74);
    String mdata75[] = {"Jumlah 4 Terlambat" ,String.valueOf(j4L)};
        tabMode2.addRow(mdata75);
      
}
 public void removeTable(){
        try{
            for(int t=tabMode.getRowCount();t>0;t--) {tabMode.removeRow(0);}
        }catch(Exception ex){ System.out.println(ex);
        }
 }
 
  public void removeTable2(){
        try{
            for(int t=tabMode2.getRowCount();t>0;t--) {tabMode2.removeRow(0);}
        }catch(Exception ex){ System.out.println(ex);
        }
 }
public void removeTable3(){
        try{
            for(int t=tabMode3.getRowCount();t>0;t--) {tabMode3.removeRow(0);}
        }catch(Exception ex){ System.out.println(ex);
        }
}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_proses;
    private javax.swing.JComboBox cmb_angkatan;
    private javax.swing.JComboBox cmb_ipk;
    private javax.swing.JComboBox cmb_jeniskelamin;
    private javax.swing.JComboBox cmb_konsentrasi;
    private javax.swing.JComboBox cmb_kota;
    private javax.swing.JComboBox cmb_statuskelulusan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblUraian;
    private javax.swing.JLabel lbl_background;
    private javax.swing.JLabel lbl_hasil;
    private javax.swing.JTable myTabel;
    private javax.swing.JButton simpan;
    private javax.swing.JTextField txtKeterangan;
    private javax.swing.JTextField txtOut;
    private javax.swing.JTextArea txtProses;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_nim;
    // End of variables declaration//GEN-END:variables
   int j2001=0;
   int j2001T=0;
   int j2001L=0;

   int j2002=0;
   int j2002T=0;
   int j2002L=0;
   
   int j2003=0;
   int j2003T=0;
   int j2003L=0;
  
   int j2004=0;
   int j2004T=0;
   int j2004L=0;
   
   int j2005=0;
   int j2005T=0;
   int j2005L=0;
  
   int j2006=0;
   int j2006T=0;
   int j2006L=0;
   
   int j2007=0;
   int j2007T=0;
   int j2007L=0;
   
   int j2008=0;
   int j2008T=0;
   int j2008L=0;
   
   int j2009=0;
   int j2009T=0;
   int j2009L=0;
   
   int j2010=0;
   int j2010T=0;
   int j2010L=0;
   
   int j2011=0;
   int j2011T=0;
   int j2011L=0;
   
   int j2012=0;
   int j2012T=0;
   int j2012L=0;
   
   int j2013=0;
   int j2013T=0;
   int j2013L=0;
   
   int j2014=0;
   int j2014T=0;
   int j2014L=0;
   
   int jpria=0;
   int jpriaT=0;
   int jpriaL=0;
   
   int jwanita=0;
   int jwanitaT=0;
   int jwanitaL=0;
   
   int jkotamadya=0;
   int jkotamadyaT=0;
   int jkotamadyaL=0;
   
   int jkabupaten=0;
   int jkabupatenT=0;
   int jkabupatenL=0;
   
   int jsangat_baik=0;
   int jsangat_baikT=0;
   int jsangat_baikL=0;
   
   int jbaik=0;
   int jbaikT=0;
   int jbaikL=0;
   
   int jcukup=0;
   int jcukupT=0;
   int jcukupL=0;
   
   int jkurang=0;
   int jkurangT=0;
   int jkurangL=0;
   
   int jipk=0;
   double dn=0;
   int ipkT=0;
   int ipkL=0;
   
   int j1=0;
   int j1T=0;
   int j1L=0;
   
   int j2=0;
   int j2T=0;
   int j2L=0;
   
   int j3=0;
   int j3T=0;
   int j3L=0;
   
   int j4=0;
   int j4T=0;
   int j4L=0;
   
   //int jumlah_tepat=0;
   //int jumlah_terlambat=0;
   //int jumlah_data=0;
    
   int varian_sampel=2;
   double atribut_angkatan=0.1;
   double atribut_jeniskelamin=0.5;  
   double atribut_kota=0.5;
   double atribut_konsentrasi=0.25;
   double atribut_ipk=0.3;
   
   double jumlah_tepat=210;
   double jumlah_terlambat=210;
   double jumlah_data=420;
   
   double jumlah_klasifikasi_benar=80;
   double jumlah_data_uji=106;
   
   double T;
   double L;

   double hitung_probabilitasT;
   double hitung_probabilitasL;
   double hasil;
}

