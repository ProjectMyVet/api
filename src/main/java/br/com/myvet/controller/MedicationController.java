package br.com.myvet.controller;

import br.com.myvet.dto.medication.MedicationCreationResponseDto;
import br.com.myvet.dto.medication.MedicationSearchingResponseDto;
import br.com.myvet.service.medication.MedicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/medications")
public class MedicationController {

    private final MedicationService service;

    @GetMapping
    public List<MedicationSearchingResponseDto> search(@RequestParam(name = "customerId") Long customerId,
                                                       @RequestParam(name = "petId") Long petId) {
        return service.search(customerId, petId);
    }

    @PostMapping
    public void create(@RequestBody MedicationCreationResponseDto responseDto) {
        service.create(responseDto);
    }
}
