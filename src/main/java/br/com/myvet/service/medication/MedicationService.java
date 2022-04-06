package br.com.myvet.service.medication;

import br.com.myvet.dto.medication.MedicationCreationResponseDto;
import br.com.myvet.dto.medication.MedicationSearchingResponseDto;

import java.util.List;

public interface MedicationService {

    List<MedicationSearchingResponseDto> search(Long customerId, Long petId);

    void create(MedicationCreationResponseDto responseDto);

}
