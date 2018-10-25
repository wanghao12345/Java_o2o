package com.wh.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImageUtil {
    //项目水印图的基本路径

    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    /**
     * 缩略图
     * @return
     */
    public static String generateThumbnail(CommonsMultipartFile thumbnail, String targetAddr){
        //生成随机文件名
        String realFileName = getRandomFileName();
        //生成文件版本
        String extension = getFileExtension(thumbnail);
        //对应路径创建文件夹
        makeDirPath(targetAddr);
        //文件具体位置
        String relativeAddr = targetAddr + realFileName + extension;
        //生成缩略图地址
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(thumbnail.getInputStream()).size(200,200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/share.png")), 0.25f)
                    .outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "";
    }

    /**
     * 对应路径创建文件夹
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {

    }

    /**
     * 生成文件版本
     * @param thumbnail
     * @return
     */
    private static String getFileExtension(CommonsMultipartFile thumbnail) {
        return null;
    }

    /**
     * 生成随机文件名,当前年月日小时分钟秒钟
     * @return
     */
    private static String getRandomFileName() {
        return null;
    }


    public static void main(String[] args) throws IOException {
        Thumbnails.of(new File("C:/Users/wh/Desktop/img/timg.jpg")).size(200, 200)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/share.png")), 0.25f)
                .outputQuality(0.8f).toFile("C:/Users/wh/Desktop/img/timgnew.jpg");

    }
}
