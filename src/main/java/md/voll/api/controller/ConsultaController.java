package md.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import md.voll.api.domain.consulta.AgendaDeConsultas;
import md.voll.api.domain.consulta.DadosAgendamentoConsulta;
import md.voll.api.domain.consulta.DadosDetalhadosConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
public class ConsultaController {
    @Autowired
    private AgendaDeConsultas agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados){
        agenda.agendar(dados);
        return ResponseEntity.ok(new DadosDetalhadosConsulta(null, null, null, null));
    }
}
