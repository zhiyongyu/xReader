package com.jaron.yzy.xreader.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 创建文件。写入文件。
 * 熟悉创建文件夹，文件，将内容写入文件 的流程以及实现
 * Created by yzy on 2017/3/30.
 */
public class FileTest {

    private static final String FILE_DIRECTORY = "/sdcard/xReader/";
    private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    private String fileName = "txtBook.txt";

    /**
     * 创建文件夹
     *
     * @param filePath 文件夹的路径。其中包括了要创建的文件夹的名字 ，例如：sdcard/xReader/
     */
    private void createdFileDirectory(String filePath) {
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
    private File createFile(String filePath, String fileName) {
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
     * 将文本内容写入 文件
     */
    private void writeToFile() {
        String fileName = formatter.format(new Date());
        createFile(FILE_DIRECTORY, fileName);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(FILE_DIRECTORY + fileName);
            fos.write("sdfsdf".getBytes());//获取字节流
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 从本地文件读取内容
     */
    private String readFromFile() {
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
