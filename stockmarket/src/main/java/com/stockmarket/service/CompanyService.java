package com.stockmarket.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmarket.model.Company;
import com.stockmarket.repository.ICompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private ICompanyRepository companyRepository;

	public CompanyService() {

	}

	public List<Company> getAllCompany() {

		return companyRepository.findAll();
	}

	public Company getCompanyByCode(int companyCode) {
		return companyRepository.getOne(companyCode);
	}
	
	public void addCompany(Company company) {
	companyRepository.save(company);
	}
	
	public void updateCompany(Company company) {
		
		companyRepository.save(company);
	}
	

	public Company getCompanyByName(String companyName, String userId) {
		companyRepository.insertSearchRecord(userId, companyName);
		return companyRepository.findByCompanyName(companyName);
	}

	public List<Company> getCompanyByCompanyType(String companyType) {
		return companyRepository.findByCompanyType(companyType);
	}

	public List<Company> getCompanySortedByName() {
		return companyRepository.getCompanySortedByName();
	}
	
	public List<Company> getCompanySortedByNameWithCompanyType(Optional<String> companyType) {
		return companyRepository.getCompanySortedByNameWithCompanyType(companyType);
	}

	public List<Company> getCompanySortedByAvailability() {
		return companyRepository.getCompanySortedByAvailability();
	}
	
	public List<Company> getCompanySortedByAvailabilityWithCompanyType(Optional<String> companyType) {
		return companyRepository.getCompanySortedByAvailabilityWithCompanyType(companyType);
	}


	public List<Company> getCompanySortedByPrice() {
		return companyRepository.getCompanySortedByPrice();
	}
	
	public List<Company> getCompanySortedByPriceWithCompanyType(Optional<String> companyType) {
		return companyRepository.getCompanySortedByPriceWithCompanyType(companyType.get());
	}
	


	public List<Company> getNewCompany() {
		return companyRepository.getNewCompany();
	}

}
