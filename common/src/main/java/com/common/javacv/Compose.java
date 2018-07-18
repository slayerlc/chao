package com.common.javacv;

import org.bytedeco.javacpp.avcodec;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.OpenCVFrameConverter;

import java.io.File;

import static org.bytedeco.javacpp.opencv_imgcodecs.cvLoadImage;

public class Compose {

    /**
     * 图片合成视频
     * @param saveMp4name
     * @param imagesPath
     * @throws Exception
     */
    public static void imageComposeVideo(String saveMp4name,String imagesPath) throws Exception  {
        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(saveMp4name,1024,768);
		recorder.setVideoCodec(avcodec.AV_CODEC_ID_MPEG4); // 设置编码格式
        recorder.setFormat("mp4");
        //	recorder.setFormat("mov,mp4,m4a,3gp,3g2,mj2,h264,ogg,MPEG4");
        recorder.setFrameRate(20);
        recorder.setPixelFormat(0); //不知道是设置是什么的 貌似跟像素有关
        recorder.start();
        //
        OpenCVFrameConverter.ToIplImage conveter = new OpenCVFrameConverter.ToIplImage();
        // 列出目录中所有的图片，都是jpg的，以1.jpg,2.jpg的方式，方便操作
        File file = new File(imagesPath);

        File[] flist = file.listFiles();
        // 循环所有图片
        for(int i = 0; i < flist.length; i++ ){
            String fname =flist[i].getPath();
            IplImage image = cvLoadImage(fname); // 加载图片
            recorder.record(conveter.convert(image));
            opencv_core.cvReleaseImage(image);   //释放图片
        }
        recorder.stop();
        recorder.release();
    }

    public static void main(String args[]) throws Exception {
        System.out.println("start...");
        //保存视频目录
        String saveMp4name = "C:\\Users\\Administrator\\Desktop\\135670630-20180625.mp4";
        // 图片目录
        String imagesPath = "C:\\Users\\Administrator\\Desktop\\handleImage\\";
        imageComposeVideo(saveMp4name,imagesPath);
        System.out.println("end...");
    }
}
