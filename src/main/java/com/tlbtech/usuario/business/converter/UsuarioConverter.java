package com.tlbtech.usuario.business.converter;

import com.tlbtech.usuario.business.dto.EnderecoDTO;
import com.tlbtech.usuario.business.dto.TelefoneDTO;
import com.tlbtech.usuario.business.dto.UsuarioDTO;
import com.tlbtech.usuario.infrastructure.entity.Endereco;
import com.tlbtech.usuario.infrastructure.entity.Telefone;
import com.tlbtech.usuario.infrastructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioConverter {

   public Usuario paraUsuario(UsuarioDTO usuarioDTO){
       return Usuario.builder()
               .nome(usuarioDTO.getNome())
               .email(usuarioDTO.getEmail())
               .senha(usuarioDTO.getSenha())
               .enderecos(paraListaEndereco(usuarioDTO.getEnderecos()))
               .telefones(paraListaTelefones(usuarioDTO.getTelefones()))
               .build();
   }

   public List<Endereco> paraListaEndereco(List<EnderecoDTO> enderecoDTOS){
        List<Endereco> enderecos = new ArrayList<>();
        for(EnderecoDTO enderecoDTO : enderecoDTOS){
            enderecos.add(paraEndereco(enderecoDTO));
        }
        return enderecos;

   }

   public Endereco paraEndereco(EnderecoDTO enderecoDTO){
       return Endereco.builder()
               .rua(enderecoDTO.getRua())
               .numero(enderecoDTO.getNumero())
               .cidade(enderecoDTO.getCidade())
               .complemento(enderecoDTO.getComplemento())
               .cep(enderecoDTO.getCep())
               .estado(enderecoDTO.getEstado())
               .build();
   }

   public List<Telefone> paraListaTelefones(List<TelefoneDTO> telefoneDTOS){
        return telefoneDTOS.stream().map(this::paraTelefone).toList();

   }

   public Telefone paraTelefone(TelefoneDTO telefoneDTO){
       return Telefone.builder()
               .numero(telefoneDTO.getNumero())
               .ddd(telefoneDTO.getDdd())
               .build();
   }

    public UsuarioDTO paraUsuarioDTO(Usuario usuarioDTO){
        return UsuarioDTO.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListaEnderecoDTO(usuarioDTO.getEnderecos()))
                .telefones(paraListaTelefonesDTO(usuarioDTO.getTelefones()))
                .build();
    }

    public List<EnderecoDTO> paraListaEnderecoDTO(List<Endereco> enderecoDTOS){
        List<EnderecoDTO> enderecos = new ArrayList<>();
        for(Endereco enderecoDTO : enderecoDTOS){
            enderecos.add(paraEnderecoDTO(enderecoDTO));
        }
        return enderecos;

    }

    public EnderecoDTO paraEnderecoDTO(Endereco endereco){
        return EnderecoDTO.builder()
                .id(endereco.getId())
                .rua(endereco.getRua())
                .numero(endereco.getNumero())
                .cidade(endereco.getCidade())
                .complemento(endereco.getComplemento())
                .cep(endereco.getCep())
                .estado(endereco.getEstado())
                .build();
    }

    public List<TelefoneDTO> paraListaTelefonesDTO(List<Telefone> telefoneDTOS){
        return telefoneDTOS.stream().map(this::paraTelefoneDTO).toList();

    }

    public TelefoneDTO paraTelefoneDTO(Telefone telefone){
        return TelefoneDTO.builder()
                .id(telefone.getId())
                .numero(telefone.getNumero())
                .ddd(telefone.getDdd())
                .build();
    }

    public Usuario updateUsuario(UsuarioDTO usuarioDto, Usuario entity){
       return Usuario.builder()
               .nome(usuarioDto.getNome() != null ? usuarioDto.getNome() : entity.getNome())
               .id(entity.getId())
               .senha(usuarioDto.getSenha() != null ? usuarioDto.getSenha() : entity.getSenha())
               .email(usuarioDto.getEmail() != null ? usuarioDto.getEmail() : entity.getEmail())
               .enderecos(entity.getEnderecos())
               .telefones(entity.getTelefones())
               .build();
    }

    public Endereco updateEndereco(EnderecoDTO dto, Endereco entity){
       return Endereco.builder()
               .id(entity.getId())
               .rua(dto.getRua() != null ? dto.getRua() : entity.getRua())
               .numero(dto.getNumero() != null ? dto.getNumero() : entity.getNumero())
               .cidade(dto.getCidade() != null ? dto.getCidade() : entity.getCidade())
               .cep(dto.getCep() != null ? dto.getCep() : entity.getCep())
               .complemento(dto.getComplemento() != null ? dto.getComplemento() : entity.getComplemento())
               .estado(dto.getEstado() != null ? dto.getEstado() : entity.getEstado())
               .build();
    }

    public Telefone updateTelefone(TelefoneDTO dto, Telefone entity) {
       return Telefone.builder()
               .id(entity.getId())
               .ddd(dto.getDdd() != null ? dto.getDdd() : entity.getDdd())
               .numero(dto.getNumero() != null ? dto.getNumero() : entity.getNumero())
               .build();
    }

    public Endereco paraEnderecoEntity(EnderecoDTO dto, Long idUsuario){
       return Endereco.builder()
               .rua(dto.getRua())
               .cidade(dto.getCidade())
               .cep(dto.getCep())
               .complemento(dto.getComplemento())
               .estado(dto.getEstado())
               .numero(dto.getNumero())
               .usuario_id(idUsuario)
               .build();
    }

    public Telefone paraTelefoneEntity(TelefoneDTO dto, Long idUsuario){
       return Telefone.builder()
               .numero(dto.getNumero())
               .ddd(dto.getDdd())
               .usuario_id(idUsuario)
               .build();
    }
}
