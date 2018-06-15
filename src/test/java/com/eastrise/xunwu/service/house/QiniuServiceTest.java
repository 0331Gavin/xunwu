package com.eastrise.xunwu.service.house;

import com.eastrise.xunwu.ApplicationTests;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

/**
 * create by gzq on 2018/6/14 16:58
 */
public class QiniuServiceTest extends ApplicationTests {

    @Autowired
    private IQiniuService qiniuService;
    @Test
    public void uploadFileTest(){
        String fileName = "C:\\Users\\郭志强\\安监项目\\xunwu\\tmp\\噶尔.png";
        File file = new File(fileName);
        Assert.assertTrue(file.exists());

        try {
            Response response = qiniuService.uploadFile(file);
            Assert.assertTrue(response.isOK());
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void deleteFileTest(){
        String key = "FtnkrEgYecVMp3X0vBMokSiTDHMS";
        try {
            Response response = qiniuService.delete(key);
            Assert.assertTrue(response.isOK());
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }
}
