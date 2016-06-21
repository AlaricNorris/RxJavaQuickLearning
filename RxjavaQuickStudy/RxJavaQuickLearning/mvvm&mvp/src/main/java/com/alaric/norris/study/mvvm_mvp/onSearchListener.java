package com.alaric.norris.study.mvvm_mvp;
import com.alaric.norris.study.mvvm_mvp.bean.IPAddress;
public interface onSearchListener {

  void onSuccess(IPAddress ipAddress);

  void onError();
}