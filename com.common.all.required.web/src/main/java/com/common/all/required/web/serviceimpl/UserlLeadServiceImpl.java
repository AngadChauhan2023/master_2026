package com.common.all.required.web.serviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.all.required.web.entity.UserLead;
import com.common.all.required.web.global.exceptions.UserNotFoundException;
import com.common.all.required.web.repository.UserLeadRepository;
import com.common.all.required.web.service.UserLeadService;

@Service
public class UserlLeadServiceImpl implements UserLeadService {

	@Autowired
	private UserLeadRepository userLeadRepository;
	
	public UserLead createUserLead(UserLead userLead) {
		if (userLead.getFirstName() == null || userLead.getFirstName().isBlank() ||
		        userLead.getEmailAddress() == null || userLead.getEmailAddress().isBlank()) {
			throw new UserNotFoundException("! Unable to create lead !");

		}
		return userLead;
	}
}
