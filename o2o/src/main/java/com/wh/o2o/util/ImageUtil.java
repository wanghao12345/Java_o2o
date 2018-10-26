package com.wh.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    //项目水印图的基本路径
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    //时间格式
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    //随机数
    private static final Random r = new Random();
    /**
     * 缩略图
     * @return
     */
    public static String generateThumbnail(CommonsMultipartFile thumbnail, String targetAddr){
        //生成随机文件名
        String realFileName = getRandomFileName();
        //获取文件后缀名
        String extension = getFileExtension(thumbnail);
        //创建目标路径所涉及到的目录
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
     * 生成随机文件名,当前年月日小时分钟秒钟+五位随机数
     * @return
     */
    private static String getRandomFileName() {
        //获取随机五位数
        int rannum = r.nextInt(89999) + 10000;
        //当前的时间
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr + rannum;
    }

    /**
     * 获取输入文件流的扩展名
     * @param cFile
     * @return
     */
    private static String getFileExtension(CommonsMultipartFile cFile) {
        //获取文件名
        String originalFileName = cFile.getOriginalFilename();
        //获取文件名的后缀
        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }

    /**
     * 创建目标路径所涉及到的目录，即/home/work/xiangze/xxx.jpg
     * 那么home work xiangze这三个文件夹都得自动创建
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        //获取文件存放路径
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        //获取文件路径文件夹
        File dirPath = new File(realFileParentPath);
        //如果文件路径文件夹不存在创建
        if (!dirPath.exists()){
            dirPath.mkdirs();
        }
    }

    public static void main(String[] args) throws IOException {
        Thumbnails.of(new File("C:/Users/wh/Desktop/img/timg.jpg")).size(200, 200)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/share.png")), 0.25f)
                .outputQuality(0.8f).toFile("C:/Users/wh/Desktop/img/timgnew.jpg");

    }
}
