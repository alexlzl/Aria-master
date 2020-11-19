package com.gome.download;

import java.util.List;

/**
 * @author lzl
 * @ describe
 * @ time 2020/11/12 10:44
 */
public class ShareResponseBean {
    /**
     * imageDownload : {"imageList":[{"imageUrl":"http://xxxxxxxx","imageSuffix":".jpg"}],"displayeStr":"下载显示的成功失败文案"}
     * copyString : {"displayeStr":"下载显示的成功失败文案","copyStr":"我是要复制的文案"}
     * videoDownLoad : {"displayeStr":"下载显示的成功失败文案","videoUrl":"http://xxxxxxxx","videoSuffix":".map4"}
     * miniProgramDownLaod : {"displayeStr":"下载显示的成功失败文案","universalParam":{"channelSelect":{"channelList":["weibo","wcfriend","wcmoments","wcmini","qq","qzone","gfriend","gcircle","gmoments","copylink","wcposters","commonposters","saveimage"],"scenceCode":"01-02-03","extendParam":{"key":"value"}},"targetMessage":{"type":"image-link","title":"分享标题","content":"分享内容","wapShareUrl":"分享链接","iconImage":"分享logo","bigImage":["img1","img2","img3"]},"source":{"type":"link-image-product-shop-circle-topic","souce":"1","mainID":"业务id","stid":"门店id","sourceInfo":{"productId":"productid","skuId":"商品id","itemType":"","groupId":"组团id"},"wapShareUrl":"","miniShareUrl":"","extendParam":{}},"extendParam":{"pastePromotion":"XXXXX","shareStatistic":{"type":"业务类型，01商品、02链接、03 店铺、04茅台....","mainID":"业务主键，商品为skuid；链接为cmsKey值或活动id；茅台是任务ID...","stid":"门店id","url":"分享的url，客户端拼接过cmpid和uid","sourceInfo":{"productId":"商品id","skuId":"商品id","itemType":"商品类型","groupId":"组团id","activeId":"茅台活动id","cmsKey":"茅台的场景说需要cmskey"}},"unShowSuccessPage":"Y 【禁止分享成功页展示】"}},"templateParam":[{"targetChannelList":["wcmini","wcmoments","wcposters","commonposters"],"childChannelMap":{"wcposters":["weibo","wcfriend","wcmoments","wcmini"]},"templateCode":"product01-activity02","supportSelfRequest":"Y","requestParam":"如果是自请求，就会从universalParam-source拿信息，这里不用重复写","renderParam":{"promDesc":"","name":"","content":"","imgUrls":["url1","url2"],"storeName":"","miniShareUrl":"","wapShareUrl":"","qrCodeImage":"","headLogoImg":"","footLogoImg":"","disclaimer":"","userImg":"","productInfo":{"itemLabel":"1：自营；2：联营；3：国美超市","itemType":"0：普通 1：团购 2：抢购 3：预约 4：预售 5：拼团","salePrice":"售价","markingPrice":"划线价","priceDesc":"","activityEndTime":" ","groupUserNum":"3人成团"},"cardImgUrl":"服务端渲染的图片地址","smallCardImgUrl":"服务端渲染小程序card图片","extendParam":{}}}]}
     */
    //下载图片素材
    private ImageDownloadBean imageDownload;
    //复制文本内容
    private CopyStringBean copyString;
    //下载视频内容
    private VideoDownLoadBean videoDownLoad;
    //小程序码下载内容
    private MiniProgramDownLaodBean miniProgramDownLaod;

    public ImageDownloadBean getImageDownload() {
        return imageDownload;
    }

    public void setImageDownload(ImageDownloadBean imageDownload) {
        this.imageDownload = imageDownload;
    }

    public CopyStringBean getCopyString() {
        return copyString;
    }

    public void setCopyString(CopyStringBean copyString) {
        this.copyString = copyString;
    }

    public VideoDownLoadBean getVideoDownLoad() {
        return videoDownLoad;
    }

    public void setVideoDownLoad(VideoDownLoadBean videoDownLoad) {
        this.videoDownLoad = videoDownLoad;
    }

    public MiniProgramDownLaodBean getMiniProgramDownLaod() {
        return miniProgramDownLaod;
    }

    public void setMiniProgramDownLaod(MiniProgramDownLaodBean miniProgramDownLaod) {
        this.miniProgramDownLaod = miniProgramDownLaod;
    }

