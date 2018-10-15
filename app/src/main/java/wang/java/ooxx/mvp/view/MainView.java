package wang.java.ooxx.mvp.view;

public interface MainView {
	public void showVictory(String victoryText);
	public void clearVictoryText();
	public void clearButtons();
	public void setButtonText(int index, String text);
}
