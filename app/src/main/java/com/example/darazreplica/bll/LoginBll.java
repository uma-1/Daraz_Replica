package com.example.darazreplica.bll;

import com.example.darazreplica.Url.Url;
import com.example.darazreplica.api.UserApi;
import com.example.darazreplica.model.User;
import com.example.darazreplica.serverresponse.SignUpResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBll {
    boolean isSuccess = false;

    public boolean checkUser(String email, String password){

        UserApi userApi = Url.getInstance().create(UserApi.class);
        User user = new User(email,password);
        Call<SignUpResponse> userCall =userApi.checkUser(user);

        try {
            Response<SignUpResponse> loginResponse = userCall.execute();
            if (loginResponse.isSuccessful()) {
                if(loginResponse.body().getStatus().equals("true") ) {
                    isSuccess = true;
                }
//                else if(loginResponse.body().getStatus().equals("false") ){
//                    isSuccess = false;
//                }
            }
            else{
                isSuccess = false;
            }
        }
        catch(IOException e){
                e.printStackTrace();
            }

        return isSuccess;
    }
}
