package org.example.school.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.school.dao.StudentEntity;
import org.example.school.dao.UserDetailsEntity;
import org.example.school.dto.ApiResponse;
import org.example.school.dto.StudentDto;
import org.example.school.dto.UserDetailsDto;
import org.example.school.dto.UserRequest;
import org.example.school.dto.UserToken;
import org.example.school.security.JwtUtil;
import org.example.school.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
public class UserController {
    private final UserService userService;
    private final org.example.school.services.UserDetailsService userDetails;
    @Autowired
    private JwtUtil jwtUtil;


    private final AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;

    public UserController(UserService userService, org.example.school.services.UserDetailsService userDetails, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.userDetails = userDetails;
        this.authenticationManager = authenticationManager;

    }
    @RequestMapping(value = "/api/v1/auth/users", method = RequestMethod.GET)
    @ResponseBody
    public List<UserDetailsDto> getUsers(){

        return userDetails.getUserDetails();
    }

    @RequestMapping(value = "/api/v1/auth/userDetails/save", method = RequestMethod.POST)
    @ResponseBody
    public UserDetailsEntity saveUserDetails(@RequestBody UserDetailsDto userDto) {


        return userDetails.addUserDetails(userDto);

    }

    @RequestMapping(value = "/api/v1/auth/userDetails/update", method = RequestMethod.POST)
    @ResponseBody
    public UserDetailsEntity UpdateUserDetails(@RequestBody UserDetailsDto userDto) {


        return userDetails.updateUserDetails(userDto);

    }


    @RequestMapping(value = "/api/v1/auth/userDetails/remove", method = RequestMethod.DELETE)
    @ResponseBody
    public void RemoveUserDetails(@RequestBody UserDetailsDto userDto) {
         userDetails.removeUserDetails(userDto);

    }



    // handler method to handle user registration form submit request
    @RequestMapping(value = "/api/v1/auth/register/save", method = RequestMethod.POST)
    @ResponseBody
    public StudentEntity registration(@RequestBody StudentDto userDto) {


        return userService.saveUser(userDto);

    }


    @RequestMapping(value = "/api/v1/auth/token", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse<UserToken> getToken(@RequestBody
                                                   UserRequest user) {

        log.info("the token will be generated for user {}", user.getUsername());
        try {
            authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    user.getUsername(), user.getPassword())
                    );
        } catch (Exception e) {
            throw new NullPointerException("invalid username or password");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        String token = jwtUtil.generateToken(userDetails);

        if (token != null) {
            log.info("token is {}", token);
            return new ApiResponse<>(200, "success", new UserToken(token, user.getUsername()));
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/api/v1/auth/logout")
    @ResponseStatus(value = HttpStatus.OK)
    public String logout(HttpServletRequest request, HttpServletResponse response) {


        boolean isSecure = false;
        String contextPath = null;
        if (request != null) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            isSecure = request.isSecure();
            contextPath = request.getContextPath();
        }
        SecurityContext context = SecurityContextHolder.getContext();
        SecurityContextHolder.clearContext();
        context.setAuthentication(null);
        if (response != null) {
            Cookie cookie = new Cookie("JSESSIONID", null);
            String cookiePath = StringUtils.hasText(contextPath) ? contextPath : "/";
            cookie.setPath(cookiePath);
            cookie.setMaxAge(0);
            cookie.setSecure(isSecure);
            response.addCookie(cookie);
        }
        return "";
    }



}
