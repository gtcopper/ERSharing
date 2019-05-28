package cn.ersharing.controller;

import cn.ersharing.common.RequestPojo.ResourceCommentRequestBody;
import cn.ersharing.common.pojo.JsonResult;
import cn.ersharing.common.util.FileUploadUtils;
import cn.ersharing.service.CommentService;
import cn.ersharing.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 用户评论赞赏模块
 */
@RestController
@RequestMapping(value = "/api/comment")
public class CommentApi {

    @Autowired(required = false)
    private EnterpriseService enterpriseService;

    @Autowired(required = false)
    private CommentService commentService;

    @Autowired
    private HttpSession session;

    @Value("${RESOURCE_COMMENT_IMAGE_LOCATION}")
    private String RESOURCE_COMMENT_IMAGE_LOCATION;


    /**
     * 用户评论资源
     *
     * @return
     */
    @RequestMapping(value = "/enterprise/commentResource", method = POST)
    public JsonResult commentResource(ResourceCommentRequestBody resourceCommentRequestBody, MultipartFile commentImage) {
        try {
            String commentImageUrl = null;
            if (commentImage != null){
                commentImageUrl = FileUploadUtils.executeUploadFile(commentImage,session, RESOURCE_COMMENT_IMAGE_LOCATION);
            }
            JsonResult result = commentService.commentResource(resourceCommentRequestBody, commentImageUrl);
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonResult.build(500,"服务器内部错误");
    }

    /**
     * 我的评论列表
     *
     * @return
     */
    @RequestMapping(value = "/enterprise/myComments", method = POST)
    public JsonResult EnterpriseCommentList(String token) {
        JsonResult result = commentService.myComment(token);
        return result;
    }

    /**
     * 资源的评论列表
     *
     * @return
     */
    @RequestMapping(value = "/resource/commentList/{resourcesId}", method = GET)
    public JsonResult resourceCommentList(@PathVariable Integer resourcesId) {
        JsonResult result = commentService.resourceComments(resourcesId);
        return result;
    }


    /**
     * 删除对资源的评论
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/enterprise/deleteResourceComment", method = POST)
    public JsonResult deleteResourceComment(String token,Integer resourceId, Integer resourceCommentId) {
        JsonResult result = commentService.deleteCommentResource(token, resourceId, resourceCommentId);
        return result;
    }

}
