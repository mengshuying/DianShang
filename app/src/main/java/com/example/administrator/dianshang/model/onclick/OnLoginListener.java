package com.example.administrator.dianshang.model.onclick;

/**
 * date:${DATA}
 * author:孟淑英
 * function:
 */

public interface OnLoginListener {
    public void onUsernameError();

    public void onPasswordError();

    public void onSuccess();

    public void onFailure(String stt);
}
