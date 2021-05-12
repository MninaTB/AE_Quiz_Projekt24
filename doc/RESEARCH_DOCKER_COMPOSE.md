# Datenbank mit Docker

## Was ist Docker?
Docker ist eine Software zur Container-Virtuallisierung. Damit lassen sich Lokal oder auch Remote einfach verschiedenste Images (Verbund von Software) System unabhängig ausführen. 

Mehr Informationen finden sich hier:  https://de.wikipedia.org/wiki/Docker_(Software)

## Was ist Docker-Compose?
Dabei handelt es sich um ein in Python geschriebenes Tool das anhand eines beschriebenen Setups (in `yaml`) Multicontaineranwendungen verwalten kann.

## Beispiele
### Eine MariaDB Datenbank mit Docker starten
Wir erzeugen eine MariaDB Instanz welche mit der Tastenkombination `CTRL+C` gestoppt werden kann.
```bash
docker run -p 127.0.0.1:3306:3306 --rm -it --name some-mariadb -e MYSQL_ROOT_PASSWORD=1234 -d mariadb:latest
```
### Eine MariaDB Datenbank mit Docker-Compose starten

Zuerst muss unsere Umgebung spezifiziert werden. In unserem Beispiel wollen wir die eine `MariaDB` Datenbank mit einem Nutzer `quiz` und dem Passwort `1234` erzeugen.

Beispiel:
```yaml
version: '3.3'
services:
  db:
    image: mariadb
    environment:
      - MYSQL_USER=quiz
      - MYSQL_PASSWORD=1234
      - MYSQL_ROOT_PASSWORD=1234
      - MYSQL_DATABASE=quiz
    ports:
      - "127.0.0.1:3306:3306"
```
Ohne weitere Einstellungen läd Docker nun die benötigen Images (MariaDB) direkt von https://hub.docker.com/ herunter.

Befehle:
- `docker-compose up` Starten der Container, kann mit `CTRL+C` beendet werden.
- `docker-compose up -d` Starten der Container im Hintergrund
- `docker-compose down` Stoppen aller Container

### Wie installiere ich Docker-Compose
Das unterscheidet sich Abhängig vom verwendeten Betriebssystem ein wenig. Eine Anleitung findet sich hier: https://docs.docker.com/compose/install/
