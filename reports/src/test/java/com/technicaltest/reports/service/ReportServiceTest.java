package com.technicaltest.reports.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.technicaltest.reports.model.Account;
import com.technicaltest.reports.model.Customer;
import com.technicaltest.reports.repository.AccountRepository;
import com.technicaltest.reports.service.impl.ReportServiceImpl;



@RunWith(SpringRunner.class)
@SpringBootTest(classes= {ReportServiceImpl.class})
public class ReportServiceTest {
    

    @MockBean
    private AccountRepository accountRepository;
    
    @Autowired
    ReportService reportService;
    

    private Page<Account> accountPage;
    
    
    /**
     * Generate report test ok
     */
    @Test
    public void reportServiceTestOK() {
    	
    	given(accountRepository.findAll(Mockito.any(Pageable.class))).willReturn(accountPage);
        
        File file = reportService.exportAccountsToPdf(PageRequest.of(0, 5));
                
        assertThat(file).isNotNull();
    
        
    }
    
    

    @Before
    public void setAccounts() {
        
    
    	Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("Niamh");
        customer.setLastName("Murphy");
        

        Account account = new Account();
        account.setId(1);
        account.setIban("IE29 AIBK 9311 5212 3456 78");
        account.setBalance(new Integer(2000));
        account.setCustomer(customer);
        
        List<Account> accountList = new ArrayList<Account>();
        accountList.add(account);
        
        accountPage = new PageImpl<>(accountList);
        
        
       
    }
    

}
