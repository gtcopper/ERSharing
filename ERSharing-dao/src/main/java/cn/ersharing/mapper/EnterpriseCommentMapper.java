package cn.ersharing.mapper;

import cn.ersharing.common.ResponsePojo.ResourcesCommentResult;
import cn.ersharing.pojo.EnterpriseComment;
import cn.ersharing.pojo.EnterpriseCommentExample;
import java.util.List;

import cn.ersharing.pojo.ResourcesComment;
import org.apache.ibatis.annotations.Param;

public interface EnterpriseCommentMapper {
    int countByExample(EnterpriseCommentExample example);

    int deleteByExample(EnterpriseCommentExample example);

    int deleteByPrimaryKey(Integer commentId);

    int insert(EnterpriseComment record);

    int insertSelective(EnterpriseComment record);

    List<EnterpriseComment> selectByExampleWithBLOBs(EnterpriseCommentExample example);

    List<EnterpriseComment> selectByExample(EnterpriseCommentExample example);

    EnterpriseComment selectByPrimaryKey(Integer commentId);

    int updateByExampleSelective(@Param("record") EnterpriseComment record, @Param("example") EnterpriseCommentExample example);

    int updateByExampleWithBLOBs(@Param("record") EnterpriseComment record, @Param("example") EnterpriseCommentExample example);

    int updateByExample(@Param("record") EnterpriseComment record, @Param("example") EnterpriseCommentExample example);

    int updateByPrimaryKeySelective(EnterpriseComment record);

    int updateByPrimaryKeyWithBLOBs(EnterpriseComment record);

    int updateByPrimaryKey(EnterpriseComment record);
}