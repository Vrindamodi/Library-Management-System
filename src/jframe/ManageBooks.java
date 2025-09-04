package jframe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;

public class ManageBooks extends javax.swing.JFrame {
    String url = "jdbc:mysql://localhost:3306/lms_db";
    String user = "root";
    String pass = "VRINDA";
    Connection con;
    PreparedStatement pst;
    ResultSet rt;
    int id, selectedRow = 0;

    public void clearData() {
        title.setText("");
        author.setText("");
        language.setSelectedIndex(3);
        isbn.setText("");
        publisher.setText("");
        if (id > 0) {
            id = 0;
            addBook.setEnabled(true);
            editBook.setEnabled(false);
            deleteBook.setEnabled(false);
        }
    }

    public void showBooks() {
        try {
            con = DriverManager.getConnection(url, user, pass);
            pst = con.prepareStatement("SELECT * FROM books");
            rt = pst.executeQuery();
            DefaultTableModel tabModel = (DefaultTableModel) (book_table.getModel());
            tabModel.setRowCount(0);
            while (rt.next()) {
                Vector bookRow = new Vector();
                bookRow.add(rt.getInt("book_id"));
                bookRow.add(rt.getString("title"));
                bookRow.add(rt.getString("author"));
                bookRow.add(rt.getString("language"));
                bookRow.add(rt.getString("publisher"));
                bookRow.add(rt.getInt("isbn"));
                tabModel.addRow(bookRow);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public ManageBooks() {
        initComponents();
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH); // Maximize the JFrame
        showBooks();
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
        title = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        author = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        isbn = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        publisher = new javax.swing.JTextField();
        addBook = new javax.swing.JButton();
        editBook = new javax.swing.JButton();
        deleteBook = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        language = new javax.swing.JComboBox<>();
        clearStudent = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        book_table = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        jPanel1.setBackground(new java.awt.Color(75, 156, 211));
        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Book Title");
        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Author");
        author.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorActionPerformed(evt);
            }
        });
        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ISBN");
        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Language");
        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Publisher");
        jLabel5.setToolTipText("");
        addBook.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        addBook.setText("ADD NEW BOOK");
        addBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookActionPerformed(evt);
            }
        });
        editBook.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        editBook.setText("EDIT EXISTING BOOK");
        editBook.setEnabled(false);
        editBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBookMouseClicked(evt);
            }
        });
        editBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBookActionPerformed(evt);
            }
        });
        deleteBook.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        deleteBook.setText("DELETE BOOK");
        deleteBook.setEnabled(false);
        deleteBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBookMouseClicked(evt);
            }
        });
        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 32)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ADD BOOK");
        jButton5.setBackground(new java.awt.Color(75, 156, 211));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addNewBooksIcons/icons8_Rewind_48px.png"))); // NOI18N
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        language.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Assamese", "Arabic", "Bengali", "English", "Gujarati", "Hebrew", "Hindi", "Kannada",
                        "Malayalam", "Marathi", "Odia", "Punjabi", "Tamil", "Telugu", "Urdu" }));
        language.setSelectedIndex(3);
        clearStudent.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        clearStudent.setText("CLEAR FORM");
        clearStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearStudentMouseClicked(evt);
            }
        });
        int width = (int) (Toolkit.getDefaultToolkit().getScreenSize().width);
        int height = (int) (Toolkit.getDefaultToolkit().getScreenSize().height);
        int panel1gap = (int) (width * 0.075);
        int panel1Height = (int) (height * 0.06);
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(panel1gap, panel1gap, panel1gap)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addGroup(jPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(title, 520, 520, 520)
                                                .addComponent(author, 520, 520, 520)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel4)
                                                                .addComponent(language, 250, 250, 250))
                                                        .addGap(20, 20, 20)
                                                        .addGroup(jPanel1Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel3)
                                                                .addComponent(isbn, 250, 250, 250)))
                                                .addComponent(publisher, 520, 520, 520)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel1)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(addBook, 250, 250, 250)
                                                                .addGap(20, 20, 20)
                                                                .addComponent(deleteBook, 250, 250, 250))
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(jPanel1Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(editBook, 250, 250, 250)
                                                                .addGap(20, 20, 20)
                                                                .addComponent(clearStudent, 250, 250, 250)))))
                                .addGap(100, 100, 100))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addGap(0, 0, Short.MAX_VALUE)));
        int labelGap = (int) (height * 0.03);
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addGap(panel1Height + 55, panel1Height + 55, panel1Height + 55)
                                .addComponent(jLabel6)
                                .addGap(labelGap, labelGap, labelGap)
                                .addComponent(jLabel1)
                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(labelGap, labelGap, labelGap)
                                .addComponent(jLabel2)
                                .addComponent(author, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(labelGap, labelGap, labelGap)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3))
                                .addGroup(jPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(language)
                                        .addComponent(isbn, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                                .addGap(labelGap, labelGap, labelGap)
                                .addComponent(jLabel5)
                                .addComponent(publisher, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(labelGap, labelGap, labelGap)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addBook, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(editBook, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(deleteBook, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(clearStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(labelGap, labelGap)));
        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Liberation Sans", 0, 32)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(75, 156, 211));
        jLabel7.setText("Manage Books");
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/books.png"))); // NOI18N
        book_table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "ID", "Title", "Author", "Language", "Publisher", "ISBN"
                }) {
            Class[] types = new Class[] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
                    java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        book_table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        book_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                book_tableMouseClicked(evt);
            }
        });
        book_table.setForeground(new java.awt.Color(0, 0, 0));
        book_table.setShowVerticalLines(true);
        book_table.setShowHorizontalLines(true);
        book_table.setBorder(new javax.swing.border.EtchedBorder());
        int widthMin = (int) (width * 0.03);
        int widthMid = (int) (width * 0.04);
        int widthMidMax = (int) (width * 0.06);
        int widthStr = (int) (width * 0.12);
        int table = 0;
        jScrollPane1.setViewportView(book_table);
        if (book_table.getColumnModel().getColumnCount() > 0) {
            book_table.getColumnModel().getColumn(0).setMinWidth(widthMin);
            book_table.getColumnModel().getColumn(0).setPreferredWidth(widthMin);
            book_table.getColumnModel().getColumn(0).setMaxWidth(widthMin);
            table += widthMin;
            book_table.getColumnModel().getColumn(1).setMinWidth(widthStr);
            book_table.getColumnModel().getColumn(1).setPreferredWidth(widthStr);
            book_table.getColumnModel().getColumn(1).setMaxWidth(widthStr);
            table += widthStr;
            book_table.getColumnModel().getColumn(2).setMinWidth(widthStr);
            book_table.getColumnModel().getColumn(2).setPreferredWidth(widthStr);
            book_table.getColumnModel().getColumn(2).setMaxWidth(widthStr);
            table += widthStr;
            book_table.getColumnModel().getColumn(3).setMinWidth(widthMid);
            book_table.getColumnModel().getColumn(3).setPreferredWidth(widthMid);
            book_table.getColumnModel().getColumn(3).setMaxWidth(widthMid);
            table += widthMid;
            book_table.getColumnModel().getColumn(4).setMinWidth(widthStr);
            book_table.getColumnModel().getColumn(4).setPreferredWidth(widthStr);
            book_table.getColumnModel().getColumn(4).setMaxWidth(widthStr);
            table += widthStr;
            book_table.getColumnModel().getColumn(5).setMinWidth(widthMidMax);
            book_table.getColumnModel().getColumn(5).setPreferredWidth(widthMidMax);
            book_table.getColumnModel().getColumn(5).setMaxWidth(widthMidMax);
            table += widthMidMax;
        }
        jPanel10.setBackground(new java.awt.Color(75, 156, 211));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-close-30.png"))); // NOI18N
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addContainerGap(14, Short.MAX_VALUE)
                                .addComponent(jLabel25)
                                .addGap(12, 12, 12)));
        jPanel10Layout.setVerticalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                                .addContainerGap()));
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, table, table, table)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel7)))
                                .addContainerGap(20, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(panel1Height, panel1Height, panel1Height)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(36, Short.MAX_VALUE)));
        int panel1width = (int) (width * 0.4);
        int panel2width = (int) (width * 0.6);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, panel1width, panel1width, panel1width)
                                .addComponent(jPanel2, panel2width, panel2width, panel2width)
                                .addGap(0, 0, 0)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void authorActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void clearStudentMouseClicked(java.awt.event.MouseEvent evt) {
        clearData();
    }

    private void editBookActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) { // GEN-FIRST:event_jButton5MouseClicked
        this.dispose();
        new Dashboard().setVisible(true);
    } // GEN-LAST:event_jButton5MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel25MouseClicked
        this.dispose();
    }// GEN-LAST:event_jLabel25MouseClicked

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) { // GEN-FIRST:event_jPanel10MouseClicked
    }// GEN-LAST:event_jPanel10MouseClicked

    private void addBookActionPerformed(java.awt.event.ActionEvent evt) { // GEN-FIRST:event_addBookActionPerformed
        if (title.getText().isEmpty() || author.getText().isEmpty() || language.getSelectedItem().toString().isEmpty()
                || isbn.getText().isEmpty() || publisher.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill all the data before submission.");
        } else {
            try {
                con = DriverManager.getConnection(url, user, pass);
                pst = con.prepareStatement(
                        "INSERT INTO books (title, author, language, isbn, publisher) VALUES (?,?,?,?,?)");
                pst.setString(1, title.getText());
                pst.setString(2, author.getText());
                pst.setString(3, language.getSelectedItem().toString());
                pst.setString(4, isbn.getText());
                pst.setString(5, publisher.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Book has been successfully added.");
                showBooks();
                clearData();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }// GEN-LAST:event_addBookActionPerformed

    private void editBookMouseClicked(java.awt.event.MouseEvent evt) { // GEN-FIRST:event_editBookMouseClicked
        if (id != 0) {
            if (title.getText().isEmpty() || author.getText().isEmpty()
                    || language.getSelectedItem().toString().isEmpty() || isbn.getText().isEmpty()
                    || publisher.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Fill all the data before submission.");
            } else {
                try {
                    con = DriverManager.getConnection(url, user, pass);
                    pst = con.prepareStatement(
                            "UPDATE books SET title=?,author=?,language=?,isbn=?,publisher=? WHERE book_id=?");
                    pst.setString(1, title.getText());
                    pst.setString(2, author.getText());
                    pst.setString(3, language.getSelectedItem().toString());
                    pst.setString(4, isbn.getText());
                    pst.setString(5, publisher.getText());
                    pst.setInt(6, id);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Book has been successfully updated.");
                    showBooks();
                    clearData();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Some error occured. Please try again.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select a row to edit.");
        }
    }// GEN-LAST:event_editBookMouseClicked

    private void clearBookMouseClicked(java.awt.event.MouseEvent evt) { // GEN-FIRST:event_clearBookMouseClicked
        clearData();
    }// GEN-LAST:event_clearBookMouseClicked

    private void book_tableMouseClicked(java.awt.event.MouseEvent evt) { // GEN-FIRST:event_book_tableMouseClicked
        selectedRow = book_table.getSelectedRow();
        if (book_table.getSelectedRowCount() > 0) {
            addBook.setEnabled(false);
            deleteBook.setEnabled(true);
            editBook.setEnabled(true);
            id = (int) book_table.getValueAt(selectedRow, 0);
            title.setText(book_table.getValueAt(selectedRow, 1).toString());
            author.setText(book_table.getValueAt(selectedRow, 2).toString());
            language.setSelectedItem(book_table.getValueAt(selectedRow, 3).toString());
            publisher.setText(book_table.getValueAt(selectedRow, 4).toString());
            isbn.setText(book_table.getValueAt(selectedRow, 5).toString());
        } else {
            clearData();
        }
    }// GEN-LAST:event_book_tableMouseClicked

    private void deleteBookMouseClicked(java.awt.event.MouseEvent evt) { // GEN-FIRST:event_deleteBookMouseClicked
        if (id != 0) {
            try {
                con = DriverManager.getConnection(url, user, pass);
                pst = con.prepareStatement("DELETE FROM books WHERE book_id=?");
                pst.setInt(1, id);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Book has been successfully deleted.");
                showBooks();
                clearData();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Some error occured. Please try again.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select a row to delete.");
        }
    } // GEN-LAST:event_deleteBookMouseClicked

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
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBook;
    private javax.swing.JTextField author;
    private javax.swing.JTable book_table;
    private javax.swing.JButton clearStudent;
    private javax.swing.JButton deleteBook;
    private javax.swing.JButton editBook;
    private javax.swing.JTextField isbn;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> language;
    private javax.swing.JTextField publisher;
    private javax.swing.JTextField title;
    // End of variables declaration//GEN-END:variables
}
