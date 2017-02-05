package tn.cni.mbean;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@ManagedBean
@SessionScoped
public class InitPageBean {

	public String viewReportPDF() throws SQLException, JRException, IOException {
		String reportId = "Fournisseur";
		Driver mDriver = new Driver();
		DriverManager.registerDriver(mDriver);
		String url = new String("jdbc:mysql://localhost:3306/cniproject");
		Connection connection = (Connection) DriverManager.getConnection(
				url,
				"root",
				"root");
		File file = new File("C:/Users/hasna/Desktop/report1");
		JasperPrint jasperPrint = JasperFillManager.fillReport(
				new FileInputStream(new File(file, reportId + ".jasper")),
				null, connection);
		byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
		/***********************************************************************
                 * Pour afficher une boîte de dialogue pour enregistrer le fichier sous
                 * le nom rapport.pdf
                 **********************************************************************/
		response.addHeader("Content-disposition",
				"inline;filename=rapport1.pdf");
		response.setContentLength(bytes.length);
		response.getOutputStream().write(bytes);
		response.setContentType("application/pdf");
		context.responseComplete();
		return null;
}
	public String viewpReportPDF() throws SQLException, JRException, IOException {
		String reportId = "Projet";
		Driver mDriver = new Driver();
		DriverManager.registerDriver(mDriver);
		String url = new String("jdbc:mysql://localhost:3306/cniproject");
		Connection connection = (Connection) DriverManager.getConnection(
				url,
				"root",
				"root");
		File file = new File("C:/Users/hasna/Desktop/reportp");
		JasperPrint jasperPrint = JasperFillManager.fillReport(
				new FileInputStream(new File(file, reportId + ".jasper")),
				null, connection);
		byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
		/***********************************************************************
                 * Pour afficher une boîte de dialogue pour enregistrer le fichier sous
                 * le nom rapport.pdf
                 **********************************************************************/
		response.addHeader("Content-disposition",
				"inline;filename=rapport.pdf");
		response.setContentLength(bytes.length);
		response.getOutputStream().write(bytes);
		response.setContentType("application/pdf");
		context.responseComplete();
		return null;
}
}
