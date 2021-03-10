package uz.raximov.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.raximov.demo.Entity.Measurement;
import uz.raximov.demo.Messages.Delete;
import uz.raximov.demo.Repository.MeasurementRepository;

import java.util.Optional;

@Service
public class MeasurementService {
    @Autowired
    MeasurementRepository measurementRepository;

    //Barchasini qaytarish
    public Page<Measurement> measurementPage(Integer page){
        Pageable pageable = PageRequest.of(page,10);
        return measurementRepository.findAll(pageable);
    }

    //Id bo'yicha qaytarish
    public Measurement measurementgetById(Integer id){
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        return optionalMeasurement.orElseGet(Measurement::new);
    }

    //Measurementni o'chirish
    public Delete deleteMeasurement(Integer id){
        return new Delete();
        //kod yozish kerak
    }

    //Measurement qo'shish
    public Measurement addMeasurement(Measurement measurement){
        Optional<Measurement> measurementOptional = measurementRepository.findByName(measurement.getName());
        if (!measurementOptional.isPresent()){
            return measurementRepository.save(measurement);
        }
        return new Measurement();
    }

    //Measurementni tahrirlash
    public Measurement editMeasurement(Integer id, Measurement measurement){
        Optional<Measurement> measurementOptional = measurementRepository.findById(id);
        if (measurementOptional.isPresent()){
            Measurement measurement1 = measurementOptional.get();
            measurement1.setName(measurement.getName());
            measurement1.setActive(measurement.isActive());
            return measurementRepository.save(measurement1);
        }
        return new Measurement();
    }
}
