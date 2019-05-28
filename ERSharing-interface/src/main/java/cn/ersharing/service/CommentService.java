package cn.ersharing.service;

import cn.ersharing.common.RequestPojo.ResourceCommentRequestBody;
import cn.ersharing.common.pojo.JsonResult;

/**
 * 资源评论
 * @author haojie
 * @date 2019/1/16
 */
public interface CommentService {
    /**
     * 评论资源
     * @param resourceCommentRequestBody
     * @return
     */
    JsonResult commentResource(ResourceCommentRequestBody resourceCommentRequestBody,String commentImageUrl);

    /**
     * 删除资源评论
     * @param token
     * @param resourceCommentId
     * @return
     */
    JsonResult deleteCommentResource(String token,Integer resourceId,Integer resourceCommentId);

    /**
     * 查看当前用户评论
     * @param token
     * @return
     */
    JsonResult myComment(String token);

    /**
     * 查看资源的评论
     * @param resourceId
     * @return
     */
    JsonResult resourceComments(Integer resourceId);
}
