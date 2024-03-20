package com.jwtsample.resttemplate.controller;

import com.jwtsample.resttemplate.service.FbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FbController {
    private final FbService fbService;

}
