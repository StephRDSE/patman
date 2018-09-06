package fr.bnpp.pf.patman.model.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.bnpp.pf.patman.model.entities.ClarityRequest;

public interface ClarityRequestRepository extends JpaRepository<ClarityRequest, Long>{

    @Query(nativeQuery=true, value = "SELECT * FROM CLARITY_REQUEST r WHERE r.STATUS_UPDATE_DATE = null")
    List<ClarityRequest> findAllActive();
    
    @Modifying
    @Query(nativeQuery=true, value = "UPDATE CLARITY_REQUEST r SET r.STATUS_UPDATE_DATE = :newDate, "
            + "r.FK_ADMIN_ID = :adminId WHERE r.ID = :id")
    Integer updateRequest(@Param("id")Long id,@Param("adminId")Long adminId, @Param("newDate")Date newDate) ;
    
}