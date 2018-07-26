package com.common.imageHandler;

import com.common.javacv.ComposeVideo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ImageWaterMark extends ImageHandle {

    private final Logger logger = LoggerFactory.getLogger(ImageWaterMark.class);

    private String smallLogo; //LOGO图片的路径 小图标
    private String bigLogo;   //LOGO图片的路径 大图标

    /**
     * 图片添加水印
     * @param imageFile 图片文件
     */
    public void iamgeAddLogo(File imageFile){
        OutputStream os = null;
        try{
                //原图片对象
                Image srcImg = ImageIO.read(imageFile);
                if(srcImg == null){
                    logger.error("该图片是一个损坏的图片. imageFile:{}",imageFile);
                    return;
                }
                int width = srcImg.getWidth(null);
                int height = srcImg.getHeight(null);

                // logo图片的路径
                String logoPath = this.smallLogo;
                if(width>1000){
                    logoPath = this.bigLogo;
                }
                ImageIcon imgIcon = new ImageIcon(logoPath);
                // logo图片对象
                Image icon = imgIcon.getImage();
                int x = icon.getWidth(null);
                int y = icon.getHeight(null);



                //加水印
                BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics2D = bufferedImage.createGraphics();
                graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                graphics2D.drawImage(srcImg,0,0,null); //先画出原图 从0,0的位置开始画
                graphics2D.drawImage(icon,6,8,x,y+4,null); //然后在添加图片水印

                graphics2D.dispose();
                File file = new File(imageFile.getParent() + "-handler");
                if(!file.exists()){
                    file.mkdir();
                }
                os = new FileOutputStream(file.getPath()+"\\"+imageFile.getName());

                ImageIO.write(bufferedImage,"jpg",os);
        }catch(IOException e){
            logger.error("图片添加水印失败images:{}:",imageFile.getPath(),e);
            throw new RuntimeException(e);
        }finally {
            try {
                if(os != null){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 获取所有需要处理的文件
     * @param file 文件根目录
     */
    @Override
    public void handlerFile(File file){
        //代表已经处理过的图片目录不需要在处理一次了
        if(file.getPath().matches("(.*)handler(.*)")){
            return;
        }
        if(file.getPath().matches(".*.jpg")){
            //如果是jpg文件则调用添加水印的方法
            this.iamgeAddLogo(file);
        }
    }

    public static void main(String args[]) throws Exception {
        //图片处理
        ImageWaterMark imageWaterMark = new ImageWaterMark();
        imageWaterMark.smallLogo = args[0]; //LOGO图片的路径 小图标
        imageWaterMark.bigLogo = args[1];   //LOGO图片的路径 大图标
        String srcPath = "G:\\fdcwork\\video\\20180710-20180724";//args[2]  // 一段时间所有图片的根目录
        File file = new File(srcPath);
        //获取目录下所有图片添加水印
        //imageWaterMark.handlerAllImage(file);

        //获取目录下所有图片处理成视频
        ComposeVideo composeVideo = new ComposeVideo();
        composeVideo.handlerDir(file);
    }
}
