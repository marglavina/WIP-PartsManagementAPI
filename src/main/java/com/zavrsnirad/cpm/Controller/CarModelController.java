package com.zavrsnirad.cpm.Controller;

import com.zavrsnirad.cpm.Model.CarBrand;
import com.zavrsnirad.cpm.Model.CarModel;
import com.zavrsnirad.cpm.Service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/brand")
public class CarModelController {

    @Autowired
    CarModelService carModelService;

    @GetMapping("/carModel")
    public List<CarModel> getAllCarModel(){
        return carModelService.getAllCarModel();
    }

    @GetMapping("/carModel/{id}")
    public List<CarModel> getAllCarModelForBrand(@PathVariable String id){
        return carModelService.getAllCarModelForBrand(id);
    }

    @PostMapping("/carModel/{brandName}")
    public CarModel addCarModel(@RequestBody CarModel carModel, @PathVariable(value = "brandName") String brandName){
        return carModelService.addCarModel(carModel, brandName);
    }

    @PutMapping("/carModel/{modelNameOLD}")
    public Optional<CarModel> updateCarModel(@PathVariable String modelNameOLD, @RequestBody CarModel carModel){
        return carModelService.updateCarModel(modelNameOLD, carModel);
    }

    @DeleteMapping("/carModel/{modelName}")
    public String deleteCarModel(@PathVariable String modelName){
        return carModelService.deleteCarModel(modelName);
    }
}
