package com.gome.download;

/**
 * @author lzl
 * @ describe
 * @ time 2020/11/18 11:31
 */
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @ describe 文件相关工具类
 *   如：递归获取文件大小,格式化单位,删除文件或文件夹,压缩文件,
 *   创建一个JPEG格式的图片文件,拷贝文件
 *
 * @author lzl
 *
 * @ time 2020/11/19 16:09
 *
 * @ param
 *
 * @ return
 */
public class FileUtils {
    /**
     * 递归获取文件大小
     *
     * @param file 文件夹
     * @return 文件大小
     */
    public static long getFolderSize(File file) {
        long size = 0;
        try {
            File[] fileList = file.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                // 如果下面还有文件
                if (fileList[i].isDirectory()) {
                    size = size + getFolderSize(fileList[i]);
                } else {
                    size = size + fileList[i].length();
                }
            }
        } catch (Exception e) {
            return 0;
        }
        return size;
    }

    /**
     * 格式化单位
     *
     * @param size 文件大小
     * @return 如10MB、10KB、10GB
     */
    public static String getFormatSize(double size) {
        double kiloByte = size / 1024;
        if (kiloByte < 1) {
            if (size == 0) {
                return "0MB";
            }
            return size + "Byte";
        }

        double megaByte = kiloByte / 1024;
        if (megaByte < 1) {
            BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
            return result1.setScale(2, BigDecimal.ROUND_HALF_UP)
                    .toPlainString() + "KB";
        }

        double gigaByte = megaByte / 1024;
        if (gigaByte < 1) {
            BigDecimal result2 = new BigDecimal(Double.toString(megaByte));
            return result2.setScale(2, BigDecimal.ROUND_HALF_UP)
                    .toPlainString() + "MB";
        }

        double teraBytes = gigaByte / 1024;
        if (teraBytes < 1) {
            BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
            return result3.setScale(2, BigDecimal.ROUND_HALF_UP)
                    .toPlainString() + "GB";
        }
        BigDecimal result4 = new BigDecimal(teraBytes);
        return result4.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString()
                + "TB";
    }

    /**
     * 删除文件或文件夹
     *
     * @param file 文件或文件夹
     */
    public static void deleteFiles(File file) {
        if (file == null) return;
        if (file.isFile() || file.list().length == 0) {
            file.delete();
        } else {
            File[] files = file.listFiles();
            for (File f : files) {
                deleteFiles(f);//递归删除每一个文件
                f.delete();//删除该文件夹
            }
        }
    }

    /**
     * 压缩文件
     *
     * @param path 文件路径
     * @return 压缩后的文件
     */
    public static File scal(String path) {
        File outputFile = new File(path);
        long fileSize = outputFile.length();
        final long fileMaxSize = 200 * 300;

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        double scale = Math.sqrt((float) fileSize / fileMaxSize);
        Log.d("scale", scale + "");
        options.outHeight = 420;
        options.outWidth = 600;
        options.inSampleSize = (int) (scale + 0.5);
        options.inJustDecodeBounds = false;

        Bitmap bitmap = BitmapFactory.decodeFile(path, options);
        outputFile = new File(createImageFile().getPath());
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(outputFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, fos);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        } else {
            File tempFile = outputFile;
            outputFile = new File(createImageFile().getPath());
            copyFileUsingFileChannels(tempFile, outputFile);
        }

        return outputFile;
    }

    /**
     * 创建一个JPEG格式的图片文件
     *
     * @return 文件File
     */
    public static File createImageFile() {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-SS", Locale.CHINA).format(new Date());
        String imageFileName = "JPEG_ " + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = null;
        try {
            image = File.createTempFile(
                    imageFileName,  /* prefix */
                    ".jpg",         /* suffix */
                    storageDir      /* directory */
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * 创建一个JPEG格式的图片文件
     *
     * @return 文件Uri
     */
    public static Uri createImageFileUri() {
        return Uri.fromFile(createImageFile());
    }


    /**
     * 拷贝文件
     *
     * @param source 初始文件
     * @param dest   目标文件
     */
    public static void copyFileUsingFileChannels(File source, File dest) {
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(dest).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert inputChannel != null;
                inputChannel.close();
                assert outputChannel != null;
                outputChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
