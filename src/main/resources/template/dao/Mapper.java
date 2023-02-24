package ${package_base}.${module_name}.${package_mapper};

import ${package_base}.${module_name}.${package_pojo}.${Table};
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/****
 * @Author:rivus
 * @Description:${Table}的Mapper
 * @Date 2019/6/14 0:12
 *****/
@Mapper
public interface ${Table}Mapper extends BaseMapper<${Table}> {
}
