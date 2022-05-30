package com.example.taskitmed.component;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageService {
    private static MessageSource messageSource;

    public static String getMessage(String key) {
        try {
            return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
        } catch (Exception ex) {
            return key;
        }
    }

    private static String merge(String action, String sourceKey) {
        return String.format(getMessage(action), getMessage(sourceKey));
    }

    private static String merge(String action) {
        return String.format(getMessage(action));
    }

    public static String successEdit(String sourceKey) {
        return merge("SUCCESS_EDIT", sourceKey);
    }


    /*==================SUCCESS===================*/

    public static String successSave(String sourceKey) {
        return merge(sourceKey + " SUCCESS_SAVE");
    }

    public static String successDelete(String sourceKey) {
        return merge(sourceKey + "SUCCESS_DELETE");
    }

    public static String cannotDelete(String sourceKey) {
        return merge("CANNOT_DELETE");
    }


    /*===================ERROR===================*/

    public static String notFound(String sourceKey) {
        return merge(sourceKey + "NOT_FOUND");
    }

    public static String alreadyExists(String sourceKey) {
        return merge(sourceKey + "ALREADY_EXISTS");
    }

    public static String notNull(String sourceKey) {
        return merge(sourceKey + "NOT_NULL");
    }

    public static String serverError() {
        return merge("INTERNAL_SERVER_ERROR");
    }

    @Autowired
    public void setSomeThing(MessageSource messageSource) {
        MessageService.messageSource = messageSource;
    }

}
