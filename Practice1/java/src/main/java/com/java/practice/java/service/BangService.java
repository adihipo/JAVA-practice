package com.java.practice.java.service;

import com.java.practice.java.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BangService {

  List<Role> getAllCards();

}
