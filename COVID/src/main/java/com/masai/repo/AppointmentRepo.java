package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment,Integer> {

}
