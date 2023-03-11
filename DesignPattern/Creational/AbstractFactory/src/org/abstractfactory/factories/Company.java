package org.abstractfactory.factories;

import org.abstractfactory.product.GPU;
import org.abstractfactory.product.Monitor;

public abstract class Company {

    public abstract GPU createGpu();
    public abstract Monitor createMonitor();
}
