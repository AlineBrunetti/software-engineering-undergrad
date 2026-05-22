package com.auditor.dlqservice.consumer;

import com.auditor.dlqservice.service.AuditService;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class DlqConsumer {

    private final AuditService auditService;

    public DlqConsumer(AuditService auditService) {
        this.auditService = auditService;
    }

    @SqsListener("processamento-pedidos-dlq") 
    public void receiveMessage(String message) {
        System.out.println("Mensagem recebida da DLQ!");
        
        String defaultQueueName = "T04N_aline_avila_brunetti"; 
        
        auditService.processFailedMessage(message, defaultQueueName);
    }
}