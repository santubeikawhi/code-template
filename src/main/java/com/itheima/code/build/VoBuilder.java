package com.itheima.code.build;

import java.util.Map;

/****
 * @Author:rivus
 * @Description:Pojo构建
 * @Date 2019/6/14 19:13
 *****/
public class VoBuilder {


    /***
     * 构建Pojo
     * @param dataModel
     */
    public static void builder(Map<String,Object> dataModel){
        dataModel.put("needId", false);
        //生成Pojo层文件
        BuilderFactory.builder(dataModel,
                "/template/vo",
                "Vo.java",
                TemplateBuilder.PACKAGE_BASE+"."+TemplateBuilder.MODULE_NAME+"."+TemplateBuilder.PACKAGE_VO,
                "Vo.java");
    }

}
