package com.mypractice.csvreader.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.mypractice.csvreader.dto.ErrorDto;
import com.mypractice.csvreader.dto.MsisDto;
import com.mypractice.csvreader.entity.Msis;
import com.mypractice.csvreader.repo.MsisRepository;
import com.mypractice.csvreader.service.MSISService;
import com.mypractice.csvreader.util.CommonUtil;
import com.mypractice.csvreader.util.FileServiceUtil;
import com.mypractice.csvreader.util.ObjectUtilMapper;
import com.mypractice.csvreader.validator.MSISValidator;

@Transactional
@Service
public class MSISServiceImpl implements MSISService {
	private final MSISValidator msisValidator;
	private final MsisRepository missRepo;

	@Autowired
	public MSISServiceImpl(MSISValidator msisValidator, MsisRepository missRepo) {
		super();
		this.msisValidator = msisValidator;
		this.missRepo = missRepo;
	}

	@Override
	public List<MsisDto> uploadFile(MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		List<MsisDto> dtos = FileServiceUtil.csvToMsisDto(file.getInputStream());
		System.out.println(dtos);
		List<MsisDto> msisDtos = dtos.stream().filter(this::printErrorOnConsole).map(FileServiceUtil::writeOnText)
				// one more transfor is required to find the dublicate
				.collect(Collectors.toList());
		return ObjectUtilMapper.mapAll( missRepo.saveAll(ObjectUtilMapper.mapAll(msisDtos, Msis.class)), MsisDto.class);
	}

	private boolean printErrorOnConsole(MsisDto dtos) {
		boolean isError = false;
		List<ErrorDto> errorDtos = msisValidator.validateMsisObject(dtos, MsisDto.class);
		if (Objects.nonNull(errorDtos) && errorDtos.size() > 0) {
			System.err.println(CommonUtil.convertObjectToList(errorDtos));
			isError = true;
		}
		return !isError;
	}
}
