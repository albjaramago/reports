package com.technicaltest.reports.rest;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technicaltest.reports.dto.ExportFileDto;
import com.technicaltest.reports.service.ReportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/report")
@Api(tags = {"Operations with reports"})
public class ReportRest {
	
	@Autowired
	ReportService reportService;


	@GetMapping(path = "/accounts/pdf", produces = "application/json")
	@ApiOperation(value = "Accounts Pdf report", notes = "Generate the report of accounts in pdf format")
	@ApiResponses({ @ApiResponse(code = 200, message = "Report succesfully generated")})
	public ResponseEntity<ExportFileDto> exportAccountsToPdf(Pageable pageable){
		
	File file = reportService.exportAccountsToPdf(pageable);
	
	return new ResponseEntity(new ExportFileDto(file.getAbsolutePath()), HttpStatus.OK);
	
	}

}
