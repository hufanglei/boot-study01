package com.hfl.service;

import com.hfl.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hfl on 2017-4-27.
 *
 * 要使接口拥有Jpa的功能，只需要将此接口继承JpaRepository接口即可，
 * JpaRespsitory接口有两个泛型，第一个：指具体的实体对象User，第二个：指实体对象的主键ID的类型Integer。
 */
public interface IUserService  extends JpaRepository<User, Integer> {
}
