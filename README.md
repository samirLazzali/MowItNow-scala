## Main 
Lawn constructor take a parametere to display the lawn in terminal (false as default) 

## TEST
Le fichier suivant est fourni en entrée :
```
5 5
1 2 N
GAGAGAGAA
3 3 E
AADAADADDA
1 20 E
ADAADADDA
5 0 N
AADAADADDA
```

On attend le résultat suivant (position finale des tondeuses) :
- Tondeuse 1 : `1 3 N`
- Tondeuse 2 : `5 1 E`
- Tondeuse 3 : Out of the lawn
- Tondeuse 4 : Collision

## Class : 
Comme il faut verifier que les déplacements sont bien dans le rectangle (qui ne dépend pas de la tondeuse) et que les deplacements sont propre à une pelouse
Les tondeuses ont été créé indépendament (sans connaitre la taille de la pelouse ou la sequence de déplacement)
De ce fait on pourra verfier la cohérence à chaque déplacement.
Enfin, **instructions** *(List[(Mower, String)])* fait le lien entre une tondeuse et une sequence