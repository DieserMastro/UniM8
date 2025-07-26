package unim8.Backend;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import org.icepdf.core.exceptions.PDFSecurityException;
import org.icepdf.core.pobjects.Document;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import org.icepdf.ri.common.views.DocumentViewControllerImpl;
import org.icepdf.ri.common.views.DocumentViewModel;


public class PDF_Viewer {
	
	Document iceDoc =  new Document();
	//SpellCheckLoader spellChecker;			//Error messages kept telling me that this is necessary. That was a lie.
	public SwingController controller = new SwingController();	
	JPanel viewerComponentPanel;
	SwingViewBuilder factory;
	
	Path defaultPath;
	public PDF_Viewer() {
		
		
	}
	public void initialize() {
		
		//spellChecker = new SpellCheckLoader();
		this.defaultPath = Path.of("C:\\Users\\sinan\\Desktop\\HTW\\Info3\\Unim8_Project\\Tests\\chicken.pdf");
		controller.setIsEmbeddedComponent(true);
	    this.factory = new SwingViewBuilder(controller);
	    this.viewerComponentPanel = factory.buildViewerPanel();
	    controller.setPageViewMode(DocumentViewControllerImpl.ONE_COLUMN_VIEW, true);
	    controller.getDocumentViewController().setAnnotationCallback(
	            new org.icepdf.ri.common.MyAnnotationCallback(
	                    controller.getDocumentViewController()));
	    
	}
	
    public void viewPDF(Path pdf) throws IOException {
	   String pdfPath = pdf.toFile().getAbsolutePath();
	   File temp = new File(pdfPath);
		try {
			iceDoc.setFile(temp.getAbsolutePath());
		} catch (PDFSecurityException e) {
			System.out.println("PDF Security access issue detected.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("I/O error");
			e.printStackTrace();
		}
	   try {
		controller.openDocument(pdfPath);
		setToolModeToDefault();
	   } catch (Exception e) {
		System.out.println(pdfPath);
	   }
   }
   
   public Document getCurrentDocumentICEdoc() {
	   return this.iceDoc;
   }
   public Path getCurrentDocumentFilePath() {
	   Path path = Path.of(this.iceDoc.getDocumentOrigin());
	   return path;
   }
   public void setCurrentDocument(Document doc) {
	   this.iceDoc = doc;
   }
   public JPanel getJPanel() {
	   return this.viewerComponentPanel;
   }
   public void printCommand() {
	   controller.actionPerformed(null);
   }
   //This removes clutter from the GUI
   public void cleanUp() {
	   //Don't change the indexes, deleting by component name is too much of a pain in the ass. This does what I need.
	   JToolBar toolbar = (JToolBar) this.viewerComponentPanel.getComponent(0);
	   
	   toolbar.remove(0);
	   toolbar.remove(0);
	   toolbar.remove(4);
	   toolbar.remove(4);
	   toolbar.remove(4);

	   
	   toolbar.revalidate();
	   toolbar.repaint();

   }
   //Useless for now, cant find a good way to do it properly using ICEpdf tools.
   /*private void customizeToolBar(JToolBar toolbar) {
	   
	   
	   addToToolBar(toolbar, factory.buildZoomToolBar());
	   addToToolBar(toolbar, factory.buildFullScreenMenuItem());
	   addToToolBar(toolbar, factory.buildFitToolBar());
	   addToToolBar(toolbar, factory.buildRotateToolBar());
	   addToToolBar(toolbar, factory.buildOutlineComponents());

   }*/
   protected void addToToolBar(JToolBar toolbar, JComponent comp) {
       if (comp != null) {
           toolbar.add(comp);
           toolbar.revalidate();
           toolbar.repaint();
       }
       else
    	   System.out.println("failed to add component");;
   }
   
   public SwingController getController() {
	   return this.controller;
   }
   //Necessary either here or in initialization. ICEpdf relies on a weird toggle to enable selecting text, which i didn't like. 
   private void setToolModeToDefault() {
	   this.controller.setDocumentToolMode(DocumentViewModel.DISPLAY_TOOL_TEXT_SELECTION);
   }
}
