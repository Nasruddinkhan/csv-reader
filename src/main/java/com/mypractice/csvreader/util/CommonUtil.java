package com.mypractice.csvreader.util;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mypractice.csvreader.dto.ErrorDto;
import com.mypractice.csvreader.dto.MsisDto;

public interface CommonUtil {
	 static final ObjectMapper mapper = new ObjectMapper();
	 public static String convertObjectToList(List<ErrorDto> errorDtos) {
		 String errorJson = null;
		 try {
			 errorJson = mapper.writeValueAsString(errorDtos);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return errorJson;
	 }
	 
	 public static String convertObjectToString(MsisDto mst) {
		 String errorJson = null;
		 try {
			 errorJson = mapper.writeValueAsString(mst);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return errorJson;
	 }
}
