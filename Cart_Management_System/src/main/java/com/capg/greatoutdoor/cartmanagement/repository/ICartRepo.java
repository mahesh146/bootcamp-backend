package com.capg.greatoutdoor.cartmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.greatoutdoor.cartmanagement.model.CartDTO;

public interface ICartRepo extends JpaRepository<CartDTO, String> {

}
