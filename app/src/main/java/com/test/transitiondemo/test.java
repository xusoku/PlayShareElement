package com.test.transitiondemo;

import java.util.List;

/**
 * Created by xushengfu on 2019/5/5.
 */

public class test {


    /**
     * code : 1
     * data : {"id":"5","title":"大标题","subtitle":"今日推荐","thumbnail_type":"3","thumbnail_url":"2","video_img":"http://test.cdn.sunmi.com/IMG/5cc542d0ccd88.jpg","summary":"概述概述333","subjectModule":[{"id":"19","subject_id":"5","content":[{"type":"4","detail":"有热呀热呀"},{"type":"4","detail":"有热呀热呀"}],"app_list":[{"aId":"31","downUrl":"http://apk.cdn.sunmi.com/APK/5b7548571ca08.apk","versionCode":"100763","versionName":"7.8.5","fileSize":"35183461","updateInfo":"1、支持App扫码登录电脑端\n2、支持自主绑定/换绑手机号\n3、订单设置功能整合优化\n4、商品分类支持分时置顶\n5、视频拍摄功能上线，加滤镜加音乐","md5":"ba7220c73923f59af84ebaefcb59bb75","doubleScreen":"0","status":"1","dev":"饿了么","cfId":"1","appName":"饿了么商家版","installType":"0","iconUrl":"http://pic.cdn.sunmi.com/file/image/developers/160119/14531785202366.png","score":1,"lastModify":"1534412909","downLoadNum":"710069","packageName":"me.ele.napos","isFreeTry":"0","appPrice":"0","partlyVisible":"0","summary":"用手机在网上开餐厅，随时随地接订单、超快速处理订单、待确认订单、退单、催单一屏处理，多维度查阅订单，查看订单再也不用来回翻，全方位管理店铺，你最关心都在这里，高精度查询账单，各项资金一目了然，最高效处理问题设置、反馈、帮助，马上下载完成注册， 用手机在网上开餐厅。"},{"aId":"31","downUrl":"http://apk.cdn.sunmi.com/APK/5b7548571ca08.apk","versionCode":"100763","versionName":"7.8.5","fileSize":"35183461","updateInfo":"1、支持App扫码登录电脑端\n2、支持自主绑定/换绑手机号\n3、订单设置功能整合优化\n4、商品分类支持分时置顶\n5、视频拍摄功能上线，加滤镜加音乐","md5":"ba7220c73923f59af84ebaefcb59bb75","doubleScreen":"0","status":"1","dev":"饿了么","cfId":"1","appName":"饿了么商家版","installType":"0","iconUrl":"http://pic.cdn.sunmi.com/file/image/developers/160119/14531785202366.png","score":1,"lastModify":"1534412909","downLoadNum":"710069","packageName":"me.ele.napos","isFreeTry":"0","appPrice":"0","partlyVisible":"0","summary":"用手机在网上开餐厅，随时随地接订单、超快速处理订单、待确认订单、退单、催单一屏处理，多维度查阅订单，查看订单再也不用来回翻，全方位管理店铺，你最关心都在这里，高精度查询账单，各项资金一目了然，最高效处理问题设置、反馈、帮助，马上下载完成注册， 用手机在网上开餐厅。"}]},{"id":"19","subject_id":"5","content":[{"type":"4","detail":"有热呀热呀"},{"type":"4","detail":"有热呀热呀"}],"app_list":[{"aId":"31","downUrl":"http://apk.cdn.sunmi.com/APK/5b7548571ca08.apk","versionCode":"100763","versionName":"7.8.5","fileSize":"35183461","updateInfo":"1、支持App扫码登录电脑端\n2、支持自主绑定/换绑手机号\n3、订单设置功能整合优化\n4、商品分类支持分时置顶\n5、视频拍摄功能上线，加滤镜加音乐","md5":"ba7220c73923f59af84ebaefcb59bb75","doubleScreen":"0","status":"1","dev":"饿了么","cfId":"1","appName":"饿了么商家版","installType":"0","iconUrl":"http://pic.cdn.sunmi.com/file/image/developers/160119/14531785202366.png","score":1,"lastModify":"1534412909","downLoadNum":"710069","packageName":"me.ele.napos","isFreeTry":"0","appPrice":"0","partlyVisible":"0","summary":"用手机在网上开餐厅，随时随地接订单、超快速处理订单、待确认订单、退单、催单一屏处理，多维度查阅订单，查看订单再也不用来回翻，全方位管理店铺，你最关心都在这里，高精度查询账单，各项资金一目了然，最高效处理问题设置、反馈、帮助，马上下载完成注册， 用手机在网上开餐厅。"},{"aId":"31","downUrl":"http://apk.cdn.sunmi.com/APK/5b7548571ca08.apk","versionCode":"100763","versionName":"7.8.5","fileSize":"35183461","updateInfo":"1、支持App扫码登录电脑端\n2、支持自主绑定/换绑手机号\n3、订单设置功能整合优化\n4、商品分类支持分时置顶\n5、视频拍摄功能上线，加滤镜加音乐","md5":"ba7220c73923f59af84ebaefcb59bb75","doubleScreen":"0","status":"1","dev":"饿了么","cfId":"1","appName":"饿了么商家版","installType":"0","iconUrl":"http://pic.cdn.sunmi.com/file/image/developers/160119/14531785202366.png","score":1,"lastModify":"1534412909","downLoadNum":"710069","packageName":"me.ele.napos","isFreeTry":"0","appPrice":"0","partlyVisible":"0","summary":"用手机在网上开餐厅，随时随地接订单、超快速处理订单、待确认订单、退单、催单一屏处理，多维度查阅订单，查看订单再也不用来回翻，全方位管理店铺，你最关心都在这里，高精度查询账单，各项资金一目了然，最高效处理问题设置、反馈、帮助，马上下载完成注册， 用手机在网上开餐厅。"}]}]}
     * msg :
     */