    public static class ImageDownloadBean {
        /**
         * imageList : [{"imageUrl":"http://xxxxxxxx","imageSuffix":".jpg"}]
         * displayeStr : 下载显示的成功失败文案
         */

        private String displayeStr;
        private List<ImageListBean> imageList;

        public String getDisplayeStr() {
            return displayeStr;
        }

        public void setDisplayeStr(String displayeStr) {
            this.displayeStr = displayeStr;
        }

        public List<ImageListBean> getImageList() {
            return imageList;
        }

        public void setImageList(List<ImageListBean> imageList) {
            this.imageList = imageList;
        }

        public static class ImageListBean {
            /**
             * imageUrl : http://xxxxxxxx
             * imageSuffix : .jpg
             */

            private String imageUrl;
            private String imageSuffix;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getImageSuffix() {
                return imageSuffix;
            }

            public void setImageSuffix(String imageSuffix) {
                this.imageSuffix = imageSuffix;
            }
        }
    }

    public static class CopyStringBean {
        /**
         * displayeStr : 下载显示的成功失败文案
         * copyStr : 我是要复制的文案
         */

        private String displayeStr;
        private String copyStr;

        public String getDisplayeStr() {
            return displayeStr;
        }

        public void setDisplayeStr(String displayeStr) {
            this.displayeStr = displayeStr;
        }

        public String getCopyStr() {
            return copyStr;
        }

        public void setCopyStr(String copyStr) {
            this.copyStr = copyStr;
        }
    }

    public static class VideoDownLoadBean {
        /**
         * displayeStr : 下载显示的成功失败文案
         * videoUrl : http://xxxxxxxx
         * videoSuffix : .map4
         */

        private String displayeStr;
        private String videoUrl;
        private String videoSuffix;

        public String getDisplayeStr() {
            return displayeStr;
        }

        public void setDisplayeStr(String displayeStr) {
            this.displayeStr = displayeStr;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public String getVideoSuffix() {
            return videoSuffix;
        }

        public void setVideoSuffix(String videoSuffix) {
            this.videoSuffix = videoSuffix;
        }
    }

    public static class MiniProgramDownLaodBean {
        /**
         * displayeStr : 下载显示的成功失败文案
         * universalParam : {"channelSelect":{"channelList":["weibo","wcfriend","wcmoments","wcmini","qq","qzone","gfriend","gcircle","gmoments","copylink","wcposters","commonposters","saveimage"],"scenceCode":"01-02-03","extendParam":{"key":"value"}},"targetMessage":{"type":"image-link","title":"分享标题","content":"分享内容","wapShareUrl":"分享链接","iconImage":"分享logo","bigImage":["img1","img2","img3"]},"source":{"type":"link-image-product-shop-circle-topic","souce":"1","mainID":"业务id","stid":"门店id","sourceInfo":{"productId":"productid","skuId":"商品id","itemType":"","groupId":"组团id"},"wapShareUrl":"","miniShareUrl":"","extendParam":{}},"extendParam":{"pastePromotion":"XXXXX","shareStatistic":{"type":"业务类型，01商品、02链接、03 店铺、04茅台....","mainID":"业务主键，商品为skuid；链接为cmsKey值或活动id；茅台是任务ID...","stid":"门店id","url":"分享的url，客户端拼接过cmpid和uid","sourceInfo":{"productId":"商品id","skuId":"商品id","itemType":"商品类型","groupId":"组团id","activeId":"茅台活动id","cmsKey":"茅台的场景说需要cmskey"}},"unShowSuccessPage":"Y 【禁止分享成功页展示】"}}
         * templateParam : [{"targetChannelList":["wcmini","wcmoments","wcposters","commonposters"],"childChannelMap":{"wcposters":["weibo","wcfriend","wcmoments","wcmini"]},"templateCode":"product01-activity02","supportSelfRequest":"Y","requestParam":"如果是自请求，就会从universalParam-source拿信息，这里不用重复写","renderParam":{"promDesc":"","name":"","content":"","imgUrls":["url1","url2"],"storeName":"","miniShareUrl":"","wapShareUrl":"","qrCodeImage":"","headLogoImg":"","footLogoImg":"","disclaimer":"","userImg":"","productInfo":{"itemLabel":"1：自营；2：联营；3：国美超市","itemType":"0：普通 1：团购 2：抢购 3：预约 4：预售 5：拼团","salePrice":"售价","markingPrice":"划线价","priceDesc":"","activityEndTime":" ","groupUserNum":"3人成团"},"cardImgUrl":"服务端渲染的图片地址","smallCardImgUrl":"服务端渲染小程序card图片","extendParam":{}}}]
         */

