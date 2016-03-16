package fr.istic.sir;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.net.UnknownHostException;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws UnknownHostException {

        Morphia morphia = new Morphia();
        MongoClient mongo = new MongoClient();
        morphia.map(Person.class).map(Address.class);
        Datastore ds = morphia.createDatastore(mongo, "tp7_sir");


        Person p1 = new Person("Peter");
        Address a1 = new Address("Rue des rossignols", "Paris", "75000", "France");
        p1.setAddress(a1);

        Person p2 = new Person("Jean");
        Address a2 = new Address("Rue des marguerites", "Rennes", "35000", "France");
        p2.setAddress(a2);

        Person p3 = new Person("Edgard");
        Address a3 = new Address("Rue des jonquilles", "Rennes", "35000", "France");
        p3.setAddress(a3);

        // Save the POJO
        ds.save(p1);
        ds.save(p2);
        ds.save(p3);

        for (Person e : ds.find(Person.class))
            System.err.println(e);



    }
}
