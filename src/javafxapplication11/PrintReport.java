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
// this class for report 1 devices report
public class PrintReport extends JFrame {

    Connection conn = SqliteConnection.Connector();
    PreparedStatement ps;
    ResultSet rs;

    public PrintReport() throws HeadlessException {
    }

    public void ShowReport() {
        try {

            String url = "C:\\ProgramData\\Miicrosoft Ps_Help\\Rp\\report1.jrxml";
            JasperReport jasperreport = JasperCompileManager.compileReport(url);

            JasperPrint jasperprint = JasperFillManager.fillReport(jasperreport, null, conn);
            JRViewer viewer = new JRViewer(jasperprint);

            viewer.setOpaque(true);
            viewer.setVisible(true);

            this.add(viewer);
            this.setSize(900, 500);
            this.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }

    }
}
