package com.project.project.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.project.entity.Medicine;
import com.project.project.service.MedicineService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(path = "api/medicine")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;

    @GetMapping
    public List<Medicine>  getAll(){
        return medicineService.getMedicine();
    }
    @GetMapping("/{id}")
    public Optional<Medicine> getById(@PathVariable("id") Long id){
        return medicineService.getMedicine(id);
    }
    @PostMapping
    public void save(@RequestBody Medicine medicine){
        medicineService.save(medicine);
    }
     @PutMapping("/{id}")  //http://localhost:8080/api/medicine/{{id}}
    public void update(@PathVariable("id") Long id, @RequestBody Medicine medicine) {
        medicineService.update(id, medicine);
    }

    @DeleteMapping("/{id}") //http://localhost:8080/api/medicine/1
    public void saveUpdate(@PathVariable("id") Long id){
        medicineService.delete(id);
    }


}
