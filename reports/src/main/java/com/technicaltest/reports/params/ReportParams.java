package com.technicaltest.reports.params;


public enum ReportParams {

	
	/**
	 * ACCOUNT_IBAN
	 */
	ACCOUNT_IBAN ("IBAN"),
	
	/**
	 * ACCOUNT_BALANCE
	 */
	ACCOUNT_BALANCE ("Balance"),
	
	/**
	 * ACCOUNT_CUSTOMER_FIRST_NAME
	 */
	ACCOUNT_CUSTOMER_FIRST_NAME ("Customer First Name"),
	
	/**
	 * ACCOUNT_CUSTOMER_LAST_NAME
	 */
	ACCOUNT_CUSTOMER_LAST_NAME ("Customer Last Name"),
	
	
	
	/**
	 * EXPORT_PDF_PRODUCTS_FILE
	 */
	EXPORT_PDF_FILE_FOLDER ("export/pdf/"),
	
	
	/**
	 * EXPORT_PDF_EXT
	 */
	EXPORT_PDF_EXT(".pdf");
	


	
	private String value;
	
	private ReportParams(String value) {
		
		this.value = value;
	}
	
	
	public String getValue() {
		
		return this.value;
	}
}
