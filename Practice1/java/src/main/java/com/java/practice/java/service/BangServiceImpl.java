package com.java.practice.java.service;

import com.java.practice.java.model.Role;
import com.java.practice.java.model.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BangServiceImpl implements BangService{

  private RoleRepository roleRepository;

  @Autowired
  public BangServiceImpl(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @Override
  public List<Role> getAllCards() {
    return roleRepository.findAll();
  }
}
