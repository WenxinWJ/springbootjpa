package com.springbootjpa.service;

import com.springbootjpa.domain.Movie;
import com.springbootjpa.domain.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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

    @Override
    public void save(Movie movie) { // 指定id 则是 修改
        movieRepository.save(movie);
    }

    @Override
    public void deleteById(Integer id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findById(Integer id) {
        return movieRepository.findById(id);
    }

    @Override
    public List<Movie> findByName(String name) {
        return movieRepository.findByName(name);
    }
}
