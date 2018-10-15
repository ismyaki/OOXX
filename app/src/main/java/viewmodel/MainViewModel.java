package viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import datamodel.PlayModel;

public class MainViewModel extends AndroidViewModel {

    public final ObservableField<String> victory = new ObservableField<>();
    public final ObservableArrayList<String> list = new ObservableArrayList<>();

    private PlayModel playModel = new PlayModel();

    private Context mContext;
    public MainViewModel(@NonNull Application application) {
        super(application);
        mContext = application.getApplicationContext();
        reset();
    }

    public void reset(){
        playModel.reset();
        if (list.size() == 0){
            for (int i = 0; i < 9; i++) {
                list.add("");
            }
        }
        for (int i = 0; i < list.size(); i++) {
            list.set(i , "");
        }
        victory.set("");
    }

    public void onButtonSelect(int index){
        if (playModel.getVictory() == true){
            return;
        }

        boolean isSuccess = playModel.mark(index);
        if (isSuccess == true){
            int user = playModel.getUser();
            if (user == 0){
                list.set(index , "O");
            }else if (user == 1){
                list.set(index , "X");
            }
        }

        boolean isVictory = playModel.getVictory();
        if (isVictory == true){
            int user = playModel.getUser();
            if (user == 0){
                victory.set("O Victory");
            }else if (user == 1){
                victory.set("X Victory");
            }
        }
    }

}
