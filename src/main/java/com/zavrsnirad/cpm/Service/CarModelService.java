package com.zavrsnirad.cpm.Service;

import com.zavrsnirad.cpm.Model.CarModel;
import com.zavrsnirad.cpm.Repository.CarModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarModelService {

    @Autowired
    CarModelRepository carModelRepository;

    public List<CarModel> getAllCarModel(){
        return carModelRepository.findAll();
    }

    public List<CarModel> getAllCarModelForBrand(String brandName){
        return carModelRepository.findByBrandName(brandName);
    }
}