    private int code;
    private DataBean data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * id : 5
         * title : 大标题
         * subtitle : 今日推荐
         * thumbnail_type : 3
         * thumbnail_url : 2
         * video_img : http://test.cdn.sunmi.com/IMG/5cc542d0ccd88.jpg
         * summary : 概述概述333
         * subjectModule : [{"id":"19","subject_id":"5","content":[{"type":"4","detail":"有热呀热呀"},{"type":"4","detail":"有热呀热呀"}],"app_list":[{"aId":"31","downUrl":"http://apk.cdn.sunmi.com/APK/5b7548571ca08.apk","versionCode":"100763","versionName":"7.8.5","fileSize":"35183461","updateInfo":"1、支持App扫码登录电脑端\n2、支持自主绑定/换绑手机号\n3、订单设置功能整合优化\n4、商品分类支持分时置顶\n5、视频拍摄功能上线，加滤镜加音乐","md5":"ba7220c73923f59af84ebaefcb59bb75","doubleScreen":"0","status":"1","dev":"饿了么","cfId":"1","appName":"饿了么商家版","installType":"0","iconUrl":"http://pic.cdn.sunmi.com/file/image/developers/160119/14531785202366.png","score":1,"lastModify":"1534412909","downLoadNum":"710069","packageName":"me.ele.napos","isFreeTry":"0","appPrice":"0","partlyVisible":"0","summary":"用手机在网上开餐厅，随时随地接订单、超快速处理订单、待确认订单、退单、催单一屏处理，多维度查阅订单，查看订单再也不用来回翻，全方位管理店铺，你最关心都在这里，高精度查询账单，各项资金一目了然，最高效处理问题设置、反馈、帮助，马上下载完成注册， 用手机在网上开餐厅。"},{"aId":"31","downUrl":"http://apk.cdn.sunmi.com/APK/5b7548571ca08.apk","versionCode":"100763","versionName":"7.8.5","fileSize":"35183461","updateInfo":"1、支持App扫码登录电脑端\n2、支持自主绑定/换绑手机号\n3、订单设置功能整合优化\n4、商品分类支持分时置顶\n5、视频拍摄功能上线，加滤镜加音乐","md5":"ba7220c73923f59af84ebaefcb59bb75","doubleScreen":"0","status":"1","dev":"饿了么","cfId":"1","appName":"饿了么商家版","installType":"0","iconUrl":"http://pic.cdn.sunmi.com/file/image/developers/160119/14531785202366.png","score":1,"lastModify":"1534412909","downLoadNum":"710069","packageName":"me.ele.napos","isFreeTry":"0","appPrice":"0","partlyVisible":"0","summary":"用手机在网上开餐厅，随时随地接订单、超快速处理订单、待确认订单、退单、催单一屏处理，多维度查阅订单，查看订单再也不用来回翻，全方位管理店铺，你最关心都在这里，高精度查询账单，各项资金一目了然，最高效处理问题设置、反馈、帮助，马上下载完成注册， 用手机在网上开餐厅。"}]},{"id":"19","subject_id":"5","content":[{"type":"4","detail":"有热呀热呀"},{"type":"4","detail":"有热呀热呀"}],"app_list":[{"aId":"31","downUrl":"http://apk.cdn.sunmi.com/APK/5b7548571ca08.apk","versionCode":"100763","versionName":"7.8.5","fileSize":"35183461","updateInfo":"1、支持App扫码登录电脑端\n2、支持自主绑定/换绑手机号\n3、订单设置功能整合优化\n4、商品分类支持分时置顶\n5、视频拍摄功能上线，加滤镜加音乐","md5":"ba7220c73923f59af84ebaefcb59bb75","doubleScreen":"0","status":"1","dev":"饿了么","cfId":"1","appName":"饿了么商家版","installType":"0","iconUrl":"http://pic.cdn.sunmi.com/file/image/developers/160119/14531785202366.png","score":1,"lastModify":"1534412909","downLoadNum":"710069","packageName":"me.ele.napos","isFreeTry":"0","appPrice":"0","partlyVisible":"0","summary":"用手机在网上开餐厅，随时随地接订单、超快速处理订单、待确认订单、退单、催单一屏处理，多维度查阅订单，查看订单再也不用来回翻，全方位管理店铺，你最关心都在这里，高精度查询账单，各项资金一目了然，最高效处理问题设置、反馈、帮助，马上下载完成注册， 用手机在网上开餐厅。"},{"aId":"31","downUrl":"http://apk.cdn.sunmi.com/APK/5b7548571ca08.apk","versionCode":"100763","versionName":"7.8.5","fileSize":"35183461","updateInfo":"1、支持App扫码登录电脑端\n2、支持自主绑定/换绑手机号\n3、订单设置功能整合优化\n4、商品分类支持分时置顶\n5、视频拍摄功能上线，加滤镜加音乐","md5":"ba7220c73923f59af84ebaefcb59bb75","doubleScreen":"0","status":"1","dev":"饿了么","cfId":"1","appName":"饿了么商家版","installType":"0","iconUrl":"http://pic.cdn.sunmi.com/file/image/developers/160119/14531785202366.png","score":1,"lastModify":"1534412909","downLoadNum":"710069","packageName":"me.ele.napos","isFreeTry":"0","appPrice":"0","partlyVisible":"0","summary":"用手机在网上开餐厅，随时随地接订单、超快速处理订单、待确认订单、退单、催单一屏处理，多维度查阅订单，查看订单再也不用来回翻，全方位管理店铺，你最关心都在这里，高精度查询账单，各项资金一目了然，最高效处理问题设置、反馈、帮助，马上下载完成注册， 用手机在网上开餐厅。"}]}]
         */

