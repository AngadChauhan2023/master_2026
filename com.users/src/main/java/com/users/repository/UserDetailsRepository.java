package com.users.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.users.entity.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
	
	/* here we can define our custom finder and query */
	
	public Optional<UserDetails> findByFirstName(String firstName);
	
	 // Using JPQL
    //@Query("SELECT u FROM UserDetails u WHERE u.firstName = :firstName")
   // Optional<UserDetails> findByFirstNameJPQL(@Param("firstName") String firstName);

    // Using Native SQL
    @Query(value = "SELECT * FROM user_details WHERE last_name = :lastName", nativeQuery = true)
    List<UserDetails> findByLastName(@Param("lastName") String lastName);


}
