package com.common.tools.redis;

import com.google.gson.Gson;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author zhuangqingdian
 * @date 2021/4/16
 * redis存储javabean
 */
public class RedisJavaBean {

    //方式一：转为byte[]数组存储
    public static byte[] serializableUtil(Object object){
        byte[] bytes = null;
        ByteOutputStream bos = null;
        ObjectOutputStream oos = null;
        try {
            bos = new ByteOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(object);
            bytes = bos.toByteArray();
        } catch (Exception e) {
            System.out.println("序列化失败"+ e.getMessage());
        }finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            bos.close();
        }
        return bytes;
    }

    public static Object unSerializableUtil(byte[] bytes){
        Object obj = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bis = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bis);
            obj = (Object) ois.readObject();
        } catch (Exception e) {
            System.out.println("反序列化失败" + e.getMessage());
        }finally {
            try {
                ois.close();
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }
    //方式二：转为json字符串存储
    public static String objectToString(Object obj){
        Gson gson = new Gson();
        String jsonStr = gson.toJson(obj);
        return jsonStr;
    }
    public static Object strToObject(String str){
        Gson gson = new Gson();
        Object obj = gson.fromJson(str,Object.class);
        return obj;
    }


}
