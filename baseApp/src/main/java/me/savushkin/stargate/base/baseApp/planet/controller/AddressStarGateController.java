package me.savushkin.stargate.base.baseApp.planet.controller;

import me.savushkin.stargate.base.baseApp.planet.model.AddressStarGate;
import me.savushkin.stargate.base.baseApp.planet.model.Zone;
import me.savushkin.stargate.base.baseApp.planet.repository.AddressStarGateRepository;
import me.savushkin.stargate.base.baseApp.planet.repository.ZoneRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/api/addressStarGate")
public class AddressStarGateController {
    private final AddressStarGateRepository addressStarGateRepository;

    private final int countShevrons = 6;

    public AddressStarGateController(AddressStarGateRepository addressStarGateRepository){
        this.addressStarGateRepository = addressStarGateRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getPage(@RequestParam(name = "page", defaultValue = "0") Integer pageNum,
                                  @RequestParam(name = "size", defaultValue = "15") Integer size) {
        try {
            Page<AddressStarGate> page = addressStarGateRepository.findAll(new PageRequest(pageNum, size));
            return new ResponseEntity(page, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getAddress(
            @PathVariable("id") @NotNull Long id){
        try{
            AddressStarGate shevron = addressStarGateRepository.findOne(id);
            return new ResponseEntity(shevron, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createAddress(
            @RequestBody() AddressStarGate address){
        try{
            AddressStarGate addressSaved = addressStarGateRepository.save(address);
            return new ResponseEntity(addressSaved, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity updateAddress(
            @RequestBody() AddressStarGate address){
        //TODO:пока что код дублирую с созданием, потом возможно будет проверка на валидность данных
        try{
            AddressStarGate addressSaved = addressStarGateRepository.save(address);
            return new ResponseEntity(addressSaved, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity deleteAddress (
            @PathVariable("id") @NotNull Long id
    ){
        try{
            addressStarGateRepository.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}