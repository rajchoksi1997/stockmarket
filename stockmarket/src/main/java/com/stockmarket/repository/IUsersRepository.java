package com.stockmarket.repository;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.stockmarket.model.Users;

@Repository
public interface IUsersRepository extends JpaRepository<Users, Long>{
	
	@Query(value="SELECT u.user_id, u.name, u.email_id, "
			+" u.contact_number, u.password, "
			+" u.confirmed FROM user u WHERE u.user_id=?;"
			, nativeQuery=true)
	public Users getByUserId(String userId);
	
	@Modifying
	@Transactional
	@Query(value="INSERT INTO user_role(ur_us_id,ur_ro_id) VALUES(?,?)",nativeQuery=true)
	public void addUserRole(String userId, int i);

	
	@Modifying
	@Transactional
	@Query(value="UPDATE user SET password=? WHERE user_id=?",nativeQuery=true)
	public void setNewPassword(String newPassword, String userId);

}

