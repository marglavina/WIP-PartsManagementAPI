package com.zavrsnirad.cpm.Repository;

import com.zavrsnirad.cpm.Model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Integer> {

    @Query("SELECT cm FROM CarModel cm LEFT JOIN CarBrand cb ON " +
            "cm.carBrand.brandName = cb.brandName WHERE cb.brandName =?1 ")
    List<CarModel> findByBrandName(String brandName);
}
