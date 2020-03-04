package com.tutorial.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class SimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleApplication.class, args);
	}


	@Bean
	public LocaleResolver localeResolver() {
		final var localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.NL);

		return localeResolver;
	}
}
