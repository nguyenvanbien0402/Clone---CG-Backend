package com.backend.controller;

import com.backend.constants.SysstemMessageCode;
import com.backend.entity.UserMaster;
import com.backend.request.UserAddRequest;
import com.backend.response.BaseResponse;
import com.backend.service.UserMasterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
@CrossOrigin

public class UserController {

    @Resource
    private UserMasterService userMasterService;
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public ResponseEntity<Object> addUser(@RequestBody UserAddRequest userMaster) throws Exception {
        BaseResponse<Object> baseResponse = userMasterService.addUser(userMaster);

        return  ResponseEntity.ok(baseResponse);
    }
}
