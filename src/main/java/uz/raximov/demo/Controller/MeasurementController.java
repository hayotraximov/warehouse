package uz.raximov.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import uz.raximov.demo.Entity.Measurement;
import uz.raximov.demo.Messages.Delete;
import uz.raximov.demo.Service.MeasurementService;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {

    @Autowired
    MeasurementService measurementService;

    @GetMapping
    public Page<Measurement> getMeasurement(@RequestParam Integer page){
        return measurementService.measurementPage(page);
    }

    @GetMapping("/{id}")
    public Measurement getMeasurementById(@PathVariable Integer id){
        return measurementService.measurementgetById(id);
    }

    @DeleteMapping("{id}")
    public Delete deleteMeasurement(@PathVariable Integer id){
        return measurementService.deleteMeasurement(id);
    }

    @PostMapping
    public Measurement addMeasurement(@RequestBody Measurement measurement){
        return measurementService.addMeasurement(measurement);
    }

    @PutMapping("/{id}")
    public Measurement editMeasurement(@PathVariable Integer id, @RequestBody Measurement measurement){
        return measurementService.editMeasurement(id, measurement);
    }
}
