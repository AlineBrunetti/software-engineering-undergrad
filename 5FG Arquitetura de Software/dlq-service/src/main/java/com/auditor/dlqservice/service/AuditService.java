package com.auditor.dlqservice.service;

import com.auditor.dlqservice.dto.OrderMessageDto;
import com.auditor.dlqservice.model.AuditRecord;
import com.auditor.dlqservice.repository.AuditRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AuditService {

    private final AuditRepository repository;
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    public AuditService(AuditRepository repository) {
        this.repository = repository;
    }

    public void processFailedMessage(String rawPayload, String queueName) {
        try {
            OrderMessageDto message = objectMapper.readValue(rawPayload, OrderMessageDto.class);

            String severity = calculateSeverity(message);

            AuditRecord record = new AuditRecord(
                    UUID.randomUUID().toString(),
                    queueName,
                    rawPayload,
                    LocalDateTime.now(),
                    "PENDING_ANALYSIS",
                    severity
            );

            // 4. Salva no banco
            repository.save(record);
            System.out.println("Mensagem salva com severidade: " + severity);

        } catch (Exception e) {
            System.err.println("Erro ao processar mensagem da DLQ: " + e.getMessage());
            throw new RuntimeException("Falha na auditoria, a mensagem voltará para a fila.");
        }
    }

    private String calculateSeverity(OrderMessageDto message) {
        if (message.orderItems == null || message.orderItems.isEmpty()) {
            return "LOW";
        }

        int totalAmount = message.orderItems.stream()
                .mapToInt(item -> item.amount != null ? item.amount : 0)
                .sum();

        if (totalAmount > 100) return "HIGH";
        if (totalAmount >= 50) return "MEDIUM";
        return "LOW";
    }
}