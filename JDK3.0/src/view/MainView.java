package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.sun.javafx.scene.control.behavior.SliderBehavior.SliderKeyBinding;

import action.AutoAdjustAction;
import action.BrightnessAction;
import action.ContrastAction;
import action.FisheyeAction;
import action.GameAction;
import action.GrayscaleAction;
import action.NegativeAction;
import action.OpenImageAction;
import action.PaintingAction;
import action.ReflectionAction;
import action.SharpenAction;
import action.VignetteAction;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
	private ImagePanel panelSlika = new ImagePanel();
	private JPanel toolBarPanel = new JPanel();

	public MainView() {
		setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1100, 500);
		this.setTitle("Photo Editor by JDK");
		this.setLocationRelativeTo(null);
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/mainicon.png"));
		this.setIconImage(icon.getImage());
		
		for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
			System.out.println(info.getName());
			if("Nimbus".equals(info.getName())){
				try {
					UIManager.setLookAndFeel(info.getClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		getContentPane().setLayout(new BorderLayout(0, 0));
		JMenuBar menuBar = new JMenuBar();
		getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu file = new JMenu("File");
		file.add(new OpenImageAction(this));
		JMenu fixImg = new JMenu("Fix image");
		menuBar.add(file);
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

		JMenu returnToChild = new JMenu("Return to childhood ");
		menuBar.add(returnToChild);
		
		JButton btnGame = new JButton("Game ");
		returnToChild.add(btnGame);
		try {
			btnGame.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/images/game.png"))));

		} catch (Exception e) {
			e.printStackTrace();
		}
		btnGame.addActionListener(new GameAction());

		getContentPane().add(toolBarPanel, BorderLayout.WEST);

		JToolBar toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		toolBarPanel.add(toolBar);
		
		JLabel lblClickBelowFor = new JLabel("click below for filter");
		toolBar.add(lblClickBelowFor);

		JButton btnNegative = new JButton("Negative   ");
		btnNegative.setSize(100, 30);

		toolBar.add(btnNegative);
		btnNegative.addActionListener(new NegativeAction());
		try {
			btnNegative.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/images/negative.png"))));

		} catch (Exception e) {
			e.printStackTrace();
		}

		JButton btnGrayscale = new JButton("Grayscale");
		toolBar.add(btnGrayscale);
		btnGrayscale.addActionListener(new GrayscaleAction());
		try {
			btnGrayscale.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/images/contrast.png"))));

		} catch (Exception e) {
			e.printStackTrace();
		}

		JButton btnVignette = new JButton("Vignette   ");
		toolBar.add(btnVignette);
		btnVignette.addActionListener(new VignetteAction());
		try {
			btnVignette.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/images/camera.png"))));

		} catch (Exception e) {
			e.printStackTrace();
		}
		

		JButton btnPainting = new JButton("Painting   ");
		
		toolBar.add(btnPainting);
		btnPainting.addActionListener(new PaintingAction());
		try {
			btnPainting.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/images/painting.png"))));

		} catch (Exception e) {
			e.printStackTrace();
		}
		


		JButton btnFisheye = new JButton("Fisheye    ");

		toolBar.add(btnFisheye);
		btnFisheye.addActionListener(new FisheyeAction());
		try {
			btnFisheye.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/images/ffisheye.png"))));

		} catch (Exception e) {
			e.printStackTrace();
		}
		

		JButton btnReflection = new JButton("Reflection");
		toolBar.add(btnReflection);
		btnReflection.addActionListener(new ReflectionAction());
		try {
			btnReflection.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/images/reflection.png"))));

		} catch (Exception e) {
			e.printStackTrace();
		}
		

		getContentPane().add(panelSlika, BorderLayout.CENTER);

		
		this.setVisible(true);
	}

	public ImagePanel getPanelSlika() {
		return panelSlika;
	}

	public void setPanelSlika(ImagePanel panelSlika) {
		this.panelSlika = panelSlika;
	}

	public JPanel getToolBarPanel() {
		return toolBarPanel;
	}

	public void setToolBarPanel(JPanel toolBarPanel) {
		this.toolBarPanel = toolBarPanel;
	}

}
