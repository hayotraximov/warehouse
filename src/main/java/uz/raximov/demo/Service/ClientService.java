package uz.raximov.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.raximov.demo.Entity.Client;
import uz.raximov.demo.Messages.Delete;
import uz.raximov.demo.Repository.ClientRepository;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    //Barchasini qaytarish
    public Page<Client> page(Integer page){
        Pageable pageable = PageRequest.of(page,10);
        return clientRepository.findAll(pageable);
    }

    //Id bo'yicha qaytarish
    public Client getById(Integer id){
        Optional<Client> optionalMeasurement = clientRepository.findById(id);
        return optionalMeasurement.orElseGet(Client::new);
    }

    //Measurementni o'chirish
    public Delete delete(Integer id){
        return new Delete();
        //kod yozish kerak
    }

    //Client qo'shish
    public Client add(Client client){
        Optional<Client> clientOptional = clientRepository.findByPhoneNumber(client.getPhoneNumber());
        if (!clientOptional.isPresent()){
            return clientRepository.save(client);
        }
        return new Client();
    }

    //Measurementni tahrirlash
    public Client edit(Integer id, Client client){
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()){
            Client client1 = clientOptional.get();
            client1.setName(client.getName());
            client1.setPhoneNumber(client.getPhoneNumber());
            return clientRepository.save(client1);
        }
        return new Client();
    }

}
