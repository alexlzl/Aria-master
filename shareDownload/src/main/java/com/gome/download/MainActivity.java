package com.gome.download;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.arialyy.aria.core.Aria;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    private TextView tv1, tv2, tv3, tv4;
    private Button stopSingleDownloadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.task1);
        tv2 = findViewById(R.id.task2);
        tv3 = findViewById(R.id.task3);
        tv4 = findViewById(R.id.task4);
        stopSingleDownloadBtn = findViewById(R.id.stopSingleDownloadBtn);
//        Aria.download(this).register();
//        Aria.get(this).getDownloadConfig().setMaxTaskNum(3);
    }

    private long apkTaskId;

    public void singleDownload(View view) {
        stopSingleDownloadBtn.setTag("start");
//        Toast.makeText(this, "下载apk", Toast.LENGTH_LONG).show();
//        PermissionsManagerUtils.getInstance().checkPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, new PermissionsManagerUtils.IPermissionsResult() {
//            @Override
//            public void passPermissions() {
//                String fileName = SDCardManagerUtils.getSDCardCacheDir(MainActivity.this) + "/demos/file/apk/test.apk";
//                String folderName = SDCardManagerUtils.getSDCardCacheDir(MainActivity.this) + "/demos/file/apk";
//                FileManagerUtils.createDir(folderName);
//                apkTaskId = Aria.download(this)
//                        .load(Url.URL1)     //读取下载地址
//                        .setFilePath(fileName) //设置文件保存的完整路径
//                        .create();   //创建并启动下载
//            }
//
//            @Override
//            public void forbidPermissions() {
//
//            }
//        });

//        ShowDialogUtil showDialog=new ShowDialogUtil(this);
//        showDialog.showDialog(getSupportFragmentManager());
//        showDialog.startLoadResource(getShareResponseBean());
        ShowDialogUtil showDialogUtil= ShowDialogUtil.getInstance(this);
        showDialogUtil .showDialog(getSupportFragmentManager(), getShareResponseBean());
        //for test js回调获取bitmap
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), com.gome.download.R.drawable.test);
//        Bitmap bitmap=null;
        showDialogUtil. loadMiniProgram(bitmap, getShareResponseBean().getMiniProgramDownLaod());
    }

    private long videoTaskId;

    public void singleDownloadVideo(View view) {
        Toast.makeText(this, "下载视频", Toast.LENGTH_LONG).show();
//        PermissionsManagerUtils.getInstance().checkPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, new PermissionsManagerUtils.IPermissionsResult() {
//            @Override
//            public void passPermissions() {
//                String fileName = SDCardManagerUtils.getSDCardCacheDir(MainActivity.this) + "/demos/file/video/test.mp4";
//                String folderName = SDCardManagerUtils.getSDCardCacheDir(MainActivity.this) + "/demos/file/video";
//                FileManagerUtils.createDir(folderName);
//                videoTaskId = Aria.download(this)
//                        .load(Url.URL2)     //读取下载地址
//                        .setFilePath(fileName) //设置文件保存的完整路径
//                        .create();   //创建并启动下载
//            }
//
//            @Override
//            public void forbidPermissions() {
//
//            }
//        });
//        ShowDialogUtil showDialog=new ShowDialogUtil(this);
//        showDialog.showDialog(getSupportFragmentManager());
//        showDialog.loadVideo(null);
    }

    private long picTaskId;

    public void singleDownloadPic(View view) {
//        Toast.makeText(this, "下载图片", Toast.LENGTH_LONG).show();
////        PermissionsManagerUtils.getInstance().checkPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, new PermissionsManagerUtils.IPermissionsResult() {
////            @Override
////            public void passPermissions() {
////                String fileName = SDCardManagerUtils.getSDCardCacheDir(MainActivity.this) + "/demos/file/pic/gome.jpg";
////                String folderName = SDCardManagerUtils.getSDCardCacheDir(MainActivity.this) + "/demos/file/pic";
////                FileManagerUtils.createDir(folderName);
////                picTaskId = Aria.download(this)
////                        .load(Url.URL3)     //读取下载地址
////                        .setFilePath(fileName) //设置文件保存的完整路径
////                        .create();   //创建并启动下载
////            }
////
////            @Override
////            public void forbidPermissions() {
////
////            }
////        });
//        ShowDialogUtil showDialog=new ShowDialogUtil(this);
//        showDialog.showDialog(getSupportFragmentManager());
//        showDialog.loadMaterialPic(null);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionsManagerUtils.getInstance().onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

    public void multiDownload(View view) {
        Toast.makeText(this, "multiple", Toast.LENGTH_LONG).show();
//        DownloadDialog d = new DownloadDialog();
//        d.show(getSupportFragmentManager(),"aa");
//      startActivity(new Intent(this,MainActivity2.class));
        new VideoManager().downMp4(this);
    }

    public ShareResponseBean getShareResponseBean() {
        ShareResponseBean shareResponseBean = new ShareResponseBean();
        //构建素材图片对象
        ShareResponseBean.ImageDownloadBean imageDownloadBean = new ShareResponseBean.ImageDownloadBean();
        imageDownloadBean.setDisplayeStr("素材图片");
        List<ShareResponseBean.ImageDownloadBean.ImageListBean> listBeanList = new ArrayList<>();
        for (int i = 0; i < Url.PICS.length; i++) {
            ShareResponseBean.ImageDownloadBean.ImageListBean imageListBean = new ShareResponseBean.ImageDownloadBean.ImageListBean();
            imageListBean.setImageUrl(Url.PICS[i]);
            imageListBean.setImageSuffix(".jpg");
            listBeanList.add(imageListBean);
        }
        imageDownloadBean.setImageList(listBeanList);
        shareResponseBean.setImageDownload(imageDownloadBean);
        //构建视频资源
        ShareResponseBean.VideoDownLoadBean videoDownLoadBean = new ShareResponseBean.VideoDownLoadBean();
        videoDownLoadBean.setDisplayeStr("视频");
        videoDownLoadBean.setVideoSuffix(".mp4");
        videoDownLoadBean.setVideoUrl(Url.URL2);
        shareResponseBean.setVideoDownLoad(videoDownLoadBean);
        //复制文案
        ShareResponseBean.CopyStringBean copyStringBean = new ShareResponseBean.CopyStringBean();
        copyStringBean.setCopyStr("我是要复制的文案");
        copyStringBean.setDisplayeStr("文案");
        shareResponseBean.setCopyString(copyStringBean);
        //小程序码
        ShareResponseBean.MiniProgramDownLaodBean miniProgramDownLaodBean = new ShareResponseBean.MiniProgramDownLaodBean();
        miniProgramDownLaodBean.setDisplayeStr("小程序码图片");
        shareResponseBean.setMiniProgramDownLaod(miniProgramDownLaodBean);
        return shareResponseBean;
    }

    /**
     * @ describe 预处理的注解，在任务为开始前回调（一般在此处预处理UI界面）
     * @author lzl
     * @ time 2020/11/5 20:26
     * @ param
     * @ return
     */

//    @Download.onPre
//    protected void downloadPre(DownloadTask task) {
//        Log.e(TAG, "Pre===========" + task.getKey());
//    }

    /**
     * @ describe 任务开始时的注解，新任务开始时进行回调
     * @author lzl
     * @ time 2020/11/5 20:27
     * @ param
     * @ return
     */
//    @Download.onTaskStart
//    protected void downloadStart(DownloadTask task) {
//        Log.e(TAG, "Start===========" + task.getKey());
//    }

    /**
     * @ describe 任务恢复时的注解，任务从停止恢复到运行前进行回调
     * @author lzl
     * @ time 2020/11/5 20:28
     * @ param
     * @ return
     */
//    @Download.onTaskResume
//    protected void downloadResume(DownloadTask task) {
//        Log.e(TAG, "Resume===========" + task.getKey());
//    }


    //在这里处理任务执行中的状态，如进度进度条的刷新
//    @Download.onTaskRunning
//    protected void running(DownloadTask task) {
//        Log.e(TAG, "Percent===========" + task.getPercent() + "======" + task.getKey());
//        if (Url.URL1.equals(task.getKey())) {
//            //任务1
//            tv1.setText(String.format("%s%%", task.getPercent()));
//        }
//        if (Url.URL2.equals(task.getKey())) {
//            //任务2
//            tv2.setText(String.format("%s%%", task.getPercent()));
//        }
//        if (Url.URL3.equals(task.getKey())) {
//            //任务3
//            tv3.setText(String.format("%s%%", task.getPercent()));
//        }
//
//        int p = task.getPercent();    //任务进度百分比
//        String speed = task.getConvertSpeed();    //转换单位后的下载速度，单位转换需要在配置文件中打开
//        long speed1 = task.getSpeed(); //原始byte长度速度
//    }

    /**
     * @ describe 队列已经满了，继续创建新任务，将会回调该方法
     * @author lzl
     * @ time 2020/11/5 20:31
     * @ param
     * @ return
     */
//    @Download.onWait
//    protected void downloadWait(DownloadTask task) {
//        Log.e(TAG, "Wait===========" + task.getKey());
//    }

    /**
     * @ describe 任务停止时的注解，任务停止时进行回调
     * @author lzl
     * @ time 2020/11/5 20:34
     * @ param
     * @ return
     */
//    @Download.onTaskStop
//    protected void downloadStop(DownloadTask task) {
//        Log.e(TAG, "Stop===========" + task.getKey());
//        if (Url.URL1.equals(task.getKey())) {
//            stopSingleDownloadBtn.setText("重新下载APK");
//            stopSingleDownloadBtn.setTag("stop");
//        }
//    }

    /**
     * @ describe 任务被删除时的注解，任务被删除时进行回调
     * @author lzl
     * @ time 2020/11/5 20:36
     * @ param
     * @ return
     */
//    @Download.onTaskCancel
//    protected void downloadCancel(DownloadTask task) {
//        Log.e(TAG, "Cancel===========" + task.getKey());
//    }

    /**
     * @ describe 任务失败时的注解，任务执行失败时进行回调
     * @author lzl
     * @ time 2020/11/5 20:36
     * @ param
     * @ return
     */
//    @Download.onTaskFail
//    protected void downloadTaskFail(DownloadTask task) {
//        Log.e(TAG, "Fail===========" + task.getKey());
//    }

    /**
     * @ describe 任务完成时的注解，任务完成时进行回调
     * @author lzl
     * @ time 2020/11/5 20:37
     * @ param
     * @ return
     */
//    @Download.onTaskComplete
//    protected void taskComplete(DownloadTask task) {
//        //在这里处理任务完成的状态
//        Log.e(TAG, "Over===========" + task.getPercent() + "======" + task.getKey());
//        if (Url.URL1.equals(task.getKey())) {
//            //任务1
//            tv1.setText(String.format("%s%%", task.getPercent()));
//        }
//        if (Url.URL2.equals(task.getKey())) {
//            //任务2
//            tv2.setText(String.format("%s%%", task.getPercent()));
//        }
//        if (Url.URL3.equals(task.getKey())) {
//            //任务3
//            tv3.setText(String.format("%s%%", task.getPercent()));
//        }
//
//    }
    public void stopSingleDownload(View view) {
        Toast.makeText(this, "停止下载apk", Toast.LENGTH_LONG).show();
        if ("stop".equals(view.getTag())) {
            //如果之前是停止状态再次下载
            stopSingleDownloadBtn.setText("停止单任务程下载APK");
            stopSingleDownloadBtn.setTag("start");
            Aria.download(this)
                    .load(apkTaskId)
                    .resume();
        } else if ("start".equals(view.getTag())) {
            //默认停止下载
            Aria.download(this)
                    .load(apkTaskId)
                    .stop();
        }


    }

    public void saveByte(View view) {
        FileByteManagerUtils.writeBytesToFile(new File(SDCardManagerUtils.getSDCardCacheDir(MainActivity.this) + "/demos/file/pic/test.jpg"), bitmapToByte(R.drawable.test), true);

    }

    public byte[] bitmapToByte(int pic) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), pic);
        //将Bitmap转换成字符串
//        String string = null;
        ByteArrayOutputStream bStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bStream);
//        string = Base64.encodeToString(bytes, Base64.DEFAULT);
        return bStream.toByteArray();
    }
}