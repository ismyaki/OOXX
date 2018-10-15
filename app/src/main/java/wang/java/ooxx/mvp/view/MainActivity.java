package wang.java.ooxx.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import wang.java.ooxx.mvp.R;
import wang.java.ooxx.mvp.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainView{
	
	MainPresenter presenter = new MainPresenter(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//
		initView();
		initEvent();
		//
		presenter.onCreate();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		presenter.onPause();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		presenter.onResume();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		presenter.onDestroy();
	}
	
	private TextView tv_message;
	private Button btn_reset;
	/**按鈕物件陣列*/
	private ArrayList<Button> btnList = new  ArrayList<>();
	private void initView() {
		tv_message = findViewById(R.id.tv_message);
		btn_reset = findViewById(R.id.btn_reset);
		//
		int idArray[] = {
				R.id.btn0 , R.id.btn1 , R.id.btn2 ,
				R.id.btn3 , R.id.btn4 , R.id.btn5 ,
				R.id.btn6 , R.id.btn7 , R.id.btn8 ,
		};
		for (int id : idArray) {
			Button btn = findViewById(id);
			btnList.add(btn);
		}
	}
	
	private void initEvent(){
		View.OnClickListener onClickListener = new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int index = btnList.indexOf(v);
				presenter.onButtonSelect(index);
			}
		};
		
		for (Button btn : btnList) {
			btn.setOnClickListener(onClickListener);
		}
		//
		btn_reset.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				presenter.reset();
			}
		});
	}
	
	@Override
	public void showVictory(String victoryText) {
		tv_message.setText(victoryText);
	}
	
	@Override
	public void clearVictoryText() {
		tv_message.setText(null);
	}
	
	@Override
	public void clearButtons() {
		for (Button btn : btnList) {
			btn.setText(null);
		}
	}
	
	@Override
	public void setButtonText(int index, String text) {
		Button btn = btnList.get(index);
		btn.setText(text);
	}
}
