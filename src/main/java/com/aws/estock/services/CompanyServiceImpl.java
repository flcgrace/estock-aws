package com.aws.estock.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.http.util.ExceptionUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws.estock.entities.Company;
import com.aws.estock.exception.CompanyNotFoundException;
import com.aws.estock.repository.CompanyDao;


@Service
public class CompanyServiceImpl implements CompanyServices {
	@Autowired
	private CompanyDao companyDao;

	@Override
	public List<Company> fetchAllCompanies() {
		List<Company> companyList= companyDao.getAllCompany();
		return companyList;
	}
	@Override
	public Map<String,String> fetchAllCompanyNames() {
		List<Company> companyList= companyDao.getAllCompany();
		Map<String,String> nameMap=new HashMap<>();
		//Iterator<Item> namesIterator= companyList.iterator();
		for(Company comp:companyList) {
			nameMap.put(comp.getCompanyname(), comp.getCompanyCode());
		}
    // Traversing elements
//    while (namesIterator.hasNext()) {
//       String compname=namesIterator.next().get("companyname").toString();
//       String compcode=namesIterator.next().get("companyCode").toString();
//       System.out.println(compname);
//       nameMap.put(compname,compcode);
//    }
		return nameMap;
	}

	@Override
	public Company findCompanyByCompanyCode(String companyCode) {
		
			
			if(Optional.ofNullable(companyDao.getCompanyByCompanyCode(companyCode)).isEmpty()) {
				throw new CompanyNotFoundException("No Companies Found!!");
			}else {
		return companyDao.getCompanyByCompanyCode(companyCode);	
			}	
	}

	@Override
	public Company saveCompany(Company company) {
		return companyDao.saveCompany(company);
		
	}

	@Override
	public void deleteCompany(String companyCode) {
		String deletedcomp=companyDao.deleteCompanyByCompanyCode(companyCode);
	}

}
