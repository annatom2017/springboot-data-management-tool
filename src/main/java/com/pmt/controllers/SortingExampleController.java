package com.pmt.controllers;

import com.pmt.services.SortingService;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

/**
 * Sorting example controller.
 */
@RestController
@RequestMapping(value = "/app/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class SortingExampleController {
    private SortingService sortingService;
    
    @Autowired
    public void setSortingService(SortingService sortingService) {
        this.sortingService = sortingService;
    }
    
    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SortingExampleController.class);

    /**
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception exception) {
        LOGGER.error("Generic errors");
        return new ResponseEntity<>(new String("Error in SortingExampleController :" + exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * This method will sort the input list
     */
   @RequestMapping(value = "/sortlist",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<?> sortData(@Valid @RequestBody List<Integer> numList, BindingResult bindingResult) {
	    LOGGER.debug("called method sortData");
       if (bindingResult.hasErrors()) {
           return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
       }
       return new ResponseEntity<>(sortingService.sortData(numList), HttpStatus.OK);
   }

}
