package cn.ersharing.controller;

import cn.ersharing.common.pojo.JsonResult;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 下载api
 * @author haojie
 * @date  2019/1/16
 */
@RestController
@RequestMapping("/api/download")
public class DownloadApi {

    @Autowired
    private HttpSession session;

    @Value("${DOWNLOAD_APK_LOCATION}")
    private String DOWNLOAD_APK_LOCATION;

    @RequestMapping(value = "/apk",method = RequestMethod.GET)
    public JsonResult downloadApk(HttpServletResponse response){
        String filename;
        filename = DOWNLOAD_APK_LOCATION.substring(DOWNLOAD_APK_LOCATION.lastIndexOf("/")+1);
        String realPath = session.getServletContext().getRealPath(DOWNLOAD_APK_LOCATION);
        File file = new File(realPath);
        OutputStream out = null;
        if (file.exists()){
            try {
                response.reset();
                //设置MIME类型
                response.setContentType("application/octet-stream; charset=utf-8");

                //设置头信息,设置文件下载时的默认文件名，同时解决中文名乱码问题
                response.setHeader("Content-Disposition", "attachment; filename=" + new String(filename.getBytes(),"ISO8859-1"));

                out = response.getOutputStream();

                out.write(FileUtils.readFileToByteArray(file));

                out.flush();

                return JsonResult.ok();
            }catch (Exception e){
                e.printStackTrace();
            }
            finally {
                if (out != null){
                    try {
                        out.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return JsonResult.build(500,"服务器内部错误");
    }

}
