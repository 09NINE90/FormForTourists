package com.grandtour.formfortourists.service;

import com.grandtour.formfortourists.entity.ApplicationEntity;
import com.grandtour.formfortourists.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface ApplicationService {

   void saveApplication(ApplicationEntity application);

   List<ApplicationEntity> getAllRequest();

}
