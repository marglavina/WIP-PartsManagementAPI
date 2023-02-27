package com.zavrsnirad.cpm.Repository;

import com.zavrsnirad.cpm.Model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Integer> {

    @Query("SELECT cm FROM CarModel cm LEFT JOIN CarBrand cb ON " +
            "cm.carBrand.brandName = cb.brandName WHERE cb.brandName =?1 ")
    List<CarModel> findByBrandName(String brandName);

    @Modifying
    @Transactional
    @Query("UPDATE CarModel cm SET cm.modelName = ?1 where cm.modelName = ?2")
    Integer updateCarModel(String modelNameNew, String model_name);

    @Modifying
    @Transactional
    @Query("DELETE FROM CarModel cm WHERE cm.modelName = ?1")
    Integer deleteCarModel(String modelName);
}
