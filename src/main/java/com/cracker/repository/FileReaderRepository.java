package com.cracker.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderRepository implements DictionaryRepository {


    private final String filePath;

    public FileReaderRepository (String filePath){
        this.filePath = filePath ;
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
