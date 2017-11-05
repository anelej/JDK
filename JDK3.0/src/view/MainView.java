package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import action.AutoAdjustAction;
import action.BrightnessAction;
import action.ContrastAction;
import action.FisheyeAction;
import action.GrayscaleAction;
import action.NegativeAction;
import action.PaintingAction;
import action.ReflectionAction;
import action.SharpenAction;
import action.VignetteAction;

import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class MainView extends JFrame {
	JPanel panelSlika = new JPanel();
	JPanel toolBarPanel = new JPanel();

	public MainView() {
		setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1100, 500);
		this.setTitle("Photo Editor by JDK");
		this.setLocationRelativeTo(null);

		getContentPane().setLayout(new BorderLayout(0, 0));
		JMenuBar menuBar = new JMenuBar();
		getContentPane().add(menuBar, BorderLayout.NORTH);

		JMenu fixImg = new JMenu("Fix image");
		menuBar.add(fixImg);
		fixImg.add(new ContrastAction());
		fixImg.add(new SharpenAction());
		fixImg.add(new AutoAdjustAction());
		fixImg.add(new BrightnessAction());

		// JMenuItem mntmContrast = new JMenuItem("Contrast");
		// mnFixImage.add(mntmContrast);
		//
		// JMenuItem menuItem = new JMenuItem("");
		// mnFixImage.add(menuItem);

		JMenu returnToChild = new JMenu("Return to childhood");
		menuBar.add(returnToChild);

		getContentPane().add(toolBarPanel, BorderLayout.WEST);

		JToolBar toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		toolBarPanel.add(toolBar);

		JButton btnNegative = new JButton("Negative");
		toolBar.add(btnNegative);
		btnNegative.addActionListener(new NegativeAction());

		JButton btnGrayscale = new JButton("Grayscale");
		toolBar.add(btnGrayscale);
		btnGrayscale.addActionListener(new GrayscaleAction());

		JButton btnVignette = new JButton("Vignette");
		toolBar.add(btnVignette);
		btnVignette.addActionListener(new VignetteAction());

		JButton btnPainting = new JButton("Painting");
		toolBar.add(btnPainting);
		btnPainting.addActionListener(new PaintingAction());

		JButton btnFisheye = new JButton("Fisheye");
		toolBar.add(btnFisheye);
		btnFisheye.addActionListener(new FisheyeAction());

		JButton btnReflection = new JButton("Reflection");
		toolBar.add(btnReflection);
		btnReflection.addActionListener(new ReflectionAction());

		getContentPane().add(panelSlika, BorderLayout.CENTER);
		
		//u ovaj panel dodajes glavnu sliku na kojoj ce se raditi... prvo cemo je samo ubaciti
		//posle cemo da dodamo file chooser da se bira slike na kojoj ce se raditi
		//ynaci ovde ucitas sliku i onda u klasama ...Action => one su akcije za dugmice efekata 
		// u toj klasi pokupis sliku sa panela i editujes je. 
		// mainView.slikaPanel.getimage .. recimo, lupila sam sad 
		this.setVisible(true);
	}

	public JPanel getPanelSlika() {
		return panelSlika;
	}

	public void setPanelSlika(JPanel panelSlika) {
		this.panelSlika = panelSlika;
	}

	public JPanel getToolBarPanel() {
		return toolBarPanel;
	}

	public void setToolBarPanel(JPanel toolBarPanel) {
		this.toolBarPanel = toolBarPanel;
	}
	

}
