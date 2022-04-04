package com.aws.estock.services;

import java.util.List;
import java.util.Map;

import com.aws.estock.entities.Company;


public interface CompanyServices {

	public List<Company> fetchAllCompanies();
	public Map<String,String> fetchAllCompanyNames();
	public Company findCompanyByCompanyCode(String companyCode);
	public Company saveCompany(Company company);
	public void deleteCompany(String companyCode);
}
