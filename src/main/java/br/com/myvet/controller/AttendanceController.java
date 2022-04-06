package br.com.myvet.controller;

import br.com.myvet.dto.attendance.AttendanceCreationRequestDto;
import br.com.myvet.dto.attendance.AttendanceFinishingRequestDto;
import br.com.myvet.dto.attendance.AttendanceSearchResponseDto;
import br.com.myvet.dto.attendance.AttendanceStatusRequestDto;
import br.com.myvet.service.attendance.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/attendances")
public class AttendanceController {

    private final AttendanceService service;

    @PostMapping
    public void create(@RequestBody AttendanceCreationRequestDto requestDto) {
        service.create(requestDto);
    }

    @GetMapping
    public List<AttendanceSearchResponseDto> search(@RequestParam(name = "userId") Long userId) {
        return service.search(userId);
    }

    @PatchMapping("/confirm")
    public void confirm(@RequestBody AttendanceStatusRequestDto requestDto) {
        service.confirm(requestDto.getUserId(), requestDto.getAttendanceId());
    }

    @PatchMapping("/cancel")
    public void cancel(@RequestBody AttendanceStatusRequestDto requestDto) {
        service.cancel(requestDto.getUserId(), requestDto.getAttendanceId());
    }

    @PatchMapping("/finish")
    public void finish(@RequestBody AttendanceFinishingRequestDto requestDto) {
        service.finish(requestDto);
    }
}
