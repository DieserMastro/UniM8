package unim8.Backend;

import java.nio.file.*;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.io.File;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import org.icepdf.core.exceptions.PDFSecurityException;
import org.icepdf.core.pobjects.Document;

import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import org.icepdf.ri.common.views.annotations.SpellCheckLoader;
import org.icepdf.ri.util.ViewerPropertiesManager;

public class PDF_Viewer {
	
	Document iceDoc =  new Document();
	//SpellCheckLoader spellChecker;
	SwingController controller = new SwingController();	
	JPanel viewerComponentPanel;
	SwingViewBuilder factory;
	
	Path defaultPath;
	public PDF_Viewer() {
		
		
	}
	/*public void initialize() {
		
		//spellChecker = new SpellCheckLoader();
		this.defaultPath = Path.of("C:\\Users\\sinan\\Desktop\\HTW\\Info3\\Unim8_Project\\Tests\\chicken.pdf");
		controller.setIsEmbeddedComponent(true);
	    this.factory = new SwingViewBuilder(controller);
	    this.viewerComponentPanel = factory.buildViewerPanel();
	    
	}*/
	//TEST:
	public void initialize() {
	    // Log initialization progress
	    System.out.println("Initializing PDF Viewer...");

	    // Ensure the controller is correctly initialized
	    controller.setIsEmbeddedComponent(true);
	    System.out.println("SwingController initialized");

	    // Now create the SwingViewBuilder
	    this.factory = new SwingViewBuilder(controller);
	    if (this.factory == null) {
	        System.out.println("SwingViewBuilder creation failed");
	    } else {
	        System.out.println("SwingViewBuilder created successfully");
	    }

	    // Attempt to create the viewer panel
	    this.viewerComponentPanel = factory.buildViewerPanel();
	    if (this.viewerComponentPanel == null) {
	        System.out.println("viewerComponentPanel is null after creation");
	    } else {
	        System.out.println("viewerComponentPanel created successfully");
	    }
	}

	
    /* public void viewPDF(Path pdf) throws IOException {
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
   } */
	
	// TEST:
	public void viewPDF(Path pdf) throws IOException {
	    String pdfPath = pdf.toFile().getAbsolutePath();
	    File temp = new File(pdfPath);
	    try {
	        iceDoc.setFile(temp.getAbsolutePath());
	    } catch (PDFSecurityException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    // Ensure the viewer component panel is not null
	    if (viewerComponentPanel == null) {
	        System.out.println("viewerComponentPanel is null. Cannot proceed.");
	        return; // Exit or handle appropriately
	    }

	    try {
	        controller.openDocument(pdfPath);
	    } catch (Exception e) {
	        System.out.println("Failed to open document: " + pdfPath);
	        e.printStackTrace();  // More details in case of failure
	    }
	}
   
   public Document getCurrentDocument() {
	   return this.iceDoc;
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
   
   public void cleanUp() {
	   //Dont chance the indexes, deleting by component name is too much of a pain in the ass
	   JToolBar toolbar = (JToolBar) this.viewerComponentPanel.getComponent(0);
	   
	   toolbar.remove(0);
	   toolbar.remove(0);
	   toolbar.remove(4);
	   toolbar.remove(4);
	   toolbar.remove(4);

	   
	   toolbar.revalidate();
	   toolbar.repaint();

   }
   //Useless for now
   private void customizeToolBar(JToolBar toolbar) {
	   
	   
	   addToToolBar(toolbar, factory.buildZoomToolBar());
	   addToToolBar(toolbar, factory.buildFullScreenMenuItem());
	   addToToolBar(toolbar, factory.buildFitToolBar());
	   addToToolBar(toolbar, factory.buildRotateToolBar());
	   addToToolBar(toolbar, factory.buildOutlineComponents());

   }
   protected void addToToolBar(JToolBar toolbar, JComponent comp) {
       if (comp != null) {
           toolbar.add(comp);
           toolbar.revalidate();
           toolbar.repaint();
       }
       else
    	   System.out.println("failed to add component");;
   }
}
