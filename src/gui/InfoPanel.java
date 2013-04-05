/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import core.Duplex;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Skeptical_Tech
 */
public class InfoPanel extends javax.swing.JPanel {
    //An array list of Duplexed Strings; yes, it's ugly :P

    private ArrayList<Duplex<String, String>> authors = new ArrayList<>();
    private ArrayList<Duplex<String, String>> contributors = new ArrayList<>();
    private ArrayList<String> rules = new ArrayList<>();
    //List Model
    DefaultListModel<String> authormodel = new DefaultListModel<>();

    /**
     * Creates new form InfoPanel
     */
    public InfoPanel() {
        initComponents();
    }

    //Gets and sets
    public String getNameField() {
        return NameField.getText();
    }

    public void setNameField(String txt) {
        NameField.setText(txt);
    }

    public String getPGMVersionField() {
        return PGMVersionField.getText();
    }

    public void setPGMVersionField(String txt) {
        PGMVersionField.setText(txt);
    }

    public String getVersionField() {
        return VersionField.getText();
    }

    public void setVersionField(String txt) {
        VersionField.setText(txt);
    }

    public String getObjectiveField() {
        return ObjectiveField.getText();
    }

    public void setObjectiveField(String txt) {
        ObjectiveField.setText(txt);
    }

    public void updateAuthorList() {
        AuthorList.removeAll(); //Clear list
        for (Duplex<String, String> dup : authors) {
            authormodel.addElement(dup.getFirst());
        }
    }
    /*
     * Input Dialog Methods and Variables
     */
    private int dialog_mode = 0; // = 0 author, 1 for contributor, 2 for rule
    private boolean dialog_edit; // = true for edit mode, false for add mode

