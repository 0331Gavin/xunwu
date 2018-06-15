package com.eastrise.xunwu.controller.dto;

/**
 * create by gzq on 2018/6/15 10:10
 */
public final class QiNiuPutRet {
    public String key;
    public String hash;
    public String bucket;
    public int width;
    public int height;

    @Override
    public String toString() {
        return "QiNiuPutRet{" +
                "key='" + key + '\'' +
                ", hash='" + hash + '\'' +
                ", bucket='" + bucket + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
