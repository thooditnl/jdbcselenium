package com.selenium.jdbc;

import java.util.ArrayList;

/**
 * Created by THOODI on 3/18/2017.
 */
public class login {
    static ReadPropertyFile file = null;

    public static void main(String[] args) throws Throwable {
        file = new ReadPropertyFile();
        Methods method = new Methods();
        String temp = method.login();

        dbverification dbVerify = new dbverification();
        ArrayList<String> dbValue = dbVerify.db(file.getQuery(),file.getColumn());
		System.out.println(dbValue.get(0));
        if ((temp.equals(dbValue.get(0)))) {
            System.out.println("UI and DB value matches");
        }
        else {
            System.out.println("Record doesn't exists in Database");
        }

    }

}
