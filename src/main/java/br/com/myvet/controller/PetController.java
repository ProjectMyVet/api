package br.com.myvet.controller;

import br.com.myvet.dto.pet.PetCreationRequestDto;
import br.com.myvet.dto.pet.PetEditionRequestDto;
import br.com.myvet.dto.pet.PetSearchingResponseDto;
import br.com.myvet.service.pet.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    @PostMapping
    public void register(@RequestBody PetCreationRequestDto requestDto) {
        petService.register(requestDto);
    }

    @GetMapping
    public List<PetSearchingResponseDto> search(@RequestParam(name = "userId") Long userId) {
        return petService.search(userId);
    }

    @PutMapping
    public void edit(@RequestParam(name = "userId") Long userId, @RequestBody PetEditionRequestDto requestDto) {
        petService.edit(userId, requestDto);
    }
}
