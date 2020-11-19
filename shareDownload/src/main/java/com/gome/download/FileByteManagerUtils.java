package com.gome.download;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author lzl
 * @ describe  简单文件读写的工具类(使用字节流工具类实现)
 * @ time 2020/11/6 16:31
 */

public class FileByteManagerUtils {

    /*
        关于文件读写的一点理解
        =================================================================================================
        1. 读取内容到内存中，是否会乱码和文件的编码格式无关。只和内容的编码格式有关。
            如果写入的内容编码格式是GBK,读取时却使用UTF-8进行解码，则会出现乱码。
            文件的编码格式是GBK也好，UTF-8也好，都不会影响。
            文件的编码格式只会影响文本内容在文件中的显示。如果文件的编码格式内容的编码格式不一致，则打开文件时会出现乱码。

        2. 获取字符串的字节流byte[]        （字节流：是UNICODE编码的字符串，以指定编码格式（如UTF-8）编码后，形式的byte数组）
            String.getBytes()
                // 作业内容：将内存中以UNICODE编码的字符串转成某种固定的编码格式（CHARSET）的字节流。
                // CHARSET使用文件的默认编码格式。如果当前文件的编码格式是UTF-8，就使用UTF-8编码格式。如果当前文件格式是GBK，就使用GBK格式编码格式。
                // 如果文件的默认编码格式不被支持,则使用"ISO-8859-1"编码格式进行编码。
               String.getBytes(CHARSET)
                   // 作业内容：将内存中以UNICODE编码的字符串转成某种固定的编码格式（CHARSET）的字节流。

        3. 文件的编码格式?
            文件本身也是有编码格式的，文件的编码格式类似于一个标记，指定文件在被打开时，文件以什么编码格式去解码文件里的字节流，以显示正确的内容。

            查看TXT文件的编码格式：
                     |- 以windows自带的NotePad打开文件;
                     |- 点击"文件(F)"父菜单下的"另存为(A)"子菜单;
                     |- 在弹出框的最下方,可以看到当前文件使用的编码格式,可能是 ANSI(即GBK)或 UTF-8;
     */

    // 读取文件流时,一次性读取的最大字节数
    public final static int buffer_size = 5120;

    /**
     * @param filePath    要操作的文件路径
     * @param charsetName 指定编码格式
     * @return
     */
    public static String readStringFromFile(String filePath, String charsetName) throws Exception {
        File file = new File(filePath);
        return FileByteManagerUtils.readStringFromFile(file, charsetName);
    }

    /**
     * 以指定编码格式解码从文件中读取的字节流
     *
     * @param file        要操作的文件
     * @param charsetName 指定编码格式
     * @return
     */
    public static String readStringFromFile(File file, String charsetName) throws Exception {
        // 从文件中读取字节流
        byte[] result = FileByteManagerUtils.readBytesFromFile(file);

        // 如果未指定编码格式,使用java文件默认的编码格式进行解码
        if (null == charsetName) {
            return new String(result);
        }
        // 如果指定了编码格式,使用指定的编码格式进行解码
        else {
            return new String(result, charsetName);
        }
    }

    /**
     * 从文件中读取字节流(有编码格式)
     *
     * @param file 要操作的文件
     * @return
     */
    public static byte[] readBytesFromFile(File file) throws Exception {
        // 文件不存在时,抛出异常
        if (null == file) {
            throw new Exception("parameter file is null.");
        }
        if (!file.exists()) {
            throw new FileNotFoundException(String.format("file (%s) is not exist.", file.getAbsolutePath()));
        }

        // 读取文件流
        BufferedInputStream in = null;
        byte[] result = new byte[0];
        try {
            // 实例化输入流
            FileInputStream fis = new FileInputStream(file);
            in = new BufferedInputStream(fis);

            // 一次读取的字节最大长度
            byte[] buffer = new byte[buffer_size];

            int count ;
            while ((count = in.read(buffer)) != -1) {
                // 拷贝buffer中的前count个元素到result中
                result = FileByteManagerUtils.appendByteArray(result, buffer, count);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            FileByteManagerUtils.close(in);
        }

        // 返回读取的字节流
        return result;
    }

    /**
     * 追加src的前count个元素到result尾部
     *
     * @param desc
     * @param src
     * @param count
     * @return
     */
    public static byte[] appendByteArray(byte[] desc, byte[] src, int count) {
        // 特殊情况1
        if (null == src) {
            return desc;
        }

        // 特殊情况2,此时append不为null
        if (null == desc) {
            byte[] result = new byte[count];
            // count值大于src的长度时会报数组越界的异常,此处不处理
            System.arraycopy(src, 0, result, 0, count);
            return result;
        }

        // 原结果数组长度
        int orignalLength = desc.length;

        // 结果数组扩容
        int newLength = orignalLength + count;
        desc = Arrays.copyOf(desc, newLength);

        // 数组追加
        System.arraycopy(src, 0, desc, orignalLength, count);

        // 返回追加后的完整数组
        return desc;
    }

    /**
     * 将String字符串以指定编码格式写入文件
     *
     * @param filePath    要操作的文件路径
     * @param content     要写入的字符串
     * @param charsetName 指定的编码格式
     * @param append      内容是追加还是覆盖
     */
    public static void writeStringToFile(String filePath, String content, String charsetName, boolean append) {
        File file = new File(filePath);
        FileByteManagerUtils.writeStringToFile(file, content, charsetName, append);
    }

    /**
     * 将String字符串以指定编码格式写入文件
     *
     * @param file        要操作的文件
     * @param content     要写入的字符串
     * @param charsetName 指定的编码格式
     * @param append      内容是追加还是覆盖
     */
    public static void writeStringToFile(File file, String content, String charsetName, boolean append) {
        try {
            // 要写入的内容为空,直接返回
            if (null == content) {
                return;
            }

            byte[] bytes;
            // 如果没指定编码格式,使用java文件的默认编码格式
            if (null == charsetName) {
                bytes = content.getBytes();
            }
            // 如果指定了编码格式,使用指定的编码格式进行编码
            else {
                bytes = content.getBytes(charsetName);
            }

            // 写入文件流到文件
            FileByteManagerUtils.writeBytesToFile(file, bytes, append);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将byte[]流写入文件
     *
     * @param file   要操作的文件
     * @param bytes  字节流是有编码格式的
     * @param append 内容是追加还是覆盖
     */
    public static void writeBytesToFile(File file, byte[] bytes, boolean append) {
        BufferedOutputStream out = null;
        try {
            // 如果文件目录不存在,创建目录
            if (!file.getParentFile().exists()) {
                file.mkdirs();
            }

            // 实例化输出流
            FileOutputStream fos = new FileOutputStream(file, append);
            out = new BufferedOutputStream(fos);

            // 输出内容到文件
            if (null != bytes) {
                out.write(bytes);
            }

            // 清空缓冲区
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            FileByteManagerUtils.close(out);
        }
    }

    /**
     * 关闭流
     *
     * @param in
     * @param out
     */
    public static void close(InputStream in, OutputStream out) {
        FileByteManagerUtils.close(in);
        FileByteManagerUtils.close(out);
    }

    /**
     * 关闭输入流
     *
     * @param in
     */
    public static void close(InputStream in) {
        if (null != in) {
            try {
                in.close();
            } catch (IOException e) {
                // e.printStackTrace();
            }
        }
    }

    /**
     * 关闭输出流
     *
     * @param out
     */
    public static void close(OutputStream out) {
        if (null != out) {
            try {
                out.close();
            } catch (IOException e) {
                // e.printStackTrace();
            }
        }
    }

}
