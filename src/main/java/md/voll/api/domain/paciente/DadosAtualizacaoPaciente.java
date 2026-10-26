package md.voll.api.domain.paciente;

import jakarta.validation.Valid;
import md.voll.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        Long id,
        String nome,
        String telefone,
        @Valid DadosEndereco endereco
) {
}
