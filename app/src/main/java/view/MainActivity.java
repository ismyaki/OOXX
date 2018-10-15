package view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import model.PlayModel;
import wang.java.ooxx.R;

public class MainActivity extends AppCompatActivity {
	
	private PlayModel playModel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//
		playModel = new PlayModel();
		initView();
		initEvent();
		reset();
	}
	
	private TextView tv_message;
	private Button btn_reset;
	/**按鈕物件陣列*/
	private  ArrayList<Button> btnList = new  ArrayList<>();
	private void initView() {
		//
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
				onButtonSelect(index);
			}
		};
		
		for (Button btn : btnList) {
			btn.setOnClickListener(onClickListener);
		}
		//
		btn_reset.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				reset();
			}
		});
	}
	
	public void onButtonSelect(int index){
		if (playModel.getVictory() == true){
			return;
		}
		
		Button btn = btnList.get(index);
		
		boolean isSuccess = playModel.mark(index);
		if (isSuccess == true){
			int user = playModel.getUser();
			if (user == 0){
				btn.setText("O");
			}else if (user == 1){
				btn.setText("X");
			}
		}
		
		boolean isVictory = playModel.getVictory();
		if (isVictory == true){
			int user = playModel.getUser();
			if (user == 0){
				tv_message.setText("O Victory");
			}else if (user == 1){
				tv_message.setText("X Victory");
			}
		}
	}
	
	private void reset(){
		playModel.reset();
		for (Button btn : btnList) {
			btn.setText(null);
		}
		tv_message.setText(null);
	}
}
