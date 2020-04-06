# Aplicație de prezentare, comandă și planificare comenzi pentru un atelier de tâmplărie.

## Context

Creearea unui magazin online pentru promovarea unui atelier de tâmplărie. Acest magazin online va permite clienților să se înregistreze cu un cont și să comande diferite produse disponibile pe aplicația web. Aplicația verifică comenzile deja existente și oferă o estimare a prețului și a timpului de așteptare în cazul în care clientul depune comanda în aceea zi.

## Mod de rezolvare a problemei

Vor exista două sau trei tipuri de utilizatori, după cum urmează:
* Administatorul care poate adăuga, șterge și modifica produse.
* (Opțional) Manager care vede comenzile existente și datele clienților care fac aceste comenzi.
* Clienții care pot vedea produsele și realiza comenzi.

## Mod de implementare

Pentru implementare folosesc Spring cu SpringBoot, Tomcat pentru conexiunea la server. PostgreSQL se folosește pentru menținerea bazei de date, iar conexiunea se realizează cu JDBC și Hikari. Migrarea bazei de date se realizează cu Flyway. Limbajul de bază al acestui proiect este Java, ide-ul de bază fiind Intellij Idea.

## Testare

Testarea se face cu JUnit și Mockito.
