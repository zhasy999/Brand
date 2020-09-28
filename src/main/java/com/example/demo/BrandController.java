package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping("/create")
    public String addBrand(@RequestParam String title) {
        Brand brand = new Brand();
        brand.setTitle(title);

        if (brandService.addBrand(brand)) {
            return ("Brand " + brand + " added");
        }
        return (brand + " Already exist");
    }

    @GetMapping
    public List<Brand> allBrands(){
        return brandService.findAll();
    }

    @GetMapping("/{id}")
    public Brand findBrandById (@PathVariable("id") Long Id) {
        return brandService.findBrandById(Id);
    }

}