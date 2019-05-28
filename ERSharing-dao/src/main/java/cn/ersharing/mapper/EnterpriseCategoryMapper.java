package cn.ersharing.mapper;

import cn.ersharing.pojo.EnterpriseCategory;
import cn.ersharing.pojo.EnterpriseCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnterpriseCategoryMapper {
    int countByExample(EnterpriseCategoryExample example);

    int deleteByExample(EnterpriseCategoryExample example);

    int deleteByPrimaryKey(Integer categoryId);

    int insert(EnterpriseCategory record);

    int insertSelective(EnterpriseCategory record);

    List<EnterpriseCategory> selectByExampleWithBLOBs(EnterpriseCategoryExample example);

    List<EnterpriseCategory> selectByExample(EnterpriseCategoryExample example);

    EnterpriseCategory selectByPrimaryKey(Integer categoryId);

    int updateByExampleSelective(@Param("record") EnterpriseCategory record, @Param("example") EnterpriseCategoryExample example);

    int updateByExampleWithBLOBs(@Param("record") EnterpriseCategory record, @Param("example") EnterpriseCategoryExample example);

    int updateByExample(@Param("record") EnterpriseCategory record, @Param("example") EnterpriseCategoryExample example);

    int updateByPrimaryKeySelective(EnterpriseCategory record);

    int updateByPrimaryKeyWithBLOBs(EnterpriseCategory record);

    int updateByPrimaryKey(EnterpriseCategory record);
}