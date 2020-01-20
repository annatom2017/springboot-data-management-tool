package com.pmt.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;


/**
 * 
 * Service layer methods
 *
 */
@Validated
public interface SortingService {

	//List<Profile> listAllUsers();

	List<Integer> sortData(List<Integer> numList);

}
