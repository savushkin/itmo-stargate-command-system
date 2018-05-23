package me.savushkin.stargate.base.baseApp.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class StorageService {
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private final Path rooLocation = Paths.get("uploads");

    public void uploadFile(String filePath,
                           MultipartFile file,
                           String fileName) throws java.io.IOException{
        Path path = rooLocation.resolve(filePath);
        if(!Files.exists(path))
            Files.createDirectory(path);
        Files.copy(file.getInputStream(), path.resolve(fileName));
    }

    public Resource loadFile(String filePath, String fileName) throws Exception {
        Path path = this.rooLocation.resolve(filePath);
        Path file = path.resolve(fileName);
        Resource resource = new UrlResource(file.toUri());
        if(resource.exists() || resource.isReadable())
            return resource;
        else
            throw new Exception("File does not exists");
    }

    public void deleteAll(){
        FileSystemUtils.deleteRecursively(rooLocation.toFile());
    }

    public void deleteFile(String filePath, String fileName)throws Exception{
        Path path = this.rooLocation.resolve(filePath);
        Files.delete(path.resolve(fileName));
    }

    public void init() throws Exception {
        try{
            Files.createDirectory(rooLocation);
        }
        catch(Exception e){
            throw new Exception("error init root directory for upload");
        }
    }

    public Boolean fileExists(String filePath, String fileName){
        Path path = this.rooLocation.resolve(filePath);
        return Files.exists(path.resolve(fileName));
    }
}