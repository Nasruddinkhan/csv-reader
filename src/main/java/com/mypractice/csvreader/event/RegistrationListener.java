package com.mypractice.csvreader.event;

import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.mypractice.csvreader.dto.MsisDto;

@Component
public class RegistrationListener implements ApplicationListener<RegistrationEvent> {

	@Override
	public void onApplicationEvent(RegistrationEvent event) {
		// TODO Auto-generated method stub
		this.confirmRegistration(event.getMsisDto());
	}

	private void confirmRegistration(List<MsisDto> event) {
		System.out.println("Different message for both genders if its rquired");
		event.forEach(e->{
			System.out.println("registration success full " + e);

		});
	}

}
