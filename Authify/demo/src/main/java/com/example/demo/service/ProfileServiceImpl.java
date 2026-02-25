package com.example.demo.service;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.UserEntity;
import com.example.demo.io.ProfileRequest;
import com.example.demo.io.ProfileResponse;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService{
    private final UserRepository userRepository;

    // public ProfileServiceImpl(UserRepository userRepository){
    //     this.userRepository = userRepository;
    // }
    @Override
    public ProfileResponse createProfile(ProfileRequest request){
        if(!userRepository.existsByEmail(request.getEmail())){
            UserEntity newProfile = convertToUserEntity(request);
            newProfile = userRepository.save(newProfile);
            return convertToProfileResponse(newProfile);
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT, "Email Already Exists");
    }

    private UserEntity convertToUserEntity(ProfileRequest request){
        UserEntity user = new UserEntity();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setUserId(UUID.randomUUID().toString());
        user.setIsAccountVerified(false);
        user.setResetOtpExpiredAt(0L);
        user.setVerifyOtp(null);
        user.setVerifyOtpExpiredAt(0L);
        user.setResetOtp(null);
        return user;
    }

    private ProfileResponse convertToProfileResponse(UserEntity newProfile){
        ProfileResponse user = new ProfileResponse();
        user.setName(newProfile.getName());
        user.setEmail(newProfile.getEmail());
        user.setUserId(newProfile.getUserId());
        user.setIsAccountVerified(newProfile.getIsAccountVerified());
        return user;
    }
}
