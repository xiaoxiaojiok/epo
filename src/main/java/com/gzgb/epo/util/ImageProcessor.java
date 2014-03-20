package com.gzgb.epo.util;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageProcessor {
	public static String createIcon(String drectory, String fileName) {
        try {
        	String filePath = drectory+'\\'+fileName;
        	int index = fileName.lastIndexOf('.');
        	String format = fileName.substring((index+1), fileName.length());
            File fiBig = new File(filePath); // 大图文件
            File foSmall = new File(drectory+'\\'+"little"+fileName); // 将要转换出的小图文件

            AffineTransform transform = new AffineTransform();
            //读取图片
            BufferedImage bis = ImageIO.read(fiBig);
            //获得图片原来的高宽
            int w = bis.getWidth();
            int h = bis.getHeight();
            
            double scale = (double) w / h;
           //等比例缩放　
            int nowWidth = 120;
            int nowHeight = (nowWidth * h) / w;
            if (nowHeight > 120) {
                nowHeight = 120;
                nowWidth = (nowHeight * w) / h;
            }

            double sx = (double) nowWidth / w;
            double sy = (double) nowHeight / h;

            transform.setToScale(sx, sy);

            AffineTransformOp ato = new AffineTransformOp(transform, null);
            BufferedImage bid = new BufferedImage(nowWidth, nowHeight,
                    BufferedImage.TYPE_3BYTE_BGR);
            ato.filter(bis, bid);
            
            ImageIO.write(bid, format, foSmall);
            return drectory+'\\'+"little"+fileName;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
