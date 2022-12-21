package com.zavrsnirad.cpm.Repository;

import com.zavrsnirad.cpm.Model.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartRepository extends JpaRepository<Part, Integer> {


    @Query("SELECT p from Part p left join CarModel cm ON" +
            " p.carModel.modelName = cm.modelName where cm.modelName = ?1")
    List<Part> getPartsByModel(String modelName);


}
