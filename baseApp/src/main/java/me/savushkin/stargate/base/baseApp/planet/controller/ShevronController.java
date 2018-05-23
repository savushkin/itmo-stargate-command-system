package me.savushkin.stargate.base.baseApp.planet.controller;

import me.savushkin.stargate.base.baseApp.Services.StorageService;
import me.savushkin.stargate.base.baseApp.planet.model.Shevron;
import me.savushkin.stargate.base.baseApp.planet.repository.ShevronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/api/shevron")
public class ShevronController {
    private ShevronRepository shevronRepository;
    private StorageService storageService;

    public final String shevronsUploadPath = "shevrons";

    @Autowired
    public ShevronController(
            ShevronRepository shevronRepository,
            StorageService storageService){
        this.shevronRepository = shevronRepository;
        this.storageService = storageService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getList(
            @RequestParam(name = "page", defaultValue = "0") Integer pageNum,
            @RequestParam(name = "size", defaultValue = "15") Integer size) {
        try {
            Page<Shevron> page = shevronRepository.findAll(new PageRequest(pageNum, size));
            return new ResponseEntity(page, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity getShevron(
            @PathVariable("id") @NotNull Long id
    ){
        try{
            Shevron shevron = shevronRepository.findOne(id);
            return new ResponseEntity(shevron, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createShevron(
            @RequestBody() Shevron shevron
    ){
        try{
            Shevron shevronSaved = shevronRepository.save(shevron);
            return new ResponseEntity(shevronSaved, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/{id}/upload", method = RequestMethod.POST)
    public ResponseEntity uploadShevron(
            @RequestParam("file") @NotNull MultipartFile file,
            @PathVariable() Long id){
        try{
            Shevron shevron = shevronRepository.findOne(id);

            if(file.isEmpty())
                return new ResponseEntity(HttpStatus.NO_CONTENT);

            String fileName = file.getOriginalFilename();
            fileName = fileName.substring(fileName.lastIndexOf("."));
            fileName = id.toString() + fileName;

            if(storageService.fileExists(shevronsUploadPath, fileName))
                storageService.deleteFile(shevronsUploadPath, fileName);

            storageService.uploadFile(shevronsUploadPath, file, fileName);

            shevronRepository.save(shevron);

            return new ResponseEntity( "Файл успешно сохранен", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

//    @RequestMapping(path = "/{id}/download", method = RequestMethod.POST)
//    public ResponseEntity downloadFileFromServer(
//            @PathVariable() Long id){
//        try{
//            Shevron shevron = shevronRepository.findOne(id);
//
//            Resource resource = storageService.loadFile(this.shevronsUploadPath, shevron.getFileName());
//
//            return new ResponseEntity(resource, HttpStatus.OK);
//        }
//        catch(Exception e){
//            return new ResponseEntity(HttpStatus.BAD_REQUEST);
//        }
//    }
}
