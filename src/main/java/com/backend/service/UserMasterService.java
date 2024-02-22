package com.backend.service;


import com.backend.constants.Constants;
import com.backend.constants.SysstemMessageCode;
import com.backend.entity.UserMaster;
import com.backend.entity.authentication.LastLoginToken;
import com.backend.enums.ColumnNameEnums;
import com.backend.helper.ValidateError;
import com.backend.helper.ValidatorUltil;
import com.backend.repository.UserMasterRepository;
import com.backend.request.UserAddRequest;
import com.backend.response.BaseResponse;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserMasterService extends BaseService{

    @Resource
    private UserMasterRepository userMasterRepository;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private ValidatorUltil validatorUltil;
    public UserMaster loadUserByUserName(String userName) throws Exception {
        if (userName == null) {
            throw new Exception("UserName is null");
        }
        UserMaster user = userMasterRepository.findByUsernameAndActive(userName, Constants.ACTIVE);
        if (ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException("User not found with name : " + userName);
        }
        return user;
    }

    public BaseResponse<Object> addUser(UserAddRequest userMaster) {

        BindingResult bindingResult = validatorUltil.validateAndDetectError(userMaster);
        List<ValidateError> validateErrorList = buildMessageErrorValidate(bindingResult);
        UserMaster userMaster1 = userMasterRepository.findByUsername(userMaster.getUserName());
        if(!ObjectUtils.isEmpty(userMaster1)) {
            ValidateError validateError = ValidateError.builder().errorCode(ColumnNameEnums.USER_NAME.getText()
                            .concat(Constants.GA)
                            .concat(Constants.NAME_SCREEN_USER)
                            .concat(getMessage(SysstemMessageCode.VALID_UPLOAD_EXISTED_IN)))
                    .fieldName("userName").build();
            validateErrorList.add(validateError);
        }

        if (StringUtils.isNotEmpty(userMaster.getPassword()) && !userMaster.getPassword().equals(userMaster.getConfirmPassword())) {
            ValidateError validateError =
                    ValidateError.builder().errorCode(getMessage(SysstemMessageCode.REPEAT_PASSWORD_INCORRECT))
                            .fieldName("confirmPassword")
                            .build();
            validateErrorList.add(validateError);
        }
        if (!CollectionUtils.isEmpty(validateErrorList)) {
            return BaseResponse.builder().code(SysstemMessageCode.ES201_NOT_SUCCESS)
                    .message( getMessage(SysstemMessageCode.ES400_INPUT_ERROR))
                    .data(validateErrorList).build();
        }
        UserMaster userMaster2 = new UserMaster();
        userMaster.setUserName(StringUtils.isNotEmpty(userMaster.getUserName()) ? userMaster.getUserName() : null);
        userMaster.setFullName(StringUtils.isNotEmpty(userMaster.getFullName()) ? userMaster.getFullName() : null);
        userMaster.setPassword(passwordEncoder.encode(userMaster.getPassword()));
        userMaster.setRole(userMaster.getRole());
        UserMaster userMaster5 = userMasterRepository.save(userMaster2);
        return BaseResponse.builder().code(SysstemMessageCode.ES200_SUCCESS)
                .message(getMessage(SysstemMessageCode.ES200_SUCCESS)).data(userMaster5).build();
    }
}
