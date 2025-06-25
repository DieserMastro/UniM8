package unim8.Backend;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font; 
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.io.MemoryUsageSetting;

public class PDF_Manager {
	
	public static void main(String[] args) throws IOException {
		
		
		
		//So far, this creates an empty pdf in the predetermined path
		File oldFile = new File("C:\\Users\\sinan\\Desktop\\temp\\TestFolder\\currentLP.pdf");
		PDDocument document = Loader.loadPDF(oldFile, "");
		document.setAllSecurityToBeRemoved(true);
		PDPage page_1 = new PDPage();
		
		document.addPage(page_1);
		
		
		/*PDFTextStripper stripper = new PDFTextStripper();
		String docContent = stripper.getText(document);
		System.out.println(docContent);*/
		
		
		
		
		
		
		
		
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
	}
}