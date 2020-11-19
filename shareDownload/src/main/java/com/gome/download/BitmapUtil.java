package com.gome.download;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author lzl
 * @ describe
 * @ time 2020/11/13 17:40
 */
class BitmapUtil {
    public static byte[] bitmapToByte(Bitmap bitmap) {
        //将Bitmap转换成字符串
        ByteArrayOutputStream bStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bStream);
        return bStream.toByteArray();
    }


    /**
     * @ describe 保持下载图片到系统图库
     * @author lzl
     * @ time 2020/11/17 15:56
     * @ param
     * @ return
     */
    public static void saveImageToSystemGallery(Context context, File file, String fileName) {


        // 其次把文件插入到系统图库
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(),
                    file.getAbsolutePath(), fileName, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 最后通知图库更新
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) { // 判断SDK版本是不是4.4或者高于4.4
            String[] paths = new String[]{file.getAbsolutePath()};
            MediaScannerConnection.scanFile(context, paths, null, null);
        } else {
            final Intent intent;
            if (file.isDirectory()) {
                intent = new Intent(Intent.ACTION_MEDIA_MOUNTED);
                intent.setClassName("com.android.providers.media", "com.android.providers.media.MediaScannerReceiver");
                intent.setData(Uri.fromFile(Environment.getExternalStorageDirectory()));
            } else {
                intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                intent.setData(Uri.fromFile(file));
            }
            context.sendBroadcast(intent);
        }

    }


    public static void saveVideoToSystem(Activity activity, File filePath, String type) {


        ContentResolver localContentResolver = activity.getContentResolver();
        ContentValues localContentValues = getVideoContentValues(activity, filePath, System.currentTimeMillis());
        Uri localUri = localContentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, localContentValues);
    }

    public static ContentValues getVideoContentValues(Context paramContext, File paramFile, long paramLong) {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("title", paramFile.getName());
        localContentValues.put("_display_name", paramFile.getName());
        localContentValues.put("mime_type", "video/3gp");
        localContentValues.put("datetaken", Long.valueOf(paramLong));
        localContentValues.put("date_modified", Long.valueOf(paramLong));
        localContentValues.put("date_added", Long.valueOf(paramLong));
        localContentValues.put("_data", paramFile.getAbsolutePath());
        localContentValues.put("_size", Long.valueOf(paramFile.length()));
        return localContentValues;
    }

    public static void saveVideo(Activity activity, File file) {
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(Uri.fromFile(file));
        activity.sendBroadcast(intent);//发送一个广播
    }

    /**
     * get Local video duration
     *
     * @return
     */
    public static long getLocalVideoDuration(String videoPath) {
         //除以 1000 返回是秒
        long duration;
        try {
            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(videoPath);
            duration = Integer.parseInt(mmr.extractMetadata
                    (MediaMetadataRetriever.METADATA_KEY_DURATION));

            //时长(毫秒)
            //String duration = mmr.extractMetadata(android.media.MediaMetadataRetriever.METADATA_KEY_DURATION);
            //宽
            String width = mmr.extractMetadata(android.media.MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH);
           //高
            String height = mmr.extractMetadata(android.media.MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT);

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return duration;
    }

    public static int getWidth(String videoPath) {
        //除以 1000 返回是秒
        int widthI;
        try {
            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(videoPath);


          //时长(毫秒)
          //String duration = mmr.extractMetadata(android.media.MediaMetadataRetriever.METADATA_KEY_DURATION);
          //宽
            String width = mmr.extractMetadata(android.media.MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH);
            widthI = Integer.valueOf(width);


        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return widthI;
    }

    public static int getHeight(String videoPath) {
        //除以 1000 返回是秒
        int heightI;
        try {
            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(videoPath);


            //时长(毫秒)
           //String duration = mmr.extractMetadata(android.media.MediaMetadataRetriever.METADATA_KEY_DURATION);

            //高
            String height = mmr.extractMetadata(android.media.MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT);
            heightI = Integer.valueOf(height);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return heightI;
    }

    public static void saveVideoToSystem(Activity activity, File file) {
        activity.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + file)));
    }
}
