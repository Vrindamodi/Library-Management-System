
package jframe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class IssueBook extends javax.swing.JFrame {
        String url = "jdbc:mysql://localhost:3306/lms_db";
        String user = "root";
        String pass = "VRINDA";
        Connection con;
        PreparedStatement pst;
        ResultSet rt;
        int book_id_var, student_id_var = 0;

        public void clearData() {
                book_id.setText("");
                student_id.setText("");
                issue_date.setDate(null);
                due_date.setDate(null);
                bookId.setText("");
                studentId.setText("");
                bookTitle.setText("");
                bookAuthor.setText("");
                bookLanguage.setText("");
                bookISBN.setText("");
                bookPublisher.setText("          ");
                studentName.setText("");
                studentCourse.setText("");
                studentPhone.setText("");
                studentAddress.setText("");
                book_id_var = 0;
                student_id_var = 0;
        }

        public IssueBook() {
                initComponents(); // Initializes UI components
                setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizes the window to full screen
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensures proper closing behavior
                setLocationRelativeTo(null); // Centers the window
                setLayout(new BorderLayout()); // Ensures dynamic resizing
                getContentPane().add(jPanel1, BorderLayout.CENTER); // Ensures jPanel1 takes full screen
                setResizable(false); // Prevents unwanted resizing issues
                setVisible(true); // Ensure the frame is displayed properly
                issue_date.addPropertyChangeListener("date", evt -> {
                        if (issue_date.getDate() != null) {
                                Calendar calendar = Calendar.getInstance();
                                calendar.setTime(issue_date.getDate());
                                calendar.add(Calendar.DAY_OF_MONTH, 7);
                                due_date.setDate(calendar.getTime());
                        }
                });
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {
                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                jLabel6 = new javax.swing.JLabel();
                jLabel7 = new javax.swing.JLabel();
                jLabel8 = new javax.swing.JLabel();
                jButton5 = new javax.swing.JButton();
                bookId = new javax.swing.JLabel();
                bookTitle = new javax.swing.JLabel();
                bookAuthor = new javax.swing.JLabel();
                bookISBN = new javax.swing.JLabel();
                bookLanguage = new javax.swing.JLabel();
                bookPublisher = new javax.swing.JLabel();
                jPanel3 = new javax.swing.JPanel();
                jLabel9 = new javax.swing.JLabel();
                jLabel10 = new javax.swing.JLabel();
                jLabel11 = new javax.swing.JLabel();
                jLabel12 = new javax.swing.JLabel();
                jLabel13 = new javax.swing.JLabel();
                jLabel14 = new javax.swing.JLabel();
                jLabel15 = new javax.swing.JLabel();
                studentId = new javax.swing.JLabel();
                studentName = new javax.swing.JLabel();
                studentPhone = new javax.swing.JLabel();
                studentCourse = new javax.swing.JLabel();
                studentAddress = new javax.swing.JLabel();
                jPanel5 = new javax.swing.JPanel();
                jLabel16 = new javax.swing.JLabel();
                jLabel17 = new javax.swing.JLabel();
                jLabel18 = new javax.swing.JLabel();
                book_id = new javax.swing.JTextField();
                jLabel19 = new javax.swing.JLabel();
                jLabel20 = new javax.swing.JLabel();
                jLabel21 = new javax.swing.JLabel();
                student_id = new javax.swing.JTextField();
                issue_date = new com.toedter.calendar.JDateChooser();
                due_date = new com.toedter.calendar.JDateChooser();
                clearFields = new javax.swing.JButton();
                issueBook = new javax.swing.JButton();
                jPanel10 = new javax.swing.JPanel();
                jLabel25 = new javax.swing.JLabel();
                findData = new javax.swing.JButton();
                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setUndecorated(true);
                jPanel1.setLayout(new GridBagLayout());
                jPanel1.setBackground(new java.awt.Color(75, 156, 211));
                jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 28));
                jLabel1.setForeground(new java.awt.Color(255, 255, 255));
                jLabel1.setText("Book Details");
                jLabel2.setIcon(
                                new javax.swing.ImageIcon(getClass()
                                                .getResource("/addNewBooksIcons/icons8_Literature_100px_1.png")));
                jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                jPanel3.setMinimumSize(new Dimension(100, 100)); // Optional minimum sizes
                jLabel3.setForeground(new java.awt.Color(255, 255, 255));
                jLabel3.setText("Book ID      :");
                jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                jLabel4.setForeground(new java.awt.Color(255, 255, 255));
                jLabel4.setText("Book Title :");
                jPanel5.setMinimumSize(new Dimension(100, 100));
                jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                jLabel5.setForeground(new java.awt.Color(255, 255, 255));
                jLabel5.setText("Author       :");
                jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                jLabel6.setForeground(new java.awt.Color(255, 255, 255));
                jLabel6.setText("ISBN           :");
                jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                jLabel7.setForeground(new java.awt.Color(255, 255, 255));
                jLabel7.setText("Language  :");
                jLabel8.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                jLabel8.setForeground(new java.awt.Color(255, 255, 255));
                jLabel8.setText("Publisher  :");
                jButton5.setBackground(new java.awt.Color(75, 156, 211));
                jButton5.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/addNewBooksIcons/icons8_Rewind_48px.png")));
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
                bookId.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                bookId.setForeground(new java.awt.Color(255, 255, 255));
                bookTitle.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                bookTitle.setForeground(new java.awt.Color(255, 255, 255));
                bookAuthor.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                bookAuthor.setForeground(new java.awt.Color(255, 255, 255));
                bookISBN.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                bookISBN.setForeground(new java.awt.Color(255, 255, 255));
                bookLanguage.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                bookLanguage.setForeground(new java.awt.Color(255, 255, 255));
                bookPublisher.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                bookPublisher.setForeground(new java.awt.Color(255, 255, 255));
                jPanel3.setBackground(new java.awt.Color(75, 156, 211));
                jLabel9.setFont(new java.awt.Font("Liberation Sans", 1, 28));
                jLabel9.setForeground(new java.awt.Color(255, 255, 255));
                jLabel9.setText("Student Details");
                jLabel10.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/addNewBooksIcons/icons8_Student_Registration_100px_2.png")));
                jLabel11.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                jLabel11.setForeground(new java.awt.Color(255, 255, 255));
                jLabel11.setText("Student ID          :");
                jLabel12.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                jLabel12.setForeground(new java.awt.Color(255, 255, 255));
                jLabel12.setText("Student Name   :");
                jLabel13.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                jLabel13.setForeground(new java.awt.Color(255, 255, 255));
                jLabel13.setText("Student Phone :");
                jLabel14.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                jLabel14.setForeground(new java.awt.Color(255, 255, 255));
                jLabel14.setText("Course               :");
                jLabel15.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                jLabel15.setForeground(new java.awt.Color(255, 255, 255));
                jLabel15.setText("Address             :");
                studentId.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                studentId.setForeground(new java.awt.Color(255, 255, 255));
                studentName.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                studentName.setForeground(new java.awt.Color(255, 255, 255));
                studentPhone.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                studentPhone.setForeground(new java.awt.Color(255, 255, 255));
                studentCourse.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                studentCourse.setForeground(new java.awt.Color(255, 255, 255));
                studentAddress.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                studentAddress.setForeground(new java.awt.Color(255, 255, 255));
                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                int width = (int) (Toolkit.getDefaultToolkit().getScreenSize().width);
                int height = (int) (Toolkit.getDefaultToolkit().getScreenSize().height);
                int constantGap = (int) (width * 0.1);
                int panel1width = (int) (width * 0.33);
                int panel2width = (int) (width * 0.33);
                int panel3width = (int) (width - (panel1width + panel2width));
                int topGap = (int) (height * 0.1);
                jPanel3Layout.setHorizontalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel3Layout
                                                                                                .createSequentialGroup()
                                                                                                .addContainerGap(
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGroup(jPanel3Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(jPanel3Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(jLabel10)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addComponent(jLabel9))
                                                                                                                .addGroup(jPanel3Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                // .addComponent(jLabel11)
                                                                                                                                // .addGap(47,
                                                                                                                                // 47,
                                                                                                                                // 47)
                                                                                                                                .addGroup(jPanel3Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                false)
                                                                                                                                                .addComponent(jLabel11,
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(jLabel12,
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(jLabel13,
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(jLabel14,
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(jLabel15,
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING))
                                                                                                                                .addGap(10, 10, 10)
                                                                                                                                .addGroup(jPanel3Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                false)
                                                                                                                                                .addComponent(studentId,
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(studentName,
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(studentPhone,
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(studentCourse,
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(studentAddress,
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING))
                                                                                                                                .addContainerGap(
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE)))))));
                jPanel3Layout.setVerticalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGap(topGap, topGap, topGap)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel3Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                .addComponent(jLabel10)
                                                                                                .addComponent(jLabel9)))
                                                                .addGap(70, 70, 70)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel11)
                                                                                .addComponent(studentId))
                                                                .addGap(30, 30, 30)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel12)
                                                                                .addComponent(studentName))
                                                                .addGap(30, 30, 30)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel13)
                                                                                .addComponent(studentPhone))
                                                                .addGap(30, 30, 30)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel14)
                                                                                .addComponent(studentCourse))
                                                                .addGap(30, 30, 30)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel15)
                                                                                .addComponent(studentAddress))
                                                                .addContainerGap(221, Short.MAX_VALUE)));
                jPanel5.setBackground(new java.awt.Color(255, 255, 255));
                jPanel5.setFont(new java.awt.Font("Liberation Sans", 1, 15));
                jLabel16.setFont(new java.awt.Font("Liberation Sans", 1, 30));
                jLabel16.setForeground(new java.awt.Color(75, 156, 211));
                jLabel16.setText("Issue Book");
                jLabel17.setIcon(
                                new javax.swing.ImageIcon(
                                                getClass().getResource("/icons/books.png")));
                jLabel18.setBackground(new java.awt.Color(75, 156, 211));
                jLabel18.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                jLabel18.setForeground(new java.awt.Color(75, 156, 211));
                jLabel18.setText("Book ID      :");
                jLabel19.setBackground(new java.awt.Color(204, 0, 51));
                jLabel19.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                jLabel19.setForeground(new java.awt.Color(75, 156, 211));
                jLabel19.setText("Student ID :");
                jLabel20.setBackground(new java.awt.Color(204, 0, 51));
                jLabel20.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                jLabel20.setForeground(new java.awt.Color(75, 156, 211));
                jLabel20.setText("Issue Date :");
                jLabel21.setBackground(new java.awt.Color(204, 0, 51));
                jLabel21.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                jLabel21.setForeground(new java.awt.Color(75, 156, 211));
                jLabel21.setText("Due Date   :");
                clearFields.setBackground(new java.awt.Color(75, 156, 211));
                clearFields.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                clearFields.setForeground(new java.awt.Color(242, 242, 242));
                clearFields.setText("CLEAR DATA");
                clearFields.addMouseListener(new java.awt.event.MouseAdapter() { // GEN-FIRST:event_addMouseListener
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                clearFieldsMouseClicked(evt);
                        }
                }); // GEN-LAST:event_addMouseListener
                clearFields.addActionListener(new java.awt.event.ActionListener() { // GEN-FIRST:event_addActionListener
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                clearFieldsActionPerformed(evt);
                        }
                });// GEN-LAST:event_addActionListener
                issueBook.setBackground(new java.awt.Color(75, 156, 211));
                issueBook.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                issueBook.setForeground(new java.awt.Color(242, 242, 242));
                issueBook.setText("ISSUE BOOK");
                issueBook.addActionListener(new java.awt.event.ActionListener() { // GEN-FIRST:event_addActionListener
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                issueBookActionPerformed(evt);
                        }
                });// GEN-LAST:event_addActionListener
                jPanel10.setBackground(new java.awt.Color(75, 156, 211));
                jPanel10.addMouseListener(new java.awt.event.MouseAdapter() { // GEN-FIRST:event_addMouseListener
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jPanel10MouseClicked(evt);
                        }
                }); // GEN-LAST:event_addMouseListener
                jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-close-30.png")));
                javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
                jPanel10.setLayout(jPanel10Layout);
                jPanel10Layout.setHorizontalGroup(
                                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                jPanel10Layout.createSequentialGroup()
                                                                                .addContainerGap(14, Short.MAX_VALUE)
                                                                                .addComponent(jLabel25)
                                                                                .addGap(12, 12, 12)));
                jPanel10Layout.setVerticalGroup(
                                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel10Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel25,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                42, Short.MAX_VALUE)
                                                                .addContainerGap()));
                findData.setBackground(new java.awt.Color(75, 156, 211));
                findData.setFont(new java.awt.Font("Liberation Sans", 1, 18));
                findData.setForeground(new java.awt.Color(242, 242, 242));
                findData.setText("FIND DATA");
                findData.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                findDataMouseClicked(evt);
                        }
                });
                findData.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                findDataActionPerformed(evt);
                        }
                });
                javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
                jPanel5.setLayout(jPanel5Layout);
                jPanel5Layout.setHorizontalGroup(
                                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout
                                                                .createSequentialGroup()
                                                                .addGap(0, 421, Short.MAX_VALUE)
                                                                .addComponent(jPanel10,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel5Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(jPanel5Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGap(108, 108,
                                                                                                                                108)
                                                                                                                .addComponent(jLabel17)
                                                                                                                // .addPreferredGap(
                                                                                                                // javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jLabel16))
                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                jPanel5Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGap(96, 96, 96)
                                                                                                                                .addGroup(jPanel5Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                                .addGroup(jPanel5Layout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                                                .addComponent(jLabel20)
                                                                                                                                                                .addComponent(jLabel21,
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                                .addComponent(jLabel19))
                                                                                                                                                .addComponent(jLabel18))
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                                .addGroup(jPanel5Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                false)
                                                                                                                                                .addComponent(book_id)
                                                                                                                                                .addComponent(student_id)
                                                                                                                                                .addComponent(issue_date,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                169,
                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                .addComponent(due_date,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE))))
                                                                                .addGroup(jPanel5Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(82, 82, 82)
                                                                                                .addGroup(jPanel5Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(findData,
                                                                                                                                520,
                                                                                                                                520,
                                                                                                                                520)
                                                                                                                .addGroup(jPanel5Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(issueBook,
                                                                                                                                                250,
                                                                                                                                                250,
                                                                                                                                                250)
                                                                                                                                .addGap(20,
                                                                                                                                                20,
                                                                                                                                                20)
                                                                                                                                .addComponent(clearFields,
                                                                                                                                                250,
                                                                                                                                                250,
                                                                                                                                                250)))))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                jPanel5Layout.setVerticalGroup(
                                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel10,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addGap(topGap, topGap, topGap)
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabel16)
                                                                                .addComponent(jLabel17))
                                                                .addGap(70, 70, 70)
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel18)
                                                                                .addComponent(book_id,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                36,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(30, 30, 30)
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel19)
                                                                                .addComponent(student_id,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                38,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(30, 30, 30)
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(issue_date,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                38,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(jPanel5Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(8, 8, 8)
                                                                                                .addComponent(jLabel20)))
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel5Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(56, 56, 56)
                                                                                                .addComponent(due_date,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                38,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanel5Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(64, 64, 64)
                                                                                                .addComponent(jLabel21)))
                                                                .addGap(30, 30, 30)
                                                                .addComponent(findData,
                                                                                40, 40, 40)
                                                                .addGap(20, 20, 20)
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(clearFields,
                                                                                                40, 40, 40)
                                                                                .addComponent(issueBook,
                                                                                                40, 40, 40))
                                                                .addGap(20, 20, 20)));
                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(constantGap, constantGap, constantGap)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel2)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jLabel1))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addComponent(jLabel3,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel4,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel5,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel6,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel7,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel8,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING))
                                                                                                .addGap(10, 10, 10)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(bookId,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(bookTitle,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(bookAuthor,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(bookISBN,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(bookLanguage,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(bookPublisher,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING))))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                53, Short.MAX_VALUE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                .addComponent(jButton5));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jButton5)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(topGap, topGap, topGap)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                .addComponent(jLabel1)
                                                                                                                                .addComponent(jLabel2)))))
                                                                .addGap(70, 70, 70)
                                                                .addGroup(jPanel1Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel3)
                                                                                .addComponent(bookId))
                                                                .addGap(30, 30, 30)
                                                                .addGroup(jPanel1Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel4)
                                                                                .addComponent(bookTitle))
                                                                .addGap(30, 30, 30)
                                                                .addGroup(jPanel1Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel5)
                                                                                .addComponent(bookAuthor))
                                                                .addGap(30, 30, 30)
                                                                .addGroup(jPanel1Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel6)
                                                                                .addComponent(bookISBN))
                                                                .addGap(30, 30, 30)
                                                                .addGroup(jPanel1Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel7)
                                                                                .addComponent(bookLanguage))
                                                                .addGap(30, 30, 30)
                                                                .addGroup(jPanel1Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel8)
                                                                                .addComponent(bookPublisher))
                                                                .addGap(0, 175, Short.MAX_VALUE)));
                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanel1, panel1width, panel1width,
                                                                                panel1width)
                                                                .addComponent(jPanel3, panel2width, panel2width,
                                                                                panel2width)
                                                                .addComponent(jPanel5, panel3width, panel3width,
                                                                                panel3width)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, height, height, height)
                                                .addComponent(jPanel3, height, height, height)
                                                .addComponent(jPanel5, height, height, height));
                pack();
                setLocationRelativeTo(null);
        } // </editor-fold>//GEN-END:initComponents

        private void clearFieldsActionPerformed(java.awt.event.ActionEvent evt) { // GEN-FIRST:event_clearFieldsActionPerformed
        } // GEN-LAST:event_clearFieldsActionPerformed

        private void issueBookActionPerformed(java.awt.event.ActionEvent evt) { // GEN-FIRST:event_issueBookActionPerformed
                if (book_id_var == 0 || student_id_var == 0) {
                        JOptionPane.showMessageDialog(null, "Choose book and student before issuing book to student.");
                } else {
                        try {
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                String issueDate = sdf.format(issue_date.getDate());
                                String dueDate = sdf.format(due_date.getDate());
                                con = DriverManager.getConnection(url, user, pass);
                                pst = con.prepareStatement(
                                                "INSERT INTO issue_books (book_id, student_id, issue_date, due_date) VALUES (?,?,?,?)");
                                pst.setString(1, book_id.getText());
                                pst.setString(2, student_id.getText());
                                pst.setString(3, issueDate);
                                pst.setString(4, dueDate);
                                pst.executeUpdate();
                                pst.close();
                                pst = con.prepareStatement(
                                                "UPDATE books SET isbn = isbn - 1 WHERE book_id = ?");
                                pst.setString(1, book_id.getText());
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Book has been successfully issued.");
                                clearData();
                        } catch (SQLException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                }
        } // GEN-LAST:event_issueBookActionPerformed

        private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) { // GEN-FIRST:event_jButton5ActionPerformed
        }// GEN-LAST:event_jButton5ActionPerformed

        private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) { // GEN-FIRST:event_jPanel10MouseClicked
                this.dispose();
        }// GEN-LAST:event_jPanel10MouseClicked

        private void jButton5MouseClicked(java.awt.event.MouseEvent evt) { // GEN-FIRST:event_jPanel5MouseClicked
                this.dispose();
                new Dashboard().setVisible(true);
        } // GEN-LAST:event_jPanel5MouseClicked

        private void clearFieldsMouseClicked(java.awt.event.MouseEvent evt) { // GEN-FIRST:event_clearFieldsMouseClicked
                clearData();
        }// GEN-LAST:event_clearFieldsMouseClicked

        private void findDataActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_findDataActionPerformed
        }// GEN-LAST:event_findDataActionPerformed

        private void findDataMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_findDataMouseClicked
                try {
                        con = DriverManager.getConnection(url, user, pass);
                        pst = con.prepareStatement("SELECT * FROM books WHERE book_id = ?");
                        pst.setString(1, book_id.getText());
                        rt = pst.executeQuery();
                        if (!rt.next()) {
                                JOptionPane.showMessageDialog(null, "Book is not available.");
                        } else {
                                book_id_var = rt.getInt("book_id");
                                bookId.setText(String.valueOf(rt.getInt("book_id")));
                                bookTitle.setText(rt.getString("title"));
                                bookAuthor.setText(rt.getString("author"));
                                bookISBN.setText(rt.getString("isbn"));
                                bookLanguage.setText(rt.getString("language"));
                                bookPublisher.setText(rt.getString("publisher"));
                        }
                        pst = con.prepareStatement("SELECT * FROM students WHERE student_id = ?");
                        pst.setString(1, student_id.getText());
                        rt = pst.executeQuery();
                        if (!rt.next()) {
                                JOptionPane.showMessageDialog(null, "Student is not available.");
                        } else {
                                student_id_var = rt.getInt("student_id");
                                studentId.setText(String.valueOf(student_id_var));
                                studentName.setText(rt.getString("name"));
                                studentPhone.setText(rt.getString("phone"));
                                studentCourse.setText(rt.getString("course"));
                                studentAddress.setText(rt.getString("address"));
                        }
                } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                }
        }// GEN-LAST:event_findDataMouseClicked

        public static void main(String args[]) {
                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(IssueBook.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(IssueBook.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(IssueBook.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(IssueBook.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                }
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new IssueBook().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel bookAuthor;
        private javax.swing.JLabel bookISBN;
        private javax.swing.JLabel bookId;
        private javax.swing.JLabel bookLanguage;
        private javax.swing.JLabel bookPublisher;
        private javax.swing.JLabel bookTitle;
        private javax.swing.JTextField book_id;
        private javax.swing.JButton clearFields;
        private com.toedter.calendar.JDateChooser due_date;
        private javax.swing.JButton findData;
        private javax.swing.JButton issueBook;
        private com.toedter.calendar.JDateChooser issue_date;
        private javax.swing.JButton jButton5;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel11;
        private javax.swing.JLabel jLabel12;
        private javax.swing.JLabel jLabel13;
        private javax.swing.JLabel jLabel14;
        private javax.swing.JLabel jLabel15;
        private javax.swing.JLabel jLabel16;
        private javax.swing.JLabel jLabel17;
        private javax.swing.JLabel jLabel18;
        private javax.swing.JLabel jLabel19;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel20;
        private javax.swing.JLabel jLabel21;
        private javax.swing.JLabel jLabel25;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel10;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JPanel jPanel5;
        private javax.swing.JLabel studentAddress;
        private javax.swing.JLabel studentCourse;
        private javax.swing.JLabel studentId;
        private javax.swing.JLabel studentName;
        private javax.swing.JLabel studentPhone;
        private javax.swing.JTextField student_id;
        // End of variables declaration//GEN-END:variables
}
