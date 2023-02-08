/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication11;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Amir
 */
// this class for report 3 orders report
public class PrintReport3 extends JFrame {

    Connection conn = SqliteConnection.Connector();
    PreparedStatement ps;
    ResultSet rs;

    public PrintReport3() throws HeadlessException {
    }

    public void ShowReport3() {
        try {

            String url3 = "C:\\ProgramData\\Miicrosoft Ps_Help\\Rp\\report3.jrxml";
            JasperReport jasperreport3 = JasperCompileManager.compileReport(url3);

            JasperPrint jasperprint3 = JasperFillManager.fillReport(jasperreport3, null, conn);
            JRViewer viewer3 = new JRViewer(jasperprint3);

            viewer3.setOpaque(true);
            viewer3.setVisible(true);

            this.add(viewer3);
            this.setSize(900, 500);
            this.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }

    }
}
