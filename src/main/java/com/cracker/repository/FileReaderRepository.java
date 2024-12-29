package com.cracker.repository;

import com.cracker.configuration.DictionaryFileConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FileReaderRepository implements DictionaryRepository {

    private final String filePath;
    @Autowired
    public FileReaderRepository (DictionaryFileConfiguration dictionaryFileConfiguration){
        this.filePath = dictionaryFileConfiguration.getPath();
    }


    @Override
   public List<String> getDictionaryWords (){
       List<String> fileContent = new ArrayList<>() ;

       try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
           String line;
           while ((line = reader.readLine()) != null) {
               fileContent.add(line);

           }
       } catch (IOException e) {
           e.printStackTrace();
       }
       return fileContent ;

   }

}
