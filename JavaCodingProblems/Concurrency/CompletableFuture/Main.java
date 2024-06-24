package JavaCodingProblems.Concurrency.CompletableFuture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        /*
         * logger.info("Printing customer order ...");
         * CustomerAsyncs.printOrder();
         * 
         * logger.info("fetch order summary");
         * CustomerAsyncs.fetchOrderSummary();
         * 
         * logger.info("fetch summary from different thread pool");
         * CustomerAsyncs.fetchSummaryExecutor();
         * 
         * logger.info("fetching invoice, total and signing the order");
         * CustomerAsyncs.fetchInvoiceTotalSign();
         * 
         * logger.info("fetching and printing order asynchronously with a callback");
         * CustomerAsyncs.fetchAndPrintOrder();
         * 
         * logger.info("fetching and printing exception if any");
         * CustomerAsyncs.fetchTotalOrderException();
         * 
         * logger.info("Computing taxes..");
         * CompletableFuture<Integer> cfTaxes = CustomerAsyncs.taxes();
         * 
         * while (!cfTaxes.isDone()) {
         * logger.info(() -> "Still computing");
         * }
         * 
         * int result = cfTaxes.get();
         * logger.info(() -> "Taxes: " + result);
         */
        List<String> invoices = Arrays.asList("#2334", "#122", "#55");

        CompletableFuture<String>[] cfInvoices = invoices.stream()
                .map(CustomerAsyncs::downloadInvoices)
                .toArray(CompletableFuture[]::new);

        CompletableFuture<Void> cfAllInvoices = CompletableFuture.allOf(cfInvoices);
        cfAllInvoices.get();
        logger.info("All invoices downloaded");

        List<String> results = cfAllInvoices.thenApply(e -> {
            List<String> downloaded = new ArrayList<>();
            for (CompletableFuture<String> cfInvoice : cfInvoices) {
                downloaded.add(cfInvoice.join()); // underlying CompletableFuture completes exceptionally
            }

            return downloaded;
        }).get();

        results.forEach(r -> logger.info(r));

        List<String> customers = Arrays.asList(
                "#1", "#4", "#2", "#7", "#6", "#5");
        @SuppressWarnings("unchecked")
        CompletableFuture<String>[] cfCustomers = customers.stream()
                .map(CustomerAsyncs::raffle)
                .toArray(CompletableFuture[]::new);

        CompletableFuture<Object> cfWinner = CompletableFuture.anyOf(cfCustomers);
        String winner = cfWinner.get().toString();
        logger.info(() -> "Winner: " + winner);

    }
}
