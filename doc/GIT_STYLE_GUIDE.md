# Git Style Guide

### Branches
Wenn man eine Funktion hinzufügt oder einen Fehler behebt, muss man einen neuen
Feature/Fix-Zweig mit einem Namen in diesem Format anlegen:
```
{feat, fix}/<kurzer titel fuer feature/fix>_<issue ID>
```
Where:
`feat` - eine neue Erweiterung oder ein grundlegendes Update einer bestehenden Funktionalität
`fix`  - eine Fehlerbehebung oder kleine Korrektur
`issue ID` - ID des github Tickets zugehörig zu dem feature/fix

Beispiel:
`feat/git_beispiel_#10`

### Commits

Commits sollten immer einen sinnvollen Inhalt haben. Das bedeutet, dass ein Commit
der nur eine Tippfehler-Korrektur enthält, unerwünscht ist.
Ein Commit sollte sich auch auf einen begrenzten Bereich beschränken, höchstens auf
eine zusammenhängende Menge von Dateien, aber besser noch eine Datei.
Eine Commit-Nachricht muss das folgende Format haben:
```
{feat, fix}(<scope>): <kurze Zusammenfassung von feature/fix>
NEWLINE
<laengere beschreibung von feature/fix>
```
Eine längere Beschreibung ist optional aber sollte genutzt werden, 
wenn der commit nicht selbsterklärend ist.

Beispiel:
```
feat(doc): style guide hinzugefuegt

git style guide zur einheitlichen nutzung hinzugefuegt
```

### Pull requests

Um den Code in den Master-Zweig einzubringen, muss ein Pull-Request
geöffnet werden.
Der Titel muss das folgende Format haben:
```
{feat, fix}: <kurze beschreibung von feature/fix>
```
Der Korpus muss enthalten:
```
closes <issue ID>
```

### Review
Jede Hinzufügung zum Master-Branch erfordert eine Überprüfung durch ein
Mitglied des Projekts, das nicht die Person ist, die
an der Änderung gearbeitet hat. Reviews sollten angefordert werden, sobald
die ursprüngliche Arbeit an dem Feature/Fix abgeschlossen ist.
