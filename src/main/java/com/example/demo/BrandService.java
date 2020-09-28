package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class BrandService {

    private BrandRepository brandRepo;


    @Autowired
    public void setClassRepository(BrandRepository brandRepo) {
        this.brandRepo = brandRepo;
    }

    @Transactional
    public boolean addBrand(Brand brand) {
        if (brandRepo.findBrandByTitleIgnoreCase(brand.getTitle()) != null) {
            brand.setId(Long.MIN_VALUE);
            System.out.println("Error");
            return false;
        }
        brandRepo.save(brand);
        return true;
    }

    @Transactional
    public Brand findBrandById(Long id) {
        return brandRepo.findById(id).get();
    }

    @Transactional
    public List<Brand> findAll() {
        List<Brand> brands = brandRepo.findAll();
        return brands;
    }


}