        private String displayeStr;
        private UniversalParamBean universalParam;
        private List<TemplateParamBean> templateParam;

        public String getDisplayeStr() {
            return displayeStr;
        }

        public void setDisplayeStr(String displayeStr) {
            this.displayeStr = displayeStr;
        }

        public UniversalParamBean getUniversalParam() {
            return universalParam;
        }

        public void setUniversalParam(UniversalParamBean universalParam) {
            this.universalParam = universalParam;
        }

        public List<TemplateParamBean> getTemplateParam() {
            return templateParam;
        }

        public void setTemplateParam(List<TemplateParamBean> templateParam) {
            this.templateParam = templateParam;
        }

        public static class UniversalParamBean {
            /**
             * channelSelect : {"channelList":["weibo","wcfriend","wcmoments","wcmini","qq","qzone","gfriend","gcircle","gmoments","copylink","wcposters","commonposters","saveimage"],"scenceCode":"01-02-03","extendParam":{"key":"value"}}
             * targetMessage : {"type":"image-link","title":"分享标题","content":"分享内容","wapShareUrl":"分享链接","iconImage":"分享logo","bigImage":["img1","img2","img3"]}
             * source : {"type":"link-image-product-shop-circle-topic","souce":"1","mainID":"业务id","stid":"门店id","sourceInfo":{"productId":"productid","skuId":"商品id","itemType":"","groupId":"组团id"},"wapShareUrl":"","miniShareUrl":"","extendParam":{}}
             * extendParam : {"pastePromotion":"XXXXX","shareStatistic":{"type":"业务类型，01商品、02链接、03 店铺、04茅台....","mainID":"业务主键，商品为skuid；链接为cmsKey值或活动id；茅台是任务ID...","stid":"门店id","url":"分享的url，客户端拼接过cmpid和uid","sourceInfo":{"productId":"商品id","skuId":"商品id","itemType":"商品类型","groupId":"组团id","activeId":"茅台活动id","cmsKey":"茅台的场景说需要cmskey"}},"unShowSuccessPage":"Y 【禁止分享成功页展示】"}
             */

            private ChannelSelectBean channelSelect;
            private TargetMessageBean targetMessage;
            private SourceBean source;
            private ExtendParamBeanXX extendParam;

            public ChannelSelectBean getChannelSelect() {
                return channelSelect;
            }

            public void setChannelSelect(ChannelSelectBean channelSelect) {
                this.channelSelect = channelSelect;
            }

            public TargetMessageBean getTargetMessage() {
                return targetMessage;
            }

            public void setTargetMessage(TargetMessageBean targetMessage) {
                this.targetMessage = targetMessage;
            }

            public SourceBean getSource() {
                return source;
            }

            public void setSource(SourceBean source) {
                this.source = source;
            }

            public ExtendParamBeanXX getExtendParam() {
                return extendParam;
            }

            public void setExtendParam(ExtendParamBeanXX extendParam) {
                this.extendParam = extendParam;
            }

            public static class ChannelSelectBean {
                /**
                 * channelList : ["weibo","wcfriend","wcmoments","wcmini","qq","qzone","gfriend","gcircle","gmoments","copylink","wcposters","commonposters","saveimage"]
                 * scenceCode : 01-02-03
                 * extendParam : {"key":"value"}
                 */

                private String scenceCode;
                private ExtendParamBean extendParam;
                private List<String> channelList;

                public String getScenceCode() {
                    return scenceCode;
                }

                public void setScenceCode(String scenceCode) {
                    this.scenceCode = scenceCode;
                }

                public ExtendParamBean getExtendParam() {
                    return extendParam;
                }

                public void setExtendParam(ExtendParamBean extendParam) {
                    this.extendParam = extendParam;
                }

                public List<String> getChannelList() {
                    return channelList;
                }

                public void setChannelList(List<String> channelList) {
                    this.channelList = channelList;
                }

                public static class ExtendParamBean {
                    /**
                     * key : value
                     */

                    private String key;

                    public String getKey() {
                        return key;
                    }

                    public void setKey(String key) {
                        this.key = key;
                    }
                }
            }

