package rmiServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import rmiService.ConversionImpl;

public class ConversionServer {

    public static void main(String[] args) throws RemoteException, MalformedURLException {

        // Create a registry on port 1099 to listen for incoming RMI requests
        LocateRegistry.createRegistry(1099);

        // Create an instance of the ConversionImpl class, which implements the RMI service
        ConversionImpl od = new ConversionImpl();

        // Print information about the created object 
        System.out.println(od.toString());

        // Bind the created object to a specific name in the RMI registry
        // Clients will use this name to look up and access the remote object
        Naming.rebind("rmi://localhost:1099/objetdistant", od);
    }
}