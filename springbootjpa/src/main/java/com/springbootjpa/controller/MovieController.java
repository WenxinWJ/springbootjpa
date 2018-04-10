package com.springbootjpa.controller;

import com.springbootjpa.domain.CustomType;
import com.springbootjpa.domain.Movie;
import com.springbootjpa.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MovieController {
    @Resource(name = "movieServiceImpl")
    private MovieService movieService;

    // 增
    @RequestMapping(value = "/movie", method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody Movie movie) {
        CustomType customType = new CustomType(200, "OK");
        try {
            movieService.save(movie);
        } catch (Exception e) {
            customType.setCode(400);
            customType.setMessage("增加失败");
        }
        return new ResponseEntity<>(customType, HttpStatus.OK);
    }

    // 删
    @RequestMapping(value = "/movie/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> remove(@PathVariable("id") Integer id) {
        CustomType customType = new CustomType(200, "OK");
        try {
            movieService.deleteById(id);
        } catch (Exception e) {
            customType.setCode(400);
            customType.setMessage("删除失败");
        }
        return new ResponseEntity<>(customType, HttpStatus.OK);
    }

    // 改
    @RequestMapping(value = "/movie", method = RequestMethod.PUT)
    public ResponseEntity<?> modify(@RequestBody Movie movie) {
        CustomType customType = new CustomType(200, "OK");
        try {
            movieService.save(movie);
        } catch (Exception e) {
            customType.setCode(400);
            customType.setMessage("修改失败");
        }
        return new ResponseEntity<>(customType, HttpStatus.OK);
    }

    // 模糊查询
    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public ResponseEntity<?> findByName(@RequestParam(value = "name", required = false) String name) {
        List<Movie> list = movieService.findByName(name);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // id 查
    @RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findId(@PathVariable("id") Integer id) {
        CustomType customType = new CustomType(400, "错误");

        Optional<Movie> movie = movieService.findById(id);
        if (movie != null) {
            customType.setCode(200);
            customType.setMessage(movie);
        }
        return new ResponseEntity<>(customType, HttpStatus.OK);
    }
}
