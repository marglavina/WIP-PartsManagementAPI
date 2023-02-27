package com.zavrsnirad.cpm.Service;

import com.zavrsnirad.cpm.Model.CarBrand;
import com.zavrsnirad.cpm.Model.CarModel;
import com.zavrsnirad.cpm.Repository.CarBrandRepository;
import com.zavrsnirad.cpm.Repository.CarModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarModelService {

    @Autowired
    CarModelRepository carModelRepository;
    @Autowired
    CarBrandRepository carBrandRepository;

    public List<CarModel> getAllCarModel(){
        return carModelRepository.findAll();
    }

    public List<CarModel> getAllCarModelForBrand(String brandName){
        return carModelRepository.findByBrandName(brandName);
    }

    public CarModel addCarModel(CarModel carModel, String brandName){

        carModel.setCarBrand(carBrandRepository.getCarBrandByBrandName(brandName.replace("%20", " ")));
        return carModelRepository.save(carModel);
    }

    public Optional<CarModel> updateCarModel(String modelNameOLD, CarModel carModel){
        Integer updated = carModelRepository.updateCarModel(carModel.getModelName(), modelNameOLD.replace("%20", " "));
        Optional<CarModel> carModelUpdated = carModelRepository.findById(carModel.getID());

        return carModelUpdated;
    }

    public String deleteCarModel(String modelName) {
        Integer deleted = carModelRepository.deleteCarModel(modelName.replace("%20", " "));
        System.out.println(deleted);
        switch (deleted){
            case 0: return "Something went wrong";
            case 1: return "Car model deleted";
            default: return "";
        }
    }
}
