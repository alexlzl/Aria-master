package com.gome.download;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;

/**
 * @author lzl
 * @ describe
 * @ time 2020/11/12 10:46
 */
public class ShowDialogUtil {
    private DownloadDialog mDownloadDialog;
    private Activity mActivity;

    public static ShowDialogUtil getInstance(Activity activity) {

        return new ShowDialogUtil(activity);
    }

    private ShowDialogUtil(Activity activity) {
        mActivity = activity;
    }

    public void showDialog(FragmentManager fragmentManager, ShareResponseBean shareResponseBean) {
        if (!ButtonUtils.isFastClick()) {
            return;
        }
        mDownloadDialog = new DownloadDialog();
        mDownloadDialog.showNow(fragmentManager, "DownloadDialog");
        startLoadResource(shareResponseBean);
    }

    /**
     * @ describe 资源下载入口方法
     * @author lzl
     * @ time 2020/11/13 11:34
     * @ param
     * @ return
     */
    private void startLoadResource(final ShareResponseBean shareResponseBean) {
        loadCopyText(shareResponseBean.getCopyString());
        mDownloadDialog.setPermissionCallBack(new DownloadDialog.IPermissionCallBack() {
            @Override
            public void success() {
                loadVideo(shareResponseBean.getVideoDownLoad());
                loadMaterialPic(shareResponseBean.getImageDownload());
            }

            @Override
            public void fail() {
                Toast.makeText(mActivity, "获取权限失败", Toast.LENGTH_LONG).show();
            }
        });
        mDownloadDialog.getPermission(mActivity);

    }

    /**
     * @ describe 文案复制
     * @author lzl
     * @ time 2020/11/12 10:47
     * @ param
     * @ return
     */
    private void loadCopyText(ShareResponseBean.CopyStringBean copyStringBean) {
        if(copyStringBean==null||TextUtils.isEmpty(copyStringBean.getCopyStr())){
            mDownloadDialog.setCopyTextFail(copyStringBean);
        }else{
            ClipboardUtil.copyText(mActivity, copyStringBean.getCopyStr());
            mDownloadDialog.setCopyTextSuccess(copyStringBean.getDisplayeStr());
        }

    }

    /**
     * @ describe 加载视频
     * @author lzl
     * @ time 2020/11/12 15:30
     * @ param
     * @ return
     */
    private void loadVideo(ShareResponseBean.VideoDownLoadBean videoDownLoadBean) {
        mDownloadDialog.loadVideo(videoDownLoadBean, mActivity);

    }

    /**
     * @ describe 存储小程序图片
     * @author lzl
     * @ time 2020/11/12 15:31
     * @ param
     * @ return
     */
    public void loadMiniProgram(Bitmap bitmap, ShareResponseBean.MiniProgramDownLaodBean miniProgramDownLaodBean) {
        mDownloadDialog.saveMiniProgramPic(bitmap, miniProgramDownLaodBean, mActivity);
    }

    /**
     * @ describe 加载素材图片
     * @author lzl
     * @ time 2020/11/12 15:32
     * @ param
     * @ return
     */
    private void loadMaterialPic(ShareResponseBean.ImageDownloadBean imageDownloadBean) {
        mDownloadDialog.loadMaterialPic(imageDownloadBean, mActivity);
    }
}
