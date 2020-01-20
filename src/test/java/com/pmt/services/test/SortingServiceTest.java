package com.pmt.services.test;

import java.util.List;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.pmt.services.SortingServiceImpl;
import org.junit.Test;
import static org.junit.Assert.*;


public class SortingServiceTest {
	public static final Logger LOGGER = LoggerFactory.getLogger(SortingServiceTest.class);
			
	@Before
	public void setUp(){
		List<Integer> list = Arrays.asList(10,5,12,89,25,78,8);
	}
	
	@Test
	public void testSortData(){
		List<Integer> list = Arrays.asList(10,5,12,89,25,78,8);
		SortingServiceImpl sortingService=new SortingServiceImpl();
				
		List<Integer> sortedList=sortingService.sortData(list);  
		Assert.assertNotNull(sortedList);
		assertEquals(Integer.valueOf(5),sortedList.get(0));
		
	}	
}
