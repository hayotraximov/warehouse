package uz.raximov.demo.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.raximov.demo.Entity.Supplier;
import uz.raximov.demo.Messages.Delete;
import uz.raximov.demo.Repository.SupplierRepositpory;

import java.util.Optional;


@Service
public class SupplierService {

    @Autowired
    SupplierRepositpory supplierRepositpory;

    //Barchasini qaytarish
    public Page<Supplier> page(Integer page){
        Pageable pageable = PageRequest.of(page,10);
        return supplierRepositpory.findAll(pageable);
    }

    //Id bo'yicha qaytarish
    public Supplier getById(Integer id){
        Optional<Supplier> optionalCategory = supplierRepositpory.findById(id);
        return optionalCategory.orElseGet(Supplier::new);
    }

    //O'chirish
    public Delete delete(Integer id){
        return new Delete();
        //kod yozish kerak
    }

    //Qo'shish
    public Supplier add(Supplier supplier1){
        Optional<Supplier> supplierOptional = supplierRepositpory.findByPhoneNumber(supplier1.getPhoneNumber());
        if (!supplierOptional.isPresent()){
            Supplier supplier = new Supplier();
            supplier.setActive(supplier1.isActive());
            supplier.setName(supplier1.getName());
            supplier.setPhoneNumber(supplier1.getPhoneNumber());
            return supplierRepositpory.save(supplier);
        }
        return new Supplier();
    }

    //Tahrirlash
    public Supplier edit(Integer id, Supplier supplier){
        Optional<Supplier> supplierOptional = supplierRepositpory.findById(id);
        if (supplierOptional.isPresent()){
            Supplier supplier1 = supplierOptional.get();
            supplier1.setName(supplier.getName());
            supplier1.setActive(supplier.isActive());
            supplier1.setPhoneNumber(supplier.getPhoneNumber());
            return supplierRepositpory.save(supplier1);
        }
        return new Supplier();
    }

}
