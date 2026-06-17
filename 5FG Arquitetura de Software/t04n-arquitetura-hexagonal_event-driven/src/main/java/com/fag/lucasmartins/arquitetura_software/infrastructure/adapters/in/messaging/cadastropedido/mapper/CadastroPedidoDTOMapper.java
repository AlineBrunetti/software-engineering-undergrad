package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.cadastropedido.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoProdutoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.cadastropedido.dto.CadastroPedidoDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.cadastropedido.dto.CadastroPedidoProdutoDTO;

import java.util.ArrayList;
import java.util.List;

public class CadastroPedidoDTOMapper {
    public static PedidoBO toBO(CadastroPedidoDTO dto) {
        final PedidoBO bo = new PedidoBO();

        final PessoaBO pessoaBO = new PessoaBO();

        pessoaBO.setId(dto.getCustomerId());

        bo.setPessoa(pessoaBO);
        bo.setCep(dto.getZipCode());

        List<PedidoProdutoBO> produtosBO = new ArrayList<>();

        for (CadastroPedidoProdutoDTO item : dto.getOrderItems()) {

            PedidoProdutoBO pedidoProdutoBO = new PedidoProdutoBO();

            ProdutoBO produtoBO = new ProdutoBO();
            produtoBO.setId(item.getSku());

            pedidoProdutoBO.setProduto(produtoBO);
            pedidoProdutoBO.setQuantidade(item.getAmount());

            produtosBO.add(pedidoProdutoBO);
        }
        bo.setItens(produtosBO);
        return bo;
    }
}
