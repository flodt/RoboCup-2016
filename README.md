RoboCup Junior Finale 2016
==========================
Um den Rescue Line Secondary Parcour zu meistern, muss der Roboter einer Linie durch verschiedene Räume folgen, in denen sich verschiedene Problemstellen wie "Speed Bumps", Kreuzungen, Hindernisse oder Lücken in der Linie befinden. Am Ende des Parcours muss er im "Evacuation Room" die zufällig platzierten "Opfer" (Metallkugeln) in ein dafür vorgesehenes Fach an einer der vier Ecken des Raumes platzieren.

#Programmlogik
Programmiert wird mit Java (leJOS für den EV3 - läuft von einer SD-Karte).

##Linienfolgen
In der Hauptschleife des Programmes überprüft der Roboter sein Umfeld, und kann dann anhand von Sensorenwerten entscheiden, welche Aktion er hervorruft. Die meisten Geschwindigkeitswerte/Richtingen sind vorgegeben, lediglich beim Überfahren einer "Speed Bump" errechnet der Roboter selber die Geschwindigkeiten der Ketten.

##Sensoren auslesen
Es wurden verschiedene Klassen geschrieben, um das Auslesen der Sensoren zu vereinfachen - so müssen sie nicht jedes mal initialisiert werden und der Aufruf einer Methode reicht. Auch für das Auslesen einer Farbe wurden Klassen verfasst.

##Motoren steuern
Das Selbe gilt auch für die Motoren - auch da wurden Klassen geschrieben um die Ansteuerung zu vereinfachen.

##Objekten ausweichen
Dies funktioniert, indem der Roboter, sobald er das Hindernis via Ultraschall erkannt hat, vor ihm zurückweicht, sich in eine im Code vorgegebene Richtung dreht, vorwärts fährt, sich wieder dreht und dann fährt, bis er die Linie wieder findet. Sobald der Roboter das Hindernis erkannt und die Linie wiedergefunden hat, gilt es als umfahren, selbst, wenn der Roboter das Hindernis von der Linie geschoben hat.

##Logging
Der Roboter gibt während der Läufe auf dem Display Infos zu seinem momentanen Status aus - in eine Log-Datei werden ebenfalls gröbere Informationen wie die Dateiversion, Variableneinstellungen, etc. geschrieben.

#JavaDoc
Das JavaDoc findet sich unter doc/.

#Regeln
Die Regeln für die momentante Saison (Regeländerungen sind immer auch vor Ort möglich) finden sich [auf rcj2016.de.](https://rcj2016.de/sites/default/files/rescue_line_2015.pdf)

#Schwierigkeiten
(vgl. Difficulties.txt)
Problemstellen sind Kreuzungen -  der Roboter biegt an Kreuzungen ohne grünem Punkt trotzdem ab, oder er biegt ab, obwohl der grüne Punkt erst nach der Kreuzung steht.
Auf der Rampe könnte er kippen/rutschen - beide dieser Probleme wurden gelöst.
An den "Speed Bumps" verliert er auch öfters die Linie, auch das wurde allerdings größtenteils gelöst.
