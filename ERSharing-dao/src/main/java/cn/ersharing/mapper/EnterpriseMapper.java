package cn.ersharing.mapper;

import cn.ersharing.common.ResponsePojo.EnterpriseInfoResult;
import cn.ersharing.pojo.Enterprise;
import cn.ersharing.pojo.EnterpriseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnterpriseMapper {
    int countByExample(EnterpriseExample example);

    int deleteByExample(EnterpriseExample example);

    int deleteByPrimaryKey(Integer enterpriseId);

    int insert(Enterprise record);

    int insertSelective(Enterprise record);

    List<Enterprise> selectByExampleWithBLOBs(EnterpriseExample example);

    List<Enterprise> selectByExample(EnterpriseExample example);

    Enterprise selectByPrimaryKey(Integer enterpriseId);

    int updateByExampleSelective(@Param("record") Enterprise record, @Param("example") EnterpriseExample example);

    int updateByExampleWithBLOBs(@Param("record") Enterprise record, @Param("example") EnterpriseExample example);

    int updateByExample(@Param("record") Enterprise record, @Param("example") EnterpriseExample example);

    int updateByPrimaryKeySelective(Enterprise record);

    int updateByPrimaryKeyWithBLOBs(Enterprise record);

    int updateByPrimaryKey(Enterprise record);

    /**
     *  通过企业名模糊查询企业
     * @return
     */
    List<EnterpriseInfoResult> selectEnterpriseByLikeEnterpriseName(String enterpriseName);

    /**
     *  通过城市名模糊查询企业
     * @return
     */
    List<EnterpriseInfoResult> selectEnterpriseByLikeCityName(String cityName);
}