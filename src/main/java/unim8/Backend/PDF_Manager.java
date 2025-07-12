package unim8.Backend;

import java.io.IOException;
import java.nio.file.Path;

public class PDF_Manager {
	
	public static void main(String[] args) throws IOException {
		
		
		File_Manager fileManager = new File_Manager();
		PDF_Viewer viewer = new PDF_Viewer();
		//fileManager.printPath();
		//fileManager.openDesktopDirectory();
		//fileManager.chooseNewDirectory();
		Path currentFile = fileManager.chooseFile();
		viewer.viewPDF(currentFile);
		
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