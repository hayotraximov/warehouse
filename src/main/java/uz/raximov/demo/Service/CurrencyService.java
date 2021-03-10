package uz.raximov.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.raximov.demo.Entity.Currency;
import uz.raximov.demo.Messages.Delete;
import uz.raximov.demo.Repository.CurrencyRepository;

import java.util.Optional;

@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;

    //Barchasini qaytarish
    public Page<Currency> page(Integer page){
        Pageable pageable = PageRequest.of(page,10);
        return currencyRepository.findAll(pageable);
    }

    //Id bo'yicha qaytarish
    public Currency getById(Integer id){
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        return optionalCurrency.orElseGet(Currency::new);
    }

    //O'chirish
    public Delete delete(Integer id){
        return new Delete();
        //kod yozish kerak
    }

    //Qo'shish
    public Currency add(Currency currency){
        Optional<Currency> currencyOptional = currencyRepository.findByName(currency.getName());
        if (!currencyOptional.isPresent()){
            Currency currency1 = new Currency();
            currency1.setActive(currency.isActive());
            currency1.setName(currency.getName());
            return currencyRepository.save(currency1);
        }
        return new Currency();
    }

    //Tahrirlash
    public Currency edit(Integer id, Currency currency){
        Optional<Currency> currencyOptional = currencyRepository.findById(id);
        if (currencyOptional.isPresent()){
            Currency currency1 = currencyOptional.get();
            currency1.setName(currency.getName());
            currency1.setActive(currency.isActive());
            return currencyRepository.save(currency1);
        }
        return new Currency();
    }
}
