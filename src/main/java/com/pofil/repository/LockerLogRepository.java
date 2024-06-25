package com.pofil.repository;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pofil.model.LockerLog;

public interface LockerLogRepository extends MongoRepository<LockerLog, String> {
	Optional<LockerLog> findByLockerId(String lockerId);

	List<LockerLog> findByCheckedInTime(LocalTime checkedInTime);

	List<LockerLog> findByEnabled(boolean enabled);

	List<LockerLog> findByCheckednDateIsBetween(Date firstDate, Date secondDate);

	List<LockerLog> findByLockerStatus(String lockerStatus);

	List<LockerLog> findByLockerExistBranch(String lockerExistBranch);
	
	List<LockerLog> findByLockerStatusAndLockerExistBranch(String lockerStatus, String lockerExistBranch);
	
	List<LockerLog> findAllByOrderByCheckednDateDesc();
	
	List<LockerLog> findByAuthorizedPerson(String authorizedPerson);
	
	
}
