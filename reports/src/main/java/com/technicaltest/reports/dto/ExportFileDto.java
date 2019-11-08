package com.technicaltest.reports.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "filePath" })
public class ExportFileDto {

	@JsonProperty("filePath")
	private String filePath;


	@JsonProperty("filePath")
	public String getFilePath() {
		return filePath;
	}

	@JsonProperty("filePath")
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public ExportFileDto(String filePath) {
		super();
		this.filePath = filePath;
	}



}