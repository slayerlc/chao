package com.common.javacv;

import org.bytedeco.javacpp.avcodec;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.FrameRecorder;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import static org.bytedeco.javacpp.opencv_imgcodecs.cvLoadImage;

public class ComposeVideo {

    private final Logger logger = LoggerFactory.getLogger(ComposeVideo.class);
    FFmpegFrameRecorder recorder;
    OpenCVFrameConverter.ToIplImage conveter;

    /**
     * 初始化视频合成参数
     *
     * @param saveMp4name 保存视频的位置
     * @throws Exception
     */
    public void init(String saveMp4name) {
        try {
            recorder = new FFmpegFrameRecorder(saveMp4name, 1024, 768);
            conveter = new OpenCVFrameConverter.ToIplImage();
            recorder.setVideoCodec(avcodec.AV_CODEC_ID_MPEG4); // 设置编码格式
            recorder.setFormat("mp4");
            //	recorder.setFormat("mov,mp4,m4a,3gp,3g2,mj2,h264,ogg,MPEG4");
            recorder.setFrameRate(8);
            recorder.setPixelFormat(0); //跟像素有关
        } catch (Exception e) {
            logger.error("初始化视参数失败。saveMp4name:{}", saveMp4name, e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 释放资源
     */
    public void release() {
        try {
            this.recorder.stop();
            this.recorder.release();
        } catch (FrameRecorder.Exception e) {
            logger.error("释放资源失败。recorder:{}", recorder, e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 合成视频
     *
     * @param imageFiles 图片文件集合
     * @throws FrameRecorder.Exception
     */
    public void compose(File[] imageFiles) throws FrameRecorder.Exception {
        recorder.start();
        //合成视频
        for (File file : imageFiles) {
            IplImage image = cvLoadImage(file.getPath()); // 加载图片
            if(image == null){
                logger.info("加载图片异常 image:{} file:{}",image, file);
                File failFile = new File(file.getParent() +"\\"+ file.getName());
                file.renameTo(failFile);
            }
            recorder.record(conveter.convert(image));
            opencv_core.cvReleaseImage(image);   //释放图片
        }
        //释放资源
        release();
    }

    /**
     * 获得所有处理过后的图片目录
     *
     * @param file 图片根路径
     * @throws Exception
     */
    public void handlerDir(File file) {
        if (!file.getName().matches(".*.tgz") && file.isDirectory()) {
            for (File f : file.listFiles()) {
                //只需要把处理过的图片目录合成视频
                if (f.getPath().matches("(.*)-handler")){
                    //视频处理
                    try {
                        //把合成的视频全部放在根目录
                        File videoPath = new File(file.getPath()+"-video");
                        videoPath.mkdir();
                        init(videoPath.getPath()+"\\"+f.getName()+".mp4");
                        this.compose(f.listFiles()); //开始合成视频
                    } catch (Exception e) {
                        logger.error("图片合成视频失败,失败的图片目录为 file:{}", file, e);
                        throw new RuntimeException(e);
                    }
                } else {
                    handlerDir(f);
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        File image = new File("C:\\Users\\Administrator\\Desktop\\20180625084746.jpg");
        File toImage = new File("C:\\Users\\Administrator\\Desktop\\test\\20180625084746.jpg");
        image.renameTo(toImage);
    }
}
