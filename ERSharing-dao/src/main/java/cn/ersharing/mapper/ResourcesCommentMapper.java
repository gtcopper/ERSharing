package cn.ersharing.mapper;

import cn.ersharing.common.ResponsePojo.ResourcesCommentResult;
import cn.ersharing.pojo.ResourcesComment;
import cn.ersharing.pojo.ResourcesCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourcesCommentMapper {
    int countByExample(ResourcesCommentExample example);

    int deleteByExample(ResourcesCommentExample example);

    int deleteByPrimaryKey(Integer commentId);

    int insert(ResourcesComment record);

    int insertSelective(ResourcesComment record);

    List<ResourcesComment> selectByExampleWithBLOBs(ResourcesCommentExample example);

    List<ResourcesComment> selectByExample(ResourcesCommentExample example);

    ResourcesComment selectByPrimaryKey(Integer commentId);

    int updateByExampleSelective(@Param("record") ResourcesComment record, @Param("example") ResourcesCommentExample example);

    int updateByExampleWithBLOBs(@Param("record") ResourcesComment record, @Param("example") ResourcesCommentExample example);

    int updateByExample(@Param("record") ResourcesComment record, @Param("example") ResourcesCommentExample example);

    int updateByPrimaryKeySelective(ResourcesComment record);

    int updateByPrimaryKeyWithBLOBs(ResourcesComment record);

    int updateByPrimaryKey(ResourcesComment record);

    List<ResourcesCommentResult>  selectResourceComments(Integer resourceId);
}