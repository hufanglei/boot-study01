package com.hfl.service;

import com.hfl.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hfl on 2017-4-27.
 *
 * 要使接口拥有Jpa的功能，只需要将此接口继承JpaRepository接口即可，
 * JpaRespsitory接口有两个泛型，第一个：指具体的实体对象User，第二个：指实体对象的主键ID的类型Integer。
 */
public interface IUserService  extends JpaRepository<User, Integer> {

    //通过Id获取数据
    User findById(Integer id);

    //通过用户名获取用户
    User findByUserName(String userName);


    //通过用户名和密码获取用户
    User findByUserNameAndPassword(String userName, String password);

    //使用Hql方式获取数据：
    @Query("FROM User u WHERE u.userName=?1 AND u.password IS NOT NULL")
    List<User> findAll(String userName);

    //修改数据
    //只要涉及修改或删除数据的操作都需要加上注释@Modifying和@Transcational（Transcational是org.springframework.transaction.annotation包中的不要导错了）
    @Query("UPDATE User u SET u.password=?2 WHERE u.userName=?1")
    @Modifying
    @Transactional
    void updatePwd(String userName, String pwd);

    //删除数据
    @Query("DELETE FROM User u WHERE u.userName=?1")
    @Modifying
    @Transactional
    void deleteByUserName(String userName);

    @Query("UPDATE User u SET u.email= :email WHERE u.userName = :user")
    @Modifying
    @Transactional
    void updateEmail(@Param("user") String userName, @Param("email") String email);
}
