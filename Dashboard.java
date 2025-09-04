/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class Dashboard extends javax.swing.JFrame {
        String url = "jdbc:mysql://localhost:3306/lms_db";
        String user = "root";
        String pass = "VRINDA";
        // Connection con = DriverManager.getConnection(url, username, password);
        Connection con;
        PreparedStatement pst;
        ResultSet rt;
        int id = 0;

        /**
         * Creates new form Dashboard
         */
        public void getDetails() {
                try {
                        con = DriverManager.getConnection(url, user, pass);
                        pst = con.prepareStatement("SELECT * FROM students");
                        rt = pst.executeQuery();
                        DefaultTableModel tabModel = (DefaultTableModel) (studentDetails.getModel());
                        JTableHeader header = studentDetails.getTableHeader();
                        header.setBackground(studentDetails.getForeground());
                        header.setForeground(studentDetails.getBackground());
                        tabModel.setRowCount(0);
                        int i = 0;
                        while (rt.next()) {
                                i++;
                                Vector studentRow = new Vector();
                                studentRow.add(rt.getInt("student_id"));
                                studentRow.add(rt.getString("name"));
                                studentRow.add(rt.getString("phone"));
                                studentRow.add(rt.getString("course"));
                                tabModel.addRow(studentRow);
                        }
                        studentCount.setText(String.valueOf(i));
                } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Some error occured while fetching student details.");
                }
                try {
                        con = DriverManager.getConnection(url, user, pass);
                        pst = con.prepareStatement("SELECT * FROM books");
                        rt = pst.executeQuery();
                        DefaultTableModel tabModel = (DefaultTableModel) (bookDetails.getModel());
                        tabModel.setRowCount(0);
                        int i = 0;
                        while (rt.next()) {
                                i++;
                                Vector bookRow = new Vector();
                                bookRow.add(rt.getInt("book_id"));
                                bookRow.add(rt.getString("title"));
                                bookRow.add(rt.getString("author"));
                                bookRow.add(rt.getString("isbn"));
                                tabModel.addRow(bookRow);
                        }
                        bookCount.setText(String.valueOf(i));
                } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Some error occured while fetching book details.");
                }
                try {
                        con = DriverManager.getConnection(url, user, pass);
                        pst = con.prepareStatement(
                                        "SELECT COUNT(*) AS issue_count FROM issue_books WHERE status='pending' AND issue_books.due_date > CURRENT_DATE");
                        rt = pst.executeQuery();
                        if (rt.next()) {
                                issueCount.setText(rt.getString("issue_count"));
                        }
                } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Some error occured while fetching issue count details.");
                }
                try {
                        con = DriverManager.getConnection(url, user, pass);
                        pst = con.prepareStatement(
                                        "SELECT COUNT(*) AS due_count FROM issue_books WHERE status='pending' AND issue_books.due_date < CURRENT_DATE");
                        rt = pst.executeQuery();
                        if (rt.next()) {
                                dueCount.setText(rt.getString("due_count"));
                        }
                } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                }
        }

        public Dashboard() {
                initComponents();
                // this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH); // Maximize the
                // JFrame
                setExtendedState(Dashboard.MAXIMIZED_BOTH);
                setResizable(true);
                if (LoginPage.sqlUserType.equals("librarian")) {
                        manageLib.setEnabled(false);
                }
                getDetails();
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {
                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jLabel6 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jPanel2 = new javax.swing.JPanel();
                jLabel2 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                manageBooks = new javax.swing.JButton();
                jButton3 = new javax.swing.JButton();
                jButton4 = new javax.swing.JButton();
                jButton5 = new javax.swing.JButton();
                jButton6 = new javax.swing.JButton();
                jButton7 = new javax.swing.JButton();
                manageLib = new javax.swing.JButton();
                logout = new javax.swing.JButton();
                jPanel4 = new javax.swing.JPanel();
                jPanel5 = new javax.swing.JPanel();
                bookCount = new javax.swing.JLabel();
                jLabel19 = new javax.swing.JLabel();
                jPanel6 = new javax.swing.JPanel();
                studentCount = new javax.swing.JLabel();
                jLabel21 = new javax.swing.JLabel();
                jPanel7 = new javax.swing.JPanel();
                issueCount = new javax.swing.JLabel();
                jLabel23 = new javax.swing.JLabel();
                jPanel8 = new javax.swing.JPanel();
                dueCount = new javax.swing.JLabel();
                jLabel25 = new javax.swing.JLabel();
                jLabel26 = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane();
                studentDetails = new javax.swing.JTable();
                jLabel27 = new javax.swing.JLabel();
                jScrollPane2 = new javax.swing.JScrollPane();
                bookDetails = new javax.swing.JTable();
                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setBackground(new java.awt.Color(255, 255, 255));
                setMaximumSize(getPreferredSize());
                setMinimumSize(getPreferredSize());
                setUndecorated(true);
                setResizable(false);
                jPanel1.setBackground(new java.awt.Color(75, 156, 211));
                jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 28)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(255, 255, 255));
                jLabel1.setText(" Library Management System");
                jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-close-30.png"))); // NOI18N
                jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jLabel6MouseClicked(evt);
                        }
                });
                jLabel3.setBackground(new java.awt.Color(75, 156, 211));
                jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
                jLabel3.setForeground(new java.awt.Color(255, 255, 255));
                jLabel3.setText("Home Page");
                jLabel4.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
                int width = (int) (Toolkit.getDefaultToolkit().getScreenSize().width);
                int height = (int) (Toolkit.getDefaultToolkit().getScreenSize().height);
                int label1width = 500;
                int label4width = 50;
                int label6width = 55;
                int label3width = 200;
                int gapBetweenLabel = 0;
                int headingGap = (int) (width - (label1width + label4width
                                + label3width + label6width + gapBetweenLabel));
                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel1, label1width, label1width,
                                                                                label1width)
                                                                .addGap(headingGap, headingGap, headingGap)
                                                                .addComponent(jLabel4, label4width, label4width,
                                                                                label4width)
                                                                .addComponent(jLabel3, label3width, label3width,
                                                                                label3width)
                                                                .addGap(gapBetweenLabel, gapBetweenLabel,
                                                                                gapBetweenLabel)
                                                                .addComponent(jLabel6, label6width, label6width,
                                                                                label6width)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 83,
                                                                Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel6,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(15, 15, 15)
                                                                                                .addComponent(jLabel1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                70,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addComponent(jLabel3,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                70,
                                                                                                Short.MAX_VALUE))));
                jPanel2.setBackground(new java.awt.Color(255, 255, 255));
                jPanel2.setToolTipText("");
                jLabel2.setBackground(new java.awt.Color(255, 153, 153));
                jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 28)); // NOI18N
                jLabel2.setForeground(new java.awt.Color(102, 102, 102));
                jLabel2.setText("Welcome ");
                jLabel5.setBackground(new java.awt.Color(255, 153, 153));
                jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                jLabel5.setForeground(new java.awt.Color(102, 102, 102));
                jLabel5.setText("Menu");
                manageBooks.setBackground(new java.awt.Color(255, 204, 204));
                manageBooks.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                manageBooks.setForeground(new java.awt.Color(102, 102, 102));
                manageBooks.setIcon(
                                new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Books_26px.png"))); // NOI18N
                manageBooks.setText("Manage Books");
                manageBooks.setBorder(null);
                manageBooks.setBorderPainted(false);
                manageBooks.setContentAreaFilled(false);
                manageBooks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                manageBooks.setFocusPainted(false);
                manageBooks.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                manageBooks.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                manageBooksMouseClicked(evt);
                        }
                });
                manageBooks.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                manageBooksActionPerformed(evt);
                        }
                });
                jButton3.setBackground(new java.awt.Color(51, 51, 51));
                jButton3.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                jButton3.setForeground(new java.awt.Color(102, 102, 102));
                jButton3.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
                jButton3.setText("Manage Students");
                jButton3.setBorder(null);
                jButton3.setBorderPainted(false);
                jButton3.setContentAreaFilled(false);
                jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jButton3MouseClicked(evt);
                        }
                });
                jButton3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton3ActionPerformed(evt);
                        }
                });
                jButton4.setBackground(new java.awt.Color(51, 51, 51));
                jButton4.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                jButton4.setForeground(new java.awt.Color(102, 102, 102));
                jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Sell_26px.png"))); // NOI18N
                jButton4.setText("Issue Books");
                jButton4.setBorder(null);
                jButton4.setBorderPainted(false);
                jButton4.setContentAreaFilled(false);
                jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jButton4MouseClicked(evt);
                        }
                });
                jButton4.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton4ActionPerformed(evt);
                        }
                });
                jButton5.setBackground(new java.awt.Color(51, 51, 51));
                jButton5.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                jButton5.setForeground(new java.awt.Color(102, 102, 102));
                jButton5.setIcon(
                                new javax.swing.ImageIcon(
                                                getClass().getResource("/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
                jButton5.setText("Return Books");
                jButton5.setBorder(null);
                jButton5.setBorderPainted(false);
                jButton5.setContentAreaFilled(false);
                jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jButton5MouseClicked(evt);
                        }
                });
                jButton5.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton5ActionPerformed(evt);
                        }
                });
                jButton6.setBackground(new java.awt.Color(102, 102, 102));
                jButton6.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                jButton6.setForeground(new java.awt.Color(102, 102, 102));
                jButton6.setIcon(
                                new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Books_26px.png"))); // NOI18N
                jButton6.setText("View Issued Books");
                jButton6.setBorder(null);
                jButton6.setBorderPainted(false);
                jButton6.setContentAreaFilled(false);
                jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jButton6MouseClicked(evt);
                        }
                });
                jButton6.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton6ActionPerformed(evt);
                        }
                });
                jButton7.setBackground(new java.awt.Color(51, 51, 51));
                jButton7.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                jButton7.setForeground(new java.awt.Color(102, 102, 102));
                jButton7.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/adminIcons/icons8_Conference_26px.png"))); // NOI18N
                jButton7.setText("View Due List");
                jButton7.setBorder(null);
                jButton7.setBorderPainted(false);
                jButton7.setContentAreaFilled(false);
                jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jButton7MouseClicked(evt);
                        }
                });
                jButton7.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton7ActionPerformed(evt);
                        }
                });
                manageLib.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                manageLib.setForeground(new java.awt.Color(102, 102, 102));
                manageLib.setText(" MANAGE LIBRARIAN");
                manageLib.setBorder(null);
                manageLib.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                manageLib.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                manageLib.setMaximumSize(new java.awt.Dimension(200, 25));
                manageLib.setMinimumSize(new java.awt.Dimension(200, 25));
                manageLib.setPreferredSize(new java.awt.Dimension(200, 25));
                manageLib.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                manageLibActionPerformed(evt);
                        }
                });
                logout.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                logout.setForeground(new java.awt.Color(102, 102, 102));
                logout.setText(" LOGOUT");
                logout.setBorder(null);
                logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                logout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                logout.setMaximumSize(new java.awt.Dimension(200, 25));
                logout.setMinimumSize(new java.awt.Dimension(200, 25));
                logout.setPreferredSize(new java.awt.Dimension(200, 25));
                logout.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                logoutActionPerformed(evt);
                        }
                });
                jPanel4.setBackground(new java.awt.Color(255, 255, 255));
                jPanel4.setMaximumSize(new java.awt.Dimension(750, 800));
                jPanel5.setBackground(new java.awt.Color(75, 156, 211));
                bookCount.setFont(new java.awt.Font("Liberation Sans", 1, 48)); // NOI18N
                bookCount.setForeground(new java.awt.Color(102, 102, 102));
                bookCount.setText("0");
                jLabel19.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
                javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
                jPanel5.setLayout(jPanel5Layout);
                jPanel5Layout.setHorizontalGroup(
                                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout
                                                                .createSequentialGroup()
                                                                .addGap(66, 66, 66)
                                                                .addComponent(jLabel19)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(bookCount)
                                                                .addGap(66, 66, 66)));
                jPanel5Layout.setVerticalGroup(
                                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addGap(48, 48, 48)
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabel19)
                                                                                .addComponent(bookCount))
                                                                .addContainerGap(51, Short.MAX_VALUE)));
                jPanel6.setBackground(new java.awt.Color(75, 156, 211));
                jPanel6.setPreferredSize(new java.awt.Dimension(203, 155));
                studentCount.setFont(new java.awt.Font("Liberation Sans", 1, 48)); // NOI18N
                studentCount.setForeground(new java.awt.Color(102, 102, 102));
                studentCount.setText("0");
                jLabel21.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/adminIcons/icons8_People_50px.png"))); // NOI18N
                javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
                jPanel6.setLayout(jPanel6Layout);
                jPanel6Layout.setHorizontalGroup(
                                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout
                                                                .createSequentialGroup()
                                                                .addGap(66, 66, 66)
                                                                .addComponent(jLabel21)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(studentCount)
                                                                .addGap(66, 66, 66)));
                jPanel6Layout.setVerticalGroup(
                                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout
                                                                .createSequentialGroup()
                                                                .addGap(48, 48, 48)
                                                                .addGroup(jPanel6Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabel21)
                                                                                .addComponent(studentCount))
                                                                .addContainerGap(51, Short.MAX_VALUE)));
                jPanel7.setBackground(new java.awt.Color(75, 156, 211));
                issueCount.setFont(new java.awt.Font("Liberation Sans", 1, 48)); // NOI18N
                issueCount.setForeground(new java.awt.Color(102, 102, 102));
                issueCount.setText("0");
                jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Sell_50px.png"))); // NOI18N
                javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
                jPanel7.setLayout(jPanel7Layout);
                jPanel7Layout.setHorizontalGroup(
                                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout
                                                                .createSequentialGroup()
                                                                .addGap(66, 66, 66)
                                                                .addComponent(jLabel23)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(issueCount)
                                                                .addGap(66, 66, 66)));
                jPanel7Layout.setVerticalGroup(
                                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel7Layout.createSequentialGroup()
                                                                .addGap(48, 48, 48)
                                                                .addGroup(jPanel7Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabel23)
                                                                                .addComponent(issueCount))
                                                                .addContainerGap(51, Short.MAX_VALUE)));
                jPanel8.setBackground(new java.awt.Color(75, 156, 211));
                dueCount.setFont(new java.awt.Font("Liberation Sans", 1, 48)); // NOI18N
                dueCount.setForeground(new java.awt.Color(102, 102, 102));
                dueCount.setText("0");
                dueCount.setMaximumSize(new java.awt.Dimension(54, 58));
                dueCount.setMinimumSize(new java.awt.Dimension(54, 58));
                jLabel25.setIcon(
                                new javax.swing.ImageIcon(getClass()
                                                .getResource("/adminIcons/icons8_List_of_Thumbnails_50px.png"))); // NOI18N
                javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
                jPanel8.setLayout(jPanel8Layout);
                jPanel8Layout.setHorizontalGroup(
                                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout
                                                                .createSequentialGroup()
                                                                .addGap(66, 66, 66)
                                                                .addComponent(jLabel25)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(dueCount,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(66, 66, 66)));
                jPanel8Layout.setVerticalGroup(
                                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel8Layout.createSequentialGroup()
                                                                .addGap(54, 54, 54)
                                                                .addComponent(jLabel25)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(dueCount,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                47,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                jLabel26.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                jLabel26.setForeground(new java.awt.Color(102, 102, 102));
                jLabel26.setText("Student Details");
                studentDetails.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                },
                                new String[] {
                                                "ID", "Name", "Phone", "Course"
                                }) {
                        Class[] types = new Class[] {
                                        java.lang.String.class, java.lang.String.class, java.lang.String.class,
                                        java.lang.String.class
                        };
                        boolean[] canEdit = new boolean[] {
                                        false, false, false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types[columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                studentDetails.setToolTipText("");
                studentDetails.setRowSelectionAllowed(false);
                studentDetails.setSelectionBackground(new java.awt.Color(0, 0, 255));
                studentDetails.setShowVerticalLines(true);
                studentDetails.setShowHorizontalLines(true);
                studentDetails.setBorder(new javax.swing.border.EtchedBorder());
                jScrollPane1.setViewportView(studentDetails);
                if (studentDetails.getColumnModel().getColumnCount() > 0) {
                        studentDetails.getColumnModel().getColumn(0).setMinWidth(40);
                        studentDetails.getColumnModel().getColumn(0).setPreferredWidth(40);
                        studentDetails.getColumnModel().getColumn(0).setMaxWidth(40);
                }
                jLabel27.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                jLabel27.setForeground(new java.awt.Color(102, 102, 102));
                jLabel27.setText("Book Details");
                bookDetails.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                },
                                new String[] {
                                                "ID", "Title", "Author", "ISBN"
                                }) {
                        Class[] types = new Class[] {
                                        java.lang.String.class, java.lang.String.class, java.lang.String.class,
                                        java.lang.String.class
                        };
                        boolean[] canEdit = new boolean[] {
                                        false, false, false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types[columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                bookDetails.setRowSelectionAllowed(false);
                bookDetails.setShowVerticalLines(true);
                bookDetails.setShowHorizontalLines(true);
                jScrollPane2.setViewportView(bookDetails);
                if (bookDetails.getColumnModel().getColumnCount() > 0) {
                        bookDetails.getColumnModel().getColumn(0).setMinWidth(40);
                        bookDetails.getColumnModel().getColumn(0).setPreferredWidth(40);
                        bookDetails.getColumnModel().getColumn(0).setMaxWidth(40);
                }
                int topGap = (int) (height * 0.05);
                float partition1 = 0.2f;
                float partition2 = 1 - partition1;
                float partitionGap = 0.1f;
                int scrollPanesWidth = (int) ((width * (partition2 - partitionGap)) / 2);
                int boxGap = (int) (width * partitionGap);
                int boxGap2 = (int) (boxGap + (partitionGap * width / 4));
                int panel4width = (int) (width * partition2);
                javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
                jPanel4.setLayout(jPanel4Layout);
                jPanel4Layout.setHorizontalGroup(
                                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addGroup(jPanel4Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addGroup(jPanel4Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jScrollPane1,
                                                                                                                scrollPanesWidth,
                                                                                                                scrollPanesWidth,
                                                                                                                scrollPanesWidth)
                                                                                                .addGap(boxGap - 25,
                                                                                                                boxGap - 25,
                                                                                                                boxGap - 25)
                                                                                                .addComponent(jScrollPane2,
                                                                                                                scrollPanesWidth,
                                                                                                                scrollPanesWidth,
                                                                                                                scrollPanesWidth))
                                                                                .addGroup(jPanel4Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel4Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(jPanel4Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(jLabel26)
                                                                                                                                .addGap(271, 271,
                                                                                                                                                271))
                                                                                                                .addGroup(jPanel4Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(jPanel5,
                                                                                                                                                boxGap,
                                                                                                                                                boxGap,
                                                                                                                                                boxGap)
                                                                                                                                .addGap(boxGap2,
                                                                                                                                                boxGap2,
                                                                                                                                                boxGap2)
                                                                                                                                .addComponent(jPanel6,
                                                                                                                                                boxGap,
                                                                                                                                                boxGap,
                                                                                                                                                boxGap)))
                                                                                                .addGroup(jPanel4Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(jPanel4Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGap(boxGap2,
                                                                                                                                                boxGap2,
                                                                                                                                                boxGap2)
                                                                                                                                .addComponent(jPanel7,
                                                                                                                                                boxGap,
                                                                                                                                                boxGap,
                                                                                                                                                boxGap)
                                                                                                                                .addGap(boxGap2,
                                                                                                                                                boxGap2,
                                                                                                                                                boxGap2)
                                                                                                                                .addComponent(jPanel8,
                                                                                                                                                boxGap,
                                                                                                                                                boxGap,
                                                                                                                                                boxGap))
                                                                                                                .addGroup(jPanel4Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGap(220, 220,
                                                                                                                                                220)
                                                                                                                                .addComponent(jLabel27)))))));
                int scrollPaneHeight = (int) (height * 0.4);
                jPanel4Layout.setVerticalGroup(
                                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addGap(topGap, topGap, topGap)
                                                                .addGroup(jPanel4Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(jPanel4Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                false)
                                                                                                .addComponent(jPanel8,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jPanel7,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jPanel6,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                161,
                                                                                                                Short.MAX_VALUE))
                                                                                .addComponent(jPanel5,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jPanel4Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGap(topGap, topGap, topGap)
                                                                                .addGroup(jPanel4Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(45, 45, 45)
                                                                                                .addComponent(jLabel26))
                                                                                .addGroup(jPanel4Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(45, 45, 45)
                                                                                                .addComponent(jLabel27)))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel4Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addComponent(jScrollPane1,
                                                                                                scrollPaneHeight,
                                                                                                scrollPaneHeight,
                                                                                                scrollPaneHeight)
                                                                                .addComponent(jScrollPane2,
                                                                                                scrollPaneHeight,
                                                                                                scrollPaneHeight,
                                                                                                scrollPaneHeight))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap(10, 10)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel2Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel2Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jButton4,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(jButton5,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(jButton7,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(manageBooks,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(jButton3,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(manageLib,
                                                                                                                                250,
                                                                                                                                250,
                                                                                                                                250)
                                                                                                                .addComponent(logout,
                                                                                                                                250,
                                                                                                                                250,
                                                                                                                                250)))
                                                                                .addGroup(jPanel2Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel2Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel2,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jLabel5,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                118,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jButton6))))
                                                                .addComponent(jPanel4, panel4width, panel4width,
                                                                                panel4width)));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jPanel4,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addGroup(jPanel2Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(topGap, topGap,
                                                                                                                topGap)
                                                                                                .addComponent(jLabel2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(55, 55, 55)
                                                                                                .addComponent(jLabel5,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                37,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(10, 10, 10)
                                                                                                .addComponent(manageBooks,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                52,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(10, 10, 10)
                                                                                                .addComponent(jButton3,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                52,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(10, 10, 10)
                                                                                                .addComponent(jButton4,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                52,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(10, 10, 10)
                                                                                                .addComponent(jButton5,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                52,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(10, 10, 10)
                                                                                                .addComponent(jButton6,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                52,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(10, 10, 10)
                                                                                                .addComponent(jButton7,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                52,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(10, 10, 10)
                                                                                                .addComponent(manageLib,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                42,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(20, 20, 20)
                                                                                                .addComponent(logout,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                39,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap()));
                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanel1,
                                                                                width, width, width))
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanel2,
                                                                                width, width, width)));
                int panel1height = (int) (height * 0.1);
                int panel2height = height - panel1height;
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanel1,
                                                                                panel1height, panel1height,
                                                                                panel1height)
                                                                .addComponent(jPanel2,
                                                                                panel2height, panel2height,
                                                                                panel2height)));
                pack();
                setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

        private void logoutActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logoutActionPerformed
                this.dispose();
                new LoginPage().setVisible(true);
        }// GEN-LAST:event_logoutActionPerformed

        private void manageBooksActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_manageBooksActionPerformed
        }// GEN-LAST:event_manageBooksActionPerformed

        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
        }// GEN-LAST:event_jButton3ActionPerformed

        private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
        }// GEN-LAST:event_jButton4ActionPerformed

        private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton5ActionPerformed
        }// GEN-LAST:event_jButton5ActionPerformed

        private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton6ActionPerformed
        }// GEN-LAST:event_jButton6ActionPerformed

        private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton7ActionPerformed
        }// GEN-LAST:event_jButton7ActionPerformed

        private void manageBooksMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_manageBooksMouseClicked
                this.dispose();
                new ManageBooks().setVisible(true);
        }// GEN-LAST:event_manageBooksMouseClicked

        private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jButton3MouseClicked
                this.dispose();
                new ManageStudents().setVisible(true);
        }// GEN-LAST:event_jButton3MouseClicked

        private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jButton4MouseClicked
                this.dispose();
                new IssueBook().setVisible(true);
        }// GEN-LAST:event_jButton4MouseClicked

        private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jButton5MouseClicked
                this.dispose();
                new ReturnBook().setVisible(true);
        }// GEN-LAST:event_jButton5MouseClicked

        private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jButton6MouseClicked
                this.dispose();
                new IssuedBookDetails().setVisible(true);
        }// GEN-LAST:event_jButton6MouseClicked

        private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jButton7MouseClicked
                this.dispose();
                new DueList().setVisible(true);
        }// GEN-LAST:event_jButton7MouseClicked

        private void manageLibActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_manageLibActionPerformed
                this.dispose();
                new ManageLibrarian().setVisible(true);
        }// GEN-LAST:event_manageLibActionPerformed

        private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel6MouseClicked
                this.dispose();
        }// GEN-LAST:event_jLabel6MouseClicked

        /**
         * @param args the command line arguments
         */
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
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(Dashboard.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(Dashboard.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(Dashboard.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(Dashboard.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                }
                // </editor-fold>
                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new Dashboard().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel bookCount;
        private javax.swing.JTable bookDetails;
        private javax.swing.JLabel dueCount;
        private javax.swing.JLabel issueCount;
        private javax.swing.JButton jButton3;
        private javax.swing.JButton jButton4;
        private javax.swing.JButton jButton5;
        private javax.swing.JButton jButton6;
        private javax.swing.JButton jButton7;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel19;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel21;
        private javax.swing.JLabel jLabel23;
        private javax.swing.JLabel jLabel25;
        private javax.swing.JLabel jLabel26;
        private javax.swing.JLabel jLabel27;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel4;
        private javax.swing.JPanel jPanel5;
        private javax.swing.JPanel jPanel6;
        private javax.swing.JPanel jPanel7;
        private javax.swing.JPanel jPanel8;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JButton logout;
        private javax.swing.JButton manageBooks;
        private javax.swing.JButton manageLib;
        private javax.swing.JLabel studentCount;
        private javax.swing.JTable studentDetails;
        // End of variables declaration//GEN-END:variables
}
