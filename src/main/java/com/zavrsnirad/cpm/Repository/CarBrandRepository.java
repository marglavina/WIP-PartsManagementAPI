package com.zavrsnirad.cpm.Repository;

import com.zavrsnirad.cpm.Model.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CarBrandRepository extends JpaRepository<CarBrand, Integer> {

    @Query("SELECT brandName from CarBrand")
    List<CarBrand> getAllCarBrand();

    @Modifying
    @Transactional
    @Query("UPDATE CarBrand cb SET cb.brandName = ?1 where cb.brandName = ?2")
    Integer updateCarBrand(String brandNameNew, String brand_name);

    @Modifying
    @Transactional
    @Query("DELETE FROM CarBrand cb WHERE cb.brandName = ?1")
    Integer deleteCarBrand(String brandName);
}
