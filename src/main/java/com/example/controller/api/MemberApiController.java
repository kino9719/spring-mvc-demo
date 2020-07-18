package com.example.controller.api;

import com.example.exception.ValidateFailedException;
import com.example.form.LoginForm;
import com.example.model.Account;
import com.example.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class MemberApiController {
    @Autowired
    MemberService memberService;

    @PostMapping("/api/login")
    public ResponseEntity<String> login(@RequestBody LoginForm loginForm, HttpSession session) {
        try {
            Account account = memberService.validateLogin(loginForm.getUsername(), loginForm.getPassword());

            session.setAttribute("username", account.getUsername());
            session.setAttribute("isAdmin", account.isAdmin());
        } catch (ValidateFailedException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<String>("", HttpStatus.NO_CONTENT);
    }
}

