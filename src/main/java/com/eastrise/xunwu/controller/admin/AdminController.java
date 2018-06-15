package com.eastrise.xunwu.controller.admin;

import com.eastrise.xunwu.base.ApiResponse;
import com.eastrise.xunwu.controller.dto.QiNiuPutRet;
import com.eastrise.xunwu.service.house.IQiniuService;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * create by gzq on 2018/6/8 15:28
 */
@Controller
public class AdminController {

    @Autowired
    private IQiniuService qiniuService;
    @Autowired
    private Gson gson;

    @GetMapping("/admin/center")
    public String adminCenterPage(){
        return "admin/center";
    }

    @GetMapping("/admin/welcome")
    public String welcomePage(){
        return "admin/welcome";
    }

    @GetMapping("/admin/login")
    public String adminLoginPage(){
        return "admin/login";
    }

    @GetMapping("/admin/add/house")
    public String addHousePage(){
        return "admin/house-add";
    }

    @PostMapping(value = "/admin/upload/photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public ApiResponse uploadPhoto(@RequestParam("file") MultipartFile file){
        if(file.isEmpty()){
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_VALID_PARAM);
        }
        String fileName = file.getOriginalFilename();

        try {
            InputStream inputStream = file.getInputStream();
            Response response =qiniuService.uploadFile(inputStream);
            if(response.isOK()){
                QiNiuPutRet ret = gson.fromJson(response.bodyString(), QiNiuPutRet.class);
                return ApiResponse.ofSuccess(ret);
            }else{
                return ApiResponse.ofMessage(response.statusCode,response.getInfo());
            }
        } catch (QiniuException e){
            Response response = e.response;
            try {
                return ApiResponse.ofMessage(response.statusCode,response.bodyString());
            } catch (QiniuException e1) {
                return ApiResponse.ofStatus(ApiResponse.Status.INTERNAL_SERVER_ERROR);
            }
        } catch (IOException e) {
            return ApiResponse.ofStatus(ApiResponse.Status.INTERNAL_SERVER_ERROR);
        }
//
//        File target = new File("C:\\Users\\郭志强\\安监项目\\xunwu\\tmp\\"+fileName);
//        try {
//            file.transferTo(target);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ApiResponse.ofStatus(ApiResponse.Status.INTERNAL_SERVER_ERROR);
//        }
//        return ApiResponse.ofMessage(null);
    }
}