        private String id;
        private String title;
        private String subtitle;
        private String thumbnail_type;
        private String thumbnail_url;
        private String video_img;
        private String summary;
        private List<SubjectModuleBean> subjectModule;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getThumbnail_type() {
            return thumbnail_type;
        }

        public void setThumbnail_type(String thumbnail_type) {
            this.thumbnail_type = thumbnail_type;
        }

        public String getThumbnail_url() {
            return thumbnail_url;
        }

        public void setThumbnail_url(String thumbnail_url) {
            this.thumbnail_url = thumbnail_url;
        }

        public String getVideo_img() {
            return video_img;
        }

        public void setVideo_img(String video_img) {
            this.video_img = video_img;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public List<SubjectModuleBean> getSubjectModule() {
            return subjectModule;
        }

        public void setSubjectModule(List<SubjectModuleBean> subjectModule) {
            this.subjectModule = subjectModule;
        }

        public static class SubjectModuleBean {
            /**
             * id : 19
             * subject_id : 5
             * content : [{"type":"4","detail":"有热呀热呀"},{"type":"4","detail":"有热呀热呀"}]
             * app_list : [{"aId":"31","downUrl":"http://apk.cdn.sunmi.com/APK/5b7548571ca08.apk","versionCode":"100763","versionName":"7.8.5","fileSize":"35183461","updateInfo":"1、支持App扫码登录电脑端\n2、支持自主绑定/换绑手机号\n3、订单设置功能整合优化\n4、商品分类支持分时置顶\n5、视频拍摄功能上线，加滤镜加音乐","md5":"ba7220c73923f59af84ebaefcb59bb75","doubleScreen":"0","status":"1","dev":"饿了么","cfId":"1","appName":"饿了么商家版","installType":"0","iconUrl":"http://pic.cdn.sunmi.com/file/image/developers/160119/14531785202366.png","score":1,"lastModify":"1534412909","downLoadNum":"710069","packageName":"me.ele.napos","isFreeTry":"0","appPrice":"0","partlyVisible":"0","summary":"用手机在网上开餐厅，随时随地接订单、超快速处理订单、待确认订单、退单、催单一屏处理，多维度查阅订单，查看订单再也不用来回翻，全方位管理店铺，你最关心都在这里，高精度查询账单，各项资金一目了然，最高效处理问题设置、反馈、帮助，马上下载完成注册， 用手机在网上开餐厅。"},{"aId":"31","downUrl":"http://apk.cdn.sunmi.com/APK/5b7548571ca08.apk","versionCode":"100763","versionName":"7.8.5","fileSize":"35183461","updateInfo":"1、支持App扫码登录电脑端\n2、支持自主绑定/换绑手机号\n3、订单设置功能整合优化\n4、商品分类支持分时置顶\n5、视频拍摄功能上线，加滤镜加音乐","md5":"ba7220c73923f59af84ebaefcb59bb75","doubleScreen":"0","status":"1","dev":"饿了么","cfId":"1","appName":"饿了么商家版","installType":"0","iconUrl":"http://pic.cdn.sunmi.com/file/image/developers/160119/14531785202366.png","score":1,"lastModify":"1534412909","downLoadNum":"710069","packageName":"me.ele.napos","isFreeTry":"0","appPrice":"0","partlyVisible":"0","summary":"用手机在网上开餐厅，随时随地接订单、超快速处理订单、待确认订单、退单、催单一屏处理，多维度查阅订单，查看订单再也不用来回翻，全方位管理店铺，你最关心都在这里，高精度查询账单，各项资金一目了然，最高效处理问题设置、反馈、帮助，马上下载完成注册， 用手机在网上开餐厅。"}]
             */

            private String id;
            private String subject_id;
            private List<ContentBean> content;
            private List<AppListBean> app_list;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getSubject_id() {
                return subject_id;
            }

            public void setSubject_id(String subject_id) {
                this.subject_id = subject_id;
            }

            public List<ContentBean> getContent() {
                return content;
            }

            public void setContent(List<ContentBean> content) {
                this.content = content;
            }

            public List<AppListBean> getApp_list() {
                return app_list;
            }

            public void setApp_list(List<AppListBean> app_list) {
                this.app_list = app_list;
            }

            public static class ContentBean {
                /**
                 * type : 4
                 * detail : 有热呀热呀
                 */

                private String type;
                private String detail;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getDetail() {
                    return detail;
                }

                public void setDetail(String detail) {
                    this.detail = detail;
                }
            }

            public static class AppListBean {
                /**
                 * aId : 31
                 * downUrl : http://apk.cdn.sunmi.com/APK/5b7548571ca08.apk
                 * versionCode : 100763
                 * versionName : 7.8.5
                 * fileSize : 35183461
                 * updateInfo : 1、支持App扫码登录电脑端
                 2、支持自主绑定/换绑手机号
                 3、订单设置功能整合优化
                 4、商品分类支持分时置顶
                 5、视频拍摄功能上线，加滤镜加音乐
                 * md5 : ba7220c73923f59af84ebaefcb59bb75
                 * doubleScreen : 0
                 * status : 1
                 * dev : 饿了么
                 * cfId : 1
                 * appName : 饿了么商家版
                 * installType : 0
                 * iconUrl : http://pic.cdn.sunmi.com/file/image/developers/160119/14531785202366.png
                 * score : 1
                 * lastModify : 1534412909
                 * downLoadNum : 710069
                 * packageName : me.ele.napos
                 * isFreeTry : 0
                 * appPrice : 0
                 * partlyVisible : 0
                 * summary : 用手机在网上开餐厅，随时随地接订单、超快速处理订单、待确认订单、退单、催单一屏处理，多维度查阅订单，查看订单再也不用来回翻，全方位管理店铺，你最关心都在这里，高精度查询账单，各项资金一目了然，最高效处理问题设置、反馈、帮助，马上下载完成注册， 用手机在网上开餐厅。
                 */

                private String aId;
                private String downUrl;
                private String versionCode;
                private String versionName;
                private String fileSize;
                private String updateInfo;
                private String md5;
                private String doubleScreen;
                private String status;
                private String dev;
                private String cfId;
                private String appName;
                private String installType;
                private String iconUrl;
                private int score;
                private String lastModify;
                private String downLoadNum;
                private String packageName;
                private String isFreeTry;
                private String appPrice;
                private String partlyVisible;
                private String summary;

                public String getAId() {
                    return aId;
                }

                public void setAId(String aId) {
                    this.aId = aId;
                }

                public String getDownUrl() {
                    return downUrl;
                }

                public void setDownUrl(String downUrl) {
                    this.downUrl = downUrl;
                }

                public String getVersionCode() {
                    return versionCode;
                }

                public void setVersionCode(String versionCode) {
                    this.versionCode = versionCode;
                }

                public String getVersionName() {
                    return versionName;
                }

                public void setVersionName(String versionName) {
                    this.versionName = versionName;
                }

                public String getFileSize() {
                    return fileSize;
                }

                public void setFileSize(String fileSize) {
                    this.fileSize = fileSize;
                }

                public String getUpdateInfo() {
                    return updateInfo;
                }

                public void setUpdateInfo(String updateInfo) {
                    this.updateInfo = updateInfo;
                }

                public String getMd5() {
                    return md5;
                }

                public void setMd5(String md5) {
                    this.md5 = md5;
                }

                public String getDoubleScreen() {
                    return doubleScreen;
                }

                public void setDoubleScreen(String doubleScreen) {
                    this.doubleScreen = doubleScreen;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getDev() {
                    return dev;
                }

                public void setDev(String dev) {
                    this.dev = dev;
                }

                public String getCfId() {
                    return cfId;
                }

                public void setCfId(String cfId) {
                    this.cfId = cfId;
                }

                public String getAppName() {
                    return appName;
                }

                public void setAppName(String appName) {
                    this.appName = appName;
                }

                public String getInstallType() {
                    return installType;
                }

                public void setInstallType(String installType) {
                    this.installType = installType;
                }

                public String getIconUrl() {
                    return iconUrl;
                }

                public void setIconUrl(String iconUrl) {
                    this.iconUrl = iconUrl;
                }

                public int getScore() {
                    return score;
                }

                public void setScore(int score) {
                    this.score = score;
                }

                public String getLastModify() {
                    return lastModify;
                }

                public void setLastModify(String lastModify) {
                    this.lastModify = lastModify;
                }

                public String getDownLoadNum() {
                    return downLoadNum;
                }

                public void setDownLoadNum(String downLoadNum) {
                    this.downLoadNum = downLoadNum;
                }

                public String getPackageName() {
                    return packageName;
                }

                public void setPackageName(String packageName) {
                    this.packageName = packageName;
                }

                public String getIsFreeTry() {
                    return isFreeTry;
                }

                public void setIsFreeTry(String isFreeTry) {
                    this.isFreeTry = isFreeTry;
                }

                public String getAppPrice() {
                    return appPrice;
                }

                public void setAppPrice(String appPrice) {
                    this.appPrice = appPrice;
                }

                public String getPartlyVisible() {
                    return partlyVisible;
                }

                public void setPartlyVisible(String partlyVisible) {
                    this.partlyVisible = partlyVisible;
                }

                public String getSummary() {
                    return summary;
                }

                public void setSummary(String summary) {
                    this.summary = summary;
                }
            }
        }
    }
}
