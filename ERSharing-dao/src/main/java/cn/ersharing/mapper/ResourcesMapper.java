package cn.ersharing.mapper;

import java.util.List;

import cn.ersharing.common.ResponsePojo.SearchResourceResult;
import cn.ersharing.common.ResponsePojo.SearchResourcesDetail;
import cn.ersharing.pojo.Resources;
import cn.ersharing.pojo.ResourcesExample;
import org.apache.ibatis.annotations.Param;

public interface ResourcesMapper {
    int countByExample(ResourcesExample example);

    int deleteByExample(ResourcesExample example);

    int deleteByPrimaryKey(Integer resourcesId);

    int insert(Resources record);

    int insertSelective(Resources record);

    List<Resources> selectByExampleWithBLOBs(ResourcesExample example);

    List<Resources> selectByExample(ResourcesExample example);

    Resources selectByPrimaryKey(Integer resourcesId);

    int updateByExampleSelective(@Param("record") Resources record, @Param("example") ResourcesExample example);

    int updateByExampleWithBLOBs(@Param("record") Resources record, @Param("example") ResourcesExample example);

    int updateByExample(@Param("record") Resources record, @Param("example") ResourcesExample example);

    int updateByPrimaryKeySelective(Resources record);

    int updateByPrimaryKeyWithBLOBs(Resources record);

    int updateByPrimaryKey(Resources record);

    List<SearchResourceResult> selectResourcesByLikeResourcesName(String ResourceName);

    List<SearchResourceResult> selectResourcesByLikeCityName(String cityName);

    List<SearchResourcesDetail> selectResourcesDetails();

    SearchResourcesDetail selectResourcesDetailById(Integer resourceId);

    List<SearchResourcesDetail> selectResourcesByEnterpriseId(Integer enterpriseId);
}