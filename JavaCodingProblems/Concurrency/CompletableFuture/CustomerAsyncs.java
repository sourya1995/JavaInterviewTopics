package JavaCodingProblems.Concurrency.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.logging.Logger;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class CustomerAsyncs {

    private static final Logger LOGGER = Logger.getLogger(CustomerAsyncs.class.getName());

    public CustomerAsyncs() {
        throw new AssertionError("no instantiation possible");
    }

    /* 1. Print a certain customer order. */
    /* CONCEPT - run an async task, and return void */

    public static void printOrder() throws InterruptedException, ExecutionException {
        CompletableFuture<Void> cfPrintOrder = CompletableFuture.runAsync(() -> {
            try {
                LOGGER.info(
                        () -> "Printing order");
                LOGGER.info(() -> "order printed by" + Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                LOGGER.severe(() -> "Thread interrupted");

            }
        });

        cfPrintOrder.get();
        LOGGER.info(() -> "Order printed");

    }

    /* Fetch the order summary of a certain customer. */
    /* CONCEPT - run an async task, and return a result */

    public static void fetchOrderSummary() throws InterruptedException, ExecutionException {
        CompletableFuture<String> cfFetchOrderSummary = CompletableFuture.supplyAsync(() -> {
            LOGGER.info(() -> "Fetching order summary");
            LOGGER.info(() -> "order summary fetched by" + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                LOGGER.severe(() -> "Thread interrupted");
            }
            return "order summary";

        });

        String summary = cfFetchOrderSummary.get();
        LOGGER.info(() -> "Order summary: " + summary);

    }

    /* Fetch the order summary of a certain customer. */
    /*
     * CONCEPT - run an async task, and return a result - using custom thread pool
     */
    public static void fetchSummaryExecutor() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<String> cfFetchOrderSummary = CompletableFuture.supplyAsync(() -> {
            LOGGER.info("Fetching order summary");
            LOGGER.info(() -> "Fetching order summary by" + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                LOGGER.severe(() -> "Thread interrupted");
            }

            return "order summary";

        }, executor);

        String summary = cfFetchOrderSummary.get();
        LOGGER.info(() -> "Order summary: " + summary);
        executor.shutdownNow();

    }

    /*
     * Fetch the order invoice of a certain customer and, afterward, compute the
     * total
     * and sign it.
     */
    /*
     * Attaching a callback that processes the result of an
     * asynchronous task and returns a result
     */

    public static void fetchInvoiceTotalSign() throws InterruptedException, ExecutionException {
        CompletableFuture<String> cfFetchInvoice = CompletableFuture.supplyAsync(() -> {
            LOGGER.info(() -> "Fetching invoice");
            LOGGER.info(() -> "Fetching invoice by" + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                LOGGER.severe(() -> "Thread interrupted");
            }

            return "invoice";

        });

        CompletableFuture<String> cfComputeTotalSign = cfFetchInvoice.thenApply(o -> o + "Total: $145")
                .thenApply(o -> o + "signed");
        String result = cfComputeTotalSign.get();
        LOGGER.info(() -> "Invoice: " + result);

    }

    /* Fetch the order summary of a certain customer. */
    /*
     * Attaching a callback that processes the result of an
     * asynchronous task and returns void
     */

    public static void fetchAndPrintOrder() throws InterruptedException, ExecutionException {
        CompletableFuture<String> cfFetchOrder = CompletableFuture.supplyAsync(() -> {
            LOGGER.info("Fetching order");
            LOGGER.info(() -> "Fetching order by" + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                LOGGER.severe(() -> "Thread interrupted");
            }
            return "order";
        });

        CompletableFuture<Void> cfPrintOrder = cfFetchOrder
                .thenAccept(o -> LOGGER.info(() -> "Printing order" + "by" + Thread.currentThread().getName()));
        cfPrintOrder.get();
        LOGGER.info(() -> "Order printed");

    }

    /* Deliver an order and notify the customer. */
    /*
     * Attaching a callback that runs after an
     * asynchronous task and returns void
     */

    public static void deliverOrderAndNotifyCustomer() throws InterruptedException, ExecutionException {
        CompletableFuture<Void> cfDeliverOrder = CompletableFuture.runAsync(() -> {
            LOGGER.info(() -> "Delivering order");
            LOGGER.info(() -> "Delivering order by" + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                LOGGER.severe(() -> "Thread interrupted");

            }

        });
        CompletableFuture<Void> cfNotifyCustomer = cfDeliverOrder.thenRun(() -> LOGGER
                .info(() -> "Dear customer, your order has been delivered by" + Thread.currentThread().getName()));
        cfNotifyCustomer.get();
        LOGGER.info(() -> "Order was delivered and customer notified");

    };

    /*
     * : Compute the total of an order. If something goes wrong, then throw an
     * IllegalStateException.
     */
    /*
     * Handling exceptions of an asynchronous task via
     * exceptionally()
     */

    public static void fetchTotalOrderException() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> ofTotalOrder = CompletableFuture.supplyAsync(() -> {
            LOGGER.info(() -> "Compute Total" + Thread.currentThread().getName());
            int surrogate = new Random().nextInt(1000);
            if (surrogate < 500) {
                throw new IllegalStateException("Something went wrong");

            }
            return 1000;
        }).exceptionally(ex -> {
            LOGGER.severe(() -> "Exception:" + ex + "by" + Thread.currentThread().getName());
            return 0;

        });

        int result = ofTotalOrder.get();
        LOGGER.info(() -> "Total: " + result);

    }

    /*
     * Fetch an invoice, compute the total, and sign. If something goes wrong then
     * throw IllegalStateException and stop the process.
     */

    public static void fetchInvoiceTotalSignChainOfException() throws InterruptedException, ExecutionException {
        CompletableFuture<String> cfFetchInvoice = CompletableFuture.supplyAsync(() -> {
            LOGGER.info(() -> "Fetch invoice by:" + Thread.currentThread().getName());
            int surrogate = new Random().nextInt(1000);
            if (surrogate < 500) {
                throw new IllegalStateException("Something went wrong");

            }

            return "invoice #3344";
        })/*
           * .exceptionally(ex -> {
           * LOGGER.severe(() -> "Exception:" + ex + "Thread: " +
           * Thread.currentThread().getName());
           * return "[Invoice-Exception]";
           * })
           */.thenApply(o -> {
            LOGGER.info(() -> "Compute total by:" + Thread.currentThread().getName());
            int surrogate = new Random().nextInt(1000);
            if (surrogate < 500) {
                throw new IllegalStateException("Something went wrong");
            }
            return o + "Total: $1450";

        })/*
           * .exceptionally(ex -> {
           * LOGGER.severe(() -> "Exception:" + ex + "Thread: " +
           * Thread.currentThread().getName());
           * return "[Total-Exception]";
           * 
           * })
           */.thenApply(o -> {
            LOGGER.info(() -> "Sign by:" + Thread.currentThread().getName());
            int surrogate = new Random().nextInt(1000);
            if (surrogate < 500) {
                throw new IllegalStateException("Something went wrong");

            }
            return o + "Signed";

        }).exceptionally(ex -> {
            LOGGER.severe(() -> "Exception:" + ex + "Thread: " + Thread.currentThread().getName());
            return "[NoInvoice-Exception]";
        });

        String result = cfFetchInvoice.get();
        LOGGER.info(() -> "Invoice: " + result);
    }

    public static void fetchInvoiceTotalSignChainOfException2() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<Integer> totalOrder = CompletableFuture.supplyAsync(() -> {
            LOGGER.info(() -> "Compute Total" + Thread.currentThread().getName());
            int surrogate = new Random().nextInt(1000);
            if (surrogate < 500) {
                throw new IllegalStateException("Something went wrong");

            }
            return 1000;
        }).exceptionallyAsync(ex -> {
            LOGGER.severe(() -> "Exception:" + ex + "Thread: " + Thread.currentThread().getName());
            return 0;
        }, executor); // JDK 12, uses same thread as execution code, computes parallelly

        int result = totalOrder.get();
        LOGGER.info(() -> "Total: " + result);
        executor.shutdownNow();

    }

    /*
     * Fetch a printer IP via the printing service or fallback to the backup printer
     * IP.
     * Or, generally speaking, when this stage completes exceptionally, it should be
     * composed using
     * the results of the supplied function applied to this stage's exception
     */

    public static void printInvoiceException() throws InterruptedException, ExecutionException {
        CompletableFuture<String> cfFetchPrinterIp = CompletableFuture.supplyAsync(() -> {
            int surrogate = new Random().nextInt(100);
            if (surrogate < 500) {
                throw new IllegalStateException("Something went wrong");

            }

            return "192.168.1.0";
        });

        CompletableFuture<String> cfFetchBackupPrinterIp = CompletableFuture.supplyAsync(() -> {
            return "192.192.192.192";
        });

        CompletableFuture<Void> printInvoice = cfFetchPrinterIp.exceptionallyCompose(th -> {
            LOGGER.severe(() -> "Exception:" + th + "Thread: " + Thread.currentThread().getName());
            return cfFetchBackupPrinterIp;
        }).thenAccept((ip) -> LOGGER.info(() -> "Printing at:" + ip));

        printInvoice.get();
        LOGGER.info(() -> "printing done");

    }

    /*
     * Compute the total of an order. If something goes wrong then throw
     * an IllegalStateException.
     */

    public static void fetchTotalOrderHandle() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> totalOrder = CompletableFuture.supplyAsync(() -> {
            LOGGER.info(() -> "Compute Total by" + Thread.currentThread().getName());
            int surrogate = new Random().nextInt(1000);
            if(surrogate < 500) {
                throw new IllegalStateException("Something went wrong");

            }
            return 1000;
        }).handle((res, ex) -> {
            if(ex != null){
                LOGGER.severe(() -> "Exception:" + ex + "Thread: " + Thread.currentThread().getName());
                return 0;
            }

            if(res != null) {
                int vat = res * 24 / 100;
                res += vat;
            }

            return res;
        });

        int result = totalOrder.get();
        LOGGER.info(() -> "Total: " + result);

    }

    /* Explicitly Cancel a CompletableFuture */

    public static CompletableFuture<Integer> taxes() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        new Thread(() -> {
            int result = new Random().nextInt(1000);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                LOGGER.severe(() -> "Exception:" + e + "Thread: " + Thread.currentThread().getName());
               /*  completableFuture.cancel(true); */
            }
            if (result < 500) {
                completableFuture.completeExceptionally(new IllegalStateException("Something went wrong"));
            } else {
                completableFuture.complete(result);
            }}).start();

        return completableFuture;

    }

    /* Combining with thenCompose() */
    private static CompletableFuture<String> fetchOrder(String customerId){
        return CompletableFuture.supplyAsync(() -> {
            return "Order of" + customerId;
        });
    }

    private static CompletableFuture<Integer> computeTotal(String order){
        return CompletableFuture.supplyAsync(() -> {
            return order.length() + new Random().nextInt(1000);

        });
    }

    public static void fetchOrderTotal(String customerId) throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> cfTotal = fetchOrder(customerId).thenCompose( o -> computeTotal(o));
        int total = cfTotal.get();
        LOGGER.info(() -> "Total: " + total);
    }

    private static CompletableFuture<String> packProducts(String order) {
        return CompletableFuture.supplyAsync(() -> {
            return "Order" + order + " | Product 1, Product 2, Product 3, ...";
        });

    }

    public static void deliverParcel(String order) throws InterruptedException, ExecutionException{
        CompletableFuture<String> cfParcel = computeTotal(order)
            .thenCombine(packProducts(order), (total, products) -> {
                return "Parcel-[" + products + "Invoice: $ " + total+ "]";
            });

        String parcel = cfParcel.get();
        LOGGER.info(() -> "Delivering: " + parcel);
    }

    public static CompletableFuture<String> downloadInvoices(String invoice){
        return CompletableFuture.supplyAsync(() -> {
           LOGGER.info(() -> "Downloading invoice: " + invoice);
           return "Downloaded invoice: " + invoice; 
        });

    }

    public static CompletableFuture<String> raffle(String customerId){
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(new Random().nextInt(5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                LOGGER.severe(() -> "Exception:" + e);
            }
            return customerId;
        });
    }
    
   

    

}
