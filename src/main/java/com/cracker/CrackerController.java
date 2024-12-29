package com.cracker;

import com.cracker.request.CrackerRequest;
import com.cracker.request.CrackerResponse;
import com.cracker.services.CrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/api/v1")
public class CrackerController {
    private final CrackerService crackerService;
    @Autowired
    public CrackerController (CrackerService crackerService){
        this.crackerService = crackerService ;
    }

    @RequestMapping(method = RequestMethod.POST, value = "test", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
        public CrackerResponse cracker (@RequestBody CrackerRequest crackerRequest){

        return crackerService.handleRequest(crackerRequest) ;

        }

}
