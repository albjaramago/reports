package com.technicaltest.reports.service;

import java.io.File;

import org.springframework.data.domain.Pageable;

public interface ReportService {

	public File exportAccountsToPdf(Pageable pageable);

}
