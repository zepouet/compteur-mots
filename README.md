# Problème 

Envisagons un programme qui doit trouver les mots les plus utilisés dans un document. 
Supposons pour le moment que le document est disponible en tant que valeur de chaîne. 
Le but est de retourner trié par ordre décroissant les mots du document.

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
[(648,"the"),(336,"of"),(281,"to"),(273,"a"),(230,"is"),(191,"and"),(178,"be"),(172,";"),(166,"for"),(156,"in")]
``` 
