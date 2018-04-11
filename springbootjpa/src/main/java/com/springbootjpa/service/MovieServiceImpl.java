package com.springbootjpa.service;

import com.springbootjpa.domain.Movie;
import com.springbootjpa.domain.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 业务逻辑接口的实现类
 *
 * @author WenXin
 */
@Service
@Transactional
public class MovieServiceImpl implements MovieService {
    @Resource(name = "movieRepository")

    private MovieRepository movieRepository;

    @Override   // 增 / 改   指定id 则是 修改
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Override   // id删除
    public void deleteById(Integer id) {
        movieRepository.deleteById(id);
    }

    @Override   // 查询所有
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override   // id 查询
    public Optional<Movie> findById(Integer id) {
        return movieRepository.findById(id);
    }

    @Override   // 手写的模糊查询
    public List<Movie> findByName(String name) {
        return movieRepository.findByName(name);
    }

    @Override   // name 查询
    public List<Movie> findName(String name) {
        return movieRepository.findName(name);
    }

    @Override   // 没写sql 的模糊查询
    public List<Movie> findByNameLike(String name) {
        return movieRepository.findByNameLike(name);
    }

    @Override   // 模糊查询 不包含 name 的 集合
    public List<Movie> findByNameNotLike(String name) {
        return movieRepository.findByNameNotLike(name);
    }

    @Override   // 模糊查询 不包含 name 并且 价格 等于 price 的集合
    public List<Movie> findByNameNotLikeAndPrice(String name, Double price) {
        return movieRepository.findByNameNotLikeAndPrice(name, price);
    }

    @Override   // 以时间范围查询
    public List<Movie> findByActionTimeBetween(Date beginDate, Date endDate) {
        return movieRepository.findByActionTimeBetween(beginDate, endDate);
    }
}
