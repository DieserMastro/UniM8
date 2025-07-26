package unim8.Backend;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.text.PDFTextStripper;


//Class currently does nothing useful. 
public class PDF_TextEditor {
	
	PDDocument doc;
	PDFTextStripper stripper = new PDFTextStripper();
	PDPage default_Page = doc.getPage(0);
	PDPage currentPage = default_Page;
	
	
	public String extractText() {
		String docText = "If this text shows, something went wrong! :(";
		try {
			docText = stripper.getText(doc);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Text extraction failed :(");
		}
		
		return docText;
	}
	
	public void addText(String text) {
		try {
			PDPageContentStream contentStream = new PDPageContentStream(doc, currentPage);
			
			
			//when done
			contentStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("contentStream init failed");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public PDF_TextEditor(PDDocument doc) {
		this.doc = doc;
	}
	public PDDocument getPDDoc() {
		return this.doc;
	}
	public void setPDDoc(PDDocument doc) {
		this.doc = doc;
	}
	public PDPage getPage() {
		return currentPage;
	}
	public PDPage getPage(int index) {
		return doc.getPage(index);
	}
	public void setPage(PDPage page) {
		this.currentPage = page;
	}
	
	
	
	
}
