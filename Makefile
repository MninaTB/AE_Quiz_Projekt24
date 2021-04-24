SOURCEDIR=./src/

SOURCES:= $(shell find $(SOURCEDIR) -type f -iname '*.java' -not -name '*Test.java')
TEST_FILES:= $(shell find $(SOURCEDIR) -type f -iname '*Test.java' -and -name '*.java')


build: # kompiliere java klassen
	javac $(SOURCES)

dependencies:
	# erzeuge ordner fuer abhaengigkeiten
	mkdir -p lib
	# lade junit herunter
	wget https://repo1.maven.org/maven2/junit/junit/4.13/junit-4.13.jar -o lib/junit.jar
	wget https://repo1.maven.org/maven2/org/hamcrest/hamcrest/2.2/hamcrest-2.2.jar -o lib/hamcrest.jar


test: # starte java tests
	java -cp lib/junit-4.13.jar:lib/hamcrest-2.2.jar:. org.junit.runner.JUnitCore $(TEST_FILES)
