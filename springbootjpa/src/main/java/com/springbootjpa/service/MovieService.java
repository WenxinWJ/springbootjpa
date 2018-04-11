package com.springbootjpa.service;

import com.springbootjpa.domain.Movie;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 业务逻辑接口
 *
 * @author WenXin
 */

public interface MovieService {

    // 增 / 改   指定id 则是 修改
    void save(Movie movie);

    // id删除
    void deleteById(Integer id);

    // 查询所有
    List<Movie> findAll();

    // id 查询
    Optional<Movie> findById(Integer id);

    // 手写的模糊查询
    List<Movie> findByName(String name);

    // name 查询
    List<Movie> findName(String name);

    // 没写sql 的模糊查询
    List<Movie> findByNameLike(String name);

    // 模糊查询 不包含 name 的 集合
    List<Movie> findByNameNotLike(String name);

    // 模糊查询 不包含 name 并且 价格 等于 price 的集合
    List<Movie> findByNameNotLikeAndPrice(String name, Double price);

    // 以时间范围查询
    List<Movie> findByActionTimeBetween(Date beginDate, Date endDate);
}
