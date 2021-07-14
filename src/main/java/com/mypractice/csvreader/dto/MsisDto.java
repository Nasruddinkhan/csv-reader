package com.mypractice.csvreader.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.mypractice.csvreader.constant.Constant;
import com.mypractice.csvreader.constraint.GenderTypeSubset;
import com.mypractice.csvreader.constraint.SimTypeSubset;
import com.mypractice.csvreader.enums.GenderType;
import com.mypractice.csvreader.enums.SimType;
import com.mypractice.csvreader.util.CommonUtil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MsisDto {

	@NotBlank(message = Constant.NAME_EMPTY_VLD)
	@Pattern(message =Constant.COUNTRY_SPECIPIC_MSG , regexp = Constant.COUNTRY_SPECIPIC_PATTERN + Constant.START_DOLLAR)
	private String msisdn;

	@NotNull
	@SimTypeSubset(anyOf = { SimType.POSTPAID, SimType.PREPAID }, message = "must be any of {anyOf}")
	private SimType simType;

	
	@NotBlank(message = Constant.NAME_EMPTY_VLD)
	@Pattern(regexp =  Constant.ONLY_CHAR_PATTERN + Constant.START_DOLLAR, message = Constant.ONLY_CHAR_ALLOW)
	private String name;

	@NotBlank(message = Constant.NAME_EMPTY_VLD)
	private String dateOfBirth;
	
	@NotNull
	@GenderTypeSubset(anyOf = {GenderType.F, GenderType.M}, message ="gender must be any of {anyOf} instean of male or female" )
	private GenderType gender;

	@NotBlank(message = Constant.NAME_EMPTY_VLD)
	@Size(min = 10, max = 50, message = Constant.MIN_MAX_VALID)
	private String address;

	@NotBlank(message = Constant.NAME_EMPTY_VLD)
	private String idNumber;

}
