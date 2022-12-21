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

    @PutMapping("/carBrand/{id}")
    public Optional<CarBrand> updateCarBrand(@PathVariable Integer id, @RequestBody CarBrand carBrand){
        return carBrandService.updateCarBrand(carBrand);
    }

    @DeleteMapping("/carBrand/{id}")
    public String deleteCarBrand(@PathVariable Integer id){
        return carBrandService.deleteCarBrand(id);
    }
}
