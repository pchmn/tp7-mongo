# TP Mongo - Redis

## MongoDB

### Object Document Mapper
On utilise lors de ce tp l'ODM [`Morphia`](http://mongodb.github.io/morphia/). Un ODM a la même fonction q'un ORM mais pour une base orienté document.

### Annotations
On utilise les annotations `Morphia` sur une classe Java pour pouvoir la "mapper". 
* `@Entity("nom_entité")` : représente le nom du document
* `@Id` : représente l'id de l'objet dans le document
* `@Embedded` : représente un sous-document inséré dans un document
```java
@Entity("persons")
public class Person {
    @Id
    private ObjectId id;
    private String name;
    @Embedded
    private Address address;
}

@Embedded
public class Address {
    private String street;
    private String city;
    private String postCode;
    private String country;
}
```

### Fonctionnement de Morphia
#### Instanciation
On instancie un objet `Moprhia` :
```java
Morphia morphia = new Morphia();
```
Ensuite on mappe les classes désirées : 
```java
morphia.map(Person.class).map(Address.class);
```
Puis on crée un `DataStore` (similaire à `EntityManager` pour JPA) : 
```java
Datastore ds = morphia.createDatastore(new MongoClient(), "tp7_sir");
```

#### Persister un objet
Pour persister un objet il suffit d'appeler la fonction `save` de `DataStore` : 
```java
Person p1 = new Person("Peter");
Address a1 = new Address("Rue des rossignols", "Paris", "75000", "France");
p1.setAddress(a1);

// on persiste p1
ds.save(p1);
```

## Redis

### Chaînes de caractères
On peut stocker des strings sous forme de Clé/Valeur.
```java
    // Définit une chaine de caractère
    jedis.set("foo", "bar");
    
    // Récupère la valeur
    jedis.get("foo");
```  
### Nombre
On peut stocker et gérer des nombres. On peut en effet faire des opérations sur ce nombre directement sur le serveur.
```java
    // Incrémente la variable counter
    jedis.incr("counter");
```
### Liste
Des listes de strings peuvent être définis, elles sont triés par ordre de définition.
```java
	// On rajoute des éléments à une liste
	jedis.lpush("Niveau", "Licence");
	jedis.lpush("Niveau", "Master");
	jedis.lpush("Niveau", "Doctorat");
	
	// On supprime le dernier élément rajouté
	jedis.lpop("Niveau");
```
### Collection de strings
Les collections peuvent être aussi des collections triées.
On peut ajouter, supprimer, modifier ces collections.
```java
    // Ajoute une valeur à la collection
    jedis.sadd(cacheKey2, "Java");
    
    // Supprime une valeur de la collection
    jedis.srem(cacheKey2, "C#");
```

### Objets
On peut stocker des objets entiers et modifier certains attributs
```java
    // Définit un objet avec une propriété 'lastName'
    Map<String, String> userProperties = new HashMap<String, String>();
	userProperties.put("lastName", "name");
	
	// Ajoute l'objet entier
	jedis.hmset("user:" + "clem", userProperties);
	
	// Récupère un attribut de l'objet
	jedis.hgetAll("user:" + username).get("lastName"));
```

<br>
###### Clément Goachet - Paul Chemin
