package com.sbrf.reboot.lesson14;

import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainReport {

    public static CompletableFuture<BigDecimal> getTotalsWithCompletableFuture(Stream<Customer> streamCustomers) {
        List<CompletableFuture<BigDecimal>> futuresBigDecimalList = streamCustomers
                .filter((customer) -> customer.getAge() >= 18 && customer.getAge() <= 30)
                .map(customer -> CompletableFuture.supplyAsync(() -> customer
                        .getAccounts()
                        .filter((account) -> account.getCreateDate().isAfter(LocalDate.of(2021, 7, 1)) && account.getCreateDate().isBefore(LocalDate.of(2021, 8, 1)))
                        .filter((account) -> account.getCurrency().equals(Currency.RUB))
                        .map(Account::getBalance)
                        .reduce(BigDecimal::add)
                        .orElse(BigDecimal.ZERO)))
                .collect(Collectors.toList());

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futuresBigDecimalList.toArray(new CompletableFuture[0]));

        return allFutures.thenApply(v -> futuresBigDecimalList
                .stream()
                .map(CompletableFuture::join)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO));
    }


    public static Mono<BigDecimal> getTotalsWithReact(Stream<Customer> streamCustomers) {
        Scheduler scheduler = Schedulers.newParallel("parallel");

        Flux<Customer> customerFlux = Flux.fromStream(streamCustomers)
                .filter(FILTER_BY_AGE);

        Flux<BigDecimal> bigDecimalFlux = customerFlux
                .flatMap(customer -> Mono.just(customer
                        .getAccounts()
                        .filter(FILTER_BY_CREATE_DATE)
                        .filter(FILTER_BY_CURRENCY)
                        .map(Account::getBalance)
                        .reduce(BigDecimal::add)
                        .orElse(BigDecimal.ZERO)))
                .subscribeOn(scheduler);

        return bigDecimalFlux.reduce(BigDecimal::add);
    }
}
