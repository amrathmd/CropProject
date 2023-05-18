/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gms;


import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JFileChooser;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ViewDetails extends javax.swing.JFrame {

    String fromYear=new String();
    String toYear=new String();
    
    public ViewDetails(String y1, String y2) {
        fromYear=y1+"01";
        toYear=y2+"03";
        initComponents();
        try{
            Connection con=getConnection();
                Statement s=con.createStatement();
                String sql="select * from crops where crop_id between '"+fromYear+"'and '"+toYear+"'";
                ResultSet rs=s.executeQuery(sql);
                DefaultTableModel model=(DefaultTableModel)cropsTable.getModel();
                while(rs.next())
                {
                    model.addRow(new String[]{String.valueOf(rs.getInt(5)),rs.getString(2),rs.getString(3),rs.getString(4),String.valueOf(rs.getFloat(6)),String.valueOf(rs.getInt(7)),String.valueOf(rs.getFloat(8)),String.valueOf(rs.getFloat(9)),String.valueOf(rs.getInt(10)),rs.getString(11)});
                }
                String sql1="select * from croptesting where crop_id between '"+fromYear+"'and '"+toYear+"'";
                ResultSet rs1=s.executeQuery(sql1);
                DefaultTableModel model1=(DefaultTableModel)CropTestingt.getModel();
                while(rs1.next())
                {   String id=rs1.getString(1);
                    String year=id.substring(0,4);
                    String season=getSeason(id.substring(4,6));
                    model1.addRow(new String[]{year,season,String.valueOf(rs1.getFloat(2)),String.valueOf(rs1.getFloat(3)),String.valueOf(rs1.getInt(4)),String.valueOf(rs1.getInt(5)),String.valueOf(rs1.getFloat(6)),String.valueOf(rs1.getInt(7)),String.valueOf(rs1.getInt(8)),String.valueOf(rs1.getInt(9)),String.valueOf(rs1.getInt(10)),String.valueOf(rs1.getInt(11)),String.valueOf(rs1.getFloat(12)),String.valueOf((char) rs1.getFloat(13)),String.valueOf(rs1.getFloat(14)),String.valueOf(rs1.getInt(15))});
                }
                String sql2="select * from planttesting where crop_id between '"+fromYear+"'and '"+toYear+"'";
                ResultSet rs2=s.executeQuery(sql2);
                DefaultTableModel model2=(DefaultTableModel)PlantTestingt.getModel();
                while(rs2.next())
                {   String id1=rs2.getString(1);
                    String year1=id1.substring(0,4);
                    String season1=getSeason(id1.substring(4,6));
                    model2.addRow(new String[]{year1,season1,rs2.getString(2),String.valueOf(rs2.getFloat(3)),rs2.getString(4),rs2.getString(5),rs2.getString(6),rs2.getString(7),rs2.getString(8),String.valueOf(rs2.getInt(9)),rs2.getString(10),rs2.getString(11),rs2.getString(12),rs2.getString(13),rs2.getString(14),rs2.getString(15),rs2.getString(16),rs2.getString(17),rs2.getString(18),rs2.getString(19),String.valueOf(rs2.getFloat(20))});
                }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ViewDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
     public static Connection getConnection()throws SQLException, ClassNotFoundException
    {
         String url="jdbc:mysql://localhost:3306/GMS";
            String user="root";
            String pass="Poojitha@123";
            
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection(url, user, pass);
                return con;
            
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cropsTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        CropTestingt = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        PlantTestingt = new javax.swing.JTable();
        printPlantTesting = new javax.swing.JButton();
        printCrop = new javax.swing.JButton();
        printCropTesting = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane6.setViewportBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane6.setAutoscrolls(true);

        jPanel1.setBackground(new java.awt.Color(154, 227, 232));
        jPanel1.setAutoscrolls(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Crops Details");

        jScrollPane2.setAutoscrolls(true);

        cropsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                " year", " crop name", "name_of_trail", "season", " plot_size", " number_of_rows", "gross", "net", " nunumber_Of_replications", "date_of_sowing"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(cropsTable);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Crop Testing Details");

        jScrollPane3.setAutoscrolls(true);

        CropTestingt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Year", "Season", "initial_stand", "final_stand", "days_to_firstflowering", "days_to_halfflowering", " plant_height", " number_of_main_branches", "secondary_branches", "pest_score", " disease_score", "number_of_seeds", " average_number_of_pods", " yield_per_plot", " average_yield_per_plant", " oil_percentage"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CropTestingt.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane3.setViewportView(CropTestingt);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Plant Testing Details");

        jScrollPane5.setAutoscrolls(true);

        PlantTestingt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Year", "Season", "growth_habit", " leaflet_size", "leaflet_color", " stem", " flower_on_mainaxis", " flower_on_sidebranches", "inflorescence", "time_of_maturity", "pod_constriction", "pod_reticulation", "number_of_kernels", " presence_of_beak", "testa_color", "color_of_testa", " kernel_shape", "fresh_seed_dormancy", "kernel_oil_percentage", "kernel_weight", "shelling_percentage"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(PlantTestingt);

        printPlantTesting.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        printPlantTesting.setForeground(new java.awt.Color(102, 102, 102));
        printPlantTesting.setText("Print");

        printCrop.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        printCrop.setForeground(new java.awt.Color(102, 102, 102));
        printCrop.setText("Print");
        printCrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printCropActionPerformed(evt);
            }
        });

        printCropTesting.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        printCropTesting.setForeground(new java.awt.Color(102, 102, 102));
        printCropTesting.setText("Print");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(573, 573, 573)
                        .addComponent(printCrop))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(579, 579, 579)
                        .addComponent(printCropTesting)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1092, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(596, 596, 596)
                        .addComponent(printPlantTesting)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(printCrop)
                .addGap(23, 23, 23)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printCropTesting)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(printPlantTesting)
                .addContainerGap(1052, Short.MAX_VALUE))
        );

        jScrollPane5.getAccessibleContext().setAccessibleName("");

        jScrollPane6.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1683, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane6.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printCropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printCropActionPerformed
        try{
            JFileChooser jFilechooser= new JFileChooser("C:\\Users\\poojitha\\Desktop\\Jtabletoexcel");
            FileNameExtensionFilter fnef=new FileNameExtensionFilter("EXCEL FILES","xls","xlsx","xlsm");
             jFilechooser.setFileFilter(fnef);
            jFilechooser.showSaveDialog(null);
            
            File saveFile=jFileChooser.getSectedFile();
            
            if(saveFile!= null){
                saveFile= new File(saveFile.toString()+".xlsx");
                Workbook wb=new XSSFWorkbook();
                Sheet sheet =wb.createSheet("crops");
                
                
                
            }
            
        }
    }//GEN-LAST:event_printCropActionPerformed

    
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ViewDetails().setVisible(true);
            }
        });
    }
    public static String getSeason(String id){
        switch (id) {
            case "01":
                return "Kharif";
            case "02":
                return "Rabi";
            default:
                return "Zaid";
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CropTestingt;
    private javax.swing.JTable PlantTestingt;
    private javax.swing.JTable cropsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton printCrop;
    private javax.swing.JButton printCropTesting;
    private javax.swing.JButton printPlantTesting;
    // End of variables declaration//GEN-END:variables
}
