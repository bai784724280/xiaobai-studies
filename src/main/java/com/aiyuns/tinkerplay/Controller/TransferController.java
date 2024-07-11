package com.aiyuns.tinkerplay.Controller;

import com.aiyuns.tinkerplay.Controller.Service.TransferService;
import com.aiyuns.tinkerplay.Entity.TransferRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "transferController")
@Tag(name = "TransferController", description = "金融模块")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @PostMapping
    public ResponseEntity<String> transfer(@RequestBody TransferRequest transferRequest) {
        transferService.transfer(transferRequest.getFromAccountNumber(),
                transferRequest.getToAccountNumber(),
                transferRequest.getAmount());
        return ResponseEntity.ok("Transfer successful");
    }
}
