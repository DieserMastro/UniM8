package unim8.Backend;

import java.io.Console;
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
