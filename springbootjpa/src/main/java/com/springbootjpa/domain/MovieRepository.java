package com.springbootjpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * 持久层： 由jpa 管理
 */                                                    // 类名，主键类型
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    // 包含了一般的增删改查

    // hql: Hiberante Quert Language : Hiberante 查询语言 - 类名 + 属性名
    @Query(value = "from Movie m where m.name = :name")
    List<Movie> findName(@Param("name") String name);

    // 模糊查询
    @Query(value = "from Movie m where m.name like CONCAT('%',:name,'%')")
    List<Movie> findByName(@Param("name") String name);

    // 模糊查询
    List<Movie> findByNameLike(String name);

    // 模糊查询 不包含 name 的 集合
    List<Movie> findByNameNotLike(String name);

    // 模糊查询 不包含 name 并且 价格 等于 price 的集合
    List<Movie> findByNameNotLikeAndPrice(String name, Double price);

    // 以时间范围查询
    List<Movie> findByActionTimeBetween(Date beginDate, Date endDate);
}
