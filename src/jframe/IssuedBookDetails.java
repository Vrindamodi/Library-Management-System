
package jframe;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class IssuedBookDetails extends javax.swing.JFrame {
    String url = "jdbc:mysql://localhost:3306/lms_db";
    String user = "root";
    String pass = "VRINDA";
    Connection con;
    PreparedStatement pst;
    ResultSet rt;
    int id = 0;

    public void showDetails() {
        try {
            con = DriverManager.getConnection(url, user, pass);
            pst = con.prepareStatement(
                    "SELECT * FROM issue_books JOIN books ON books.book_id=issue_books.book_id JOIN students ON students.student_id=issue_books.student_id WHERE issue_books.due_date > CURRENT_DATE");
            rt = pst.executeQuery();
            DefaultTableModel tabModel = (DefaultTableModel) (issuedBookDetailsTab.getModel());
            tabModel.setRowCount(0);
            while (rt.next()) {
                Vector issuedRow = new Vector();
                issuedRow.add(rt.getInt("issue_id"));
                issuedRow.add(rt.getString("book_id"));
                issuedRow.add(rt.getString("title"));
                issuedRow.add(rt.getString("student_id"));
                issuedRow.add(rt.getString("name"));
                issuedRow.add(rt.getString("issue_date"));
                issuedRow.add(rt.getString("due_date"));
                issuedRow.add(rt.getString("status"));
                tabModel.addRow(issuedRow);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public IssuedBookDetails() {
        initComponents(); // Initialize components
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH); // Set the JFrame to full screen
        jPanel1.setLayout(new java.awt.BorderLayout()); // Make jPanel1 scalable
        showDetails(); // Load data into the table
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        issuedBookDetailsTab = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(75, 156, 211));
        jLabel1.setText("Issued Book Details");
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/books.png"))); // NOI18N
        issuedBookDetailsTab.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Serial No.", "Book ID", "Book Title", "Student ID", "Student Name", "Issue Date", "Due Date",
                        "Status"
                }) {
            Class[] types = new Class[] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        issuedBookDetailsTab.setInheritsPopupMenu(true);
        issuedBookDetailsTab.setForeground(new java.awt.Color(0, 0, 0));
        issuedBookDetailsTab.setShowVerticalLines(true);
        issuedBookDetailsTab.setShowHorizontalLines(true);
        issuedBookDetailsTab.setBorder(new javax.swing.border.EtchedBorder());
        int width = (int) (Toolkit.getDefaultToolkit().getScreenSize().width);
        int height = (int) (Toolkit.getDefaultToolkit().getScreenSize().height);
        int widthMin = (int) (width * 0.03);
        int widthMid = (int) (width * 0.04);
        int widthMidMax = (int) (width * 0.06);
        int widthStr = (int) (width * 0.12);
        int tableWidth = 0;
        jScrollPane1.setViewportView(issuedBookDetailsTab);
        if (issuedBookDetailsTab.getColumnModel().getColumnCount() > 0) {
            issuedBookDetailsTab.getColumnModel().getColumn(0).setMinWidth(widthMid);
            issuedBookDetailsTab.getColumnModel().getColumn(0).setPreferredWidth(widthMid);
            issuedBookDetailsTab.getColumnModel().getColumn(0).setMaxWidth(widthMid);
            tableWidth += widthMid;
            issuedBookDetailsTab.getColumnModel().getColumn(1).setMinWidth(widthMid);
            issuedBookDetailsTab.getColumnModel().getColumn(1).setPreferredWidth(widthMid);
            issuedBookDetailsTab.getColumnModel().getColumn(1).setMaxWidth(widthMid);
            tableWidth += widthMid;
            issuedBookDetailsTab.getColumnModel().getColumn(2).setMinWidth(widthStr);
            issuedBookDetailsTab.getColumnModel().getColumn(2).setPreferredWidth(widthStr);
            issuedBookDetailsTab.getColumnModel().getColumn(2).setMaxWidth(widthStr);
            tableWidth += widthStr;
            issuedBookDetailsTab.getColumnModel().getColumn(3).setMinWidth(widthMid);
            issuedBookDetailsTab.getColumnModel().getColumn(3).setPreferredWidth(widthMid);
            issuedBookDetailsTab.getColumnModel().getColumn(3).setMaxWidth(widthMid);
            tableWidth += widthMid;
            issuedBookDetailsTab.getColumnModel().getColumn(4).setMinWidth(widthStr);
            issuedBookDetailsTab.getColumnModel().getColumn(4).setPreferredWidth(widthStr);
            issuedBookDetailsTab.getColumnModel().getColumn(4).setMaxWidth(widthStr);
            tableWidth += widthStr;
            issuedBookDetailsTab.getColumnModel().getColumn(5).setMinWidth(widthMidMax);
            issuedBookDetailsTab.getColumnModel().getColumn(5).setPreferredWidth(widthMidMax);
            issuedBookDetailsTab.getColumnModel().getColumn(5).setMaxWidth(widthMidMax);
            tableWidth += widthMidMax;
            issuedBookDetailsTab.getColumnModel().getColumn(6).setMinWidth(widthMidMax);
            issuedBookDetailsTab.getColumnModel().getColumn(6).setPreferredWidth(widthMidMax);
            issuedBookDetailsTab.getColumnModel().getColumn(6).setMaxWidth(widthMidMax);
            tableWidth += widthMidMax;
            issuedBookDetailsTab.getColumnModel().getColumn(7).setMinWidth(widthMidMax);
            issuedBookDetailsTab.getColumnModel().getColumn(7).setPreferredWidth(widthMidMax);
            issuedBookDetailsTab.getColumnModel().getColumn(7).setMaxWidth(widthMidMax);
            tableWidth += widthMidMax;
        }
        jButton5.setBackground(new java.awt.Color(75, 156, 211));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addNewBooksIcons/icons8_Rewind_48px.png"))); // NOI18N
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jPanel3.setBackground(new java.awt.Color(75, 156, 211));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-close-30.png"))); // NOI18N
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(5, 5)
                                .addComponent(jLabel3)
                                .addGap(12, 12, 12)));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                                .addContainerGap()));
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        int widthAdjust = (int) (width - tableWidth) / 2;
        int widthAdjust2 = (int) (width * 0.38);
        int heightAdjust = (int) (height * 0.1);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(widthAdjust, widthAdjust)
                                .addComponent(jScrollPane1, tableWidth, tableWidth, tableWidth)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addContainerGap(widthAdjust, widthAdjust))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addGap(widthAdjust2, widthAdjust2, widthAdjust2)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 606,
                                        Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(heightAdjust, heightAdjust, heightAdjust)
                                                        .addComponent(jLabel2))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                        jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel1)
                                                                .addGap(11, 11, 11)))
                                        .addComponent(jButton5)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(heightAdjust, heightAdjust, heightAdjust)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(heightAdjust, heightAdjust, heightAdjust)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) { // GEN-FIRST:event_jButton5MouseClicked
        this.dispose();
        new Dashboard().setVisible(true);
    } // GEN-LAST:event_jButton5MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) { // GEN-FIRST:event_jPanel3MouseClicked
        this.dispose();
    }// GEN-LAST:event_jPanel3MouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IssuedBookDetails.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssuedBookDetails.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssuedBookDetails.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssuedBookDetails.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssuedBookDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable issuedBookDetailsTab;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
