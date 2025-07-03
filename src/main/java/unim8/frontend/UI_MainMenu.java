package unim8.frontend;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

public class UI_MainMenu {
	
	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem newMenuItem;
	private JMenuItem saveJMenuItem;
	private JMenuItem exitJMenuItem;
	
	public UI_MainMenu() {
		initialize();
		
	}
	private void initialize() {
		this.frame = new JFrame("UniM8");
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.pack();
		frame.setLayout(new BorderLayout(10, 10));
		frame.setLocationRelativeTo(null);
		
		Font font = new Font("sans-serif", Font.PLAIN, 18);
		UIManager.put("Menu.font", font);
		UIManager.put("MenuItem.font", font);
		UIManager.put("CheckBoxMenuItem.font", font);
		UIManager.put("RadioButtonMenuItem.font", font);
		
		this.menuBar = new JMenuBar();
		this.fileMenu = new JMenu("File");
		this.newMenuItem = new JMenuItem("New");
		this.saveJMenuItem = new JMenuItem("Save");
		this.exitJMenuItem = new JMenuItem("Exit");
		
		fileMenu.add(newMenuItem);
		fileMenu.add(saveJMenuItem);
		fileMenu.add(exitJMenuItem);
		
	}

}
