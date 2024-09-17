package com.grandtour.formfortourists.service.impl;

import com.grandtour.formfortourists.entity.ApplicationEntity;
import com.grandtour.formfortourists.entity.UserEntity;
import com.grandtour.formfortourists.entity.enumeration.MailType;
import com.grandtour.formfortourists.service.MailService;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import freemarker.template.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
    private final Configuration configuration;
    private final JavaMailSender javaMailSender;

    @Override
    public void sendMail(UserEntity user, ApplicationEntity application, MailType type, Properties properties) {
        switch (type) {
            case REQUEST -> sendRequestEmail(user, application, properties);
            case REQUEST_INFO -> sendRequestInfoEmail(user, application, properties);
            default -> {}
        }
    }
    @SneakyThrows
    private void sendRequestInfoEmail(UserEntity user, ApplicationEntity application, Properties properties){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
        helper.setSubject("Ваша заявка отправлена!");
        helper.setTo(user.getEmail());
        String emailContent = getRequestInfoEmailContent(user,application);
        helper.setText(emailContent, true);
        javaMailSender.send(mimeMessage);
    }
    @SneakyThrows
    private void sendRequestEmail(UserEntity user, ApplicationEntity application, Properties properties){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
        helper.setSubject("Пришла заявка от  " + user.getLastName() + " " + user.getName());
        helper.setTo("razumov.aleksei101@yandex.ru");
//        helper.setTo("razumova.p@yandex.ru");
        String emailContent = getRequestEmailContent(user,application);
        helper.setText(emailContent, true);
        javaMailSender.send(mimeMessage);
    }

    @SneakyThrows
    private String getRequestEmailContent(UserEntity user, ApplicationEntity application){
        StringWriter stringWriter = new StringWriter();
        Map<String, Object> model = new HashMap<>();
        model.put("name", user.getName());
        model.put("lastName", user.getLastName());
        model.put("patronymic", user.getPatronymic());
        model.put("phoneNumber", user.getPhoneNumber());
        model.put("preferences", application.getPreferences());
        model.put("budget", application.getBudget());
        model.put("numberOfAdults", application.getNumberOfAdults());
        model.put("children", application.getAgeOfChildren());
        model.put("numberOfNights", application.getNumberOfNights());
        model.put("startDate", application.getStartDate());
        configuration.getTemplate("request-mail.html")
                .process(model,stringWriter);
        return stringWriter.getBuffer().toString();
    }

    @SneakyThrows
    private String getRequestInfoEmailContent(UserEntity user, ApplicationEntity application){
        StringWriter stringWriter = new StringWriter();
        Map<String, Object> model = new HashMap<>();
        model.put("name", user.getName());
        model.put("lastName", user.getLastName());
        model.put("patronymic", user.getPatronymic());
        model.put("phoneNumber", user.getPhoneNumber());
        model.put("preferences", application.getPreferences());
        model.put("budget", application.getBudget());
        model.put("numberOfAdults", application.getNumberOfAdults());
        model.put("children", application.getAgeOfChildren());
        model.put("numberOfNights", application.getNumberOfNights());
        model.put("startDate", application.getStartDate());
        configuration.getTemplate("request-info-mail.html")
                .process(model,stringWriter);
        return stringWriter.getBuffer().toString();
    }
}
