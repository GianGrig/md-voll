package md.voll.api.domain.medico;

import jakarta.validation.Valid;
import md.voll.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        Long id,
        String nome,
        String telefone,
        @Valid DadosEndereco endereco) {
}
