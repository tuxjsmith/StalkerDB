/*
 * Copyright (c) 2005, tuxjsmith@gmail.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package stalkerdb;

//<editor-fold defaultstate="collapsed" desc="import">
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import static utilities.Constants.GLOBAL_NOTES.LOADED;
import utilities.Constants.HTTP_METHODS;
import static utilities.Constants.HTTP_METHODS.POST;
import static utilities.Constants.IMAGES_SEARCH_DB_RETURN_VALUES_AL;
import static utilities.Constants.RETURN_OBJECT.EDIT_ID_RETURN_OBJECT;
import static utilities.Constants.RETURN_OBJECT.VALIDATION_RETURN_OBJECT;
import utilities.Constants.RETURN_TYPES;
import static utilities.Constants.RETURN_TYPES.DEFAULT;
import static utilities.Constants.RETURN_TYPES.GLOBAL_NOTES;
import static utilities.Constants.RETURN_TYPES.IMAGES;
import static utilities.Constants.RETURN_TYPES.SEARCH;
import utilities.Constants.STATE;
import utilities.Constants.VALIDATION;
import utilities.Flashing;
import static utilities.Constants.SAVE_DB_RETURN_VALUES_HM;
import static utilities.Constants.SEARCH_DB_RETURN_VALUES_HM;
import static utilities.Constants.STATE.DELETED;
import static utilities.Constants.VERSION;
import utilities.EncodeDecodeImage;
//</editor-fold>

/**
 * DONE: Ability to edit fields after saving, another edit button of first tab,
 * will need to get the ID, last added ID DONE: If in EDIT_MODE, after saving
 * come out of EDIT_MODE. The Edit button will need to be clicked for further
 * editing.
 *
 * @author john
 */
