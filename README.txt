# Stockage

Notre service permet de stocker des valeurs dans une base de donnée. 
Ca supporte des structures de données comme les strings et les ensembles.
C'est un service de stockage cle/valeurs


# Les commandes sur les clés/valeurs

SET Key Value : Cette commande attribue à la clé "Key" la valeur "Value"
GET Key : Permet d'obtenir la valeur de la clé "Key"
DEL Key :  Si la clé "Key" est un entier, la mets à 0
INCR Key : Si la clé "Key" est un entier, l'incrémente (La concurrence est gérée lors de cette opération)
DECR Key : Si la clé "Key" est un entier, le décrémente

# Les commandes suivantes sont la gestion d'une liste

RPUSH Key Value : Permet de mettre la valeur "Value" à la clé "Key" à la fin de la liste
LPUSH Key Value : Permet de mettre la valeur "Value" à la clé "Key" au début de la liste
LLEN Key : Retourne la taille de la liste à la clé "Key"
LPOP Key : Supprime le premier élément de la liste et le retourne
RPOP Key : Supprime le dernier élément de la liste et le retourne

# Les commandes suivantes sont la gestion d'un ensemble (un set)

SADD Key Value(s) : Ajoute les valeurs dans "Value(s) dans l'ensemble à la clé "Key"
SREM Key Value(s) : Supprime les valeurs dans "Value(s) dans l'ensemble à la clé "Key"
SISMEMBER Key Value : Teste si la valeur "Value" est dans l'ensemble à la clé "Key"
SMEMBERS Key : Retourne ce que contient la liste à la clé "Key"
SUNION Key Key : Combine deux éléments et retourne la liste de tous les éléments joints dans le nouvel ensemble

# Gestion des hash

HSET Key Field Value : Stocke la valeur "Value" dans le champ "Field" de la clé "Key"
HGET Key Field : Récupére la valeur stockée dans le champ "Field" de la clé "Key"
HGETALL Key : Récupère tous les champs et toutes les valeurs de la clé "Key"
HDEL Key Field : Supprime les valeurs du champ "Field", ainsi que ce même champ
HDECRBY Key Field Value : Décrémente la valeur de "Value" dans le champ "Field" de la clé "Key" si c'est un entier
HINCRBY Key Field Value : Incrémente la valeur de "Value" dans le champ "Field" de la clé "Key" si c'est un entier


# Utilisation 

Exécuter le Menu afin d'accéder à toutes ces fonctionnalités.
La commande "-help" permet d'afficher la liste des commandes existante et "-quit" de quitter le programme.
De plus, nous gérons un historique des commandes, que nous pouvons retrouver à l'aide de la commande "-hist"


# Tests unitaires 

Toutes ces fonctionnalités sont validées à l'aide de tests unitaires.


# FeedBack 

L'utilisation de Travis semble primordiale dans un grand projet, 
puisqu'elle permet de s'assurer que les modifications du push n'entravent pas les précédentes validations.
Elle nous a permit de voir que si on modifie la structure et les commandes déjà mises en place dans les tests, 
il faut soit changer le test et voir tout ce que cela implique, soit faire en sorte que le test passe à nouveau.
Maven apporte beaucoup de outils essentiels permettant le bon fonctionnement d'un projet, tel que la compilation, l'exécution des tests unitaires, la couverture de code et j'en passe.. En tout cas pour Java, c'est un outils que nous comptons réutiliser dans des projets à venir.
L'utilisation de Git n'est pas nouveau, mais je pense indispensable dans un projet en groupe, ce projet nous a permis d'être un peu plus à l'aise sur des fonctionnalité existante très pratique dont on n'avait pas l'habitude d'utiliser.
Eclispe est un IDE très pratique quand il est bien mis en place, néanmoins nous restons assez séptique pour comprendre son fonctionnement lorsqu'il ne fait ce que l'on veut.
