package com.crud_es.demo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud_es.demo.model.CartaoDeCreditoModel;
import com.crud_es.demo.model.UserModel;
import com.crud_es.demo.model.endereco.EnderecoModel;
import com.crud_es.demo.repository.UserRepository;
import com.crud_es.demo.service.FachadaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@RestController
public class UserController {

    FachadaService fachadaService = new FachadaService();

    @Autowired
    private UserRepository userRepository;
    

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<String> consultar(@PathVariable("id") Long id) {
        return userRepository.findById(id)
            .map(user -> {
                Map<String, Object> userMap = new LinkedHashMap<>();

                // Adiciona propriedades simples
                userMap.put("nomeCliente", user.getNomeCliente());
                userMap.put("generoCliente", user.getGeneroCliente().name());
                userMap.put("dataNascimentoCliente", user.getDataNascimentoCliente());
                userMap.put("cpfCliente", user.getCpfCliente());
                userMap.put("emailCliente", user.getEmailCliente());
                userMap.put("senhaCliente1", user.getSenhaCliente1());
                userMap.put("senhaCliente2", user.getSenhaCliente2());
                userMap.put("statusCliente", user.getStatusCliente());

                // Processando telefone
                Map<String, Object> telefoneMap = new LinkedHashMap<>();
                telefoneMap.put("tipoTelefone", user.getTelefoneCliente().getTipoTelefone().name());
                telefoneMap.put("ddi", user.getTelefoneCliente().getDdi());
                telefoneMap.put("ddd", user.getTelefoneCliente().getDdd());
                telefoneMap.put("numero", user.getTelefoneCliente().getNumero());
                userMap.put("telefoneCliente", telefoneMap);

                // Processando endereços
                List<Map<String, Object>> enderecosList = new ArrayList<>();
                for (EnderecoModel endereco : user.getEnderecosCliente()) {
                    Map<String, Object> enderecoMap = new LinkedHashMap<>();
                    enderecoMap.put("nomeEndereco", endereco.getNomeEndereco());
                    enderecoMap.put("numero", endereco.getNumero());
                    enderecoMap.put("complemento", endereco.getComplemento());
                    enderecoMap.put("bairro", endereco.getBairro());
                    enderecoMap.put("cep", endereco.getCep());
                    enderecoMap.put("observacao", endereco.getObservacao());
                    enderecoMap.put("tipoEndereco", endereco.getTipoEndereco().name());
                    enderecoMap.put("tipoResidencia", endereco.getTipoResidencia().name());
                    enderecoMap.put("tipoLogradouro", endereco.getTipoLogradouro().name());
                    enderecoMap.put("logradouro", endereco.getLogradouro());
                    // Adicionar informações de país, estado e cidade
                    enderecoMap.put("pais", Map.of("nomePais", endereco.getPais().getNomePais()));
                    enderecoMap.put("estado", Map.of("nomeEstado", endereco.getEstado().getNomeEstado()));
                    enderecoMap.put("cidade", Map.of("nomeCidade", endereco.getCidade().getNomeCidade()));
                    enderecosList.add(enderecoMap);
                }
                userMap.put("enderecosCliente", enderecosList);

                // Processando cartões
                List<Map<String, Object>> cartoesList = new ArrayList<>();
                for (CartaoDeCreditoModel cartao : user.getCartoesCliente()) {
                    Map<String, Object> cartaoMap = new LinkedHashMap<>();
                    cartaoMap.put("numeroCartao", cartao.getNumeroCartao());
                    cartaoMap.put("nomeTitularCartao", cartao.getNomeTitularCartao());
                    cartaoMap.put("bandeiraCartao", cartao.getBandeiraCartao());
                    cartaoMap.put("preferencial", cartao.getPreferencial());
                    cartoesList.add(cartaoMap);
                }
                userMap.put("cartoesCliente", cartoesList);

                // Convertendo o mapa para JSON
                String jsonResult = "";
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    objectMapper.registerModule(new JavaTimeModule());
                    objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
                    objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
                    jsonResult = objectMapper.writeValueAsString(userMap);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }

                return ResponseEntity.ok().body(jsonResult);
            })
            .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping(path = "/user")
    public String salvar (@RequestBody UserModel user){
        System.out.println("\n\n\n\n\n\n\n" + user);
        
        for (CartaoDeCreditoModel cartao : user.getCartoesCliente()) {
            cartao.setUser(user);
        }
        
        for (EnderecoModel endereco : user.getEnderecosCliente()) {
            endereco.setUser(user);
        }
        
        boolean permissao = fachadaService.salvar(user);
        if (permissao) {
            return userRepository.save(user).hashCode() + " - Salvo com sucesso";
        }
        return "Não foi possível salvar o registro";
    }

    @DeleteMapping(path = "/user/{id}")
    public String excluir(@PathVariable("id") Long id) {
        try {
            userRepository.findById(id)
                .map(user -> {
                    userRepository.delete(user);
                    return "Deletado com sucesso";
                })
                .orElseThrow( () -> {
                    return new RuntimeException("Não foi possível deletar o registro");});  
        } catch (Exception e) {
            return "Erro ao deletar";
        }
        return "Finalizamos a exclusão";
    }

    @PutMapping(path = "/user/{id}")
    public UserModel editar(@PathVariable Long id, @RequestBody UserModel userAtualizado) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setNomeCliente(userAtualizado.getNomeCliente());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> {
                    return new RuntimeException("Não foi possível atualizar o registro");});
    }
}
