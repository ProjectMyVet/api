package br.com.myvet.service.medication;

import br.com.myvet.dto.medication.MedicationCreationResponseDto;
import br.com.myvet.dto.medication.MedicationSearchingResponseDto;
import br.com.myvet.mapper.MedicationMapper;
import br.com.myvet.repository.MedicationRepository;
import br.com.myvet.service.pet.PetService;
import br.com.myvet.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicationServiceImpl implements MedicationService {

    private final MedicationRepository repository;

    private final UserService userService;

    private final MedicationMapper mapper;

    private final PetService petService;

    @Override
    public List<MedicationSearchingResponseDto> search(Long customerId, Long petId) {
        final var customer = userService.findByIdOrElseThrow(customerId);
        final var pet = petService.findByUserAndId(customer, petId);
        return repository.findByCustomerAndPet(customer, pet).stream()
                .map(mapper::mapToMedicationSearchingResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void create(MedicationCreationResponseDto responseDto) {
        final var customer = userService.findByIdOrElseThrow(responseDto.getCustomerId());
        final var pet = petService.findByUserAndId(customer, responseDto.getPetId());
        final var medication = mapper.mapFromMedicationCreationResponseDto(customer, pet, responseDto);
        repository.save(medication);
    }
}
