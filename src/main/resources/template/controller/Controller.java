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
import javax.annotation.Resource;

/**
 * @Author:rivus
 * @Description:
 * @Date ${currentDateTime}
 */
<#if swagger==true>@Api(tags = "${Table}Controller")</#if>
@RestController
@RequestMapping("/${table}")
@CrossOrigin
public class ${Table}Controller {

    @Resource
    private ${Table}Service ${table}Service;

    /***
     * ${Table}分页条件搜索实现 列表——分页——不鉴权
     * @param ${table}PageReq
     * @return
     */
    <#if swagger==true>
    @ApiOperation("${Table}条件分页查询")
    </#if>
    @GetMapping(value = "/noAuth/page" )
    public RestVo<Page<${Table}Vo>> noAuthPage(${Table}PageReq ${table}PageReq){
        return RestVo.SUCCESS(${table}Service.page(${table}PageReq));
    }

    /***
     * ${Table}分页条件搜索实现 列表——分页
     * @param ${table}PageReq
     * @return
     */
    <#if swagger==true>
    @ApiOperation("${Table}条件分页查询")
    </#if>
    @GetMapping(value = "/page" )
    public RestVo<Page<${Table}Vo>> page(${Table}PageReq ${table}PageReq){
        return RestVo.SUCCESS(${table}Service.page(${table}PageReq));
    }

    /***
     * ${Table}分页条件搜索实现 列表——不分页——不鉴权
     * @param ${table}PageReq
     * @return
     */
    <#if swagger==true>
    @ApiOperation("${Table}条件分页查询")
    </#if>
    @GetMapping(value = "/noAuth/list" )
    public RestVo<List<${Table}Vo>> noAuthList(${Table}PageReq ${table}PageReq){
        return RestVo.SUCCESS(${table}Service.list(${table}PageReq));
    }

    /***
     * ${Table}分页条件搜索实现 列表——分页
     * @param ${table}PageReq
     * @return
     */
    <#if swagger==true>
    @ApiOperation("${Table}条件分页查询")
    </#if>
    @GetMapping(value = "/list" )
    public RestVo<List<${Table}Vo>> list(${Table}PageReq ${table}PageReq){
        return RestVo.SUCCESS(${table}Service.list(${table}PageReq));
    }

}
