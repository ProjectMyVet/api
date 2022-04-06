package br.com.myvet.controller;

import br.com.myvet.dto.treatment.TreatmentSearchingResponseDto;
import br.com.myvet.service.attendance.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/treatments")
public class TreatmentController {

    private final AttendanceService service;

    @GetMapping
    public List<TreatmentSearchingResponseDto> search(@RequestParam(name = "userId") Long userId,
                                                      @RequestParam(name = "petId") Long petId) {
        return service.searchTreatments(userId, petId);
    }
}
