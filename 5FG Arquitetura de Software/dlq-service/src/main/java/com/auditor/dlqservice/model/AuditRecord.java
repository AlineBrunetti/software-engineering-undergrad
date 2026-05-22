package com.auditor.dlqservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_records")
public class AuditRecord {

    @Id
    private String errorId;
    private String queueName;
    
    @Column(columnDefinition = "TEXT")
    private String payload;
    
    private LocalDateTime timestamp;
    private String status;
    private String severity;

    public AuditRecord() {}

    public AuditRecord(String errorId, String queueName, String payload, LocalDateTime timestamp, String status, String severity) {
        this.errorId = errorId;
        this.queueName = queueName;
        this.payload = payload;
        this.timestamp = timestamp;
        this.status = status;
        this.severity = severity;
    }

}