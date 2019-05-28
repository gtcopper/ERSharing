package cn.ersharing.common.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;

/**
 * 文件上传工具类
 * @author haojie
 * @date 2019/1/16
 */
public class FileUploadUtils {
    /**
     * 返回上传文件的URL
     * @param uploadFile
     * @return
     */
    public static String executeUploadFile(MultipartFile uploadFile, HttpSession session, String location) throws Exception{
        //获取源文件名
        String originalFilename = uploadFile.getOriginalFilename();
        //获取文件的后缀名
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        //获取文件在硬盘中的真实路径
        String path;
        path = session.getServletContext().getRealPath(location);
        //设置文件在硬盘中的文件名
        File file = new File(path,System.nanoTime()+"_"+originalFilename);
        //完成文件写入服务器端
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdir();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        uploadFile.transferTo(file);
        return location + file.getName();
    }
}
