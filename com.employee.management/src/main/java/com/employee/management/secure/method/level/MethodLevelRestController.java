package com.employee.management.secure.method.level;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employee.management.secure.method.service.UserService;

@RestController
public class MethodLevelRestController {
	
	private final UserService userService;

    public MethodLevelRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String userAccess() {
        return userService.getUserData();
    }

    @GetMapping("/admin")
    public String adminAccess() {
        return userService.getAdminData();
    }

}
