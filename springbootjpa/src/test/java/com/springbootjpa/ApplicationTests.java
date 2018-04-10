package com.springbootjpa;

import com.springbootjpa.domain.Movie;
import com.springbootjpa.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Resource(name = "movieServiceImpl")
    private MovieService movieService;

    @Test
    public void save() {    // 指定id 则是 修改
        Movie movie = new Movie();
        movie.setName("肖申克的救赎");
        movie.setPrice(40d);
        movie.setActionTime(new Date());

        movieService.save(movie);
    }

    @Test
    public void find() {
        for (Movie m : movieService.findAll()) {
            System.out.println(m);
        }
    }

    @Test
    public void findId() {
        Optional<Movie> movie = movieService.findById(2);
        System.out.println(movie.get().getName());
        //System.out.println(movieService.findById(2));
    }

    @Test
    public void deleteById() {
        movieService.deleteById(10);
    }

    @Test
    public void findByName() {
        for (Movie movie : movieService.findByName("")) {
            System.out.println(movie);
        }
    }
}
