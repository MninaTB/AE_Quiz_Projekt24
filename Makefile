SOURCEDIR=src
DESTDIR=bin

SOURCES:= $(shell find $(SOURCEDIR) -type f -iname '*.java' -not -name '*Test.java')
TEST_FILES:= $(shell find $(SOURCEDIR) -type f -iname '*Test.java' -and -name '*.java')

VERSION_JUNIT=4.13
VERSION_HAMCREST=2.2
VERSION_GSON=2.6.2
VERSION_PLANTUML=1.2021.5

JAR_JUNIT=junit-$(VERSION_JUNIT).jar
JAR_HAMCREST=hamcrest-$(VERSION_HAMCREST).jar
JAR_GSON=gson-$(VERSION_GSON).jar
JAR_PLANTUML=plantuml.$(VERSION_PLANTUML).jar
JAR_PLANTUMLDOCLET=plantUmlDoclet.jar

.PHONY: build dependencies test doc clean

build: # kompiliere java klassen
	javac -cp $(JAR_GSON):. -d $(DESTDIR) $(SOURCES)

dependencies:
	# erzeuge ordner fuer abhaengigkeiten
	mkdir -p lib
	# lade junit herunter
	wget https://repo1.maven.org/maven2/junit/junit/$(VERSION_JUNIT)/$(JAR_JUNIT)
	wget https://repo1.maven.org/maven2/org/hamcrest/hamcrest/$(VERSION_HAMCREST)/$(JAR_HAMCREST)
	wget https://repo1.maven.org/maven2/com/google/code/gson/gson/$(VERSION_GSON)/$(JAR_GSON) 
	wget https://kumisystems.dl.sourceforge.net/project/plantuml/$(VERSION_PLANTUML)/$(JAR_PLANTUML)
	wget https://deac-riga.dl.sourceforge.net/project/plantuml/$(JAR_PLANTUMLDOCLET)
	#wget https://repo1.maven.org/maven2/nl/talsmasoftware/umldoclet/2.0.12/umldoclet-2.0.12.jar -o umldoclet.jar

test: # starte java tests
	java -cp $(JAR_JUNIT):$(JAR_HAMCREST):. org.junit.runner.JUnitCore $(TEST_FILES)

doc:
	CLASSPATH=$(JAR_GSON) javadoc -taglet org.jdrupes.taglets.plantUml.Taglet -tagletpath $(JAR_PLANTUMLDOCLET):$(JAR_PLANTUML) $(SOURCES)

db_up:
	docker-compose up -d

db_down:
	docker-compose down

clean:
	rm -rf bin/*
	rm -rf $(shell find . -type f -name '*.jar*')

distclean:
	rm -rf bin/*
	git ls-files --others | xargs rm -rf
