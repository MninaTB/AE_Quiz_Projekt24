# Ideen für Screens und GUIs
Diese Dokumentation soll Ideen für die Anzahl der möglichen Screens und deren GUIs dokumentieren.

## Wie viele und welche Screens werden benötigt?
- **Start-Screen** - Ein einfacher Screen mit Game-Title und einem Start-Button und einem Exit-Button
- **Game-Screen** - Ein komplexer Screen, der das eigentliche Spiel präsentiert

## Start-Screen
### Funktionen des Screens
- Das Spiel starten
- Das Spiel schließen

### Komponenten
- **Title-Label** - Der Name des Spiels
- **Start-Button** - Ein Button, der zum Game-Screen führt
- **Exit-Button** - Ein Button, der das Spiel schließt

### Zeichnung
![StartGUI Bild](StartGUI.png)

## Game-Screen
### Funktionen des Screens
- Zurück zum Start-Screen gehen
- Das Spiel schließen
- Einen der 4 Antworten auswählen
- Mit dem 50/50 Joker 2 falsche Antworten entfernen
- Das aktuelle Level anzeigen

### Komponenten
- **Title-Label** - Der Name des Spiels
- **Home-Button** - Ein Button, der zum Start-Screen zurück geht
- **Exit-Button** - Ein Button, der das Spiel schließt
- **Question-Label** - Die aktuelle Frage
- **Level-Labels** - Liste aller Level und das aktuelle Level zeigt
- **Answer-Buttons** - Die 4 Antworten-Buttons(1 richtig, 3 falsch)
- **Joker-Button** - Ein Button, der 2 falsche Antworten entfernt

### Zeichnung
![GameGUI Bild](GameGUI.png)

## Zeichnung bearbeiten
Mit den .drawio-Files hat man die Möglichkeit die Zeichnungen(.png-Files) weiter zu bearbeiten im ![Browser](https://app.diagrams.net/?src=about) oder sich ![hier](https://github.com/jgraph/drawio-desktop/releases/tag/v14.5.1) die Anwendung zu downloaden.

### Files
- `EditableStartGUI.drawio`
- `EditableGameGUI.drawio`
- `StartGUI.png`
- `GameGUI.png`
