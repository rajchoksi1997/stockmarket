package com.stockmarket.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockmarket.model.Company;
import com.stockmarket.service.CompanyService;

@RestController
@RequestMapping(value="/companies")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@GetMapping()
	public ResponseEntity<List<Company>> getAllCompany() {
		return new ResponseEntity<>(companyService.getAllCompany(), HttpStatus.OK);
	}
//	@GetMapping(value = {"/sorted/name", "/sorted/name/{Sectors}"})
//	public List<Company> getCompanySortedByName(@PathVariable Optional<String> Sectors) {
//		if(Sectors.isPresent())
//		{
//		return companyService.getCompanySortedByNameWithCompanyType(Sectors);
//		}
//		else
//		{
//			return companyService.getCompanySortedByName();
//		}
//	}
//	
//	@GetMapping(value = {"/sorted/availability", "/sorted/availability/{companyType}"})
//	public List<Company> getCompanySortedByAvailability(@PathVariable Optional<String> companyType) {
//		
//		if(companyType.isPresent())
//		{
//			return companyService.getCompanySortedByAvailabilityWithCompanyType(companyType);		
//		}
//		else
//		{
//			return companyService.getCompanySortedByAvailability();		
//		}
//	}
//	
//	@GetMapping(value = {"/sorted/price","/sorted/price/{companyType}"})
//	public List<Company> getCompanySortedByPrice(@PathVariable Optional<String> companyType) {
//		
//		if(companyType.isPresent())
//		{
//			return companyService.getCompanySortedByPriceWithCompanyType(companyType);
//		}
//		else
//		{
//			return companyService.getCompanySortedByPrice();
//		}
//		
//	}
	
	
	@GetMapping("/{companyId}")
	public Company getCompanyByCode(@PathVariable("companyCode") int companyCode){
		return companyService.getCompanyByCode(companyCode);
	}
	
	@GetMapping("/newcompanys")
	public List<Company> getNewCompany(){
		return companyService.getNewCompany();
	}
	
	
	@GetMapping("/companyType/{companyType}")
	public List<Company> getCompanyByCompanyType(@PathVariable("companyType") String companyType) {
		return companyService.getCompanyByCompanyType(companyType);
	}
	
	@GetMapping("/{companyName}/{userId}")
	public Company getCompanyByName(@PathVariable("companyName") String companyCode,
			@PathVariable("userId") String userId ){
		return companyService.getCompanyByName(companyCode, userId);
	}
	
	@PostMapping()
	public void addCompany(@RequestBody Company company){
		System.out.println(company);
		companyService.addCompany(company);
	}
	
	@PutMapping()
	public void updateCompany(@RequestBody Company company) {
		System.out.println("Update company"+company);
		companyService.updateCompany(company);
	}
	
}