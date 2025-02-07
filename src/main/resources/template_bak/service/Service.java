package ${package_base}.${module_name}.${package_service};
import ${package_pojo}.${Table};
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import java.util.List;

/**
 * @Author:${author}
 * @Description:${Table} Service
 * @Date ${currentDateTime}
 */

public interface ${Table}Service {
    
    /**
     * 列表-分页
     * @param registerPageReq
     * @return
     */
    Page<${Table}> page(${Table}PageReq ${table}PageReq);

    /**
     * 列表
     * @param registerPageReq
     * @return
     */
    List<${Table}> list(${Table}PageReq ${table}PageReq);
    
    
    

    /***
     * ${Table}多条件分页查询
     * @param ${table}
     * @param page
     * @param size
     * @return
     */
    PageInfo<${Table}> findPage(${Table} ${table}, int page, int size);

    /***
     * ${Table}分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<${Table}> findPage(int page, int size);

    /***
     * ${Table}多条件搜索方法
     * @param ${table}
     * @return
     */
    List<${Table}> findList(${Table} ${table});

    /***
     * 删除${Table}
     * @param id
     */
    void delete(${keyType} id);

    /***
     * 修改${Table}数据
     * @param ${table}
     */
    void update(${Table} ${table});

    /***
     * 新增${Table}
     * @param ${table}
     */
    void add(${Table} ${table});

    /**
     * 根据ID查询${Table}
     * @param id
     * @return
     */
     ${Table} findById(${keyType} id);

    /***
     * 查询所有${Table}
     * @return
     */
    List<${Table}> findAll();
}
