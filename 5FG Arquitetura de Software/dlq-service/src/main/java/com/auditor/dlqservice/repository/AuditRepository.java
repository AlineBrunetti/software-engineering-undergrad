package com.auditor.dlqservice.repository;

import com.auditor.dlqservice.model.AuditRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends JpaRepository<AuditRecord, String> {
}