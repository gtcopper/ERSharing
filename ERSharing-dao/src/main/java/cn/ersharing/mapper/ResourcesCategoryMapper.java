package cn.ersharing.mapper;

import cn.ersharing.pojo.ResourcesCategory;
import cn.ersharing.pojo.ResourcesCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourcesCategoryMapper {
    int countByExample(ResourcesCategoryExample example);

    int deleteByExample(ResourcesCategoryExample example);

    int deleteByPrimaryKey(Integer categoryId);

    int insert(ResourcesCategory record);

    int insertSelective(ResourcesCategory record);

    List<ResourcesCategory> selectByExampleWithBLOBs(ResourcesCategoryExample example);

    List<ResourcesCategory> selectByExample(ResourcesCategoryExample example);

    ResourcesCategory selectByPrimaryKey(Integer categoryId);

    int updateByExampleSelective(@Param("record") ResourcesCategory record, @Param("example") ResourcesCategoryExample example);

    int updateByExampleWithBLOBs(@Param("record") ResourcesCategory record, @Param("example") ResourcesCategoryExample example);

    int updateByExample(@Param("record") ResourcesCategory record, @Param("example") ResourcesCategoryExample example);

    int updateByPrimaryKeySelective(ResourcesCategory record);

    int updateByPrimaryKeyWithBLOBs(ResourcesCategory record);

    int updateByPrimaryKey(ResourcesCategory record);
}