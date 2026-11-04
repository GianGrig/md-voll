package md.voll.api.domain.consulta.validacoes;

import md.voll.api.domain.ValidacaoException;
import md.voll.api.domain.consulta.ConsultaRepository;
import md.voll.api.domain.consulta.DadosAgendamentoConsulta;

public class ValidadorPacienteSemOutraConsultaNoDia {
    private ConsultaRepository repository;
    public void validar(DadosAgendamentoConsulta dados) {
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = repository.existsByPacienteIdAndDataBetweenAndMotivoCancelamentoIsNull(dados.idPaciente(), primeiroHorario, ultimoHorario);
        if (pacientePossuiOutraConsultaNoDia) {
            throw new ValidacaoException("Paciente já possui uma consulta agendada nesse dia");
        }
    }
}
