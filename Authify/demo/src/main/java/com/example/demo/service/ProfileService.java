package com.example.demo.service;

import com.example.demo.io.ProfileRequest;
import com.example.demo.io.ProfileResponse;

public interface ProfileService {
    public ProfileResponse createProfile(ProfileRequest request);
}
