# tp7-mongo



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

