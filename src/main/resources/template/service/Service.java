package ${package_base}.${module_name}.${package_service};

import ${package_base}.${module_name}.${package_pojo}.${Table};
import ${package_base}.${module_name}.${package_req}.${Table}PageReq;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * @Author:${author}
 * @Description:${Table} Service
 * @Date ${currentDateTime}
 */

public interface ${Table}Service extends IService<${Table}>  {
    
    /**
     * 列表-分页
     * @param ${table}PageReq
     * @return
     */
    Page<${Table}> page(${Table}PageReq ${table}PageReq);

    /**
     * 列表
     * @param ${table}PageReq
     * @return
     */
    List<${Table}> list(${Table}PageReq ${table}PageReq);
    
}
