package com.common.imageHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ImageHandle {


    /**
     * 为图片添加图片水印
     * @param srcPath 所有图片保存的路径
     * @param logoPath logo路径
     * @param exportPath 需要保存的路径（文件夹路径,文件名用原图片名称）
     */
    public void iamgeAddLogo(String srcPath, String logoPath, String exportPath){
        File imagePath = new File(srcPath);
        File[] files = imagePath.listFiles();
        OutputStream os = null;
        try{
            for(int i=0; i<files.length; i++){
                //原图片对象
                Image srcImg = ImageIO.read(files[i]);
                int width = srcImg.getWidth(null);
                int height = srcImg.getHeight(null);

                // logo图片的路径
                ImageIcon imgIcon = new ImageIcon(logoPath);
                // logo图片对象
                Image icon = imgIcon.getImage();
                int x = icon.getWidth(null);
                int y = icon.getHeight(null);

                //加水印
                BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics2D = bufferedImage.createGraphics();
                graphics2D.drawImage(srcImg,0,0,null); //先画出原图 从0,0的位置开始画
                graphics2D.drawImage(icon,5,8,x,y,null); //然后在添加图片水印

                graphics2D.dispose();
                File file = new File(exportPath);
                if(!file.exists()){
                    file.mkdir();
                }
                os = new FileOutputStream(file.getPath()+"\\"+files[i].getName());

                ImageIO.write(bufferedImage,"jpg",os);
            }
        }catch(IOException e){
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

    public static void main(String args[]) throws IOException {
        ImageHandle imageHandle = new ImageHandle();
        String srcPath = "C:\\Users\\Administrator\\Desktop\\135670630-20180625";
        String logoPath ="C:\\Users\\Administrator\\Desktop\\logo2.png";
        String exportPath = "C:\\Users\\Administrator\\Desktop\\handleImage";
        imageHandle.iamgeAddLogo(srcPath,logoPath,exportPath);
    }
}
