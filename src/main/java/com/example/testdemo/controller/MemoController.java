package com.example.testdemo.controller;

import com.example.testdemo.dto.MemoRequestDto;
import com.example.testdemo.dto.MemoResponseDto;
import com.example.testdemo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @PostMapping("/memos")
    public MemoResponseDto save(@RequestBody MemoRequestDto dto) {
        return memoService.save(dto);
    }

    @GetMapping("/memos")
    public List<MemoResponseDto> findAll() {
        return memoService.findAll();
    }

    @GetMapping("/memos/{memoId}")
    public MemoResponseDto fineOne (@PathVariable Long memoId) {
        return memoService.findById(memoId);
    }

    @PutMapping("/memos/{memoId}")
    public MemoResponseDto update(@RequestBody MemoRequestDto dto, @PathVariable Long memoId) {
        return memoService.update(dto, memoId);
    }

    @DeleteMapping("/memos/{memoId}")
    public void delete(@PathVariable long memoId) {
        memoService.deleteById(memoId);
    }
}
