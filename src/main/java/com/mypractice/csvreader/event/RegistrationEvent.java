package com.mypractice.csvreader.event;

import java.util.List;

import org.springframework.context.ApplicationEvent;

import com.mypractice.csvreader.dto.MsisDto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegistrationEvent  extends ApplicationEvent {
	private static final long serialVersionUID = 6857242080304805007L;
	private List<MsisDto> msisDto;
	public RegistrationEvent(List<MsisDto> msisDto) {
		super(msisDto);
		this.msisDto = msisDto;
		// TODO Auto-generated constructor stub
	}
	
}
