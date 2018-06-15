package com.eastrise.xunwu.service.house;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;

import java.io.File;
import java.io.InputStream;

/**
 *  七牛云服务
 * create by gzq on 2018/6/14 16:43
 */
public interface IQiniuService {
    Response uploadFile(File file) throws QiniuException;

    Response uploadFile(InputStream inputStream) throws QiniuException;

    Response delete(String key) throws QiniuException;
}
