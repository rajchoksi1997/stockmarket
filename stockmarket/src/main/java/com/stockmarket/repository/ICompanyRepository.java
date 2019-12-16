package com.stockmarket.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stockmarket.model.Company;

@Repository
public interface ICompanyRepository extends JpaRepository<Company, Integer> {

	public Company findByCompanyCode(long companyCode);
	
	public Company findByCompanyName(String companyName);
	
	@Transactional
	@Modifying
	@Query(value="INSERT INTO search (search_date, user_id, company_name) VALUES "
			+ "(CURDATE(),?,?);", nativeQuery=true)
	public void insertSearchRecord(String userId, String companyName);

	
	@Query(value="SELECT p.company_code, p.company_name, p.company_type, brand, "
			+ "p.rate_per_quantity, p.stock_count, p.add_date, p.aisle, p.shelf, "
			+ "p.date_of_manf, p.date_of_exp, p.company_img FROM company p "
			+ "WHERE p.company_type=?", nativeQuery=true)
	public List<Company> findByCompanyType(String companyType);

	
	@Query(value="SELECT p.company_code, p.company_name, p.company_type, brand, "
			+ "p.rate_per_quantity, p.stock_count, p.add_date, p.aisle, p.shelf, "
			+ "p.date_of_manf, p.date_of_exp, p.company_img FROM company p ORDER BY p.company_name", nativeQuery=true)
	public List<Company> getCompanySortedByName();
	
	@Query(value="SELECT p.company_code, p.company_name, p.company_type, brand, "
			+ "p.rate_per_quantity, p.stock_count, p.add_date, p.aisle, p.shelf, "
			+ "p.date_of_manf, p.date_of_exp, p.company_img FROM company p WHERE p.company_type=? ORDER BY p.company_name", nativeQuery=true)
	public List<Company> getCompanySortedByNameWithCompanyType(Optional<String> companyType);

	
	@Query(value="SELECT p.company_code, p.company_name, p.company_type, brand, "
			+ "p.rate_per_quantity, p.stock_count, p.add_date, p.aisle, p.shelf, "
			+ "p.date_of_manf, p.date_of_exp, p.company_img FROM company p ORDER BY p.stock_count DESC", nativeQuery=true)
	public List<Company> getCompanySortedByAvailability();
	
	@Query(value="SELECT p.company_code, p.company_name, p.company_type, brand, "
			+ "p.rate_per_quantity, p.stock_count, p.add_date, p.aisle, p.shelf, "
			+ "p.date_of_manf, p.date_of_exp, p.company_img FROM company p WHERE p.company_type=? ORDER BY p.stock_count DESC", nativeQuery=true)
	public List<Company> getCompanySortedByAvailabilityWithCompanyType(Optional<String> companyType);

	
	@Query(value="SELECT p.company_code, p.company_name, p.company_type, brand, "
			+ "p.rate_per_quantity, p.stock_count, p.add_date, p.aisle, p.shelf, "
			+ "p.date_of_manf, p.date_of_exp, p.company_img FROM company p ORDER BY p.rate_per_quantity", nativeQuery=true)
	public List<Company> getCompanySortedByPrice();

	@Query(value="SELECT p.company_code, p.company_name, p.company_type, brand, "
			+ "p.rate_per_quantity, p.stock_count, p.add_date, p.aisle, p.shelf, "
			+ "p.date_of_manf, p.date_of_exp, p.company_img FROM company p WHERE p.company_type=? ORDER BY p.rate_per_quantity", nativeQuery=true)
	public List<Company> getCompanySortedByPriceWithCompanyType(String companyType);

	
	@Query(value="(SELECT company_code FROM purchase GROUP BY company_code ORDER BY COUNT(purchase_id) DESC) ", nativeQuery=true)
	public String[] getCompanySortedByPopularity();

	@Query(value="(SELECT company_code FROM purchase WHERE company_code IN (SELECT company_code FROM company WHERE company_type =?) GROUP BY company_code ORDER BY COUNT(purchase_id) DESC) ", nativeQuery=true)
	public String[] getCompanySortedByPopularityWithCompanyType(Optional<String> companyType);

	@Query(value="SELECT p.company_code, p.company_name, p.company_type, brand, "
			+ "p.rate_per_quantity, p.stock_count, p.add_date, p.aisle, p.shelf, "
			+ "p.date_of_manf, p.date_of_exp, p.company_img FROM company p WHERE (CURDATE() - p.add_date) < 8",nativeQuery=true)
	public List<Company> getNewCompany();

	@Transactional
	@Modifying
	public void deleteByCompanyCode(String companyCode);


}