            public static class TargetMessageBean {
                /**
                 * type : image-link
                 * title : 分享标题
                 * content : 分享内容
                 * wapShareUrl : 分享链接
                 * iconImage : 分享logo
                 * bigImage : ["img1","img2","img3"]
                 */

                private String type;
                private String title;
                private String content;
                private String wapShareUrl;
                private String iconImage;
                private List<String> bigImage;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getWapShareUrl() {
                    return wapShareUrl;
                }

                public void setWapShareUrl(String wapShareUrl) {
                    this.wapShareUrl = wapShareUrl;
                }

                public String getIconImage() {
                    return iconImage;
                }

                public void setIconImage(String iconImage) {
                    this.iconImage = iconImage;
                }

                public List<String> getBigImage() {
                    return bigImage;
                }

                public void setBigImage(List<String> bigImage) {
                    this.bigImage = bigImage;
                }
            }

            public static class SourceBean {
                /**
                 * type : link-image-product-shop-circle-topic
                 * souce : 1
                 * mainID : 业务id
                 * stid : 门店id
                 * sourceInfo : {"productId":"productid","skuId":"商品id","itemType":"","groupId":"组团id"}
                 * wapShareUrl :
                 * miniShareUrl :
                 * extendParam : {}
                 */

                private String type;
                private String souce;
                private String mainID;
                private String stid;
                private SourceInfoBean sourceInfo;
                private String wapShareUrl;
                private String miniShareUrl;
                private ExtendParamBeanX extendParam;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getSouce() {
                    return souce;
                }

                public void setSouce(String souce) {
                    this.souce = souce;
                }

                public String getMainID() {
                    return mainID;
                }

                public void setMainID(String mainID) {
                    this.mainID = mainID;
                }

                public String getStid() {
                    return stid;
                }

                public void setStid(String stid) {
                    this.stid = stid;
                }

                public SourceInfoBean getSourceInfo() {
                    return sourceInfo;
                }

                public void setSourceInfo(SourceInfoBean sourceInfo) {
                    this.sourceInfo = sourceInfo;
                }

                public String getWapShareUrl() {
                    return wapShareUrl;
                }

                public void setWapShareUrl(String wapShareUrl) {
                    this.wapShareUrl = wapShareUrl;
                }

                public String getMiniShareUrl() {
                    return miniShareUrl;
                }

                public void setMiniShareUrl(String miniShareUrl) {
                    this.miniShareUrl = miniShareUrl;
                }

                public ExtendParamBeanX getExtendParam() {
                    return extendParam;
                }

                public void setExtendParam(ExtendParamBeanX extendParam) {
                    this.extendParam = extendParam;
                }

                public static class SourceInfoBean {
                }

                public static class ExtendParamBeanX {
                }
            }

            public static class ExtendParamBeanXX {
                /**
                 * pastePromotion : XXXXX
                 * shareStatistic : {"type":"业务类型，01商品、02链接、03 店铺、04茅台....","mainID":"业务主键，商品为skuid；链接为cmsKey值或活动id；茅台是任务ID...","stid":"门店id","url":"分享的url，客户端拼接过cmpid和uid","sourceInfo":{"productId":"商品id","skuId":"商品id","itemType":"商品类型","groupId":"组团id","activeId":"茅台活动id","cmsKey":"茅台的场景说需要cmskey"}}
                 * unShowSuccessPage : Y 【禁止分享成功页展示】
                 */

                private String pastePromotion;
                private ShareStatisticBean shareStatistic;
                private String unShowSuccessPage;

                public String getPastePromotion() {
                    return pastePromotion;
                }

                public void setPastePromotion(String pastePromotion) {
                    this.pastePromotion = pastePromotion;
                }

                public ShareStatisticBean getShareStatistic() {
                    return shareStatistic;
                }

                public void setShareStatistic(ShareStatisticBean shareStatistic) {
                    this.shareStatistic = shareStatistic;
                }

                public String getUnShowSuccessPage() {
                    return unShowSuccessPage;
                }

                public void setUnShowSuccessPage(String unShowSuccessPage) {
                    this.unShowSuccessPage = unShowSuccessPage;
                }

                public static class ShareStatisticBean {
                    /**
                     * type : 业务类型，01商品、02链接、03 店铺、04茅台....
                     * mainID : 业务主键，商品为skuid；链接为cmsKey值或活动id；茅台是任务ID...
                     * stid : 门店id
                     * url : 分享的url，客户端拼接过cmpid和uid
                     * sourceInfo : {"productId":"商品id","skuId":"商品id","itemType":"商品类型","groupId":"组团id","activeId":"茅台活动id","cmsKey":"茅台的场景说需要cmskey"}
                     */

