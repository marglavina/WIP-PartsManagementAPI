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

    public Optional<CarBrand> updateCarBrand(CarBrand carBrand){
        Integer updated = carBrandRepository.updateCarBrand(carBrand.getBrandName(), carBrand.getID());
        Optional<CarBrand> carBrandUpdated = carBrandRepository.findById(carBrand.getID());

        return carBrandUpdated;
    }

    public String deleteCarBrand(Integer id) {
        Integer deleted = carBrandRepository.deleteCarBrand(id);
        switch (deleted){
            case 0: return "Something went wrong";
            default: return "Car brand deleted";
        }
    }
}
