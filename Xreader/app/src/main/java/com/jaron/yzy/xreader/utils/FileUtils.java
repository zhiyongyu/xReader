package com.jaron.yzy.xreader.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Jaron Yu on 2017/4/5.
 */
public class FileUtils {

    public static final String FILE_DIRECTORY = "/sdcard/xReader/";


    /**
     * 创建文件夹
     *
     * @param filePath 文件夹的路径。其中包括了要创建的文件夹的名字 ，例如：sdcard/xReader/
     */
    private static void createdFileDirectory(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /**
     * 创建文件
     *
     * @param filePath 文件路径，就是创建文件夹时候的文件夹路径
     * @param fileName 文件名字，需要创建的文件命名
     */
    public static File createFile(String filePath, String fileName) {
        createdFileDirectory(filePath);
        File file = new File(filePath + fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /**
     * 从本地文件读取内容
     */
    private String readFromFile(String fileName) {
        String content = "";//最后读取到的内容
        try {
            InputStream inputStream = new FileInputStream(FILE_DIRECTORY + fileName);//读取文件需要指定目录
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                String line;
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                while ((line = bufferedReader.readLine()) != null) {
                    content += line;
                }
                inputStream.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
