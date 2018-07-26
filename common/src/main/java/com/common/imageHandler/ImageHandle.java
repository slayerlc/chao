package com.common.imageHandler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class ImageHandle {
    /**
     * 获取一个目录下所有文件,并处理所有文件
     * @param file 文件根目录
     */
    public void handlerAllImage(File file) {
        //如果是目录则获得目录下所有文件
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File f : files) {
                //继续递归目录下的所有文件
                this.handlerAllImage(f);
            }
            //如果是一个空的目录file 则返回空
        }else{
            //如果file是一个文件不是目录 处理文件，由各自的实现方法去处理
            handlerFile(file);
        }
    }

    /**
     * 获取一个目录下所有文件,并处理所有文件
     * @param res 文件根目录
     */
    public void handlerAllImage(String res) {
        handlerAllImage(new File(res));
    }

    /**
     * 处理文件
     * @param file
     */
    public abstract void handlerFile(File file);
}
