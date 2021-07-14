package com.mypractice.csvreader.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.mypractice.csvreader.dto.MsisDto;

public interface MSISService {
	 List<MsisDto> uploadFile(MultipartFile file) throws IOException;
}
