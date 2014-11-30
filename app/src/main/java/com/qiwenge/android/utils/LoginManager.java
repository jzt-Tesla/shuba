package com.qiwenge.android.utils;

import android.content.Context;

import com.dev1024.utils.PreferencesUtils;
import com.dev1024.utils.StringUtils;
import com.google.gson.Gson;
import com.qiwenge.android.models.Auth;
import com.qiwenge.android.models.User;

/**
 * Created by Eric on 14/11/22.
 */
public class LoginManager {

    private static final String LOGIN = "login";

    private static final String KEY_AUTH = "auth";

    private static final String KEY_USER = "user";

    private static User mUser;

    private static Auth mAuth;

    public static boolean isLogin() {
        return mUser != null;
    }

    public static void logout() {
        mUser = null;
    }

    public static void init(Context context) {
        System.out.println("init LoginManager");
        mUser = getUser(context);
        mAuth = getAuth(context);
    }

    public static void saveAuth(Context context, Auth auth) {
        if (auth != null) {
            mAuth = auth;
            Gson gson = new Gson();
            String json = gson.toJson(auth);
            PreferencesUtils.putString(context, LOGIN, KEY_AUTH, json);
        }
    }

    public static Auth getAuth(Context context) {
        Auth auth = null;
        String authJson = PreferencesUtils.getString(context, LOGIN, KEY_AUTH);
        if (!StringUtils.isEmptyOrNull(authJson)) {
            Gson gson = new Gson();
            auth = gson.fromJson(authJson, Auth.class);
        }
        return auth;
    }

    public static void saveUser(Context context, User user) {
        if (user != null) {
            mUser = user;
            Gson gson = new Gson();
            String json = gson.toJson(user);
            System.out.println("save user :" + json);
            PreferencesUtils.putString(context, LOGIN, KEY_USER, json);
        }
    }

    public static User getUser(Context context) {
        User user = null;
        String userJson = PreferencesUtils.getString(context, LOGIN, KEY_USER);
        if (!StringUtils.isEmptyOrNull(userJson)) {
            Gson gson = new Gson();
            user = gson.fromJson(userJson, User.class);
        }
        return user;
    }

    public static User getUser() {
        return mUser;
    }

    public static Auth getAuth() {
        return mAuth;
    }



}
