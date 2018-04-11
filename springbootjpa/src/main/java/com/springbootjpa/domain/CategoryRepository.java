package com.springbootjpa.domain;

import org.hibernate.boot.model.source.spi.JpaCallbackSource;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Integer> {
}
