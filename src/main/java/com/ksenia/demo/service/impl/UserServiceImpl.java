package com.ksenia.demo.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ksenia.demo.model.Role;
import com.ksenia.demo.model.User;
import com.ksenia.demo.repository.RoleRepository;
import com.ksenia.demo.repository.UserRepository;
import com.ksenia.demo.service.IUserService;

/**
 * Copyright (c) 2020 apollon GmbH+Co. KG All Rights Reserved.
 */

@Service
public class UserServiceImpl implements IUserService
{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User getUserById(Integer id)
	{
		return userRepository.getOne(id);
	}

	@Override
	public User findUserByName(String name)
	{
		return userRepository.findUserByName(name);
	}

	@Override
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}

	@Override
	public void addUser(User user)
	{
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Set<Role> roles = new HashSet<>();
		roles.add(roleRepository.getOne(2));
		user.setRoles(roles);
		userRepository.save(user);
	}

	@Override
	public User editUser(User user)
	{
		return userRepository.saveAndFlush(user);
	}

	@Override
	public void deleteUser(Integer id)
	{
		userRepository.deleteById(id);
	}
}