public class StalkerDB extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    //<editor-fold defaultstate="collapsed" desc="StalkerDB constructor">
    public StalkerDB() {
        
        initComponents();
        
        setTitleState ();
        
        reg_TF.grabFocus();
        
        saveDeleteError_LBL.setText(STATE.NEW_ENTRY_MODE.getMessage ());
        
        Flashing.startFlashing ( saveDeleteError_LBL );
        
        //<editor-fold defaultstate="collapsed" desc="Testing search results table.">
//        DefaultTableModel tableModel = (DefaultTableModel)searchResultsTable.getModel();
//       
//        tableModel.addRow(new Object[]{"foo", "bar"}); 
//        tableModel.addRow(new Object[]{"bar", "foo"});
//        
//        /*
//          Deletes all rows.
//          A for loop will fail because the Table Model row count changes when
//          a row is deleted.
//        */
//        while (tableModel.getRowCount() > 0) {
//        
//            tableModel.removeRow(0);
//        }
        //</editor-fold>
    }
    //</editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchCriteria = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        saveGlobalNotes_menuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        insertDate_menuItem = new javax.swing.JMenuItem();
        clipboardCopyPopup = new javax.swing.JPopupMenu();
        copyImage_imageItem = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        reg_TF = new javax.swing.JTextField();
        make_TF = new javax.swing.JTextField();
        crimeStoppers_CB = new javax.swing.JCheckBox();
        vehicleType_Combo = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        location_TF = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        time_TF = new javax.swing.JTextField();
        date_TF = new javax.swing.JTextField();
        today_BTN = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        notesScrollPane = new javax.swing.JScrollPane();
        notes_TA = new javax.swing.JTextArea();
        jPanel14 = new javax.swing.JPanel();
        videoFile_TF = new javax.swing.JTextField();
        uploadImage_btn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        duplicates_LBL = new javax.swing.JLabel();
        id_LBL = new javax.swing.JLabel();
        saveDeleteError_LBL = new javax.swing.JLabel();
        count_LBL = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        save_BTN = new javax.swing.JButton();
        delete_BTN = new javax.swing.JButton();
        clear_BTN = new javax.swing.JButton();
        editFront_BTN = new javax.swing.JButton();
        readOnly_BTN = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        reg_lbl = new javax.swing.JLabel();
        make_lbl = new javax.swing.JLabel();
        loc_lbl = new javax.swing.JLabel();
        time_lbl = new javax.swing.JLabel();
        date_lbl = new javax.swing.JLabel();
        file_lbl = new javax.swing.JLabel();
        notes_lbl = new javax.swing.JLabel();
        type_lbl = new javax.swing.JLabel();
        crimeStoppers_lbl = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        regSearch_TF = new javax.swing.JTextField();
        makeSearch_TF = new javax.swing.JTextField();
        locationSearch_TF = new javax.swing.JTextField();
        timeSearch_TF = new javax.swing.JTextField();
        dateSearch_TF = new javax.swing.JTextField();
        videoFileSearch_TF = new javax.swing.JTextField();
        notesSearch_TF = new javax.swing.JTextField();
        vehicleTypeSearch_combo = new javax.swing.JComboBox<>();
        jPanel17 = new javax.swing.JPanel();
        reg_RB = new javax.swing.JRadioButton();
        make_RB = new javax.swing.JRadioButton();
        location_RB = new javax.swing.JRadioButton();
        time_RB = new javax.swing.JRadioButton();
        date_RB = new javax.swing.JRadioButton();
        file_RB = new javax.swing.JRadioButton();
        notes_RB = new javax.swing.JRadioButton();
        vehicleType_rb = new javax.swing.JRadioButton();
        crimeStoppers_rb = new javax.swing.JRadioButton();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        searchResultsTable = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        search_BTN = new javax.swing.JButton();
        editSearch_BTN = new javax.swing.JButton();
        imagesDesktopPane = new javax.swing.JDesktopPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        globalNotesText = new javax.swing.JTextPane();

        saveGlobalNotes_menuItem.setLabel("Save global notes");
        saveGlobalNotes_menuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveGlobalNotes_menuItemActionPerformed(evt);
            }
        });
        jPopupMenu1.add(saveGlobalNotes_menuItem);
        jPopupMenu1.add(jSeparator1);

        insertDate_menuItem.setText("Insert date at cursor");
        insertDate_menuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertDate_menuItemActionPerformed(evt);
            }
        });
        jPopupMenu1.add(insertDate_menuItem);

        copyImage_imageItem.setText("Copy");
        copyImage_imageItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyImage_imageItemActionPerformed(evt);
            }
        });
        clipboardCopyPopup.add(copyImage_imageItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stalker DB");
        setMinimumSize(new java.awt.Dimension(400, 650));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTabbedPane1.setDoubleBuffered(true);
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(483, 0));

        jPanel1.setLayout(new java.awt.BorderLayout(0, 5));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Car registration and make", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel10.setMinimumSize(new java.awt.Dimension(34, 100));
        jPanel10.setPreferredSize(new java.awt.Dimension(481, 85));
        jPanel10.setLayout(new java.awt.GridLayout(2, 3, 5, 5));

        reg_TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        reg_TF.setToolTipText("Car registration, upper or lower case, with or without spaces");
        reg_TF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        reg_TF.setDoubleBuffered(true);
        reg_TF.setMinimumSize(new java.awt.Dimension(14, 25));
        reg_TF.setPreferredSize(new java.awt.Dimension(150, 25));
        reg_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                reg_TFKeyPressed(evt);
            }
        });
        jPanel10.add(reg_TF);

        make_TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        make_TF.setText("Dunno");
        make_TF.setToolTipText("Car make");
        make_TF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        make_TF.setDoubleBuffered(true);
        jPanel10.add(make_TF);

        crimeStoppers_CB.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        crimeStoppers_CB.setText("<html><body>Crime Stoppers</body></html>");
        crimeStoppers_CB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        crimeStoppers_CB.setDoubleBuffered(true);
        jPanel10.add(crimeStoppers_CB);

        vehicleType_Combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dunno", "Police car", "Police van", "Saloon", "Estate", "SUV", "Bicycle", "Male", "Female" }));
        vehicleType_Combo.setToolTipText("Type of thing.");
        vehicleType_Combo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.add(vehicleType_Combo);

        jPanel1.add(jPanel10, java.awt.BorderLayout.NORTH);

        jPanel3.setLayout(new java.awt.BorderLayout(0, 5));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Where and when", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel4.setMinimumSize(new java.awt.Dimension(284, 90));
        jPanel4.setPreferredSize(new java.awt.Dimension(481, 85));
        jPanel4.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        jPanel18.setLayout(new java.awt.GridLayout(1, 0));

        location_TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        location_TF.setText("Dunno");
        location_TF.setToolTipText("Free form text describing the location of this event");
        location_TF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        location_TF.setDoubleBuffered(true);
        location_TF.setMinimumSize(new java.awt.Dimension(14, 25));
        location_TF.setPreferredSize(new java.awt.Dimension(450, 25));
        location_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                location_TFKeyPressed(evt);
            }
        });
        jPanel18.add(location_TF);

        jPanel4.add(jPanel18);

        jPanel13.setLayout(new java.awt.GridLayout(1, 3, 5, 0));

        time_TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        time_TF.setText("00 : 00 : 00");
        time_TF.setToolTipText("HH:MM:SS");
        time_TF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        time_TF.setDoubleBuffered(true);
        time_TF.setMinimumSize(new java.awt.Dimension(130, 25));
        time_TF.setPreferredSize(new java.awt.Dimension(130, 25));
        time_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                time_TFKeyPressed(evt);
            }
        });
        jPanel13.add(time_TF);

        date_TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        date_TF.setText("2019 - 01 - 01");
        date_TF.setToolTipText("YYYY-MM-DD");
        date_TF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        date_TF.setDoubleBuffered(true);
        date_TF.setMinimumSize(new java.awt.Dimension(130, 25));
        date_TF.setPreferredSize(new java.awt.Dimension(130, 25));
        date_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                date_TFKeyPressed(evt);
            }
        });
        jPanel13.add(date_TF);

        today_BTN.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        today_BTN.setText("Today");
        today_BTN.setDoubleBuffered(true);
        today_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                today_BTNActionPerformed(evt);
            }
        });
        jPanel13.add(today_BTN);

        jPanel4.add(jPanel13);

        jPanel3.add(jPanel4, java.awt.BorderLayout.NORTH);

        jPanel5.setToolTipText("");
        jPanel5.setLayout(new java.awt.BorderLayout(0, 5));

        notesScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Notes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        notesScrollPane.setDoubleBuffered(true);

        notes_TA.setColumns(20);
        notes_TA.setLineWrap(true);
        notes_TA.setRows(5);
        notes_TA.setText("None");
        notes_TA.setToolTipText("Free form text");
        notes_TA.setWrapStyleWord(true);
        notes_TA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        notes_TA.setDoubleBuffered(true);
        notesScrollPane.setViewportView(notes_TA);

        jPanel5.add(notesScrollPane, java.awt.BorderLayout.CENTER);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Video file and image", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel14.setMinimumSize(new java.awt.Dimension(24, 50));
        jPanel14.setPreferredSize(new java.awt.Dimension(89, 52));
        jPanel14.setLayout(new java.awt.BorderLayout(5, 0));

        videoFile_TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        videoFile_TF.setText("None");
        videoFile_TF.setToolTipText("Name / path of the video file");
        videoFile_TF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        videoFile_TF.setDoubleBuffered(true);
        jPanel14.add(videoFile_TF, java.awt.BorderLayout.CENTER);

        uploadImage_btn.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        uploadImage_btn.setText("Upload Image");
        uploadImage_btn.setDoubleBuffered(true);
        uploadImage_btn.setMaximumSize(new java.awt.Dimension(130, 31));
        uploadImage_btn.setMinimumSize(new java.awt.Dimension(130, 31));
        uploadImage_btn.setPreferredSize(new java.awt.Dimension(130, 31));
        uploadImage_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadImage_btnActionPerformed(evt);
            }
        });
        jPanel14.add(uploadImage_btn, java.awt.BorderLayout.LINE_END);

        jPanel5.add(jPanel14, java.awt.BorderLayout.PAGE_START);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel6.setMinimumSize(new java.awt.Dimension(10, 60));
        jPanel6.setPreferredSize(new java.awt.Dimension(10, 60));
        jPanel6.setLayout(new java.awt.GridLayout(1, 4));

        duplicates_LBL.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        duplicates_LBL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        duplicates_LBL.setText("Duplicate Reg's");
        duplicates_LBL.setToolTipText("Number of matching registrations");
        duplicates_LBL.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        duplicates_LBL.setDoubleBuffered(true);
        jPanel6.add(duplicates_LBL);

        id_LBL.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        id_LBL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        id_LBL.setText("Last ID");
        id_LBL.setToolTipText("New database ID");
        id_LBL.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        id_LBL.setDoubleBuffered(true);
        jPanel6.add(id_LBL);

        saveDeleteError_LBL.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        saveDeleteError_LBL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        saveDeleteError_LBL.setText("<html><body style=\"text-align:center\">Saved / Deleted / Error</body></html>");
        saveDeleteError_LBL.setToolTipText("Saved / deleted / Error");
        saveDeleteError_LBL.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        saveDeleteError_LBL.setDoubleBuffered(true);
        jPanel6.add(saveDeleteError_LBL);

        count_LBL.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        count_LBL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        count_LBL.setText("Total Records");
        count_LBL.setToolTipText("Number of database records");
        count_LBL.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        count_LBL.setDoubleBuffered(true);
        jPanel6.add(count_LBL);

        jPanel5.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel7.setMinimumSize(new java.awt.Dimension(426, 50));
        jPanel7.setPreferredSize(new java.awt.Dimension(475, 60));
        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));

        save_BTN.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        save_BTN.setText("Save");
        save_BTN.setToolTipText("Save these details.");
        save_BTN.setDoubleBuffered(true);
        save_BTN.setMinimumSize(new java.awt.Dimension(100, 31));
        save_BTN.setName(""); // NOI18N
        save_BTN.setPreferredSize(new java.awt.Dimension(80, 40));
        save_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_BTNActionPerformed(evt);
            }
        });
        jPanel7.add(save_BTN);

        delete_BTN.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        delete_BTN.setText("Delete");
        delete_BTN.setToolTipText("Move these details to the waste bin.");
        delete_BTN.setDoubleBuffered(true);
        delete_BTN.setEnabled(false);
        delete_BTN.setMinimumSize(new java.awt.Dimension(100, 31));
        delete_BTN.setPreferredSize(new java.awt.Dimension(80, 40));
        delete_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_BTNActionPerformed(evt);
            }
        });
        jPanel7.add(delete_BTN);

        clear_BTN.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        clear_BTN.setText("Clear");
        clear_BTN.setToolTipText("Clear all fields.");
        clear_BTN.setDoubleBuffered(true);
        clear_BTN.setMinimumSize(new java.awt.Dimension(100, 31));
        clear_BTN.setPreferredSize(new java.awt.Dimension(80, 40));
        clear_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_BTNActionPerformed(evt);
            }
        });
        jPanel7.add(clear_BTN);

        editFront_BTN.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        editFront_BTN.setText("Edit");
        editFront_BTN.setDoubleBuffered(true);
        editFront_BTN.setEnabled(false);
        editFront_BTN.setPreferredSize(new java.awt.Dimension(80, 40));
        editFront_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editFront_BTNActionPerformed(evt);
            }
        });
        jPanel7.add(editFront_BTN);

        readOnly_BTN.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        readOnly_BTN.setText("<html><body style=\"text-align:center;\">Read only</body></html>");
        readOnly_BTN.setEnabled(false);
        readOnly_BTN.setPreferredSize(new java.awt.Dimension(80, 40));
        readOnly_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readOnly_BTNActionPerformed(evt);
            }
        });
        jPanel7.add(readOnly_BTN);

        jPanel1.add(jPanel7, java.awt.BorderLayout.SOUTH);

        jTabbedPane1.addTab("Add / Edit", jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());
        jTabbedPane1.addTab("DVLA", jPanel2);

        jPanel8.setPreferredSize(new java.awt.Dimension(453, 0));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registration, Location, Date", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel9.setPreferredSize(new java.awt.Dimension(10, 300));
        jPanel9.setLayout(new java.awt.BorderLayout(5, 0));

        jPanel11.setMinimumSize(new java.awt.Dimension(10, 150));
        jPanel11.setPreferredSize(new java.awt.Dimension(100, 150));
        jPanel11.setLayout(new java.awt.GridLayout(9, 0));

        reg_lbl.setText("Registration:");
        reg_lbl.setDoubleBuffered(true);
        reg_lbl.setPreferredSize(new java.awt.Dimension(70, 25));
        jPanel11.add(reg_lbl);

        make_lbl.setText("Make:");
        make_lbl.setDoubleBuffered(true);
        make_lbl.setPreferredSize(new java.awt.Dimension(70, 25));
        jPanel11.add(make_lbl);

        loc_lbl.setText("Location:");
        loc_lbl.setDoubleBuffered(true);
        loc_lbl.setPreferredSize(new java.awt.Dimension(70, 25));
        jPanel11.add(loc_lbl);

        time_lbl.setText("Time:");
        time_lbl.setDoubleBuffered(true);
        time_lbl.setPreferredSize(new java.awt.Dimension(70, 25));
        jPanel11.add(time_lbl);

        date_lbl.setText("Date:");
        date_lbl.setDoubleBuffered(true);
        date_lbl.setPreferredSize(new java.awt.Dimension(70, 25));
        jPanel11.add(date_lbl);

        file_lbl.setText("File:");
        file_lbl.setDoubleBuffered(true);
        file_lbl.setPreferredSize(new java.awt.Dimension(70, 25));
        jPanel11.add(file_lbl);

        notes_lbl.setText("Notes:");
        notes_lbl.setDoubleBuffered(true);
        notes_lbl.setPreferredSize(new java.awt.Dimension(70, 25));
        jPanel11.add(notes_lbl);

        type_lbl.setText("Vehicle Type");
        jPanel11.add(type_lbl);

        crimeStoppers_lbl.setText("Crime Stoppers");
        crimeStoppers_lbl.setDoubleBuffered(true);
        crimeStoppers_lbl.setPreferredSize(new java.awt.Dimension(70, 25));
        jPanel11.add(crimeStoppers_lbl);

        jPanel9.add(jPanel11, java.awt.BorderLayout.WEST);

        jPanel12.setMinimumSize(new java.awt.Dimension(15, 250));
        jPanel12.setPreferredSize(new java.awt.Dimension(300, 250));
        jPanel12.setLayout(new java.awt.GridLayout(9, 0));

        regSearch_TF.setDoubleBuffered(true);
        jPanel12.add(regSearch_TF);

        makeSearch_TF.setDoubleBuffered(true);
        jPanel12.add(makeSearch_TF);

        locationSearch_TF.setDoubleBuffered(true);
        jPanel12.add(locationSearch_TF);

        timeSearch_TF.setDoubleBuffered(true);
        jPanel12.add(timeSearch_TF);

        dateSearch_TF.setDoubleBuffered(true);
        jPanel12.add(dateSearch_TF);

        videoFileSearch_TF.setDoubleBuffered(true);
        jPanel12.add(videoFileSearch_TF);

        notesSearch_TF.setDoubleBuffered(true);
        jPanel12.add(notesSearch_TF);

        vehicleTypeSearch_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dunno", "Police car", "Police van", "Saloon", "Estate", "SUV", "Bicycle", "Male", "Female" }));
        jPanel12.add(vehicleTypeSearch_combo);

        jPanel9.add(jPanel12, java.awt.BorderLayout.CENTER);

        jPanel17.setLayout(new java.awt.GridLayout(9, 0));

        searchCriteria.add(reg_RB);
        reg_RB.setSelected(true);
        reg_RB.setDoubleBuffered(true);
        reg_RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reg_RBActionPerformed(evt);
            }
        });
        jPanel17.add(reg_RB);

        searchCriteria.add(make_RB);
        make_RB.setDoubleBuffered(true);
        make_RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                make_RBActionPerformed(evt);
            }
        });
        jPanel17.add(make_RB);

        searchCriteria.add(location_RB);
        location_RB.setDoubleBuffered(true);
        location_RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                location_RBActionPerformed(evt);
            }
        });
        jPanel17.add(location_RB);

        searchCriteria.add(time_RB);
        time_RB.setDoubleBuffered(true);
        time_RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                time_RBActionPerformed(evt);
            }
        });
        jPanel17.add(time_RB);

        searchCriteria.add(date_RB);
        date_RB.setDoubleBuffered(true);
        date_RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                date_RBActionPerformed(evt);
            }
        });
        jPanel17.add(date_RB);

        searchCriteria.add(file_RB);
        file_RB.setDoubleBuffered(true);
        file_RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                file_RBActionPerformed(evt);
            }
        });
        jPanel17.add(file_RB);

        searchCriteria.add(notes_RB);
        notes_RB.setDoubleBuffered(true);
        notes_RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notes_RBActionPerformed(evt);
            }
        });
        jPanel17.add(notes_RB);

        searchCriteria.add(vehicleType_rb);
        jPanel17.add(vehicleType_rb);

        searchCriteria.add(crimeStoppers_rb);
        crimeStoppers_rb.setDoubleBuffered(true);
        crimeStoppers_rb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crimeStoppers_rbActionPerformed(evt);
            }
        });
        jPanel17.add(crimeStoppers_rb);

        jPanel9.add(jPanel17, java.awt.BorderLayout.LINE_END);

        jPanel8.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        jPanel15.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setDoubleBuffered(true);

        searchResultsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Reg'", "Notes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        searchResultsTable.setDoubleBuffered(true);
        searchResultsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(searchResultsTable);
        if (searchResultsTable.getColumnModel().getColumnCount() > 0) {
            searchResultsTable.getColumnModel().getColumn(0).setResizable(false);
            searchResultsTable.getColumnModel().getColumn(0).setPreferredWidth(8);
            searchResultsTable.getColumnModel().getColumn(1).setResizable(false);
            searchResultsTable.getColumnModel().getColumn(1).setPreferredWidth(25);
            searchResultsTable.getColumnModel().getColumn(2).setResizable(false);
            searchResultsTable.getColumnModel().getColumn(2).setPreferredWidth(235);
        }

        jPanel15.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        search_BTN.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        search_BTN.setText("Search");
        search_BTN.setDoubleBuffered(true);
        search_BTN.setPreferredSize(new java.awt.Dimension(100, 31));
        search_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_BTNActionPerformed(evt);
            }
        });
        jPanel16.add(search_BTN);

        editSearch_BTN.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        editSearch_BTN.setText("Edit");
        editSearch_BTN.setDoubleBuffered(true);
        editSearch_BTN.setPreferredSize(new java.awt.Dimension(100, 31));
        editSearch_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSearch_BTNActionPerformed(evt);
            }
        });
        jPanel16.add(editSearch_BTN);

        jPanel15.add(jPanel16, java.awt.BorderLayout.PAGE_END);

        jPanel8.add(jPanel15, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Search", jPanel8);

        imagesDesktopPane.setDoubleBuffered(true);
        jTabbedPane1.addTab("Images", imagesDesktopPane);

        jScrollPane3.setDoubleBuffered(true);

        globalNotesText.setComponentPopupMenu(jPopupMenu1);
        globalNotesText.setDoubleBuffered(true);
        jScrollPane3.setViewportView(globalNotesText);

        jTabbedPane1.addTab("Global notes", jScrollPane3);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * static getDeleteBtn
     * @return JButton
     */
    //<editor-fold defaultstate="collapsed" desc="static getDeleteBtn">
    public static JButton getDeleteBtn() {

        return delete_BTN;
    }
    //</editor-fold>

    /**
     * static getFrontEditBtn
     * @return JButton
     */
    //<editor-fold defaultstate="collapsed" desc="static getFrontEditBtn">
    public static JButton getFrontEditBtn() {

        return editFront_BTN;
    }
    //</editor-fold>

    /**
     * static getSearchEditBtn
     * @return JButton
     */
    //<editor-fold defaultstate="collapsed" desc="static getSearchEditBtn">
    public static JButton getSearchEditBtn() {

        return editSearch_BTN;
    }
    //</editor-fold>

    /**
     * static getSearchBtn
     * @return JButton
     */
    //<editor-fold defaultstate="collapsed" desc="static getSearchBtn">
    public static JButton getSearchBtn() {

        return search_BTN;
    }
    //</editor-fold>

    /**
     * static getIdLbl
     * @return JLabel
     */
    //<editor-fold defaultstate="collapsed" desc="static getIdLbl">
    public static JLabel getIdLbl() {

        return id_LBL;
    }
    //</editor-fold>

    /**
     * static getRegistrationTF
     * @return JLabel
     */
    //<editor-fold defaultstate="collapsed" desc="getDuplicatesLbl">
    public static JLabel getDuplicatesLbl() {

        return duplicates_LBL;
    }
    //</editor-fold>

    /**
     * 
     * @return JTextField
     */
    //<editor-fold defaultstate="collapsed" desc="static getRegistrationTF">
    public static JTextField getRegistrationTF() {

        return reg_TF;
    }
    //</editor-fold>

    /**
     * static getMakeTF
     * @return JTextField
     */
    //<editor-fold defaultstate="collapsed" desc="static getMakeTF">
    public static JTextField getMakeTF() {

        return make_TF;
    }
    //</editor-fold>

    /**
     * static getLocationTF
     * @return JTextField
     */
    //<editor-fold defaultstate="collapsed" desc="static getLocationTF">
    public static JTextField getLocationTF() {

        return location_TF;
    }
    //</editor-fold>

    /**
     * static getTimeTF
     * @return JTextField
     */
    //<editor-fold defaultstate="collapsed" desc="static getTimeTF">
    public static JTextField getTimeTF() {

        return time_TF;
    }
    //</editor-fold>

    /**
     * static getDateTF
     * @return JTextField
     */
    //<editor-fold defaultstate="collapsed" desc="static getDateTF">
    public static JTextField getDateTF() {

        return date_TF;
    }
    //</editor-fold>

    /**
     * static getVideoFileTF
     * @return JTextField
     */
    //<editor-fold defaultstate="collapsed" desc="static getVideoFileTF">
    public static JTextField getVideoFileTF() {

        return videoFile_TF;
    }
    //</editor-fold>

    /**
     * static getNotesTA
     * @return JTextArea
     */
    //<editor-fold defaultstate="collapsed" desc="static getNotesTA">
    public static JTextArea getNotesTA() {

        return notes_TA;
    }
    //</editor-fold>

    /**
     * static getSaveBtn
     * @return JButton
     */
    //<editor-fold defaultstate="collapsed" desc="static getSaveBtn">
    public static JButton getSaveBtn () {

        return save_BTN;
    }
    //</editor-fold>

    /**
     * static getTodayBtn
     * @return JButton
     */
    //<editor-fold defaultstate="collapsed" desc="static getTodayBtn">
    public static JButton getTodayBtn () {

        return today_BTN;
    }
    //</editor-fold>
    
    /**
     * static getUploadBtn
     * @return JButton
     */
    //<editor-fold defaultstate="collapsed" desc="static getUploadBtn">
    public static JButton getUploadBtn () {

        return uploadImage_btn;
    }
    //</editor-fold>
    
    /**
     * static getReadOnlyBtn
     * @return JButton
     */
    //<editor-fold defaultstate="collapsed" desc="static getReadOnlyBtn">
    public static JButton getReadOnlyBtn () {

        return readOnly_BTN;
    }
    //</editor-fold>

    /**
     * static getCrimeStoppersCb
     * @return JCheckBox
     */
    //<editor-fold defaultstate="collapsed" desc="static getCrimeStoppersCb">
    public static JCheckBox getCrimeStoppersCb () {

        return crimeStoppers_CB;
    }
    //</editor-fold>
    
    /**
     * static getVehicleTypeCombo
     * @return JComboBox
     */
    //<editor-fold defaultstate="collapsed" desc="static getVehicleTypeCombo">
    public static JComboBox getVehicleTypeCombo () {

        return vehicleType_Combo;
    }
    //</editor-fold>

    /**
     * reg_TFKeyPressed
     * @param evt - KeyEvent
     */
    //<editor-fold defaultstate="collapsed" desc="reg_TFKeyPressed">
    private void reg_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reg_TFKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            location_TF.grabFocus();
        }
    }//GEN-LAST:event_reg_TFKeyPressed
    //</editor-fold>
    
    /**
     * location_TFKeyPressed
     * @param evt - KeyEvent
     */
    //<editor-fold defaultstate="collapsed" desc="location_TFKeyPressed">
    private void location_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_location_TFKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            date_TF.grabFocus();
        }
    }//GEN-LAST:event_location_TFKeyPressed
    //</editor-fold>
    
    /**
     * save_BTNActionPerformed
     * @param evt - KeyEvent
     */
    //<editor-fold defaultstate="collapsed" desc="Save button actionPerformed.">
    private void save_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_BTNActionPerformed

        new Save ().start ();
    }//GEN-LAST:event_save_BTNActionPerformed
    //</editor-fold>
    
    /**
     * clear_BTNActionPerformed
     * @param evt - KeyEvent
     */
    // <editor-fold defaultstate="collapsed" desc="clear_BTNActionPerformed">
    private void clear_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_BTNActionPerformed

        STATE.CLEARED.activate();
        
        setTitleState ();

        for (VALIDATION validate : VALIDATION.values()) {

            validate.resetValid();
        }

        defaultFieldValues();

        reg_TF.grabFocus();

        saveDeleteError_LBL.setText("<html><body style=\"color:#bbbbbb;\">Cleared</body></html>");
        saveDeleteError_LBL.setToolTipText("<html><body style=\"color:#bbbbbb;\">Fields cleared</body></html>");

        Flashing.startFlashing(saveDeleteError_LBL);
    }//GEN-LAST:event_clear_BTNActionPerformed
    //</editor-fold>
    
    /**
     * defaultFieldValues
     */
    //<editor-fold defaultstate="collapsed" desc="defaultFieldValues">
    private void defaultFieldValues() {

        reg_TF.setText("");
        make_TF.setText("Dunno");
        time_TF.setText("00 : 00 : 00");
        date_TF.setText("2019 - 01 - 01");
        videoFile_TF.setText("None");
        location_TF.setText("Dunno");
        notes_TA.setText("None");
        crimeStoppers_CB.setSelected(Boolean.FALSE);
        vehicleType_Combo.setSelectedIndex ( 0 ); 
        
        imagesDesktopPane.removeAll();
    }
    //</editor-fold>

    /**
     * date_TFKeyPressed
     * @param evt - KeyEvent
     */
    //<editor-fold defaultstate="collapsed" desc="date_TFKeyPressed">
    private void date_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_date_TFKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            time_TF.grabFocus();
        }
    }//GEN-LAST:event_date_TFKeyPressed
    //</editor-fold>
    
    /**
     * time_TFKeyPressed
     * @param evt - KeyEvent
     */
    //<editor-fold defaultstate="collapsed" desc="time_TFKeyPressed">
    private void time_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_time_TFKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            notes_TA.grabFocus();
        }
    }//GEN-LAST:event_time_TFKeyPressed
    //</editor-fold>
    
    /*
     * TODO: Table rows could have hint text that allows the user to see more 
     * information.
     */
    
    /**
     * search_BTNActionPerformed
     * @param evt - ActionEvent
     */
    //<editor-fold defaultstate="collapsed" desc="Search button actionPerformed.">
    private void search_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_BTNActionPerformed

        clearTable();
        
        new Search ().start ();
    }//GEN-LAST:event_search_BTNActionPerformed
    //</editor-fold>
    
    /**
     * today_BTNActionPerformed
     * @param evt - ActionEvent
     */
    //<editor-fold defaultstate="collapsed" desc="Today button action performed.">
    private void today_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_today_BTNActionPerformed

        GregorianCalendar calendar = new GregorianCalendar();

