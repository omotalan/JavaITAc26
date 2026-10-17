## Què és un bloc d’inicialització (sense static)?
És el bloc dintre de la classe que s'utilitza per inicialitzar una instància d'aquesta classe.
No són els statics, perquè pertanyen a la instància; els statics pertanyen a la classe.

## Quan s’executa?
Quan es crida `new Classe()`

## Quina diferència hi ha entre aquest i un bloc static?
El bloc static pertany a la classe i no a una instància d'ella, doncs inicialitza els atributs de classe.
Com no hi ha instància, només s'inicialitza una vegada per programa (e.g. el "main")