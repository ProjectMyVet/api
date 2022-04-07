package br.com.myvet.controller;

import br.com.myvet.dto.evaluation.EvaluationCreationRequestDto;
import br.com.myvet.service.attendance.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/evaluations")
public class EvaluationController {

    private final AttendanceService service;

    @PostMapping
    public void search(@RequestBody EvaluationCreationRequestDto requestDto) {
        service.createEvaluation(requestDto);
    }
}
