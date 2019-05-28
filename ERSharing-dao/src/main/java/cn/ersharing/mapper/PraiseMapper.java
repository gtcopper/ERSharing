package cn.ersharing.mapper;

import cn.ersharing.pojo.Praise;
import cn.ersharing.pojo.PraiseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PraiseMapper {
    int countByExample(PraiseExample example);

    int deleteByExample(PraiseExample example);

    int deleteByPrimaryKey(Integer praiseId);

    int insert(Praise record);

    int insertSelective(Praise record);

    List<Praise> selectByExample(PraiseExample example);

    Praise selectByPrimaryKey(Integer praiseId);

    int updateByExampleSelective(@Param("record") Praise record, @Param("example") PraiseExample example);

    int updateByExample(@Param("record") Praise record, @Param("example") PraiseExample example);

    int updateByPrimaryKeySelective(Praise record);

    int updateByPrimaryKey(Praise record);
}