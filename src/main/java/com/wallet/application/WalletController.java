package com.wallet.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@CrossOrigin(value= "http://localhost:4200/")
public class WalletController {
    @Autowired
    private WalletService walletService;
//    @GetMapping
//    public String greet(){
//        return  "welcome to wallet project";
//    }
    @PostMapping("/wallet")
    @ResponseStatus(value = HttpStatus.CREATED)
    public WalletDto addWallet(@Valid @RequestBody WalletDto wallet) throws WalletException{
        return walletService.registerWallet(wallet);
    }
    @GetMapping("/getwallet/{id}")
    public WalletDto getWalletById(@PathVariable Integer id) throws WalletException{


        //return "get wallet by id"+id;
        return walletService.getWalletById(id);
    }
    @PutMapping("/updatewallet")
    public WalletDto updateWallet(@RequestBody WalletDto wallet) throws WalletException{
        return walletService.updateWallet(wallet);
    }
    @DeleteMapping("/wallet/{walletid}")
    public WalletDto deleteWallet(@PathVariable Integer walletid) throws WalletException{
        return walletService.deleteWalletById(walletid);
    }
    @PatchMapping("wallet/{id}/{amount}")
    public Double addFundsToWalletById(@PathVariable("id")Integer walletId,@PathVariable("amount") Double amount) throws WalletException {

        return this.walletService.addFundsToWalletById(walletId,amount);

    }

    @PatchMapping("wallet/{id}/fund/{amount}")
    public Double withdrawFundsfromWalletById(@PathVariable("id")Integer walletId,@PathVariable("amount") Double amount) throws WalletException {

        return this.walletService.withdrawFundsFromWalletById(walletId,amount);

    }



    @PatchMapping(value = "/transfer/{id}/{idtoid}/{amount}")
    public Boolean transferFunds(@PathVariable Integer id,@PathVariable Integer idtoid, @PathVariable Double amount) throws WalletException{
        return walletService.fundTransfer(id, idtoid, amount);
    }

    @GetMapping("wallets")
    public Collection<WalletDto> getAllWallets(){

        return this.walletService.getAllWallets();

    }
}