    private void displayDialog(int mode, boolean edit) {
        InputDialog.setLocationRelativeTo(this);
        InputDialogLabel2.setVisible(true);
        InputDialogField2.setVisible(true);
        switch (mode) {
            case 0: //Author
                InputDialogLabel1.setText("Author:");
                InputDialogLabel2.setText("Contribution:");
                break;
            case 1: //Contributor
                InputDialogLabel1.setText("Contributor:");
                InputDialogLabel2.setText("Contribution:");
                break;
            case 2: //Rule
                InputDialogLabel1.setText("Rule:");
                InputDialogLabel2.setVisible(false);
                InputDialogField2.setVisible(false);
                break;

        }
        if (edit) {
            Ok.setText(edit ? "Edit" : "False");
        }
        InputDialog.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InputDialog = new javax.swing.JDialog();
        InputDialogField1 = new javax.swing.JTextField();
        InputDialogField2 = new javax.swing.JTextField();
        InputDialogLabel1 = new javax.swing.JLabel();
        InputDialogLabel2 = new javax.swing.JLabel();
        Ok = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        BasicPanel = new javax.swing.JPanel();
        AuthorPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        AuthorList = new javax.swing.JList(authormodel);
        AddAuthorButton = new javax.swing.JButton();
        RemoveAuthorButton = new javax.swing.JButton();
        EditAuthorButton = new javax.swing.JButton();
        NamePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        PGMVerPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        PGMVersionField = new javax.swing.JTextField();
        VersionPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        VersionField = new javax.swing.JTextField();
        ObjectivePanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ObjectiveField = new javax.swing.JTextArea();

        InputDialog.setMinimumSize(new java.awt.Dimension(400, 150));
        InputDialog.setModal(true);
        InputDialog.setResizable(false);

        InputDialogField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputDialogField1ActionPerformed(evt);
            }
        });

        InputDialogField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputDialogField2ActionPerformed(evt);
            }
        });

        InputDialogLabel1.setText("Author:");

        InputDialogLabel2.setText("Contribution:");

        Ok.setText("Add");
        Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkActionPerformed(evt);
            }
        });

        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout InputDialogLayout = new javax.swing.GroupLayout(InputDialog.getContentPane());
        InputDialog.getContentPane().setLayout(InputDialogLayout);
        InputDialogLayout.setHorizontalGroup(
            InputDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InputDialogLayout.createSequentialGroup()
                .addGroup(InputDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InputDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(InputDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(InputDialogLabel2)
                            .addComponent(InputDialogLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InputDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(InputDialogField1)
                            .addComponent(InputDialogField2, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)))
                    .addGroup(InputDialogLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(Ok)
                        .addGap(64, 64, 64)
                        .addComponent(Cancel)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        InputDialogLayout.setVerticalGroup(
            InputDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InputDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InputDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InputDialogLabel1)
                    .addComponent(InputDialogField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InputDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InputDialogLabel2)
                    .addComponent(InputDialogField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(InputDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ok)
                    .addComponent(Cancel))
                .addContainerGap())
        );

        setMinimumSize(new java.awt.Dimension(700, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BasicPanel.setLayout(new java.awt.GridBagLayout());
        add(BasicPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 5, -1, -1));

        jLabel5.setText("Authors");

        AuthorList.setFixedCellHeight(200);
        AuthorList.setVisibleRowCount(4);
        jScrollPane3.setViewportView(AuthorList);

        AddAuthorButton.setText("Add");
        AddAuthorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAuthorButtonActionPerformed(evt);
            }
        });

        RemoveAuthorButton.setText("Edit");
        RemoveAuthorButton.setEnabled(false);
        RemoveAuthorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveAuthorButtonActionPerformed(evt);
            }
        });

        EditAuthorButton.setText("Remove");
        EditAuthorButton.setEnabled(false);
        EditAuthorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditAuthorButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AuthorPanelLayout = new javax.swing.GroupLayout(AuthorPanel);
        AuthorPanel.setLayout(AuthorPanelLayout);
        AuthorPanelLayout.setHorizontalGroup(
            AuthorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AuthorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(AuthorPanelLayout.createSequentialGroup()
                    .addComponent(AddAuthorButton)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(RemoveAuthorButton)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(EditAuthorButton)
                    .addGap(57, 57, 57)))
            .addGroup(AuthorPanelLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel5))
        );
        AuthorPanelLayout.setVerticalGroup(
            AuthorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AuthorPanelLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(AuthorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RemoveAuthorButton)
                    .addComponent(AddAuthorButton)
                    .addComponent(EditAuthorButton)))
        );

        add(AuthorPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        jLabel1.setText("Name:");
        NamePanel.add(jLabel1);

        NameField.setColumns(28);
        NameField.setText("New Map");
        NameField.setToolTipText("The name of the map.");
        NameField.setMinimumSize(new java.awt.Dimension(150, 22));
        NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameFieldActionPerformed(evt);
            }
        });
        NamePanel.add(NameField);

        add(NamePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 34));

        PGMVerPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel3.setText("PGM Version:");
        PGMVerPanel.add(jLabel3);

        PGMVersionField.setColumns(4);
        PGMVersionField.setText("1.3.0");
        PGMVersionField.setToolTipText("The Plugin Version (Currently 1.3.0).");
        PGMVerPanel.add(PGMVersionField);

        add(PGMVerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 34));

        jLabel2.setText("Map Version:");
        VersionPanel.add(jLabel2);

        VersionField.setColumns(4);
        VersionField.setText("1.0");
        VersionField.setToolTipText("The version of the map");
        VersionPanel.add(VersionField);

        add(VersionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, 34));

        ObjectivePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel4.setText("Objective:");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        ObjectivePanel.add(jLabel4);

        ObjectiveField.setColumns(26);
        ObjectiveField.setRows(2);
        jScrollPane1.setViewportView(ObjectiveField);

        ObjectivePanel.add(jScrollPane1);

        add(ObjectivePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 370, 48));
    }// </editor-fold>//GEN-END:initComponents

    private void NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameFieldActionPerformed

    private void EditAuthorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditAuthorButtonActionPerformed
        if (AuthorList.getSelectedIndex() != -1) {
            displayDialog(0, true);
        }
    }//GEN-LAST:event_EditAuthorButtonActionPerformed

    private void RemoveAuthorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveAuthorButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RemoveAuthorButtonActionPerformed

    private void AddAuthorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAuthorButtonActionPerformed
        displayDialog(0, false);
    }//GEN-LAST:event_AddAuthorButtonActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        InputDialog.setVisible(false);
        InputDialogField1.setText("");
        InputDialogField2.setText("");
        InputDialogLabel1.setText("");
        InputDialogLabel2.setText("");
    }//GEN-LAST:event_CancelActionPerformed

    private void InputDialogField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputDialogField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputDialogField2ActionPerformed

    private void InputDialogField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputDialogField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputDialogField1ActionPerformed

    private void OkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkActionPerformed
        if (InputDialogField1.getText() != "") {
            if (dialog_mode == 2) { //Rule mode
                if (dialog_edit == true) {
                    //TODO
                } else {
                    //TODO
                }
            } else { //It's an author or contributor
                Duplex<String, String> tempdup = new Duplex<>(InputDialogField1.getText(), InputDialogField2.getText());
                //Generate reference to the appropriate ArrayList and JList
                ArrayList<Duplex<String, String>> arraydup;
                JList tempList;
                if (dialog_mode == 0) { //Author
                    arraydup = authors;
                    tempList = AuthorList;
                } else {
                    arraydup = contributors;
                    tempList = AuthorList; //TODO, fix when contributor panel added
                }
                //Now check if in edit mode
                if (dialog_edit) {
                    arraydup.set(tempList.getSelectedIndex(), tempdup);
                } else {
                    arraydup.add(tempdup);
                }
                updateAuthorList();
            }
            //Now determine which 
        }

    }//GEN-LAST:event_OkActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddAuthorButton;
    private javax.swing.JList AuthorList;
    private javax.swing.JPanel AuthorPanel;
    private javax.swing.JPanel BasicPanel;
    private javax.swing.JButton Cancel;
    private javax.swing.JButton EditAuthorButton;
    private javax.swing.JDialog InputDialog;
    private javax.swing.JTextField InputDialogField1;
    private javax.swing.JTextField InputDialogField2;
    private javax.swing.JLabel InputDialogLabel1;
    private javax.swing.JLabel InputDialogLabel2;
    private javax.swing.JTextField NameField;
    private javax.swing.JPanel NamePanel;
    private javax.swing.JTextArea ObjectiveField;
    private javax.swing.JPanel ObjectivePanel;
    private javax.swing.JButton Ok;
    private javax.swing.JPanel PGMVerPanel;
    private javax.swing.JTextField PGMVersionField;
    private javax.swing.JButton RemoveAuthorButton;
    private javax.swing.JTextField VersionField;
    private javax.swing.JPanel VersionPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
