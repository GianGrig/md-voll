package md.voll.api.domain.paciente;

import md.voll.api.domain.endereco.Endereso;

public record DadosDetalhadosPaciente(String nome, String email, String cpf, String telefone,
                                      Endereso endereso) {
    public DadosDetalhadosPaciente(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }
}
