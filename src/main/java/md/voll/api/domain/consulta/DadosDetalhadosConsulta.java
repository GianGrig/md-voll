package md.voll.api.domain.consulta;

import java.time.LocalDateTime;

public record DadosDetalhadosConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
}
