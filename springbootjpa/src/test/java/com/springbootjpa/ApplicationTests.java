package com.springbootjpa;

import com.springbootjpa.domain.Movie;
import com.springbootjpa.domain.Product;
import com.springbootjpa.service.CategoryService;
import com.springbootjpa.service.MovieService;
import com.springbootjpa.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Resource(name = "movieServiceImpl")
    private MovieService movieService;

    @Resource(name = "productService")
    private ProductService productService;

    @Resource(name = "categoryService")
    private CategoryService categoryService;

    @Test
    public void save() {    // 指定id 则是 修改
        Movie movie = new Movie();
        movie.setName("肖申克的救赎");
        movie.setPrice(40d);
        movie.setActionTime(new Date());

        movieService.save(movie);
    }

    @Test
    public void deleteById() {
        movieService.deleteById(10);
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
    public void findByName() {
        for (Movie movie : movieService.findByName("")) {
            System.out.println(movie);
        }
    }

    @Test
    public void findName() {
        for (Movie movie : movieService.findName("xixi")) {
            System.out.println(movie);
        }
    }

    @Test
    public void findByNameLike() {
        for (Movie movie : movieService.findByNameLike("%xi%")) {
            System.out.println(movie);
        }
    }

    @Test
    public void findByNameNotLike() {
        for (Movie movie : movieService.findByNameNotLike("%xi%")) {
            System.out.println(movie);
        }
    }

    @Test
    public void findByNameNotLikeAndPrice() {
        for (Movie movie : movieService.findByNameNotLikeAndPrice("%xi%", 40d)) {
            System.out.println(movie);
        }
    }

    @Test
    public void findByActionTimeBetween() {
        Date beginDate = new Date();
        Date endDate = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            beginDate = sdf.parse("2018-04-08 00:00:00");
            endDate = sdf.parse("2018-04-11 23:59:59");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        for (Movie movie : movieService.findByActionTimeBetween(beginDate, endDate)) {
            System.out.println(movie);
        }
    }
}
