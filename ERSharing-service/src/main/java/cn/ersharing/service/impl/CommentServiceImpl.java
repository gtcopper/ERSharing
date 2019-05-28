package cn.ersharing.service.impl;

import cn.ersharing.common.RequestPojo.ResourceCommentRequestBody;
import cn.ersharing.common.ResponsePojo.ResourceCommentResult;
import cn.ersharing.common.ResponsePojo.ResourcesCommentResult;
import cn.ersharing.common.ResponsePojo.SearchResult;
import cn.ersharing.common.pojo.JsonResult;
import cn.ersharing.common.util.JsonUtils;
import cn.ersharing.jedis.JedisClient;
import cn.ersharing.mapper.ResourcesCommentMapper;
import cn.ersharing.pojo.Enterprise;
import cn.ersharing.pojo.ResourcesComment;
import cn.ersharing.pojo.ResourcesCommentExample;
import cn.ersharing.pojo.ResourcesExample;
import cn.ersharing.service.CommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private ResourcesCommentMapper resourcesCommentMapper;

    @Value("${USER_SESSION}")
    private String USER_SESSION;

    @Value("${SESSION_EXPIRE}")
    private Integer SESSION_EXPIRE;


    @Autowired
    private JedisClient jedisClient;

    @Override
    public JsonResult commentResource(ResourceCommentRequestBody resourceCommentRequestBody,String commentImageUrl) {
        String token = resourceCommentRequestBody.getToken();
        if (StringUtils.isNoneBlank(token)){
            String json = jedisClient.get(USER_SESSION + ":" + token);
            if (StringUtils.isNoneBlank(json)){
                Enterprise enterprise = JsonUtils.jsonToPojo(json, Enterprise.class);
                ResourcesComment resourcesComment = new ResourcesComment();
                resourcesComment.setCommentContent(resourceCommentRequestBody.getCommentContent());
                resourcesComment.setCommentImage(commentImageUrl);
                resourcesComment.setCommentTime(new Date());
                resourcesComment.setResourcesId(resourceCommentRequestBody.getResourceId());
                //1 不匿名 0 匿名
                if (resourceCommentRequestBody.getAnonymityEnterprise() == 1){
                    resourcesComment.setAnonymityEnterprise(1);
                    resourcesComment.setEnterpriseId(enterprise.getEnterpriseId());
                }else{
                    resourcesComment.setAnonymityEnterprise(0);
                }
                Integer row = resourcesCommentMapper.insert(resourcesComment);
                Integer commentId = resourcesComment.getCommentId();
                //查询结果集
                ResourcesComment comment = resourcesCommentMapper.selectByPrimaryKey(commentId);
                String nums = jedisClient.hget("COMMENT",resourceCommentRequestBody.getResourceId().toString());
                int commentNums = 0;
                if (!StringUtils.isNoneBlank(nums)){
                    jedisClient.hset("COMMENT",resourceCommentRequestBody.getResourceId().toString(),"1");
                }else{
                    commentNums = Integer.parseInt(nums) + 1;
                    jedisClient.hset("COMMENT",resourceCommentRequestBody.getResourceId().toString(),String.valueOf(commentNums));
                }
                //返回json结果
                ResourceCommentResult result = new ResourceCommentResult();
                result.setAnonymityEnterprise(resourceCommentRequestBody.getAnonymityEnterprise());
                result.setCommentContent(resourceCommentRequestBody.getCommentContent());
                result.setCommentImageUrl(commentImageUrl);
                result.setCommentTime(comment.getCommentTime());
                result.setEnterpriseUser(enterprise.getEnterpriseUser());
                result.setEnterpriseLogoUrl(enterprise.getEnterpriseLogo());
                result.setResourceCommentId(commentId);
                result.setResourceId(resourceCommentRequestBody.getResourceId());
                result.setCommentNums(commentNums);
                //1 表示当前用户发的评论 0则不是,或者是匿名(均表示不是自己的评论)
                if (enterprise.getEnterpriseId().equals(comment.getEnterpriseId()) && resourceCommentRequestBody.getAnonymityEnterprise() == 1){
                    result.setUserCommentState(1);
                    result.setEnterpriseName(enterprise.getEnterpriseName());
                }else {
                    result.setUserCommentState(0);
                }
                return JsonResult.ok(result);
            }
        }
        return JsonResult.build(400,"用户未登录");
    }

    @Override
    public JsonResult deleteCommentResource(String token,Integer resourceId, Integer resourceCommentId) {
        if (StringUtils.isNoneBlank(token)){
            String json = jedisClient.get(USER_SESSION + ":" + token);
            if (StringUtils.isNoneBlank(json)){
                Enterprise enterprise = JsonUtils.jsonToPojo(json, Enterprise.class);
                //删除评论
                resourcesCommentMapper.deleteByPrimaryKey(resourceCommentId);
                String nums = jedisClient.hget("COMMENT",resourceId.toString());
                Integer praiseNums = 0;
                if (Integer.parseInt(nums) < 1){
                    jedisClient.hset("COMMENT",resourceId.toString(),praiseNums.toString());
                }else{
                    praiseNums = Integer.parseInt(nums) - 1;
                    jedisClient.hset("COMMENT",resourceId.toString(),praiseNums.toString());
                }
                return JsonResult.ok();
            }
        }
        return JsonResult.build(400,"用户未登录");
    }

    @Override
    public JsonResult myComment(String token) {
        if (StringUtils.isNoneBlank(token)){
            String json = jedisClient.get(USER_SESSION + ":" + token);
            if (StringUtils.isNoneBlank(json)) {
                Enterprise enterprise = JsonUtils.jsonToPojo(json, Enterprise.class);
                ResourcesCommentExample example = new ResourcesCommentExample();
                example.createCriteria().andEnterpriseIdEqualTo(enterprise.getEnterpriseId());
                List<ResourcesComment> resourcesComments = resourcesCommentMapper.selectByExampleWithBLOBs(example);
                return JsonResult.ok(resourcesComments);
            }
        }
        return JsonResult.build(400,"用户未登录");
    }

    @Override
    public JsonResult resourceComments(Integer resourceId) {
        if (StringUtils.isNoneBlank(resourceId.toString())){
            List<ResourcesCommentResult> resourcesComments = resourcesCommentMapper.selectResourceComments(resourceId);
            SearchResult result = new SearchResult();
            result.setTotal(resourcesComments.size());
            result.setRows(resourcesComments);
            return JsonResult.ok(result);
        }
        return JsonResult.build(400,"资源id为空");
    }
}
