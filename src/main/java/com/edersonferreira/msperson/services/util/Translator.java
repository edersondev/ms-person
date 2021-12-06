package com.edersonferreira.msperson.services.util;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class Translator {

	private final ResourceBundleMessageSource messageSource;
	
    public Translator(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String toLocale(String msgCode) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(msgCode, null, locale);
    }
    
    public String toLocale(String msgCode, Object[] args) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(msgCode, args, locale);
    }
}
