# Problème 

Envisagons un programme qui doit trouver les 10 mots les plus utilisés dans un document. 
Supposons pour le moment que le document est disponible en tant que valeur de chaîne. 

# Contrainte

Attention à ne pas tenir compte de :
* La ponctuation
* de la casse (*The* vaut pour *the*)
 
Par simplicité (mais c'est mal) on va considérer que les pronoms (y, à, où...) sont des mots. 

# Exemples

La chaine `foo bar foo foobar bar foo` retourne :
* (3, foo)
* (2, bar)
* (1, foobar)

# Pour finir

Prendre le texte de la http://www.ietf.org/rfc/rfc0822.txt
Le résultat devrait être:

```
["the","of","to","a","is","and","be",";","for","in"]
``` 
