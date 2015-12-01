package com.mypackage.myapp.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mypackage.myapp.domain.Address;
import com.mypackage.myapp.service.AddressService;
import com.mypackage.myapp.validators.AddressValidator;

@Controller
@SessionAttributes
public class AddressController {

	@Autowired
	AddressService addressService;

	AddressValidator addressValidator = new AddressValidator();

	
	@RequestMapping("/addresses")
	public String listAddresses(Map<String, Object> map, HttpServletRequest request) {

		int addressId = ServletRequestUtils.getIntParameter(request, "addressId", -1);

		if (addressId > 0)
			map.put("address", addressService.getAddress(addressId));
		else
			map.put("address", new Address());

		map.put("addressList", addressService.listAddress());

		return "address";

	}

	@RequestMapping(value = "/addAddress", method = {RequestMethod.POST,RequestMethod.GET})

	public String addAddress(@ModelAttribute("address") Address address, BindingResult result,HttpServletRequest request, Map<String,Object> map) {// przyjmujemy
		// uzytkownika

		addressValidator.validate(address, result);
		
		if(result.getErrorCount() == 0)
		{
			if (address.getId() == 0)
				addressService.addAddress(address);
			else
				addressService.editAddress(address);

			System.out.println("Country: " + address.getCountry() + " State: " + address.getState() + " City "
					+ address.getCity() + " Street: " + address.getStreet());

			return "redirect:addresses.html";
		}
		map.put("addressList", addressService.listAddress());
		return "address";

	}

	@RequestMapping("/delete_address/{addressId}")
	public String deleteUAddress(@PathVariable("addressId") Integer addressId) {
		addressService.removeAddress(addressId);

		return "redirect:/addresses.html";
	}

	// @RequestMapping("/addresses") // wywolany kontroler
	// public ModelAndView showContacts(Locale locale, Model model) {
	// model.addAttribute("serverTime", HomeController.getDate(locale));
	// return new ModelAndView("address", "command", new Address());
	// }
}
