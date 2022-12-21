package com.zavrsnirad.cpm.Controller;

import com.zavrsnirad.cpm.Model.Part;
import com.zavrsnirad.cpm.Service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class PartController {

    @Autowired
    PartService partService;

    @GetMapping("/parts")
    List<Part> getAllParts(){
        return partService.getAllParts();
    }

    @GetMapping("/parts/{id}")
    List<Part> getPartsByModel(@PathVariable String id)
    {
        return partService.getPartsByModel(id);
    }
}
