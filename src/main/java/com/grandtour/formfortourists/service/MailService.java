package com.grandtour.formfortourists.service;

import com.grandtour.formfortourists.entity.ApplicationEntity;
import com.grandtour.formfortourists.entity.UserEntity;
import com.grandtour.formfortourists.entity.enumeration.MailType;

import java.util.Properties;

public interface MailService {
    void sendMail(UserEntity user, ApplicationEntity application, MailType type, Properties properties);
}
