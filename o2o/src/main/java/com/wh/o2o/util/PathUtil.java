package com.wh.o2o.util;

public class PathUtil {

    //文件间隔符替换
    private static String seperator = System.getProperty("file.separator");

    /**
     * 获取图片基本路径
     * @return
     */
    public static String getImgBasePath(){
        //获取系统类型
        String os = System.getProperty("os.name");
        String basePath = "";

        if(os.toLowerCase().startsWith("win")){
            basePath = "D:/projectdev/image/";
        } else {
            basePath = "/home/xiangze/image/";
        }
        basePath = basePath.replace("/", seperator);
        return basePath;
    }

    /**
     * 获取图片子路径
     * @param shopId
     * @return
     */
    public static String getShopImagePath(long shopId){
        String imagePath = "/upload/item/shop/" + shopId + "/";
        return imagePath.replace("/", seperator);
    }




}
