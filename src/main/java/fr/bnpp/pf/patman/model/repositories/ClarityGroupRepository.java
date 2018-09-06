package fr.bnpp.pf.patman.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.bnpp.pf.patman.model.entities.ClarityGroup;

public interface ClarityGroupRepository extends JpaRepository<ClarityGroup, Long>{

    @Query(nativeQuery=true, value = "SELECT * FROM ASSIGNMENT_GROUP g WHERE g.IS_ACTIVE = 1")
    List<ClarityGroup> findAllActive();
    
    @Modifying
    @Query(nativeQuery=true, value = "UPDATE ASSIGNMENT_GROUP g SET g.IS_ACTIVE = :active WHERE g.ID = :id")
    Integer updateStatus(@Param("id")Long id, @Param("active") Boolean active );
}