                    private String type;
                    private String mainID;
                    private String stid;
                    private String url;
                    private SourceInfoBeanX sourceInfo;

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getMainID() {
                        return mainID;
                    }

                    public void setMainID(String mainID) {
                        this.mainID = mainID;
                    }

                    public String getStid() {
                        return stid;
                    }

                    public void setStid(String stid) {
                        this.stid = stid;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public SourceInfoBeanX getSourceInfo() {
                        return sourceInfo;
                    }

                    public void setSourceInfo(SourceInfoBeanX sourceInfo) {
                        this.sourceInfo = sourceInfo;
                    }

                    public static class SourceInfoBeanX {
                        /**
                         * productId : 商品id
                         * skuId : 商品id
                         * itemType : 商品类型
                         * groupId : 组团id
                         * activeId : 茅台活动id
                         * cmsKey : 茅台的场景说需要cmskey
                         */

                        private String productId;
                        private String skuId;
                        private String itemType;
                        private String groupId;
                        private String activeId;
                        private String cmsKey;

                        public String getProductId() {
                            return productId;
                        }

                        public void setProductId(String productId) {
                            this.productId = productId;
                        }

                        public String getSkuId() {
                            return skuId;
                        }

                        public void setSkuId(String skuId) {
                            this.skuId = skuId;
                        }

                        public String getItemType() {
                            return itemType;
                        }

                        public void setItemType(String itemType) {
                            this.itemType = itemType;
                        }

                        public String getGroupId() {
                            return groupId;
                        }

                        public void setGroupId(String groupId) {
                            this.groupId = groupId;
                        }

                        public String getActiveId() {
                            return activeId;
                        }

                        public void setActiveId(String activeId) {
                            this.activeId = activeId;
                        }

                        public String getCmsKey() {
                            return cmsKey;
                        }

                        public void setCmsKey(String cmsKey) {
                            this.cmsKey = cmsKey;
                        }
                    }
                }
            }
        }

        public static class TemplateParamBean {
            /**
             * targetChannelList : ["wcmini","wcmoments","wcposters","commonposters"]
             * childChannelMap : {"wcposters":["weibo","wcfriend","wcmoments","wcmini"]}
             * templateCode : product01-activity02
             * supportSelfRequest : Y
             * requestParam : 如果是自请求，就会从universalParam-source拿信息，这里不用重复写
             * renderParam : {"promDesc":"","name":"","content":"","imgUrls":["url1","url2"],"storeName":"","miniShareUrl":"","wapShareUrl":"","qrCodeImage":"","headLogoImg":"","footLogoImg":"","disclaimer":"","userImg":"","productInfo":{"itemLabel":"1：自营；2：联营；3：国美超市","itemType":"0：普通 1：团购 2：抢购 3：预约 4：预售 5：拼团","salePrice":"售价","markingPrice":"划线价","priceDesc":"","activityEndTime":" ","groupUserNum":"3人成团"},"cardImgUrl":"服务端渲染的图片地址","smallCardImgUrl":"服务端渲染小程序card图片","extendParam":{}}
             */

            private ChildChannelMapBean childChannelMap;
            private String templateCode;
            private String supportSelfRequest;
            private String requestParam;
            private RenderParamBean renderParam;
            private List<String> targetChannelList;

            public ChildChannelMapBean getChildChannelMap() {
                return childChannelMap;
            }

            public void setChildChannelMap(ChildChannelMapBean childChannelMap) {
                this.childChannelMap = childChannelMap;
            }

            public String getTemplateCode() {
                return templateCode;
            }

            public void setTemplateCode(String templateCode) {
                this.templateCode = templateCode;
            }

            public String getSupportSelfRequest() {
                return supportSelfRequest;
            }

            public void setSupportSelfRequest(String supportSelfRequest) {
                this.supportSelfRequest = supportSelfRequest;
            }

            public String getRequestParam() {
                return requestParam;
            }

            public void setRequestParam(String requestParam) {
                this.requestParam = requestParam;
            }

            public RenderParamBean getRenderParam() {
                return renderParam;
            }

            public void setRenderParam(RenderParamBean renderParam) {
                this.renderParam = renderParam;
            }

