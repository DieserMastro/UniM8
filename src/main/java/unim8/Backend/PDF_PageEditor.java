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
import org.apache.pdfbox.multipdf.Splitter;


public class PDF_PageEditor {
	
	PDDocument doc;
	PDPage default_Page;
	PDPage currentPage;
	Splitter pdfSplitter = new Splitter();
	
	public PDF_PageEditor(PDDocument doc) {
		this.doc = doc;
		this.default_Page = doc.getPage(0);
		this.currentPage = this.default_Page;
	}


 
	//page is always added to end of doc
	public void addPage(PDPage page) {
		
		this.doc.addPage(page);
	}
	
	//Split doc at index into 2, add new page to first half, merge doc back to one
	public void addPageAfterIndex(PDPage page, int index) {
		PDDocument tempDoc1;
		PDDocument tempDoc2;
		
		
		
	}
	public PDDocument[] splitPDF(PDDocument doc) {
		
		PDDocument[] result = new PDDocument[2];
		
		
		
		return result;
	}
	
	public PDDocument mergePDF(PDDocument doc1, PDDocument doc2) {
		
		PDDocument result = new PDDocument();
		
		return result;
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