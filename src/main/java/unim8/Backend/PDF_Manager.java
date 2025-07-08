package unim8.Backend;

import java.awt.image.BufferedImage;
import java.nio.file.*;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font; 
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.icepdf.core.exceptions.PDFSecurityException;
import org.icepdf.core.pobjects.Document;
import org.icepdf.core.util.GraphicsRenderingHints;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

public class PDF_Manager {
	
	// Main-class: 
	public static void main(String[] args) throws IOException {
		
		File_Manager fileManager = new File_Manager();
		PDF_Viewer viewer = new PDF_Viewer();
		
		//fileManager.printPath();
		//fileManager.openDesktopDirectory();
		//fileManager.chooseNewDirectory();
		Path currentFile = fileManager.chooseFile();
		
		//added:
		viewer.initialize();
		
		viewer.viewPDF(currentFile);
		
		//added:
		 JFrame frame = new JFrame("ICEpdf Viewer");
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.getContentPane().add(viewer.getJPanel());
		 frame.setSize(800, 600);
		 frame.setVisible(true);
		
		/*
		//So far, this creates an empty pdf in the predetermined path
		File oldFile = new File("C:\\Users\\sinan\\Desktop\\temp\\TestFolder\\currentLP.pdf");
		PDDocument document = Loader.loadPDF(oldFile, "");
		document.setAllSecurityToBeRemoved(true);
		PDPage page_1 = new PDPage();
		
		document.addPage(page_1);
		
		
		/*PDFTextStripper stripper = new PDFTextStripper();
		String docContent = stripper.getText(document);
		System.out.println(docContent);*/
		//testViewPDF();
		
		
		
		
		
		
		/*
		try {
			document.save("C:\\Users\\sinan\\Desktop\\temp\\TestFolder\\Test2.pdf");
			System.out.println("File saved Successfully");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("File saved Successfully");
		///
		 
		document.close();
		*/
	}
	/*public static void testViewPDF() {
		Document iceDoc =  new Document();
		
		String testFilePath = "C:\\Users\\sinan\\Desktop\\HTW\\Info3\\Unim8_Project\\Tests\\chicken.pdf";
		File temp = new File(testFilePath);
		try {
			iceDoc.setFile(temp.getAbsolutePath());
		} catch (PDFSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SwingController controller = new SwingController();
        controller.setIsEmbeddedComponent(true);
        SwingViewBuilder factory = new SwingViewBuilder(controller);
        JPanel viewerComponentPanel = factory.buildViewerPanel();
        JFrame frame = new JFrame("ICEpdf Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(viewerComponentPanel);
        frame.pack();
        frame.setVisible(true);
		
        controller.openDocument(testFilePath);
	}*/
}