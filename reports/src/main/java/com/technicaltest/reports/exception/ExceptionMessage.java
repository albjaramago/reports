package com.technicaltest.reports.exception;

public enum ExceptionMessage {

	
	GENERATE_PDF_FILE_ERROR("Error generating pdf report.");
    
    private String value;
    
    

    private ExceptionMessage(String value) {
        
        this.value = value;
    }
    
    
    public String getValue() {
        
        return this.value;
    }

}
