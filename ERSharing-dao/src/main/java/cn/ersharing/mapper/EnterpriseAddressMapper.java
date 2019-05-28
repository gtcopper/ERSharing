package cn.ersharing.mapper;

import cn.ersharing.pojo.EnterpriseAddress;
import cn.ersharing.pojo.EnterpriseAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnterpriseAddressMapper {
    int countByExample(EnterpriseAddressExample example);

    int deleteByExample(EnterpriseAddressExample example);

    int insert(EnterpriseAddress record);

    int insertSelective(EnterpriseAddress record);

    List<EnterpriseAddress> selectByExample(EnterpriseAddressExample example);

    int updateByExampleSelective(@Param("record") EnterpriseAddress record, @Param("example") EnterpriseAddressExample example);

    int updateByExample(@Param("record") EnterpriseAddress record, @Param("example") EnterpriseAddressExample example);
}