            public List<String> getTargetChannelList() {
                return targetChannelList;
            }

            public void setTargetChannelList(List<String> targetChannelList) {
                this.targetChannelList = targetChannelList;
            }

            public static class ChildChannelMapBean {
                private List<String> wcposters;

                public List<String> getWcposters() {
                    return wcposters;
                }

                public void setWcposters(List<String> wcposters) {
                    this.wcposters = wcposters;
                }
            }

            public static class RenderParamBean {
                /**
                 * promDesc :
                 * name :
                 * content :
                 * imgUrls : ["url1","url2"]
                 * storeName :
                 * miniShareUrl :
                 * wapShareUrl :
                 * qrCodeImage :
                 * headLogoImg :
                 * footLogoImg :
                 * disclaimer :
                 * userImg :
                 * productInfo : {"itemLabel":"1：自营；2：联营；3：国美超市","itemType":"0：普通 1：团购 2：抢购 3：预约 4：预售 5：拼团","salePrice":"售价","markingPrice":"划线价","priceDesc":"","activityEndTime":" ","groupUserNum":"3人成团"}
                 * cardImgUrl : 服务端渲染的图片地址
                 * smallCardImgUrl : 服务端渲染小程序card图片
                 * extendParam : {}
                 */

                private String promDesc;
                private String name;
                private String content;
                private String storeName;
                private String miniShareUrl;
                private String wapShareUrl;
                private String qrCodeImage;
                private String headLogoImg;
                private String footLogoImg;
                private String disclaimer;
                private String userImg;
                private ProductInfoBean productInfo;
                private String cardImgUrl;
                private String smallCardImgUrl;
                private ExtendParamBeanXXX extendParam;
                private List<String> imgUrls;

                public String getPromDesc() {
                    return promDesc;
                }

                public void setPromDesc(String promDesc) {
                    this.promDesc = promDesc;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getStoreName() {
                    return storeName;
                }

                public void setStoreName(String storeName) {
                    this.storeName = storeName;
                }

                public String getMiniShareUrl() {
                    return miniShareUrl;
                }

                public void setMiniShareUrl(String miniShareUrl) {
                    this.miniShareUrl = miniShareUrl;
                }

                public String getWapShareUrl() {
                    return wapShareUrl;
                }

                public void setWapShareUrl(String wapShareUrl) {
                    this.wapShareUrl = wapShareUrl;
                }

                public String getQrCodeImage() {
                    return qrCodeImage;
                }

                public void setQrCodeImage(String qrCodeImage) {
                    this.qrCodeImage = qrCodeImage;
                }

                public String getHeadLogoImg() {
                    return headLogoImg;
                }

                public void setHeadLogoImg(String headLogoImg) {
                    this.headLogoImg = headLogoImg;
                }

                public String getFootLogoImg() {
                    return footLogoImg;
                }

                public void setFootLogoImg(String footLogoImg) {
                    this.footLogoImg = footLogoImg;
                }

                public String getDisclaimer() {
                    return disclaimer;
                }

                public void setDisclaimer(String disclaimer) {
                    this.disclaimer = disclaimer;
                }

                public String getUserImg() {
                    return userImg;
                }

                public void setUserImg(String userImg) {
                    this.userImg = userImg;
                }

                public ProductInfoBean getProductInfo() {
                    return productInfo;
                }

                public void setProductInfo(ProductInfoBean productInfo) {
                    this.productInfo = productInfo;
                }

                public String getCardImgUrl() {
                    return cardImgUrl;
                }

                public void setCardImgUrl(String cardImgUrl) {
                    this.cardImgUrl = cardImgUrl;
                }

                public String getSmallCardImgUrl() {
                    return smallCardImgUrl;
                }

                public void setSmallCardImgUrl(String smallCardImgUrl) {
                    this.smallCardImgUrl = smallCardImgUrl;
                }

                public ExtendParamBeanXXX getExtendParam() {
                    return extendParam;
                }

                public void setExtendParam(ExtendParamBeanXXX extendParam) {
                    this.extendParam = extendParam;
                }

                public List<String> getImgUrls() {
                    return imgUrls;
                }

                public void setImgUrls(List<String> imgUrls) {
                    this.imgUrls = imgUrls;
                }

                public static class ProductInfoBean {
                }

                public static class ExtendParamBeanXXX {
                }
            }
        }
    }
}
