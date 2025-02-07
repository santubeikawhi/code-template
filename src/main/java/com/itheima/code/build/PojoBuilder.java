package com.itheima.code.build;

import freemarker.template.Template;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/****
 * @Author:rivus
 * @Description:Pojo构建
 * @Date 2019/6/14 19:13
 *****/
public class PojoBuilder {


    /***
     * 构建Pojo
     * @param dataModel
     */
    public static void builder(Map<String,Object> dataModel){
        dataModel.put("needId", false);
        //生成Pojo层文件
        BuilderFactory.builder(dataModel,
                "/template/pojo",
                "Pojo.java",
                TemplateBuilder.PACKAGE_BASE+"."+TemplateBuilder.MODULE_NAME+"."+TemplateBuilder.PACKAGE_POJO,
                ".java");
    }

}
