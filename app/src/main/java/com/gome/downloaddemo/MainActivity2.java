package com.gome.downloaddemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gome.download.PermissionsManagerUtils;


//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;

//import com.arialyy.annotations.DownloadGroup;
//import com.arialyy.aria.core.Aria;
//import com.arialyy.aria.core.download.DownloadEntity;
//import com.arialyy.aria.core.task.DownloadGroupTask;

public class MainActivity2 extends FragmentActivity {
    private Button multiButtonStart,multiButtonStop;
     private TextView task1,task2,task3,task4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        task1=findViewById(R.id.task1);
        task2=findViewById(R.id.task2);
        task3=findViewById(R.id.task3);
        task4=findViewById(R.id.task4);
//        Aria.download(this).register();
//        Aria.get(this).getDownloadConfig().setMaxTaskNum(3);
    }

    public void multiDownloadStart(View view){
//        Toast.makeText(this, "多任务下载", Toast.LENGTH_LONG).show();
//        PermissionsManagerUtils.getInstance().checkPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, new PermissionsManagerUtils.IPermissionsResult() {
//            @Override
//            public void passPermissions() {
//                List<String> subUrls = new ArrayList<>(); // 创建一个http url集合
//                subUrls.add(Url.URL1);  // 添加一个视频地址
//                subUrls.add(Url.URL2);     // 添加一个字幕地址
//                subUrls.add(Url.URL3);            // 添加一个视频截图
//                String folderName = SDCardManagerUtils.getSDCardCacheDir(MainActivity2.this) + "/demos/file/multi";
//                FileManagerUtils.createDir(folderName);
//                long taskId = Aria.download(this)
//                        .loadGroup(subUrls) // 设置url集合
//                        .setDirPath(folderName)   // 设置该组合任务的文件夹路径
//                        .unknownSize().ignoreFilePathOccupy()            // 如果你不知道组合任务的长度请设置这个，需要注意的是，恢复任务时也有加上这个
//                        .create();
//            }
//
//            @Override
//            public void forbidPermissions() {
//
//            }
//        });
//



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionsManagerUtils.getInstance().onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

//    /*
//     * 任务执行中
//     */
//    @DownloadGroup.onTaskRunning()
//    protected void running(DownloadGroupTask task) {
//       task1.setText("group running, p = "
//               + task.getPercent()
//               + ", speed = "
//               + task.getConvertSpeed()
//               + "current_p = "
//               + task.getCurrentProgress());
//
//    }
//
//    /*
//     * 任务完成
//     */
//    @DownloadGroup.onTaskComplete()
//    protected void taskComplete(DownloadGroupTask task) {
//        task1.setText("下载完成");
//    }
//    @DownloadGroup.onSubTaskRunning
//    void onSubTaskRunning(DownloadGroupTask groupTask, DownloadEntity subEntity) {
//        // 子任务执行中的回调
//        if(Url.URL1.equals(subEntity.getKey())){
//            task2.setText(String.format("%s%%",subEntity.getPercent()));
//        }
//        if(Url.URL2.equals(subEntity.getKey())){
//            task3.setText(String.format("%s%%",subEntity.getPercent()));
//        }
//        if(Url.URL3.equals(subEntity.getKey())){
//            task4.setText(String.format("%s%%",subEntity.getPercent()));
//        }
//    }
//
//    @DownloadGroup.onSubTaskComplete
//    void onSubTaskComplete(DownloadGroupTask groupTask, DownloadEntity subEntity) {
//        // 子任务完成的回调
//        if(Url.URL1.equals(subEntity.getKey())){
//            task2.setText("下载完成");
//        }
//        if(Url.URL2.equals(subEntity.getKey())){
//            task3.setText("下载完成");
//        }
//        if(Url.URL3.equals(subEntity.getKey())){
//            task4.setText("下载完成");
//        }
//    }

}