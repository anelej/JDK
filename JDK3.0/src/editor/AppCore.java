package editor;

import view.MainView;

public class AppCore {

	private static AppCore instance = null;
	
	private MainView mainFrame = null;
	
	private String imagePath = null;
	
	

	
	private AppCore(){
		
	}
	
	public static AppCore getInstance(){
		if(instance==null){
			instance = new AppCore();
			instance.init();
		}
		return instance;
	}
	
	private void init(){
		mainFrame = new MainView();
	}
	
	public MainView getMainFrame(){
		
		return mainFrame;
	}
	
	public void loadImagePath(String path){
		imagePath = path;
		mainFrame.getPanelSlika().setImage(path);
		
		
	}
	
}
