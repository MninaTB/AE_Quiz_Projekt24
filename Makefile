SOURCEDIR=src
DESTDIR=bin

SOURCES:= $(shell find $(SOURCEDIR) -type f -iname '*.java' -not -name '*Test.java')
TEST_FILES:= $(shell find $(SOURCEDIR) -type f -iname '*Test.java' -and -name '*.java')


build: # kompiliere java klassen
	javac -cp gson-2.6.2.jar:src -d $(DESTDIR) $(SOURCES)

dependencies:
	# erzeuge ordner fuer abhaengigkeiten
	mkdir -p lib
	# lade junit herunter
	wget https://repo1.maven.org/maven2/junit/junit/4.13/junit-4.13.jar -o junit-4.13.jar
	wget https://repo1.maven.org/maven2/org/hamcrest/hamcrest/2.2/hamcrest-2.2.jar -o hamcrest-2.2.jar
	wget https://repo1.maven.org/maven2/com/google/code/gson/gson/2.6.2/gson-2.6.2.jar -o gson-2.6.2.jar
	wget https://kumisystems.dl.sourceforge.net/project/plantuml/1.2021.5/plantuml.1.2021.5.jar -o plantuml.1.2021.5.jar

test: # starte java tests
	java -cp junit-4.13.jar:hamcrest-2.2.jar:. org.junit.runner.JUnitCore $(TEST_FILES)

uml:
	java -jar plantuml.1.2021.5.jar project.puml

clean:
	rm -rf bin/*
	rm -rf $(shell find . -type f -name '*.jar*')
