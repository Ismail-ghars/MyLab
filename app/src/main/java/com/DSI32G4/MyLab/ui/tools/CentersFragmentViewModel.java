package com.DSI32G4.MyLab.ui.tools;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CentersFragmentViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CentersFragmentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is tools fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}