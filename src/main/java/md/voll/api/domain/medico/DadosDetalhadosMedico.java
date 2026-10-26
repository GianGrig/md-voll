package md.voll.api.domain.medico;

import md.voll.api.domain.endereco.Endereso;

public record DadosDetalhadosMedico(Long id, String nome, String email, String crm, String tefone,
                                    Especialidade especialidade, Endereso endereso) {
    public DadosDetalhadosMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereso());
    }
}
