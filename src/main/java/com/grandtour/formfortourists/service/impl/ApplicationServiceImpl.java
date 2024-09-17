package com.grandtour.formfortourists.service.impl;

import com.grandtour.formfortourists.entity.ApplicationEntity;
import com.grandtour.formfortourists.repository.ApplicationRepository;
import com.grandtour.formfortourists.service.ApplicationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    final
    ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public void saveApplication(ApplicationEntity application) {
        applicationRepository.save(application);
    }

    @Override
    public List<ApplicationEntity> getAllRequest() {
        return applicationRepository.findAll();
    }
}
