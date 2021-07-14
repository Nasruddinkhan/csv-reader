package com.mypractice.csvreader.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.mypractice.csvreader.dto.MsisDto;
import com.mypractice.csvreader.enums.GenderType;
import com.mypractice.csvreader.enums.SimType;

public class FileServiceUtil {

	public static List<MsisDto> csvToMsisDto(InputStream is) {
		List<MsisDto> dtos = null;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(br,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {
			dtos = csvParser.getRecords().parallelStream().map(FileServiceUtil::getMsisDto)
					.collect(Collectors.toList());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dtos;
	}

	public static MsisDto getMsisDto(CSVRecord csvRecord) {
		return MsisDto.builder().address(csvRecord.get("ADDRESS")).dateOfBirth(csvRecord.get("DATE_OF_BIRTH"))
				.gender(getGender(csvRecord.get("GENDER"))).idNumber(csvRecord.get("ID_NUMBER"))
				.msisdn(csvRecord.get("MSISDN")).name(csvRecord.get("NAME"))
				.simType(getEnumType(csvRecord.get("SIM_TYPE"))).build();
	}

	private static SimType getEnumType(String value) {
		// TODO Auto-generated method stub
		if (Objects.isNull(value))
			return null;
		else {
			return value.equals(SimType.POSTPAID.toString()) ? SimType.POSTPAID
					: value.equals(SimType.PREPAID.toString()) ? SimType.PREPAID : null;
		}

	}

	private static GenderType getGender(String value) {
		// TODO Auto-generated method stub
		if (Objects.isNull(value))
			return null;
		else {
			return value.equals(GenderType.F.toString()) ? GenderType.F
					: value.equals(GenderType.M.toString()) ? GenderType.M : null;
		}

	}

	public static MsisDto writeOnText(MsisDto dto) {
		System.out.println("FileServiceUtil.writeOnText()");
		Path path = Paths.get("src/main/resources/" + dto.getMsisdn() + ".txt");
		try {
			Files.createFile(path);
			BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()));
			writer.write(CommonUtil.convertObjectToString(dto));
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("FileServiceUtil.writeOnText() sucess");
		return dto;
	}
}
