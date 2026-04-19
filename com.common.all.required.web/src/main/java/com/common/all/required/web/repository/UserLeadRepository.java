package com.common.all.required.web.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.common.all.required.web.entity.UserLead;
@Repository
public interface UserLeadRepository extends JpaRepository<UserLead, Long>{

}
