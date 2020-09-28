package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface BrandRepository extends CrudRepository<Brand, Long> {

    Class findBrandByTitleIgnoreCase(String title);

    Class findBrandById(Long id);

    List<Brand> findAll();

}
