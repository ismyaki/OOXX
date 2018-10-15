package model;

import java.util.ArrayList;

public class PlayModel {
	/**戳記陣列 0=圈 1=叉*/
	private ArrayList<Integer> pointList = new ArrayList<>();
	/**user 0=圈 1=叉*/
	private int user = 1;
	/**true = 已有優勝者*/
	private boolean isVictory = false;
	
	public PlayModel(){
		reset();
	}
	
	public boolean mark(int index){
		if (pointList.get(index) != -1){
			return false;
		}
		if (user == 0){
			user = 1;
		}else if (user == 1){
			user = 0;
		}
		
		if (user == 0){
			pointList.set(index , 0);
		}else if (user == 1){
			pointList.set(index , 1);
		}
		
		isVictory = isVictory();
		return true;
	}
	
	public int getUser(){
		return user;
	}
	
	/**取得 判斷勝利*/
	public boolean getVictory(){
		return isVictory;
	}
	
	/**判斷勝利*/
	private boolean isVictory(){
		boolean isVictory = false;
		int arr[][] = {
				{0,1,2},
				{3,4,5},
				{6,7,8},
				{0,3,6},
				{1,4,7},
				{2,5,8},
				{0,4,8},
				{2,4,6},
		};
		
		for (int[] ints : arr) {
			if (pointList.get(ints[0]) != -1 && pointList.get(ints[0]) == pointList.get(ints[1]) && pointList.get(ints[1]) == pointList.get(ints[2])){
				isVictory = true;
				break;
			}
		}
		
		return isVictory;
	}
	
	/**重新開始*/
	public void reset(){
		for (int i = 0; pointList.size() < 9 && i < 9; i++) {
			pointList.add(0 , -1);
		}
		user = 1;
		isVictory = false;
		for (int i = 0; i < pointList.size(); i++) {
			pointList.set(i , -1);
		}
	}
}
