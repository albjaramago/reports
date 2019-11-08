package com.technicaltest.reports.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.technicaltest.reports.exception.ExceptionMessage;
import com.technicaltest.reports.exception.ReportException;
import com.technicaltest.reports.model.Account;
import com.technicaltest.reports.params.ReportParams;
import com.technicaltest.reports.repository.AccountRepository;
import com.technicaltest.reports.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService{

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public File exportAccountsToPdf(Pageable pageable) {
		
		
		Document document = new Document();
		
		File file = this.getFile();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(file.getAbsolutePath()));
			document.open();			 
			PdfPTable table = this.getPdfTable(pageable);
			document.add(table);
			document.close();
		} catch (FileNotFoundException | DocumentException e) {
			throw new ReportException(ExceptionMessage.GENERATE_PDF_FILE_ERROR.getValue());
		}
		 
		return file;
	}
	
	
	/**
	 * @param table
	 * @param pageable
	 */
	private PdfPTable getPdfTable(Pageable pageable) {
			
		PdfPTable table = new PdfPTable(4);
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 6);
		this.addTableHeader(table);
		
		//TODO Add Rows

		
		return null;
		  
	}
	
	
	/**
	 * @param table
	 */
	private void addTableHeader(PdfPTable table) {
		
		
		Stream.of(ReportParams.ACCOUNT_IBAN.getValue(), ReportParams.ACCOUNT_BALANCE.getValue(), ReportParams.ACCOUNT_CUSTOMER_FIRST_NAME.getValue(),
				ReportParams.ACCOUNT_CUSTOMER_LAST_NAME.getValue())
				.forEach(columnTitle -> {
					PdfPCell header = new PdfPCell();
					header.setBackgroundColor(BaseColor.LIGHT_GRAY);
					header.setBorderWidth(2);
					header.setPhrase(new Phrase(columnTitle, FontFactory.getFont(FontFactory.HELVETICA, 7)));
					table.addCell(header);
				});
		
	}
	
	

	/**
	 * @return
	 */
	private File getFile() {
		
		return new File(ReportParams.EXPORT_PDF_FILE_FOLDER.getValue() + System.currentTimeMillis()
		+ ReportParams.EXPORT_PDF_EXT.getValue());
		
	}

}
