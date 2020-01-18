package com.sq.bookstore.util;

import java.util.UUID;

/**
 * Author:   chenfeiliang
 * Description:
 */
public class UuidUtil {

    public static String getUUID32(){
        return UUID.randomUUID().toString().replace("-","").toLowerCase();
    }

    public static void main(String args[]){
        System.out.println(getUUID32());
    }
}