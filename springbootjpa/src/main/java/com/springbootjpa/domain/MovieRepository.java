package com.springbootjpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 持久层： 由jpa 管理
 */                                                    // 类名，主键类型
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    // 包含了一般的增删改查

    // 模糊查询
    @Query(value = "from Movie m where m.name like CONCAT('%',:name,'%')")
    List<Movie> findByName(@Param("name") String name);

}
