package ${package_base}.${module_name}.${package_pojo};

import com.baomidou.mybatisplus.annotation.TableName;
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
 * @Description:${Table} Entity
 * @Date ${currentDateTime}
 */

<#if swagger==true>
@ApiModel(description = "${Table}",value = "${Table}")
</#if>
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("${TableName}")
public class ${Table} extends BaseEntity<Long>{
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
	<#if model.name != 'id' && model.name != 'createdAt' && model.name != 'updatedAt' && model.name != 'deleted'>
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
