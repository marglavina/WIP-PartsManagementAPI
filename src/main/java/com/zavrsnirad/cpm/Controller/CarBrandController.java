package com.zavrsnirad.cpm.Controller;

import com.zavrsnirad.cpm.Model.CarBrand;
import com.zavrsnirad.cpm.Service.CarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/brand")
public class CarBrandController {

    @Autowired
    CarBrandService carBrandService;

    @GetMapping("/carBrand")
    public List<CarBrand> getAllCarBrand(){
        return carBrandService.getAllCarBrand();
    }

    @PostMapping("/carBrand")
    public CarBrand addNewCarBrand(@RequestBody CarBrand carBrand){
        return carBrandService.addNewCarBrand(carBrand);
    }

    @PutMapping("/carBrand/{brandNameOLD}")
    public Optional<CarBrand> updateCarBrand(@PathVariable String brandNameOLD, @RequestBody CarBrand carBrand){
        return carBrandService.updateCarBrand(brandNameOLD, carBrand);
    }

    @DeleteMapping("/carBrand/{brandName}")
    public String deleteCarBrand(@PathVariable String brandName){
        return carBrandService.deleteCarBrand(brandName);
    }
}
