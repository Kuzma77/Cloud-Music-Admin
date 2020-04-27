package com.soft1851.music.admin.util;

import org.apache.poi.ss.formula.functions.T;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author wl_sun
 * @description 数据缓冲区
 * @Data 2020/4/27
 */
public class ExportDataAdapter<T> {
    /**
     * 默认队列大小
     */
    private static Integer DEFAULT_SIZE = 1000;

    private BlockingQueue<T> resourceQueue = null;

    public ExportDataAdapter(){
        this.resourceQueue = new LinkedBlockingQueue<>(DEFAULT_SIZE);
    }

    /**
     * 从队列中获取数据
     * @return
     */
    public T getData(){
        try{
            return  resourceQueue.take();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取剩余数据数量
     *
     * @return
     */
    public Integer getDataSize(){
        return resourceQueue.size();
    }

    public void addData(T data){
        try{
            resourceQueue.put(data);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
