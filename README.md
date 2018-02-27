# Problème 

Envisagons un programme qui doit trouver les 10 mots les plus utilisés dans un document. 
Supposons pour le moment que le document est disponible en tant que valeur de chaîne. 

# Contrainte

Attention à ne pas tenir compte de :
* La ponctuation
* de la casse

Par simplicité (mais c'est mal) on va considérer que les pronoms (y, à, où...) sont des mots. 

# Exemple

La chaine `foo bar foo` retourne :
* (2, foo)
* (1, bar)

# Pour finir

Prendre le texte de la http://www.ietf.org/rfc/rfc0822.txt
Le résultat devrait être:

```
["the","of","to","a","is","and","be",";","for","in"]
``` 
