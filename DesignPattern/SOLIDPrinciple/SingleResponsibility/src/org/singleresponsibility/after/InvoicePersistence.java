package org.singleresponsibility.after;

public class InvoicePersistence {

    private final Invoice invoice;

    public InvoicePersistence(Invoice invoice){
        this.invoice = invoice;
    }

    public void saveToFile(String filename) {
        // Creates a file with given name and writes the invoice
    }
}
