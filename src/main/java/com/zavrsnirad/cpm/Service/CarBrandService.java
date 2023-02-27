package com.zavrsnirad.cpm.Service;

import com.zavrsnirad.cpm.Model.CarBrand;
import com.zavrsnirad.cpm.Repository.CarBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarBrandService {

    @Autowired
    CarBrandRepository carBrandRepository;

    public List<CarBrand> getAllCarBrand(){
        return carBrandRepository.findAll() ;
    }

    public CarBrand addNewCarBrand(CarBrand carBrand){
         return carBrandRepository.save(carBrand);
    }

    public Optional<CarBrand> updateCarBrand(String brandNameOLD, CarBrand carBrand){
        Integer updated = carBrandRepository.updateCarBrand(carBrand.getBrandName(), brandNameOLD.replace("%20", " "));
        Optional<CarBrand> carBrandUpdated = carBrandRepository.findById(carBrand.getID());

        return carBrandUpdated;
    }

    public String deleteCarBrand(String brandName) {
        Integer deleted = carBrandRepository.deleteCarBrand(brandName.replace("%20", " "));
        System.out.println(deleted);
        switch (deleted){
            case 0: return "Something went wrong";
            case 1: return "Car brand deleted";
            default: return "";
        }
    }
}
