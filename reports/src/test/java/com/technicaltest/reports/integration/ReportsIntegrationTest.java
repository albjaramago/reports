package com.technicaltest.reports.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.technicaltest.reports.ReportsApplication;
import com.technicaltest.reports.config.ReportTestConfig;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
  ReportsApplication.class,  
  ReportTestConfig.class})
@ActiveProfiles("test")
public class ReportsIntegrationTest {


	@Autowired
    private WebApplicationContext webApplicationContext;
	
		
	private MockMvc mockMvc;
	

	
	/**
	 * Create report test ok.
	 * 
	 */
	@Test
	public void createReportTest() throws Exception {

		
	    this.mockMvc.perform(get("/report/accounts/pdf")
	    		.contentType(MediaType.APPLICATION_JSON))
	    		.andExpect(status().isOk());
	      
	}
	
	
	    @Before
	    public void setUp() {
	        
	        this.mockMvc =  MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); 	 

	    }
	
}
