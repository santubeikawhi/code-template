package ${package_base}.${module_name}.${package_service_impl};

import ${package_base}.${module_name}.${package_mapper}.${Table}Mapper;
import ${package_base}.${module_name}.${package_service}.${Table}Service;
import ${package_base}.${module_name}.${package_pojo}.${Table};
import ${package_base}.${module_name}.${package_req}.${Table}PageReq;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import java.util.List;
/**
 * @Author:${author}
 * @Description:${Table} serviceImpl
 * @Date ${currentDateTime}
 */

@Service
public class ${Table}ServiceImpl extends RivTowerAbstractServiceImpl<${Table}Mapper, ${Table}, ${Table}PageReq> implements ${Table}Service {

  @Override
  QueryWrapper<${Table}> condition(QueryWrapper<${Table}> queryWrapper, ${Table}PageReq req) {
  <#list models as model>
  <#if model.name != 'id' >
  <#if model.simpleType == 'String'>
      //${model.desc!""}
      if (StringUtils.isNotEmpty(req.get${model.upperName}())) {
  </#if>
  <#if model.simpleType != 'String'>
      //${model.desc!""}
      if (ObjectUtils.isNotEmpty(req.get${model.upperName}())) {
  </#if>
          queryWrapper.lambda().eq(${Table}::get${model.upperName}, req.get${model.upperName}());
      }
  </#if>        
  </#list>
      return queryWrapper;
  }

}
