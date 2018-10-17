package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class UploadController {
    @RequestMapping("/maopian")
    public String maopian(MultipartFile maopian, HttpServletRequest request) throws Exception {
    //获取上传的文件
        System.out.println("-------------------");
        String originalFilename = maopian.getOriginalFilename();


        //创建一个文件夹来保存文件
        String realPath = request.getSession().getServletContext().getRealPath("/maopian");

        File file1 = new File(realPath);
        if (!file1.exists()) {
            file1.mkdir();
        }
        originalFilename = UUID.randomUUID().toString() + "_" + originalFilename;

        //将上传的文件保存到创建的文件当中
        File file = new File(realPath + "/" + originalFilename);


            maopian.transferTo(file);





        return "success";
    }
}



