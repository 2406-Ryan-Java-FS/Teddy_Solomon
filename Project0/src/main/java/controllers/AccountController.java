package controllers;

import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.NotFoundResponse;
import models.Account;
import models.Item;
import services.AccountService;

import java.util.List;

public class AccountController {

    private AccountService as;
    private Gson gson = new Gson();

    public AccountController(AccountService as) { this.as = as; }

    public Handler getAllAccounts = (context) -> {

        List<Account> accounts = as.getAllAccounts();
        String accountsJSON = gson.toJson(accounts);
        context.result(accountsJSON);
    };

    public Handler getAccountById = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));
        Account a = as.getAccount(id);
        if (a == null) {
            throw new NotFoundResponse();
        }
        context.result(gson.toJson(a));
    };

    public Handler createAccount = (context) -> {

        Account a = gson.fromJson(context.body(), Account.class);
        a = as.addAccount(a);
        context.result(gson.toJson(a));
    };

    public Handler updateAccount = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));
        Account change = gson.fromJson(context.body(), Account.class);
        change.setId(id);
        change = as.updateAccount(change);
        if (change == null) {
            throw new NotFoundResponse();
        }
        context.result(gson.toJson(change));
    };

    public Handler deleteAccountById = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));
        Account a = as.deleteAccount(id);
        if (a == null) {
            throw new NotFoundResponse();
        }
        context.result(gson.toJson(a));
    };
}
