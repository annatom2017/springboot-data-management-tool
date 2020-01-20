package com.pmt.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;


/**
 * Product service implementation layer
 * DTO --> entity copy done here.
 */
@Service
public class SortingServiceImpl implements SortingService {
	
	@Override
	public List<Integer> sortData(List<Integer> numList) {
		if(numList!=null) {
			return numList.stream().sorted().collect(Collectors.toList());
		}		
		return null;
	}
	
}
