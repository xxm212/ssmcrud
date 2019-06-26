package cn.gray.crud.test;

import cn.gray.crud.bean.Department;
import cn.gray.crud.bean.Employee;
import cn.gray.crud.dao.DepartmentMapper;
import cn.gray.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.swing.*;
import java.util.UUID;

/**
 * 测试dao层的工作
 * 推荐Spring的项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
 * 导入SpringTest模块
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public  class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SqlSession sqlSession;
    /**
     * 测试DepartmentMapper
     */
    @Test
    public void testCRUD(){
//        //1.创建SpringIOC容器
//        ApplicationContext ioc=
//                new ClassPathXmlApplicationContext("applicationContext.xml");
//        //2.从容器中获取mapper
//        DepartmentMapper bean=ioc.getBean(DepartmentMapper.class);
        System.out.println(departmentMapper);

        //1.插入几个部门
//        departmentMapper.insertSelective(new Department(null,"业务部"));
//        departmentMapper.insertSelective(new Department(null,"测试部"));

//        System.out.println(new Employee(null,"Jerry","M","Jerry@gray.com",1));

        //2生成员工数据，测试员工插入
     //   employeeMapper.insertSelective(new Employee(null,"Jerry","M","Jerry@gray.com",1));
        //3.批量导入员工信息
       EmployeeMapper mapper= sqlSession.getMapper(EmployeeMapper.class);
       for (int i=0;i<1000;i++){
           String uid=UUID.randomUUID().toString().substring(0,5)+i;
           mapper.insertSelective(new Employee(null,uid,"M",uid+"@gray.com",1));
       }
        System.out.println("批量完成");




    }

}
