package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {
	public MainView() {
		getContentPane().setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(0, 0, 842, 493);
		getContentPane().add(splitPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		splitPane.setLeftComponent(toolBar);
		
		JLabel lblChooseAnEffect = new JLabel("Choose an effect:");
		toolBar.add(lblChooseAnEffect);
		
		JButton btnNewButton = new JButton("Negative");
		toolBar.add(btnNewButton);
		
		JButton btnGrayscale = new JButton("Grayscale");
		toolBar.add(btnGrayscale);
		
		JButton btnVignette = new JButton("Vignette");
		toolBar.add(btnVignette);
		
		JButton btnReflection = new JButton("Reflection");
		toolBar.add(btnReflection);
		
		JButton btnPainting = new JButton("Painting");
		toolBar.add(btnPainting);
		
		JButton btnFisheye = new JButton("Fisheye");
		btnFisheye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		toolBar.add(btnFisheye);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator);
		
		JMenuBar menuBar = new JMenuBar();
		toolBar.add(menuBar);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);
		
		JToolBar toolBar_1 = new JToolBar();
		splitPane_1.setLeftComponent(toolBar_1);
		
		JButton btnGame = new JButton("Click to return to childhood");
		btnGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		toolBar_1.add(btnGame);
	}
	private JPanel panel; 

}
