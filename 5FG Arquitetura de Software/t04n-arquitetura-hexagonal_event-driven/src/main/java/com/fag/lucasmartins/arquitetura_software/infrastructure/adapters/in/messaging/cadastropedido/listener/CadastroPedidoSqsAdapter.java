package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.cadastropedido.listener;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PedidoServicePort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.cadastropedido.dto.CadastroPedidoDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.cadastropedido.mapper.CadastroPedidoDTOMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CadastroPedidoSqsAdapter {
    private static final Logger log = LoggerFactory.getLogger(CadastroPedidoSqsAdapter.class);

    private final PedidoServicePort pedidoServicePort;

    public CadastroPedidoSqsAdapter(PedidoServicePort pedidoServicePort) {
        this.pedidoServicePort = pedidoServicePort;
    }
    @SqsListener(value = "${aws.sqs.queue.cadastro-pedido}")
    public void receberMensagem(CadastroPedidoDTO evento) {
        try {
            log.info("Evento de entrada de cadastro de pedido recebido");

            final PedidoBO bo = CadastroPedidoDTOMapper.toBO(evento);
            pedidoServicePort.criarPedido(bo);

            log.info("Pedido criado com sucesso");
        } catch (Exception e) {
            log.error("Erro ao criar um pedido", e);
            throw e;
        }
    }
}
