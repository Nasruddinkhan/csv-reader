package com.mypractice.csvreader.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mypractice.csvreader.dto.MsisDto;
import com.mypractice.csvreader.event.RegistrationEvent;
import com.mypractice.csvreader.service.MSISService;

/**
 * 
 * @author Nasruddin khan In this class just define the entry point
 */
@RestController
@RequestMapping("/api")
public class MSISController {

	private final ApplicationEventPublisher eventPublisher;
	private final MSISService msisService;

	@Autowired
	public MSISController(MSISService msisService, ApplicationEventPublisher eventPublisher) {
		super();
		this.msisService = msisService;
		this.eventPublisher = eventPublisher;
	}

	/**
	 * @param file
	 * @return
	 */
	@PostMapping("/upload-csv")
	public ResponseEntity<List<MsisDto>> uploadMSISFile(@RequestParam("file") MultipartFile file) throws IOException {
		List<MsisDto> dtos = msisService.uploadFile(file);
		eventPublisher.publishEvent(new RegistrationEvent(dtos) );
		return ResponseEntity.status(HttpStatus.OK).body(dtos);
	}
}
