package unim8.Backend;

import java.nio.file.*;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.icepdf.core.exceptions.PDFSecurityException;
import org.icepdf.core.pobjects.Document;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

public class PDF_Viewer {
	
	Document iceDoc =  new Document();
	SwingController controller = new SwingController();
	Path defaultPath;
	
	public PDF_Viewer() {
		
		this.defaultPath = Path.of("C:\\Users\\sinan\\Desktop\\HTW\\Info3\\Unim8_Project\\Tests\\chicken.pdf");
		controller.setIsEmbeddedComponent(true);
	    SwingViewBuilder factory = new SwingViewBuilder(controller);
	    JPanel viewerComponentPanel = factory.buildViewerPanel();
	    JFrame frame = new JFrame("ICEpdf Viewer");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().add(viewerComponentPanel);
	    frame.pack();
	    frame.setVisible(true);
	}
	
   public void viewPDF(Path pdf) throws IOException {
	   String pdfPath = pdf.toFile().getAbsolutePath();
	   File temp = new File(pdfPath);
		try {
			iceDoc.setFile(temp.getAbsolutePath());
		} catch (PDFSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   try {
		controller.openDocument(pdfPath);
	   } catch (Exception e) {
		System.out.println(pdfPath);
	   }
   }
   
   public Document getCurrentDocument() {
	   return this.iceDoc;
   }
   public void setCurrentDocument(Document doc) {
	   this.iceDoc = doc;
   }
   
}
