package com.zavrsnirad.cpm.Service;

import com.zavrsnirad.cpm.Model.Part;
import com.zavrsnirad.cpm.Repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartService {

    @Autowired
    PartRepository partRepository;

    public List<Part> getAllParts(){
        return partRepository.findAll();
    }

    public List<Part> getPartsByModel(String modelName){
        return partRepository.getPartsByModel(modelName.replace("_", ""));
    }

}
