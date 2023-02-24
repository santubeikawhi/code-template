package ${package_base}.${module_name}.${package_req};

<#if swagger==true>
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
</#if>
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
<#list typeSet as set>
import ${set};
</#list>

/**
 * @Author:rivus
 * @Description:${Table}PageReq
 * @Date ${currentDateTime}
 */

<#if swagger==true>
@ApiModel(description = "${Table}",value = "${Table}")
</#if>
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ${Table}PageReq extends BasePageReq{
<#list models as model>
    <#if needId == true>
	<#if swagger==true>
	@ApiModelProperty(value = "${model.desc!""}",required = false)
	</#if>
    <#if model.name == 'id'>
	<#if model.id==true>
	@Id
	<#if model.identity=='YES'>
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	</#if>
	</#if>
	</#if>
	@Column(name = "${model.column}")
	private ${model.simpleType} ${model.name};//${model.desc!""}
	</#if>
	<#if model.name != 'id' >
	<#if swagger==true>
	/**
	 * ${model.desc!""}
	 */
	@ApiModelProperty(value = "${model.desc!""}")
	</#if>
	private ${model.simpleType} ${model.name};
	
	</#if>
</#list>
<#if lombok != true>
<#list models as model>
	//get方法
	public ${model.simpleType} get${model.upperName}() {
		return ${model.name};
	}

	//set方法
	public void set${model.upperName}(${model.simpleType} ${model.name}) {
		this.${model.name} = ${model.name};
	}
</#list>
</#if>
}
