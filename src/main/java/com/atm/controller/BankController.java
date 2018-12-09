package com.atm.controller;

import com.atm.entity.Bank;
import com.atm.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class BankController {

	private BankRepository bankRepository;

    @Autowired
    public BankController(BankRepository bankRepository){
        this.bankRepository = bankRepository;
    }

	@PostMapping("/newBank")
	public ResponseEntity<?> createBank(@RequestBody Bank newBank) {
        bankRepository.save(newBank);

        return new ResponseEntity<>(bankRepository.findAll(), HttpStatus.CREATED);
    }

    @PostMapping(value = "/deleteBank/{idBank}")
    public ResponseEntity<?> removeAccount(@PathVariable long idBank){
        bankRepository.deleteById(idBank);
        return new ResponseEntity<>(bankRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/allBanks")
    public ResponseEntity<?> getAllAccount(){
        return new ResponseEntity<>(bankRepository.findAll(), HttpStatus.OK);
    }
}
