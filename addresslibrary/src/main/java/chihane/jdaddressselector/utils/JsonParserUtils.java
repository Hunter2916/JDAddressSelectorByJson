package chihane.jdaddressselector.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import chihane.jdaddressselector.model.Province;

public class JsonParserUtils {

    //读取assets中的文件
    public static List<Province> readFromAssets(Context context) {
        try {
            InputStream is = context.getAssets().open("json.json");//此处为要加载的json文件名称
            String text = readTextFromSDcard(is);
            return handleCitiesResponse(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //将传入的is一行一行解析读取出来出来
    private static String readTextFromSDcard(InputStream is) throws Exception {
        StringBuilder buffer = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
        try {
            reader = new InputStreamReader(is, "UTF-8");
            bufferedReader = new BufferedReader(reader);
            buffer = new StringBuilder("");
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
                buffer.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        return buffer.toString();//把读取的数据返回
    }

    //把读取出来的json数据进行解析
    private static List<Province> handleCitiesResponse(String response) {
        if (response != null) {
            List<Province> json;
            json = new Gson().fromJson(response,
                    new TypeToken<List<Province>>() {
                    }.getType());
            return json;
        }
        return null;
    }
}