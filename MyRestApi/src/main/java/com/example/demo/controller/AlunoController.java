package com.example.demo.controller;

import java.util.List;
import com.example.demo.model.*;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.AlunoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
public class AlunoController {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@GetMapping("/alunos-teste")
	public List<Aluno> getAlunos()
	{
		return alunoRepository.findAll();
	}
	
	@GetMapping("/aluno/{id}")
	public Aluno getAluno(@PathVariable(value="id") int id)
	{
		return alunoRepository.findById(id).get();
	}
	
	@PostMapping("/aluno")
	public Aluno save(@RequestBody Aluno aluno)
	{
		return alunoRepository.save(aluno);
	}
	

	@DeleteMapping("/aluno")
	public void deleteAluno(@RequestBody Aluno aluno)
	{
		alunoRepository.delete(aluno);
	}
	
	@PutMapping("/aluno")
	public Aluno upDateAluno(@RequestBody Aluno aluno)
	{
		return alunoRepository.save(aluno);
		
	}
	
	
	
}
