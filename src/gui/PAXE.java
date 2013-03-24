/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import core.*;
import java.io.File;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PAXE extends javax.swing.JFrame {

    public static final String version = "0.1.0";
    public static final String program_name = "PAXE";
    public Map curMap;

    /**
     * Creates new form PAXE
     */
    public PAXE() {
        //Make a new map (for now, will be changed to load from saved, etc)
        curMap = new Map();
        this.setTitle("PAXE v " + PAXE.version);
        initComponents();
    }

    public void updateMapObj() {
        curMap.setName(infoPanel2.getNameField());
        curMap.setPGMVersion(infoPanel2.getPGMVersionField());
        curMap.setVersion(infoPanel2.getVersionField());
        curMap.setObjective(infoPanel2.getObjectiveField());
    }

    public void load(File file) {
    }

    public void save(File file) {
        updateMapObj();
        String serialized = "<!--This is not the Map.xml. This is just PAXE's special save format -->\n";
        serialized += curMap.serializeXml();
        try {
            PrintWriter pw = new PrintWriter(file);
            pw.print(serialized);
            pw.close();
        } catch (Exception e) {
            System.out.println("Unable to save");
        }
    }

    public void runExport() {
        updateMapObj();
        curMap.output("output.xml");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        infoPanel2 = new gui.InfoPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemNew = new javax.swing.JMenuItem();
        jMenuItemOpen = new javax.swing.JMenuItem();
        jMenuItemSave = new javax.swing.JMenuItem();
        jMenuItemSaveAs = new javax.swing.JMenuItem();
        jMenuItemExport = new javax.swing.JMenuItem();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jTabbedPane1.addTab("tab1", infoPanel2);

        getContentPane().add(jTabbedPane1);

        jMenu1.setText("File");

        jMenuItemNew.setText("New");
        jMenuItemNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNewActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemNew);

        jMenuItemOpen.setText("Open");
        jMenuItemOpen.setEnabled(false);
        jMenuItemOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemOpen);

        jMenuItemSave.setText("Save");
        jMenuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSave);

        jMenuItemSaveAs.setText("Save As");
        jMenuItemSaveAs.setEnabled(false);
        jMenu1.add(jMenuItemSaveAs);

        jMenuItemExport.setText("Export to Map.xml");
        jMenuItemExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExportActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemExport);

        jMenuItemExit.setText("Exit");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemOpenActionPerformed

    private void jMenuItemNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemNewActionPerformed

    private void jMenuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveActionPerformed
        final JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("PAXE Files (*.pxl)", "pxl"));
        if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            if (!file.getPath().toLowerCase().endsWith(".pxl")) {
                file = new File(file.getPath() + ".pxl");
            }
            save(file);
        }
    }//GEN-LAST:event_jMenuItemSaveActionPerformed

    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
        System.exit(0); //TODO: Make this more sensible, check if save neccesary
    }//GEN-LAST:event_jMenuItemExitActionPerformed

    private void jMenuItemExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExportActionPerformed
        runExport();
    }//GEN-LAST:event_jMenuItemExportActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PAXE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PAXE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PAXE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PAXE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PAXE().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.InfoPanel infoPanel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemExport;
    private javax.swing.JMenuItem jMenuItemNew;
    private javax.swing.JMenuItem jMenuItemOpen;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JMenuItem jMenuItemSaveAs;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}