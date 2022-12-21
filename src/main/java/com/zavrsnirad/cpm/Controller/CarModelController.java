package com.zavrsnirad.cpm.Controller;

import com.zavrsnirad.cpm.Model.CarModel;
import com.zavrsnirad.cpm.Service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
