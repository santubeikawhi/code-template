package ${package_base}.${module_name}.${package_controller};

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${package_base}.${module_name}.${package_req}.${Table}PageReq;
import ${package_base}.${module_name}.${package_req}.${Table}SaveReq;
import ${package_base}.${module_name}.${package_vo}.${Table}Vo;
import ${package_base}.${module_name}.${package_service}.${Table}Service;
<#if swagger==true>import io.swagger.annotations.*;</#if>
import com.rivtower.rivtrust.core.domain.RestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @Author:rivus
 * @Description:
 * @Date ${currentDateTime}
 */
<#if swagger==true>@Api(value = "${Table}Controller")</#if>
@RestController
@RequestMapping("/${table}")
@CrossOrigin
public class ${Table}Controller {

    @Autowired
    private ${Table}Service ${table}Service;

    /***
     * ${Table}分页条件搜索实现 列表——分页——不鉴权
     * @param ${table}PageReq
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}条件分页查询",notes = "分页条件查询${Table}方法详情",tags = {"${Table}Controller"})
    </#if>
    @PostMapping(value = "/noAuth/page" )
    public RestVo<Page<${Table}Vo>> noAuthPage(${Table}PageReq ${table}PageReq){
        return RestVo.SUCCESS(${table}Service.page(${table}PageReq));
    }

    /***
     * ${Table}分页条件搜索实现 列表——分页
     * @param ${table}PageReq
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}条件分页查询",notes = "分页条件查询${Table}方法详情",tags = {"${Table}Controller"})
    </#if>
    @PostMapping(value = "/page" )
    public RestVo<Page<${Table}Vo>> page(${Table}PageReq ${table}PageReq){
        return RestVo.SUCCESS(${table}Service.page(${table}PageReq));
    }

    /***
     * ${Table}分页条件搜索实现 列表——分页——不鉴权
     * @param ${table}PageReq
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}条件分页查询",notes = "分页条件查询${Table}方法详情",tags = {"${Table}Controller"})
    </#if>
    @PostMapping(value = "/noAuth/list" )
    public RestVo<List<${Table}Vo>> noAuthList(${Table}PageReq ${table}PageReq){
        return RestVo.SUCCESS(${table}Service.list(${table}PageReq));
    }

    /***
     * ${Table}分页条件搜索实现 列表——分页
     * @param ${table}PageReq
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}条件分页查询",notes = "分页条件查询${Table}方法详情",tags = {"${Table}Controller"})
    </#if>
    @PostMapping(value = "/list" )
    public RestVo<List<${Table}Vo>> list(${Table}PageReq ${table}PageReq){
        return RestVo.SUCCESS(${table}Service.list(${table}PageReq));
    }

}
