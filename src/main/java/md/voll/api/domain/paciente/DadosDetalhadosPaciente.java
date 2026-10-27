package md.voll.api.domain.paciente;

import md.voll.api.domain.endereco.Endereco;

public record DadosDetalhadosPaciente(String nome, String email, String cpf, String telefone,
                                      Endereco endereco) {
    public DadosDetalhadosPaciente(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());
    }
}
