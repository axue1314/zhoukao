package com.zb;

import com.zb.pojo.Edoc_entry;
import com.zb.service.impl.Edoc_entryServiceImpl;
import com.zb.util.UtilPage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class test {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(test.class,args);
        Edoc_entryServiceImpl service = run.getBean(Edoc_entryServiceImpl.class);
        Scanner scanner=new Scanner(System.in);
        System.out.println("1.查询所有电子文档");
        System.out.println("2.新增电子文档");
        System.out.println("3.修改电子文档");
        System.out.println("4.删除电子文档");
        System.out.println("请选择你要进行的操作:");
        int num=scanner.nextInt();
        switch (num){
            case 1:
                UtilPage util = service.getAll(-1,1,2);
                List<Edoc_entry> list = util.getList();
                System.out.println("总页数:"+util.getPageCount());
                System.out.println("总数据量:"+util.getTotalCount());
                System.out.println("当前页码:"+util.getPageIndex());
                System.out.println("每页条数:"+util.getPageSize());
                for (Edoc_entry e : list) {
                    System.out.println(e.toString());
                }
                break;
            case 2:
                Edoc_entry edoc_entry=new Edoc_entry();
                System.out.println("请输入要新增文档的类型编号:1.计算机 2.报纸 3.书本");
                int bianhao=scanner.nextInt();
                System.out.println("请输入文档标题:");
                String title=scanner.next();
                System.out.println("请输入内容:");
                String neirong=scanner.next();
                System.out.println("请输入上传人姓名:");
                String name=scanner.next();
                edoc_entry.setCategoryId(bianhao);
                edoc_entry.setTitle(title);
                edoc_entry.setSummary(neirong);
                edoc_entry.setUploaduser(name);
                if( service.add(edoc_entry)){
                    System.out.println("新增成功!");
                }else{
                    System.out.println("新增失败!");
                }
                break;
            case 3:
                Edoc_entry edoc_entry2=new Edoc_entry();
                System.out.println("请输入要修改的文档编号:");
                int id=scanner.nextInt();
                System.out.println("请输入修改后的文档标题:");
                String title2=scanner.next();
                System.out.println("请输入修改后的内容:");
                String neirong2=scanner.next();
                System.out.println("请输入修改后的上传人姓名:");
                String name2=scanner.next();
                edoc_entry2.setId(id);
                edoc_entry2.setTitle(title2);
                edoc_entry2.setSummary(neirong2);
                edoc_entry2.setUploaduser(name2);
                if(service.update(edoc_entry2)){
                    System.out.println("修改成功!");
                }else{
                    System.out.println("修改失败!");
                }
                break;
            case 4:
                System.out.println("请输入要删除的文档编号:");
                int id2=scanner.nextInt();
                if(service.delete(id2)){
                    System.out.println("删除成功!");
                }else{
                    System.out.println("删除失败!");
                }
                break;
                default:
                    System.out.println("请输入1~4之间的数字!");
                    break;
                 }
    }

}
