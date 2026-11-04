package md.voll.api.domain.consulta.validacoes;

import md.voll.api.domain.ValidacaoException;
import md.voll.api.domain.consulta.DadosAgendamentoConsulta;

import java.time.DayOfWeek;

public class ValidadorHorarioFuncionamentoClinica {
    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisDoEncerramentoDaClinica = dataConsulta.getHour() > 18;
        var horarioQuebrado = dataConsulta.getMinute() != 0;
        if(domingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaClinica || horarioQuebrado){
            throw new ValidacaoException("Consulta fora do horário de funcionamento da clínica");
        }
    }
}
