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
// this class for report 2 drinks report
public class PrintReport2 extends JFrame {

    Connection conn = SqliteConnection.Connector();
    PreparedStatement ps;
    ResultSet rs;

    public PrintReport2() throws HeadlessException {
    }

    public void ShowReport2() {
        try {

            String url2 = "C:\\ProgramData\\Miicrosoft Ps_Help\\Rp\\report2.jrxml";
            JasperReport jasperreport2 = JasperCompileManager.compileReport(url2);

            JasperPrint jasperprint2 = JasperFillManager.fillReport(jasperreport2, null, conn);
            JRViewer viewer2 = new JRViewer(jasperprint2);

            viewer2.setOpaque(true);
            viewer2.setVisible(true);

            this.add(viewer2);
            this.setSize(900, 500);
            this.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }

    }
}
