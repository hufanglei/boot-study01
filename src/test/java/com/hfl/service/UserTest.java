package com.hfl.service;

import com.hfl.dto.SearchDto;
import com.hfl.model.User;
import com.hfl.tools.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by hfl on 2017-4-27.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
public class UserTest {

    @Autowired
    private IUserService userService;

    //添加数据
    //这里的save方法是从JpaRepository中继承而来，是属于Jpa封装方法之一。
    @Test
    public void testAdd() {
        User user = new User();
        user.setEmail("393156105@qq.com");
        user.setNickName("知识林");
        user.setPassword("123456");
        user.setUserName("zslin");
        userService.save(user);
    }

    //获取数据
    //注意： 这里的findOne方法也是从JpaRepository中继承而来。由于在testAdd方法中添加了一条数据，主键Id为1，
    //所以在这里可以直接在findOne中传1获取出相应数据，findOne的参数是对象Id。
    @Test
    public void testFind() {
        User user = userService.findOne(1);
        System.out.println("nickName : "+user.getNickName()+", email : "+user.getEmail());
    }

    //修改数据
    //这里的修改数据也是使用save方法，也就是说添加和修改都使用save方法，运行testUpdate方法后将得
    @Test
    public void testUpdate() {
        User user = userService.findOne(1);
        user.setNickName("胡方雷");
        userService.save(user);
        System.out.println("nickName : "+user.getNickName()+", email : "+user.getEmail());
    }

    //删除数据
    //这里的delete也是继承于JpaRepository。参数可以传一个Id值，也可以传一个数据对象。
    // deleteAll()方法也可以删除，没有参数，是属于清空数据表，一般不会使用。
    @Test
    public void testDelete() {
        userService.delete(1);
        //userService.deleteAll();
    }

    //列表数据
    @Test
    public void testAddBatch() {
        for(Integer i=0; i < 10; i++) {
            User user = new User();
            user.setNickName("昵称"+i);
            user.setUserName("user"+i);
            user.setPassword("pwd"+i);
            user.setEmail("email"+i+"@domain.com");
            userService.save(user);
        }
    }

    //获取所有数据：
    @Test
    public void testFindAll() {
        List<User> list = userService.findAll();
        for(User u : list) {
            System.out.println("nickName : "+u.getNickName()+", email : "+u.getEmail());
        }
    }

    //通过字段获取数据
    @Test
    public void testFindById() {
        User u = userService.findById(3);
        System.out.println("nickName : "+u.getNickName()+", email : "+u.getEmail());
    }

    //通过用户名获取用户
    @Test
    public void testFindByUserName() {
        User u = userService.findByUserName("user3");
        System.out.println("nickName : "+u.getNickName()+", email : "+u.getEmail());
    }

    //通过用户名和密码获取用户
    @Test
    public void testFindByNameAndPwd() {
        User u = userService.findByUserNameAndPassword("user4", "pwd4");
        System.out.println("nickName : "+u.getNickName()+", email : "+u.getEmail());
    }


    @Test
    public void testQuery() {
        List<User> list = userService.findAll("user3");
        System.out.println(list.size());
    }

    @Test
    public void testUpdate2() {
        userService.updatePwd("user1", "123456");
    }

    @Test
    public void testDelete2() {
        userService.deleteByUserName("user4");
    }

    @Test
    public void testUpdate3() {
        userService.updateEmail("user2", "user2@qq.com");
    }

    //排序
    @Test
    public void testPage() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        List<User> list = userService.findAll(sort);
        for(User u : list) {
            System.out.println(u.getUserName());
        }
    }

    @Test
    public void testSort2() {
        List<User> list = userService.findAll(SortTools.basicSort());
        for(User u : list) {
            System.out.println(u.getUserName());
        }
    }

    @Test
    public void testSort3() {
        List<User> list = userService.findAll(SortTools.basicSort("desc", "userName"));
        for(User u : list) {
            System.out.println(u.getUserName());
        }
    }

    @Test
    public void testSort4() {
        List<User> list = userService.findAll(SortTools.basicSort(new SortDto("desc", "userName"), new SortDto("id")));
        for(User u : list) {
            System.out.println(u.getId()+"===="+u.getUserName());
        }
    }

    //原生分页
    //继承了JpaRepository后的IUserService拥有了findAll的重载方法，当传入参数为Pageable时，返回传则是一个分页的对象Page。
    @Test
    public void test1() {
        Pageable pageable =new PageRequest(0, 5);
        Page<User> datas = userService.findAll(pageable);
        System.out.println("总条数："+datas.getTotalElements());
        System.out.println("总页数："+datas.getTotalPages());
        for(User u : datas) {
            System.out.println(u.getId()+"===="+u.getUserName());
        }
    }

    //测试传页码和条数
    private void print(Page<User> datas) {
        System.out.println("总条数："+datas.getTotalElements());
        System.out.println("总页数："+datas.getTotalPages());
        for(User u : datas) {
            System.out.println(u.getId()+"===="+u.getUserName());
        }
    }

    @Test
    public void test2() {
        Page<User> datas = userService.findAll(PageableTools.basicPage(0));
        print(datas);
    }

    //测试传页码和条数
    @Test
    public void test3() {
        Page<User> datas = userService.findAll(PageableTools.basicPage(1, 5));
        print(datas);
    }

    //测试传页码、条数和排序
    @Test
    public void test4() {
        Page<User> datas = userService.findAll(PageableTools.basicPage(1, 5, new SortDto("id")));
        print(datas);

        Page<User> datas2 = userService.findAll(PageableTools.basicPage(1, 5, new SortDto("ASC", "id")));
        print(datas2);
    }

    //筛选对象
    private void print(List<User> list) {
        for(User u : list) {
            System.out.println(u.getId()+"==="+u.getUserName());
        }
    }

    @Test
    public void test6() {
        List<User> list = userService.findAll(new BaseSearch<User>(new SearchDto("userName","eq", "user1")));
        print(list);
    }

    //测试创建筛选功能对象
    @Test
    public void test7() {
        List<User> list = userService.findAll(SearchTools.buildSpecification(
                SearchTools.buildSpeDto("and", new SearchDto("and", "id", "gt", 2)),
                SearchTools.buildSpeDto("and", new SearchDto("userName", "ne", "user5"),
                        new SearchDto("or", "userName", "ne", "user9"))
        ));
        print(list);
    }




}
