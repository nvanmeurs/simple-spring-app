package com.tutorial.simple.greeting;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/greeting")
@RequiredArgsConstructor
public class GreetingResource {
    private final MessageSource messageSource;

    @GetMapping("/{firstName}")
    public String getGreeting(@PathVariable String firstName) {
        return messageSource.getMessage("greeting", new Object[] {firstName}, LocaleContextHolder.getLocale());
    }
}
