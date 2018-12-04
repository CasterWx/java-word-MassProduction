package com.wordtemp.util;

import com.wordtemp.dao.impl.ProblemDAOImpl;
import com.wordtemp.domain.Problem;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetWord {
    public void exportSimpleWord(String templateFileName, String outFileName) throws Exception{
        // 要填充的数据, 注意map的key要和word中${xxx}的xxx一致
        Map<String,String> dataMap = new HashMap<String,String>();
        ProblemDAOImpl problemDAO = new ProblemDAOImpl() ;
        List<Problem> list = problemDAO.listAll() ;
        for (int i=0;i<list.size();i++){
            dataMap.put(list.get(i).getQid(),list.get(i).getTitle());
        }
        //Configuration用于读取ftl文件
        Configuration configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");

        /*以下是两种指定ftl文件所在目录路径的方式, 注意这两种方式都是
         * 指定ftl文件所在目录的路径,而不是ftl文件的路径
         */
        //指定路径的第一种方式(根据某个类的相对路径指定)
        //configuration.setClassForTemplateLoading(this.getClass(),"");

        //指定路径的第二种方式,我的路径是C:/a.ftl

        configuration.setDirectoryForTemplateLoading(new File("src\\main\\java\\ftl\\"));


        // 输出文档路径及名称
        File outFile = new File(outFileName);
        //以utf-8的编码读取ftl文件
        Template t =  configuration.getTemplate(templateFileName,"utf-8");
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src\\main\\java\\word\\"+outFile+".doc"), "utf-8"),10240);
        t.process(dataMap, out);
        out.close();
    }
}