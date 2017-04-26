# Stockage

Notre service permet de stocker des valeurs dans une base de donn�e. 
Ca supporte des structures de donn�es comme les strings et les ensembles.
C'est un service de stockage cle/valeurs


# Les commandes sur les cl�s/valeurs

SET Key Value : Cette commande attribue � la cl� "Key" la valeur "Value"
GET Key : Permet d'obtenir la valeur de la cl� "Key"
DEL Key : Permet de supprimer la cl� "Key" et sa valeur assossic�e
INCR Key : Si la cl� "Key" est un entier, l'incr�mente (La concurrence est g�r�e lors de cette op�ration)
DECR Key : Si la cl� "Key" est un entier, le d�cr�mente

# Les commandes suivantes sont la gestion d'une liste

RPUSH Key Value : Permet de mettre la valeur "Value" � la cl� "Key" � la fin de la liste
LPUSH Key Value : Permet de mettre la valeur "Value" � la cl� "Key" au d�but de la liste
LLEN Key : Retourne la taille de la liste � la cl� "Key"
LPOP Key : Supprime le premier �l�ment de la liste et le retourne
RPOP Key : Supprime le dernier �l�ment de la liste et le retourne

# Les commandes suivantes sont la gestion d'un ensemble (un set)

SADD Key Value(s) : Ajoute les valeurs dans "Value(s) dans l'ensemble � la cl� "Key"
SREM Key Value(s) : Supprime les valeurs dans "Value(s) dans l'ensemble � la cl� "Key"
SISMEMBER Key Value : Teste si la valeur "Value" est dans l'ensemble � la cl� "Key"
SMEMBERS Key : Retourne ce que contient la liste � la cl� "Key"
SUNION Key Key : Combine deux �l�ments et retourne la liste de tous les �l�ments joints dans le nouvel ensemble

# Gestion des hash

HSET Key Field Value : Stocke la valeur "Value" dans le champ "Field" de la cl� "Key"
HGET Key Field : R�cup�re la valeur stock�e dans le champ "Field" de la cl� "Key"
HGETALL Key : R�cup�re tous les champs et toutes les valeurs de la cl� "Key"
HDEL Key Field : Supprime les valeurs du champ "Field", ainsi que ce m�me champ
HDECRBY Key Field Value : D�cr�mente la valeur de "Value" dans le champ "Field" de la cl� "Key" si c'est un entier
HINCRBY Key Field Value : Incr�mente la valeur de "Value" dans le champ "Field" de la cl� "Key" si c'est un entier


# Utilisation 

Ex�cuter le Menu afin d'acc�der � toutes ces fonctionnalit�s.
De plus, nous g�rons un historique des commandes, que nous pouvons retrouver � l'aide de la commande "-hist"


# Tests unitaires 

Toutes ces fonctionnalit�s sont valid�es � l'aide de tests unitaires.


# FeedBack 

L'utilisation de Travis semble primordiale dans un grand projet, 
puisqu'elle permet de s'assurer que les modifications du push n'entravent pas les pr�c�dentes validations.
Elle nous a permit de voir que si on modifie la structure et les commandes d�j� mises en place dans les tests, 
il faut soit changer le test et voir tout ce que cela implique, soit faire en sorte que le test passe � nouveau.
