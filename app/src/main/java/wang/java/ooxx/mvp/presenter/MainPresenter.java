package wang.java.ooxx.mvp.presenter;

import wang.java.ooxx.mvp.model.PlayModel;
import wang.java.ooxx.mvp.view.MainView;

public class MainPresenter implements Presenter {
	private MainView mainView;
	private PlayModel playModel;
	
	public MainPresenter(MainView mainView) {
		this.mainView = mainView;
		playModel = new PlayModel();
	}
	
	public void reset(){
		playModel.reset();
		mainView.clearButtons();
		mainView.clearVictoryText();
	}
	
	public void onButtonSelect(int index){
		if (playModel.getVictory() == true){
			return;
		}
		
		boolean isSuccess = playModel.mark(index);
		if (isSuccess == true){
			int user = playModel.getUser();
			if (user == 0){
				mainView.setButtonText(index , "O");
			}else if (user == 1){
				mainView.setButtonText(index , "X");
			}
		}
		
		boolean isVictory = playModel.getVictory();
		if (isVictory == true){
			int user = playModel.getUser();
			if (user == 0){
				mainView.showVictory("O Victory");
			}else if (user == 1){
				mainView.showVictory("X Victory");
			}
		}
	}
	
	@Override
	public void onCreate() {
	
	}
	
	@Override
	public void onPause() {
	
	}
	
	@Override
	public void onResume() {
	
	}
	
	@Override
	public void onDestroy() {
	
	}
}
