# reports
Generate pdf reports

Reports is a Spring boot application using RESTful, Spring MVC, JPA persistence and H2 on memory database.
The application allows to generate a pdf with the resume of bank accounts and customers 
The data model presents two entities: Account and Customer in which a Customer can have several Accounts.

The structure of the application contains a RestController to process the GET requests, a Service interface and its implementation 
for the business logic and a JPA Repository for the entity persistence.

Unitary tests wiht mock operations and assertions are provided as well as integration tests with H2 database configuration.
Swagger documentation is also included.

To run the application execute it as a spring boot application.

After starting the API documentation will be available in: http://localhost:8080/swagger-ui.html#

The GET request returns the path in which the pdf is generated in case of response OK.
Ej, for a GET request:
http://localhost:8080/report/accounts/pdf?page=0&size=5

The body response would be something like: 
{
    "filePath": "C:\\IDE\\workspace\\reports\\export\\pdf\\1573211497007.pdf"
}

The request allows pagination.

H2 database console will be available in: http://localhost:8080/h2-console


The code needs to be completed to add the rows to the table in the pdf report:

	/**
	 * @param table
	 * @param pageable
	 */
	private PdfPTable getPdfTable(Pageable pageable) {
			
		PdfPTable table = new PdfPTable(4);
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 6);
		this.addTableHeader(table);
		
		//TODO Add Rows

		
		return table;
		  
	}
