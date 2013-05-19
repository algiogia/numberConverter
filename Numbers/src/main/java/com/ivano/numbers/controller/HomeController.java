package com.ivano.numbers.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ivano.numbers.model.ConverterForm;
import com.ivano.numbers.model.HomeForm;
import com.ivano.numbers.service.Dictionary;
import com.ivano.numbers.service.GBDictionary;
import com.ivano.numbers.service.ITDictionary;
import com.ivano.numbers.service.NumberConverter;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	private NumberConverter numberConverter;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) {

		Map<String, String> dictionaries = new HashMap<String, String>();
		dictionaries.put(GBDictionary.getCode(), GBDictionary.getDescription());
		dictionaries.put(ITDictionary.getCode(), ITDictionary.getDescription());

		model.addAttribute("number", new HomeForm());
		model.addAttribute("dictionaries", dictionaries);

		return "home";
	}

	@RequestMapping(value = "/convert")
	public String convert(HomeForm homeForm, ConverterForm converterForm,
			Model model) {

		if (homeForm.getDictionary() != null) {
			numberConverter = new NumberConverter(
					getDictionary(homeForm.getDictionary()));
		}

		String numberToConvert = converterForm.getNumber();
		if (numberToConvert != null) {

			int numberToConvertValue;
			try {
				numberToConvertValue = Integer.parseInt(numberToConvert);
				model.addAttribute("result",
						numberConverter.convert(numberToConvertValue));
				model.addAttribute("request", numberToConvert);

			} catch (NumberFormatException nfe) {
				logger.error("Unable to convert " + numberToConvert);
				nfe.printStackTrace();
				model.addAttribute("error", numberConverter
						+ " is not a valid integer.");

			} catch (Exception e) {

				logger.error("Unable to convert " + numberToConvert);
				e.printStackTrace();
				model.addAttribute("error", e.getMessage());
			}
		}

		model.addAttribute("converter", new ConverterForm());

		return "converter";
	}

	private Dictionary getDictionary(String dictionary) {
		if (ITDictionary.getCode().equals(dictionary))
			return new ITDictionary();
		if (GBDictionary.getCode().equals(dictionary))
			return new GBDictionary();

		return null;
	}
}