//        System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
//        
//        System.out.println("MONTH: " + (((calendar.get(Calendar.MONTH) + 1) < 10) 
//                ? "0" + (calendar.get(Calendar.MONTH) + 1)
//                : (calendar.get(Calendar.MONTH) + 1)));
//        
//        System.out.println("DAY_OF_MONTH: " + 
//                ((calendar.get(Calendar.DAY_OF_MONTH) < 10) 
//                ? "0" + calendar.get(Calendar.DAY_OF_MONTH)
//                : calendar.get(Calendar.DAY_OF_MONTH)) );
        date_TF.setText(
                calendar.get(Calendar.YEAR) + " - "
                + (((calendar.get(Calendar.MONTH) + 1) < 10) ? "0" + (calendar.get(Calendar.MONTH) + 1) : (calendar.get(Calendar.MONTH) + 1)) + " - "
                + ((calendar.get(Calendar.DAY_OF_MONTH) < 10) ? "0" + calendar.get(Calendar.DAY_OF_MONTH) : calendar.get(Calendar.DAY_OF_MONTH)));

    }//GEN-LAST:event_today_BTNActionPerformed
    //</editor-fold>
    
    /**
     * editSearch_BTNActionPerformed
     * @param evt - ActionEvent
     */
    //<editor-fold defaultstate="collapsed" desc="Edit search button actionPerformed.">
    private void editSearch_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSearch_BTNActionPerformed

        if (searchResultsTable.getSelectedRowCount() > 0) {

            /*
             * TODO: put the for loop inside the STATE enum.
             */
            STATE.EDIT_MODE.activate();
            
            setTitleState ();

            final String ID = 
                    searchResultsTable.getModel().getValueAt(
                            searchResultsTable.getSelectedRow(),
                            0).toString();

            /*
             * Trick so that we can save an edit by: id
             */
            EDIT_ID_RETURN_OBJECT.setMessage(ID);

            /*
             * Populate fields and change their colour to show EDIT_MODE.
             * The Clear button should switch back to NEW_ENTRY_MODE
             */
            reg_TF.setText(SEARCH_DB_RETURN_VALUES_HM.get(ID).split("reg:")[1].split(":~:")[0]);
            /*
             * date and time are extracted from the save value
             */
            date_TF.setText(SEARCH_DB_RETURN_VALUES_HM.get(ID).split("date:")[1].split(":~:")[0].split(" ")[0]);
            time_TF.setText(SEARCH_DB_RETURN_VALUES_HM.get(ID).split("date:")[1].split(":~:")[0].split(" ")[1]);
            videoFile_TF.setText(SEARCH_DB_RETURN_VALUES_HM.get(ID).split("fileName:")[1].split(":~:")[0]);
            make_TF.setText(SEARCH_DB_RETURN_VALUES_HM.get(ID).split("make:")[1].split(":~:")[0]);
            notes_TA.setText(SEARCH_DB_RETURN_VALUES_HM.get(ID).split("notes:")[1].split(":~:")[0].replace("--linebreak--", System.getProperty("line.separator")));
            location_TF.setText(SEARCH_DB_RETURN_VALUES_HM.get(ID).split("location:")[1].split(":~:")[0]);
            crimeStoppers_CB.setSelected(
                    (SEARCH_DB_RETURN_VALUES_HM.get(ID).split("crimeStoppers:")[1].equals("0")
                    ? Boolean.TRUE : Boolean.FALSE));
            vehicleType_Combo.setSelectedItem ( SEARCH_DB_RETURN_VALUES_HM.get(ID).split("type:")[1].split(":~:")[0] ); 
            
            id_LBL.setText(EDIT_ID_RETURN_OBJECT.getMessage());

            for (VALIDATION validate : VALIDATION.values()) {

                validate.resetValid();
            }

            jTabbedPane1.setSelectedIndex(0);
            
            /*
             * Get images.
             */
            new GetSearchImages (ID).start ();
            
        } 
        else {

            System.err.println("no rows selected");
        }
    }//GEN-LAST:event_editSearch_BTNActionPerformed
    //</editor-fold>
    
    /**
     * delete_BTNActionPerformed
     * @param evt - ActionEvent
     */
    //<editor-fold defaultstate="collapsed" desc="Delete button actionPerformed.">
    private void delete_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_BTNActionPerformed

        if ( javax.swing.JOptionPane.showConfirmDialog ( 
                this,
                "Confirm deletion",
                "Are you sure ?",
                javax.swing.JOptionPane.YES_NO_OPTION ) == javax.swing.JOptionPane.YES_OPTION ) {

            new Delete ().start ();
        }
    }//GEN-LAST:event_delete_BTNActionPerformed
    //</editor-fold>
    
    /**
     * @param url - String PHP url.
     * @param arguments - Map: field, value
     * @param state - STATE to activate if successful.
     * @param doOutput_b - we expect output.
     * @param doInput_b - we only input values.
     * @param httpMethod - transmission type.
     * @param getSearchResults_b - get search results
     * @param getGlobalNotes_b - get global notes
     */
    //<editor-fold defaultstate="collapsed" desc="phpConnection">
    private Boolean phpConnection (
            
            String url,
            Map<String, String> arguments,
            STATE state,
            Boolean doOutput_b,
            Boolean doInput_b,
            HTTP_METHODS httpMethod, 
            RETURN_TYPES returnType) {
        
        try {

            /*
             * We don't need any special behavior so we use URLConnection
             * https://docs.oracle.com/javase/8/docs/api/java/net/URLConnection.html
             *   
             * HttpURLConnection could have been used also. 
             * https://docs.oracle.com/javase/8/docs/api/java/net/URL.html
             */
            final URL PHP_URL;

            PHP_URL = new URL(url);
            
            final HttpURLConnection PHP_CONNECTION = (HttpURLConnection) PHP_URL.openConnection();

            PHP_CONNECTION.setRequestProperty(
                    "User-Agent",
                    "StalkerDB Client");
            PHP_CONNECTION.setRequestMethod(httpMethod.getHttpMethodString());
            
            if (doOutput_b) {
            
                PHP_CONNECTION.setDoOutput(true);
            }
            else if (doInput_b) {
                
                PHP_CONNECTION.setDoInput(true);
            }

            StringJoiner sj = new StringJoiner("&");

            for (Map.Entry<String, String> entry : arguments.entrySet()) {

                sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "="
                        + URLEncoder.encode(entry.getValue(), "UTF-8"));
            }

            byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
            int length = out.length;

            /*
                We can then attach our form contents to the http request with
                proper headers and send it.
             */
            PHP_CONNECTION.setFixedLengthStreamingMode(length);
            PHP_CONNECTION.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded; charset=UTF-8");
            PHP_CONNECTION.connect();

            try (OutputStream os = PHP_CONNECTION.getOutputStream()) {

                os.write(out);
            }

            /*
             * Wrapping BufferedReader in a try statement like this will
             * automatically close the BufferedReader when the statement is
             * complete.
             *   
             * https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
             *   
             * https://docs.oracle.com/javase/8/docs/api/java/net/URLConnection.html#getInputStream--
             */
            try (BufferedReader bufferedReader
                    = new BufferedReader(new InputStreamReader(PHP_CONNECTION.getInputStream(), "UTF-8"))) {

                String line;
                
                switch (returnType) {

                    case SEARCH:

                        SEARCH_DB_RETURN_VALUES_HM.clear();

                        while ((line = bufferedReader.readLine()) != null) {
                            
                            /*
                             * Un-comment to see all php is echos.
                             */
                            // System.err.println (line);

                            if (!line.trim().isEmpty()
                                    && line.contains("id:")) {

                                SEARCH_DB_RETURN_VALUES_HM.put(line.split("id:")[1].split(":~:")[0], line);
                            } else {

                                System.err.println(
                                        "bad result line. Line is either empty or does not contain 'id:'"
                                        + "\n-> " + line);
                            }
                        }

                        DefaultTableModel tableModel = (DefaultTableModel) searchResultsTable.getModel();

                        /*
                         * Deletes all rows.
                         * A for loop will fail because the Table Model row count
                         * changes when a row is deleted.
                         */
                        while (tableModel.getRowCount() > 0) {

                            tableModel.removeRow(0);
                        }

                        for (Enumeration<String> e = SEARCH_DB_RETURN_VALUES_HM.keys(); e.hasMoreElements();) {

                            final String ID = e.nextElement();

                            tableModel.addRow(new Object[]{
                                ID,
                                SEARCH_DB_RETURN_VALUES_HM.get(ID).split("reg:")[1].split(":~:")[0],
                                SEARCH_DB_RETURN_VALUES_HM.get(ID).split("notes:")[1].split(":~:")[0]
                            });
                        }

                        break;
                        
                    case GLOBAL_NOTES:

                        final StringBuilder RESULT = new StringBuilder();

                        while ((line = bufferedReader.readLine()) != null) {

                            /*
                             * Build the text for the Global Notes field.
                             */
                            RESULT.append(line);
                            RESULT.append("\n");
                        }

                        globalNotesText.setText(RESULT.toString());

                        break;
                        
                    case IMAGES:

                        IMAGES_SEARCH_DB_RETURN_VALUES_AL.clear ();

                        while ( ( line = bufferedReader.readLine () ) != null ) {

                            IMAGES_SEARCH_DB_RETURN_VALUES_AL.add ( line );
                        }

                        /*
                             * For incrementing image names and position of
                             * InternalFrames on DesktopPane.
                         */
                        Integer counter = 0;

                        //<editor-fold defaultstate="collapsed" desc="Testing: create image files.">
//                            for (String s : IMAGES_SEARCH_DB_RETURN_VALUES_AL) {
//
//                                EncodeDecodeImage.setMimeString(s);
//                                EncodeDecodeImage.toImage("/home/john/temp/fooBar_" + counter + ".png");
//
//                                counter++;
//                            }
                        //</editor-fold>
                        /*
                             * Remove any existing InternalFrames from the DesktopPane.
                         */
                        imagesDesktopPane.removeAll ();

                        //<editor-fold defaultstate="collapsed" desc="Create a new InternalFrames for each image.">
                        for ( String s : IMAGES_SEARCH_DB_RETURN_VALUES_AL ) {

                            EncodeDecodeImage.setMimeString ( s );

                            /*
                                 * Create a label with an image.
                             */
                            final ImageIcon II = new ImageIcon ( EncodeDecodeImage.getBufferedImageFromBytes () );
                            JLabel fooLabel = new JLabel ();
                            fooLabel.setIcon ( II );
                            /*
                                 * End label.
                             */

                            JScrollPane jScrollPane1 = new JScrollPane ();
                            
                            jScrollPane1.setBackground(new java.awt.Color(255, 255, 153));
                            jScrollPane1.setDoubleBuffered(true);
                            jScrollPane1.setOpaque(false);
                            jScrollPane1.setViewportView(fooLabel);
                            
                            JInternalFrame foo = new JInternalFrame (
                                    "#" + counter,
                                    Boolean.TRUE,
                                    Boolean.FALSE,
                                    Boolean.TRUE,
                                    Boolean.TRUE );

                            foo.setAutoscrolls ( true );
                            foo.setDoubleBuffered ( true );
                            foo.setVisible ( true );
                            foo.getContentPane ().add ( jScrollPane1, java.awt.BorderLayout.CENTER );
//                            foo.setBounds ( 50 + ( counter * 10 ), 50 + ( counter * 10 ), 320, 240 );
                            foo.setBounds ( 
                                    50 + ( counter * 10 ), 
                                    50 + ( counter * 10 ), 
                                    II.getIconWidth () + 30, 
                                    II.getIconHeight () + 40 );
                            jScrollPane1.setComponentPopupMenu (clipboardCopyPopup );

                            imagesDesktopPane.add ( foo );

                            counter ++;
                        }
                        //</editor-fold>

                        break;

                    default:

                        SAVE_DB_RETURN_VALUES_HM.clear();

                        while ((line = bufferedReader.readLine()) != null) {

                            /*
                             * The hashMap is only really useful if we intend to use
                             * the returned values later.
                             */
                            if (line.startsWith("duplicates")) {

                                SAVE_DB_RETURN_VALUES_HM.put("duplicates", line.split("duplicates:")[1]);
                                duplicates_LBL.setText("<html><body style=\"text-align:center;\">Duplicate Reg's<br>" + SAVE_DB_RETURN_VALUES_HM.get("duplicates") + "</body></html>");
                            } else if (line.startsWith("count")) {

                                SAVE_DB_RETURN_VALUES_HM.put("count", line.split("count:")[1]);
                                count_LBL.setText("<html><body style=\"text-align:center;\">Total Records<br>" + SAVE_DB_RETURN_VALUES_HM.get("count") + "</body></html>");
                            } 
                            else if (line.startsWith("id")) {

                                SAVE_DB_RETURN_VALUES_HM.put("id", line.split("id:")[1]);

                                if (state.equals(DELETED)) {

                                    id_LBL.setText("<html><body style=\"text-align:center;\">Deleted ID<br>" + SAVE_DB_RETURN_VALUES_HM.get("id") + "</body></html>");
                                } 
                                else if (arguments.containsKey ( "id") )  {

                                    id_LBL.setText( arguments.get ( "id") );
//                                    id_LBL.setText("<html><body style=\"text-align:center;\">Last ID<br>" + SAVE_DB_RETURN_VALUES_HM.get("id") + "</body></html>");
                                }
                                else {
                                    
                                    id_LBL.setText(SAVE_DB_RETURN_VALUES_HM.get("id"));
                                }
                            } 
                            /*
                             * An error has likely occured with database connectivity.    
                             */ 
                            else {

                            }
                        }

                        break;
                }
            }
            
            PHP_CONNECTION.disconnect();
            
            saveDeleteError_LBL.setText("<html><body style=\"color:#bbbbbb;\">" + state.getMessage() + "</body></html>");
            saveDeleteError_LBL.setToolTipText("<html><body style=\"color:#bbbbbb;\">" + state.getMessage() + "</body></html>");

            /*
             * Switch out of EDIT_MODE.
             */
            state.activate();

            setTitleState();

            /*
             * Make the fields black.
             */
            for (VALIDATION validate : VALIDATION.values()) {

                validate.resetValid();
            }
        } catch (IOException ioe) {

            System.err.println(ioe.getMessage());

            saveDeleteError_LBL.setText("<html><body style=\"color:#bbbbbb;\">Connection Error</body></html>");
            saveDeleteError_LBL.setToolTipText("<html><body style=\"color:#bbbbbb;\">" + ioe.getMessage() + "</body></html>");

            return Boolean.FALSE;
        }

        Flashing.startFlashing(saveDeleteError_LBL);

        return Boolean.TRUE;
    }
    //</editor-fold>

    /**
     * setTitleState
     */
    //<editor-fold defaultstate="collapsed" desc="setTitleState">
    private void setTitleState() {

        for (STATE states : STATE.values()) {

            if (states.isActive()) {

                this.setTitle("Stalker DB :: " + states.getMessage() + " :: " + VERSION);

                break;
            }
        }
    }
    //</editor-fold>

    /**
     * editFront_BTNActionPerformed
     * @param evt - ActionEvent
     */
    //<editor-fold defaultstate="collapsed" desc="editFront_BTN actionPerformed">
    private void editFront_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editFront_BTNActionPerformed

        /*
         * For testing.
         */
//        for (Enumeration<String> e = SAVE_DB_RETURN_VALUES_HM.keys (); e.hasMoreElements (); ) {
//            
//            final String KEY = e.nextElement ();
//            
//            System.out.println (KEY);
//        }
        
        /*
         * DONE: Make sure we know what ID we are editing. Perhaps add the ID to the title too.
         */
        if (SAVE_DB_RETURN_VALUES_HM.containsKey("id")
                && SAVE_DB_RETURN_VALUES_HM.get("id") != null) {

            /*
             * Trick so that we can save an edit by: id
             */
            EDIT_ID_RETURN_OBJECT.setMessage(SAVE_DB_RETURN_VALUES_HM.get("id"));

            /*
             * Set EDIT_MODE
             */
            STATE.EDIT_MODE.activate();
            
            setTitleState ();

            /*
             * Make the fields green.
             */
            for (VALIDATION validate : VALIDATION.values()) {

                validate.resetValid();
            }

            id_LBL.setText(EDIT_ID_RETURN_OBJECT.getMessage());
        }
        else {

            saveDeleteError_LBL.setText("<html><body style=\"color:#bbbbbb;\">Error</body></html>");
            saveDeleteError_LBL.setToolTipText("<html><body style=\"color:#bbbbbb;\">No ID to edit</body></html>");
        }
    }//GEN-LAST:event_editFront_BTNActionPerformed
    //</editor-fold>
  
    /**
     * 
     * @param evt - ActionEvent
     */
    //<editor-fold defaultstate="collapsed" desc="crimeStoppers_rbActionPerformed">
    private void crimeStoppers_rbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crimeStoppers_rbActionPerformed

        editSearch_BTN.setEnabled(Boolean.FALSE);

        clearTable();
    }//GEN-LAST:event_crimeStoppers_rbActionPerformed
    //</editor-fold>
   
    /**
     * 
     * @param evt - ActionEvent
     */
    //<editor-fold defaultstate="collapsed" desc="notes_RBActionPerformed">
    private void notes_RBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notes_RBActionPerformed

        editSearch_BTN.setEnabled(Boolean.TRUE);

        clearTable();
    }//GEN-LAST:event_notes_RBActionPerformed
    //</editor-fold>
   
    /**
     * 
     * @param evt - ActionEvent
     */
    //<editor-fold defaultstate="collapsed" desc="file_RBActionPerformed">
    private void file_RBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_file_RBActionPerformed

        editSearch_BTN.setEnabled(Boolean.TRUE);

        clearTable();
    }//GEN-LAST:event_file_RBActionPerformed
    //</editor-fold>
    
    /**
     * 
     * @param evt - ActionEvent
     */
    //<editor-fold defaultstate="collapsed" desc="date_RBActionPerformed">
    private void date_RBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_date_RBActionPerformed

        editSearch_BTN.setEnabled(Boolean.TRUE);

        clearTable();
    }//GEN-LAST:event_date_RBActionPerformed
    //</editor-fold>
    
    /**
     * 
     * @param evt - ActionEvent
     */
    //<editor-fold defaultstate="collapsed" desc="time_RBActionPerformed">
    private void time_RBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_time_RBActionPerformed

        editSearch_BTN.setEnabled(Boolean.TRUE);

        clearTable();
    }//GEN-LAST:event_time_RBActionPerformed
    //</editor-fold>
    
    /**
     * 
     * @param evt - ActionEvent
     */
    //<editor-fold defaultstate="collapsed" desc="location_RBActionPerformed">
    private void location_RBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_location_RBActionPerformed

        editSearch_BTN.setEnabled(Boolean.TRUE);

        clearTable();
    }//GEN-LAST:event_location_RBActionPerformed
    //</editor-fold>
  
    /**
     * 
     * @param evt - ActionEvent
     */
    //<editor-fold defaultstate="collapsed" desc="make_RBActionPerformed">
    private void make_RBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_make_RBActionPerformed

        editSearch_BTN.setEnabled(Boolean.TRUE);

        clearTable();
    }//GEN-LAST:event_make_RBActionPerformed
    //</editor-fold>
    
    /**
     * 
     * @param evt - ActionEvent
     */
    //<editor-fold defaultstate="collapsed" desc="reg_RBActionPerformed">
    private void reg_RBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reg_RBActionPerformed

        editSearch_BTN.setEnabled(Boolean.TRUE);

        clearTable();
    }//GEN-LAST:event_reg_RBActionPerformed
    //</editor-fold>
    
    /**
     * 
     * @param evt - ActionEvent
     */
    //<editor-fold defaultstate="collapsed" desc="uploadImage_btn actionPerformed">
    private void uploadImage_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadImage_btnActionPerformed
        
        javax.swing.JFileChooser chooseFile = new javax.swing.JFileChooser();
        
        FileNameExtensionFilter filter = 
                new FileNameExtensionFilter( "PNG Images", "png" );
        
        chooseFile.setFileFilter(filter);
        
        chooseFile.setApproveButtonText("Select");
        
        chooseFile.setDialogTitle("Choose an image.");
        
        chooseFile.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);
        
        chooseFile.setMultiSelectionEnabled(false);
        
        int returnVal = chooseFile.showOpenDialog(this);
        
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {

//            System.out.println( chooseFile.getSelectedFile().getAbsolutePath() );

            EncodeDecodeImage.encodeFile ( chooseFile.getSelectedFile().getAbsolutePath() );

            /*
                 * Testing whether the encoded image can be decoded back into a file. 
             */
//            EncodeDecodeImage.toImage("/home/john/temp/image.png");
            /*
                 * End testing.
             */
        }
    }//GEN-LAST:event_uploadImage_btnActionPerformed
    //</editor-fold>
    
    /**
     * 
     * @param evt - ActionEvent
     */
    //<editor-fold defaultstate="collapsed" desc="saveGlobalNotes_menuItemActionPerformed">
    private void saveGlobalNotes_menuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveGlobalNotes_menuItemActionPerformed

        new SaveGlobalNotes ().start();
    }//GEN-LAST:event_saveGlobalNotes_menuItemActionPerformed
    //</editor-fold>
   
    /**
     * 
     * @param evt - ActionEvent
     */
    //<editor-fold defaultstate="collapsed" desc="insertDate_menuItemActionPerformed">
    private void insertDate_menuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertDate_menuItemActionPerformed
        
        GregorianCalendar calendar = new GregorianCalendar();

        globalNotesText.replaceSelection(calendar.get(Calendar.YEAR) + " - "
                + (((calendar.get(Calendar.MONTH) + 1) < 10) ? "0" + (calendar.get(Calendar.MONTH) + 1) : (calendar.get(Calendar.MONTH) + 1)) + " - "
                + ((calendar.get(Calendar.DAY_OF_MONTH) < 10) ? "0" + calendar.get(Calendar.DAY_OF_MONTH) : calendar.get(Calendar.DAY_OF_MONTH))); 
    }//GEN-LAST:event_insertDate_menuItemActionPerformed
    //</editor-fold>
    
    
    /**
     * 
     * @param evt - ActionEvent
     */
    //<editor-fold defaultstate="collapsed" desc="copyImage_imageItem actionPerformed">
    private void copyImage_imageItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyImage_imageItemActionPerformed
        
        BufferedImage bi = new BufferedImage (
                ( ( JLabel ) ( ( JScrollPane ) imagesDesktopPane.getSelectedFrame ().getContentPane ().getComponents ()[ 0 ] ).getViewport ().getView () ).getIcon().getIconWidth (),
                ( ( JLabel ) ( ( JScrollPane ) imagesDesktopPane.getSelectedFrame ().getContentPane ().getComponents ()[ 0 ] ).getViewport ().getView () ).getIcon().getIconHeight (),
                BufferedImage.TYPE_INT_RGB
        );
        
        Graphics g = bi.createGraphics();
        ( ( JLabel ) ( ( JScrollPane ) imagesDesktopPane.getSelectedFrame ().getContentPane ().getComponents ()[ 0 ] ).getViewport ().getView () ).getIcon ().paintIcon ( null, g, 0, 0 );
        g.dispose();
        
        Toolkit.getDefaultToolkit ().getSystemClipboard ().setContents ( new Transferable () {

            @Override
            public DataFlavor[] getTransferDataFlavors () {

                JOptionPane.showMessageDialog (
                        jTabbedPane1,
                        "Image has been copied",
                        "Clipboard copy",
                        JOptionPane.INFORMATION_MESSAGE );

                return new DataFlavor[] { DataFlavor.imageFlavor };
            }

            @Override
            public boolean isDataFlavorSupported ( DataFlavor flavor ) {

                throw new UnsupportedOperationException ( "Not supported yet." );
            }

            @Override
            public Object getTransferData ( DataFlavor flavor ) throws UnsupportedFlavorException, IOException {

                return bi;
            }
        }, null );
    }//GEN-LAST:event_copyImage_imageItemActionPerformed
    //</editor-fold>
    
    /**
     * 
     * @param evt - WindowEvent
     */
    //<editor-fold defaultstate="collapsed" desc="formWindowOpened">
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
//        System.out.println ("Window opened");
        
        if (!LOADED.isActive ()) {
            
            new GetGlobalNotes().start();
            
            LOADED.setActive ( Boolean.FALSE ); 
        }
    }//GEN-LAST:event_formWindowOpened
    //</editor-fold>
    
    /**
     * When we want to be able to read and copy values to the clipboard but not
     * edit.
     * 
     * @param evt - ActionEvent
     */
    //<editor-fold defaultstate="collapsed" desc="readOnly_BTNActionPerformed">
    private void readOnly_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readOnly_BTNActionPerformed
        
        STATE.READ_ONLY.activate ();
        
        SAVE_DB_RETURN_VALUES_HM.put ( "id", EDIT_ID_RETURN_OBJECT.getMessage () );
        
        /*
         * We reset all values to their original when this button is clicked.
         */
        reg_TF.setText ( SEARCH_DB_RETURN_VALUES_HM.get ( EDIT_ID_RETURN_OBJECT.getMessage () ).split ( "reg:" )[ 1 ].split ( ":~:" )[ 0 ] );
        date_TF.setText ( SEARCH_DB_RETURN_VALUES_HM.get ( EDIT_ID_RETURN_OBJECT.getMessage () ).split ( "date:" )[ 1 ].split ( ":~:" )[ 0 ].split ( " " )[ 0 ] );
        time_TF.setText ( SEARCH_DB_RETURN_VALUES_HM.get ( EDIT_ID_RETURN_OBJECT.getMessage () ).split ( "date:" )[ 1 ].split ( ":~:" )[ 0 ].split ( " " )[ 1 ] );
        videoFile_TF.setText ( SEARCH_DB_RETURN_VALUES_HM.get ( EDIT_ID_RETURN_OBJECT.getMessage () ).split ( "fileName:" )[ 1 ].split ( ":~:" )[ 0 ] );
        make_TF.setText ( SEARCH_DB_RETURN_VALUES_HM.get ( EDIT_ID_RETURN_OBJECT.getMessage () ).split ( "make:" )[ 1 ].split ( ":~:" )[ 0 ] );
        notes_TA.setText ( SEARCH_DB_RETURN_VALUES_HM.get ( EDIT_ID_RETURN_OBJECT.getMessage () ).split ( "notes:" )[ 1 ].split ( ":~:" )[ 0 ].replace ( "--linebreak--", System.getProperty ( "line.separator" ) ) );
        location_TF.setText ( SEARCH_DB_RETURN_VALUES_HM.get ( EDIT_ID_RETURN_OBJECT.getMessage () ).split ( "location:" )[ 1 ].split ( ":~:" )[ 0 ] );
        crimeStoppers_CB.setSelected (
                ( SEARCH_DB_RETURN_VALUES_HM.get ( EDIT_ID_RETURN_OBJECT.getMessage () ).split ( "crimeStoppers:" )[ 1 ].equals ( "0" )
                ? Boolean.TRUE : Boolean.FALSE ) );
        vehicleType_Combo.setSelectedItem ( SEARCH_DB_RETURN_VALUES_HM.get ( EDIT_ID_RETURN_OBJECT.getMessage () ).split ( "type:" )[ 1 ].split ( ":~:" )[ 0 ] );

        id_LBL.setText ( EDIT_ID_RETURN_OBJECT.getMessage () );
        
        saveDeleteError_LBL.setText("<html><body style=\"color:#bbbbbb;\">Read only</body></html>");
        saveDeleteError_LBL.setToolTipText("<html><body style=\"color:#bbbbbb;\">Editable but save not allowed</body></html>");
    }//GEN-LAST:event_readOnly_BTNActionPerformed
    //</editor-fold>
    
    /**
     * Remove all rows and data from the search results table.
     */
    //<editor-fold defaultstate="collapsed" desc="clearTable">
    private void clearTable() {

        ((DefaultTableModel) searchResultsTable.getModel()).getDataVector ().clear ();
        ((DefaultTableModel) searchResultsTable.getModel()).fireTableDataChanged ();
    }
    //</editor-fold>

    /**
     * @param args the command line arguments
     */
    //<editor-fold defaultstate="collapsed" desc="main">
    public static void main(String args[]) {
        
        com.formdev.flatlaf.FlatDarkLaf.install();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            
            StalkerDB sdb = new StalkerDB();
            
            sdb.setVisible (true);
            
            sdb.setLocationRelativeTo (null);
        });
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Swing variables">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear_BTN;
    private javax.swing.JPopupMenu clipboardCopyPopup;
    private javax.swing.JMenuItem copyImage_imageItem;
    private javax.swing.JLabel count_LBL;
    private static javax.swing.JCheckBox crimeStoppers_CB;
    private javax.swing.JLabel crimeStoppers_lbl;
    private javax.swing.JRadioButton crimeStoppers_rb;
    private javax.swing.JTextField dateSearch_TF;
    private javax.swing.JRadioButton date_RB;
    private static javax.swing.JTextField date_TF;
    private javax.swing.JLabel date_lbl;
    private static javax.swing.JButton delete_BTN;
    private static javax.swing.JLabel duplicates_LBL;
    private static javax.swing.JButton editFront_BTN;
    private static javax.swing.JButton editSearch_BTN;
    private javax.swing.JRadioButton file_RB;
    private javax.swing.JLabel file_lbl;
    private javax.swing.JTextPane globalNotesText;
    private static javax.swing.JLabel id_LBL;
    private javax.swing.JDesktopPane imagesDesktopPane;
    private javax.swing.JMenuItem insertDate_menuItem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel loc_lbl;
    private javax.swing.JTextField locationSearch_TF;
    private javax.swing.JRadioButton location_RB;
    private static javax.swing.JTextField location_TF;
    private javax.swing.JTextField makeSearch_TF;
    private javax.swing.JRadioButton make_RB;
    private static javax.swing.JTextField make_TF;
    private javax.swing.JLabel make_lbl;
    private javax.swing.JScrollPane notesScrollPane;
    private javax.swing.JTextField notesSearch_TF;
    private javax.swing.JRadioButton notes_RB;
    private static javax.swing.JTextArea notes_TA;
    private javax.swing.JLabel notes_lbl;
    private static javax.swing.JButton readOnly_BTN;
    private javax.swing.JTextField regSearch_TF;
    private javax.swing.JRadioButton reg_RB;
    private static javax.swing.JTextField reg_TF;
    private javax.swing.JLabel reg_lbl;
    private javax.swing.JLabel saveDeleteError_LBL;
    private javax.swing.JMenuItem saveGlobalNotes_menuItem;
    private static javax.swing.JButton save_BTN;
    private javax.swing.ButtonGroup searchCriteria;
    private javax.swing.JTable searchResultsTable;
    private static javax.swing.JButton search_BTN;
    private javax.swing.JTextField timeSearch_TF;
    private javax.swing.JRadioButton time_RB;
    private static javax.swing.JTextField time_TF;
    private javax.swing.JLabel time_lbl;
    private static javax.swing.JButton today_BTN;
    private javax.swing.JLabel type_lbl;
    private static javax.swing.JButton uploadImage_btn;
    private javax.swing.JComboBox<String> vehicleTypeSearch_combo;
    private static javax.swing.JComboBox<String> vehicleType_Combo;
    private javax.swing.JRadioButton vehicleType_rb;
    private javax.swing.JTextField videoFileSearch_TF;
    private static javax.swing.JTextField videoFile_TF;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
    
    /**
     * A threaded class that sends all values to the database via PHP.
     */
    //<editor-fold defaultstate="collapsed" desc="Save class">
    public class Save extends Thread {

        @Override
        public void run () {

            /*
             * DONE: EDIT_MODE needs return values that can be added to the status bar.
             * DONE: if EDIT_MODE then update the database else if NEW_ENTRY_MODE then insert.
             * DONE: allow certain empty fields, change database to use default values.
             * DONE: flash the 'Save' message for a few seconds.
             * DONE: The last ID should be returned by PHP, the function: saveFeedback
             *
             * STET: exclude: '
             * DONE: allow punctuation characters.
             */
            VALIDATION_RETURN_OBJECT.clearMessage ();
            VALIDATION_RETURN_OBJECT.setTrue ();

            saveDeleteError_LBL.setText ( "Saving ..." );
            saveDeleteError_LBL.setToolTipText ( "Saving ..." );

            /*
                 * Reset all validation values.
             */
            for ( VALIDATION field : VALIDATION.values () ) {

                field.resetValid ();
            }

            /*
             * These two loops have to be separated.
             *
             * Parse each field's String. 
             */
            for ( VALIDATION field : VALIDATION.values () ) {

                field.validate ();
            }

            if ( ! VALIDATION_RETURN_OBJECT.isTrue () ) {

                saveDeleteError_LBL.setText ( "<html><body style=\"color:#bbbbbb;\">Error</body></html>" );

                saveDeleteError_LBL.setToolTipText ( "<html><body style=\"color:#bbbbbb;\">" + VALIDATION_RETURN_OBJECT.getMessage () + "</body></html>" );
            } 
            else {

                final String PHP_URL_S;

                /*
                 * Which URL should we use.
                 */
                if ( STATE.EDIT_MODE.isActive () ) {

                    PHP_URL_S = "http://localhost/logFarm/PHP/StalkerDbPhp/updateEntry.php";
                } else {

                    PHP_URL_S = "http://localhost/logFarm/PHP/StalkerDbPhp/addNewEntry.php";
                }

                final Map<String, String> ARGUMENTS = new HashMap<> ();

                /*
                 * Alphanumeric only.
                 */
                ARGUMENTS.put ( "reg", reg_TF.getText ().replaceAll ( " ", "" ).toUpperCase () );

                /*
                 * 2 numbers, slash, 2 numbers, slash, 4 numbers.
                 */
                ARGUMENTS.put ( "date", date_TF.getText ().replaceAll ( " ", "" ) + " " + time_TF.getText ().replaceAll ( " ", "" ) );

                ARGUMENTS.put ( "location", location_TF.getText ().trim () );

                /*
                 * Free form.
                 * fileName.matches("[a-zA-Z0-9_\\-\\.]+\\.tar\\.gz$")
                 */
                ARGUMENTS.put ( "fileName", videoFile_TF.getText ().trim () );

                /*
                 * Free form.
                 */
                ARGUMENTS.put ( "make", make_TF.getText ().toUpperCase ().trim () );

                /*
                 * Free form.
                 */
                ARGUMENTS.put ( "notes", notes_TA.getText ().replace ( System.getProperty ( "line.separator" ), "--linebreak--" ).trim () );

                /*
                 * EDIT_MODE
                 * We send an ID for the database to update.
                 */
                if ( STATE.EDIT_MODE.isActive () ) {

                    ARGUMENTS.put ( "id", EDIT_ID_RETURN_OBJECT.getMessage () );
                }

                ARGUMENTS.put ( "crimeStoppers", ( crimeStoppers_CB.isSelected () ) ? "0" : "1" );

                ARGUMENTS.put ( "imageMime", EncodeDecodeImage.getMimeString () );
                
                ARGUMENTS.put ("vehicleType", vehicleType_Combo.getSelectedItem ().toString () );

                phpConnection (
                        PHP_URL_S,
                        ARGUMENTS,
                        STATE.SAVED,
                        Boolean.TRUE,
                        Boolean.FALSE,
                        HTTP_METHODS.POST,
                        DEFAULT
                );

                if ( ! EncodeDecodeImage.getMimeString ().equals ( "no image" ) ) {
                    /*
                     * Create a label with an image.
                     */
                    final ImageIcon II = new ImageIcon ( EncodeDecodeImage.getBufferedImageFromBytes () );
                    JLabel fooLabel = new JLabel ();
                    fooLabel.setIcon ( II );
                    /*
                     * End label.
                     */

                    JInternalFrame foo = new JInternalFrame (
                            "#n",
                            Boolean.TRUE,
                            Boolean.FALSE,
                            Boolean.TRUE,
                            Boolean.TRUE );

                    foo.setAutoscrolls ( true );
                    foo.setDoubleBuffered ( true );
                    foo.setVisible ( true );
                    foo.getContentPane ().add ( fooLabel, java.awt.BorderLayout.CENTER );
                    foo.setBounds ( 50, 50, 320, 240 );
                    foo.setComponentPopupMenu ( clipboardCopyPopup );

                    imagesDesktopPane.add ( foo );
                }

                /*
                 * If arguments includes: id
                 * then we have just edited an existing record.
                 * Search results need to be updated.
                 */
                if ( ARGUMENTS.containsKey ( "id" ) ) {

                    search_BTN.doClick ();
                }

                Flashing.startFlashing ( saveDeleteError_LBL );
            }

            EncodeDecodeImage.resetMimeString ();

            reg_TF.grabFocus ();
        }
    }
    //</editor-fold>
    
    /**
     * A threaded class that gets images from the database via PHP.
     */
    //<editor-fold defaultstate="collapsed" desc="GetSearchImages class">
    public class GetSearchImages extends Thread {
        
        private final String RECORD_ID;
        
        public GetSearchImages (String id) {
            
            RECORD_ID = id;
        }
        
        @Override
        public void run () {
            
            final String PHP_URL_S = "http://localhost/logFarm/PHP/StalkerDbPhp/getImages.php";
            final Map<String, String> ARGUMENTS = new HashMap<> ();
            ARGUMENTS.put ( "reg", SEARCH_DB_RETURN_VALUES_HM.get ( RECORD_ID ).split ( "reg:" )[ 1 ].split ( ":~:" )[ 0 ] );

            phpConnection (
                    PHP_URL_S,
                    ARGUMENTS,
                    STATE.getCurrentState (),
                    Boolean.TRUE,
                    Boolean.FALSE,
                    POST,
                    IMAGES );
        }
    }
    //</editor-fold>
    
    /**
     * A threaded class that gets global notes from the data via PHP.
     */
    //<editor-fold defaultstate="collapsed" desc="GetGlobalNotes class">
    public class GetGlobalNotes extends Thread {

        @Override
        public void run() {
            
            final String PHP_URL_S = "http://localhost/logFarm/PHP/StalkerDbPhp/getGlobalNotes.php";

            final Map<String, String> ARGUMENTS = new HashMap<>();

            phpConnection(
                    PHP_URL_S,
                    ARGUMENTS,
                    STATE.getCurrentState (),
                    Boolean.TRUE,
                    Boolean.FALSE,
                    HTTP_METHODS.POST,
                    GLOBAL_NOTES
            );
        }
    }
    //</editor-fold>
    
    /**
     * Request and retrieve search data via PHP.
     */
    //<editor-fold defaultstate="collapsed" desc="Search">
    public class Search extends Thread {

        @Override
        public void run () {
            
            search_BTN.setEnabled ( false ); 

            final String PHP_URL_S = "http://localhost/logFarm/PHP/StalkerDbPhp/search.php";

            final Map<String, String> ARGUMENTS = new HashMap<> ();

            if ( reg_RB.isSelected () ) {

                ARGUMENTS.put ( "reg", regSearch_TF.getText ().trim ().toUpperCase ().replaceAll ( " ", "" ) );
            } else if ( make_RB.isSelected () ) {

                ARGUMENTS.put ( "make", makeSearch_TF.getText ().trim () );
            } else if ( location_RB.isSelected () ) {

                ARGUMENTS.put ( "location", locationSearch_TF.getText ().trim () );
            } else if ( time_RB.isSelected () ) {

                ARGUMENTS.put ( "time", timeSearch_TF.getText ().trim () );
            } else if ( date_RB.isSelected () ) {

                ARGUMENTS.put ( "date", dateSearch_TF.getText ().trim () );
            } else if ( file_RB.isSelected () ) {

                ARGUMENTS.put ( "fileName", videoFileSearch_TF.getText ().trim ().replaceAll ( " ", "" ) );
            } else if ( notes_RB.isSelected () ) {

                ARGUMENTS.put ( "notes", notesSearch_TF.getText ().trim () );
            } else if ( crimeStoppers_rb.isSelected () ) {

                /*
                 * TODO: make constant: "crimeStoppers_value_not_required"
                 */
                ARGUMENTS.put ( "crimeStoppers", "crimeStoppers_value_not_required" );
            } else if ( vehicleType_rb.isSelected () ) {
                
                ARGUMENTS.put ( "vehicleType", vehicleTypeSearch_combo.getSelectedItem ().toString () );
            }
            
            else {

                /*
                 * Error no radio button was selected.
                 */
                return;
            }

            phpConnection (
                    PHP_URL_S,
                    ARGUMENTS,
                    STATE.getCurrentState (),
                    Boolean.TRUE,
                    Boolean.FALSE,
                    POST,
                    SEARCH );
            
            search_BTN.setEnabled ( true ); 
        }
    }
    //</editor-fold>
    
    /**
     * A threaded class that marks a record as deleted in the database via PHP.
     */
    //<editor-fold defaultstate="collapsed" desc="Delete class">
    public class Delete extends Thread {

        @Override
        public void run() {

            /*
             * TODO: Mark a record as deleted so that it will not show when a search is made.
             */
            saveDeleteError_LBL.setText("Deleting ...");
            saveDeleteError_LBL.setToolTipText("Deleting ...");

            /*
             * We can delete in EDIT_MODE and READ_ONLY.
             */
            if (STATE.EDIT_MODE.isActive()
                || STATE.READ_ONLY.isActive()) {

                final String PHP_URL_S = "http://localhost/logFarm/PHP/StalkerDbPhp/delete.php";

                Map<String, String> args = new HashMap<>();
                
                args.put("id", EDIT_ID_RETURN_OBJECT.getMessage());

                if (phpConnection(
                        PHP_URL_S,
                        args,
                        DELETED,
                        Boolean.TRUE,
                        Boolean.FALSE,
                        POST,
                        DEFAULT)) {

                    StalkerDB.getSearchBtn().doClick();

                    for (VALIDATION validate : VALIDATION.values()) {
                        
                        validate.resetValid();
                    }
                    
                    defaultFieldValues();

                    reg_TF.grabFocus();
                }
            } 
            else {

                saveDeleteError_LBL.setText("<html><body style=\"color:#bbbbbb;\">Error</body></html>");
                saveDeleteError_LBL.setToolTipText("<html><body style=\"color:#bbbbbb;\">Only delete in Edit Mode, id: " + EDIT_ID_RETURN_OBJECT.getMessage() + "</body></html>");
            }
        }
    }
    //</editor-fold>
    
    /**
     * A threaded class that saves global notes.
     */
    //<editor-fold defaultstate="collapsed" desc="SaveGlobalNotes">
    public class SaveGlobalNotes extends Thread {
        
        @Override
        public void run () {
            
            setCursor (new Cursor (Cursor.WAIT_CURSOR));
            
            final String PHP_URL_S = "http://localhost/logFarm/PHP/StalkerDbPhp/updateGlobalNotes.php";
                
            Map<String, String> ARGUMENTS = new HashMap<>();

            ARGUMENTS.put("notes", globalNotesText.getText());

            phpConnection(
                    PHP_URL_S,
                    ARGUMENTS,
                    STATE.getCurrentState(),
                    Boolean.TRUE,
                    Boolean.FALSE,
                    POST,
                    DEFAULT);
            
            setCursor (new Cursor (Cursor.DEFAULT_CURSOR));
        }
    }
    //</editor-fold>
}
