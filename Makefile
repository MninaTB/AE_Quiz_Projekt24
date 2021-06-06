SOURCEDIR=src
DESTDIR=bin

SOURCES:= $(shell find $(SOURCEDIR) -type f -iname '*.java' -not -name '*Test.java')
TEST_FILES:= $(shell find $(SOURCEDIR) -type f -iname '*Test.java' -and -name '*.java')
CLASS:= $(shell find $(DESTDIR) -type f -iname '*.class' -not -name '*Test.class')

VERSION_JUNIT=1.7.1
VERSION_GSON=2.8.6
VERSION_PLANTUML_BUILDER=1.3
VERSION_GUAVA=21.0
VERSION_COMMONS_LANG3=3.5
VERSION_MOCKITO_JUNIT_JUPITER=3.11.0
VERSION_MOCKITO_CORE=3.10.0
VERSION_BYTE_BUDDY=1.11.1
VERSION_OBJENESIS=3.2

JAR_JUNIT=junit-platform-console-standalone-$(VERSION_JUNIT).jar
JAR_GSON=gson-$(VERSION_GSON).jar
JAR_PLANTUMLDOCLET=plantUmlDoclet.jar
JAR_PLANTUML_BUILDER=plantuml-builder-$(VERSION_PLANTUML_BUILDER).jar
JAR_GUAVA=guava-$(VERSION_GUAVA).jar
JAR_COMMONS_LANG3=commons-lang3-$(VERSION_COMMONS_LANG3).jar
JAR_MOCKITO_JUNIT_JUPITER=mockito-junit-jupiter-$(VERSION_MOCKITO_JUNIT_JUPITER).jar
JAR_MOCKITO_CORE=mockito-core-$(VERSION_MOCKITO_CORE).jar
JAR_BYTE_BUDDY=byte-buddy-$(VERSION_BYTE_BUDDY).jar
JAR_BYTE_BUDDY_AGENT=byte-buddy-agent-$(VERSION_BYTE_BUDDY).jar
JAR_OBJENESIS=objenesis-$(VERSION_OBJENESIS).jar

CP_TEST=$(JAR_JUNIT):$(JAR_GSON):$(JAR_PLANTUML_BUILDER):$(JAR_GUAVA):$(JAR_COMMONS_LANG3):$(JAR_MOCKITO_JUNIT_JUPITER):$(JAR_MOCKITO_CORE):$(JAR_BYTE_BUDDY):$(JAR_BYTE_BUDDY_AGENT):$(JAR_OBJENESIS)

.PHONY: build dependencies test doc clean

build: # kompiliere java klassen
	javac -cp $(JAR_GSON):$(JAR_PLANTUML_BUILDER):$(JAR_GUAVA):$(JAR_COMMONS_LANG3):. -d $(DESTDIR) $(SOURCES)

dependencies:
	# erzeuge ordner fuer abhaengigkeiten
	mkdir -p lib
	# lade junit herunter
	wget https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/$(VERSION_JUNIT)/$(JAR_JUNIT)
	wget https://repo1.maven.org/maven2/com/google/code/gson/gson/$(VERSION_GSON)/$(JAR_GSON)
	wget https://repo1.maven.org/maven2/ch/ifocusit/plantuml-builder/$(VERSION_PLANTUML_BUILDER)/$(JAR_PLANTUML_BUILDER)
	wget https://repo1.maven.org/maven2/com/google/guava/guava/$(VERSION_GUAVA)/$(JAR_GUAVA)
	wget https://repo1.maven.org/maven2/org/apache/commons/commons-lang3/$(VERSION_COMMONS_LANG3)/$(JAR_COMMONS_LANG3)
	wget https://repo1.maven.org/maven2/org/mockito/mockito-junit-jupiter/$(VERSION_MOCKITO_JUNIT_JUPITER)/$(JAR_MOCKITO_JUNIT_JUPITER)
	wget https://repo1.maven.org/maven2/org/mockito/mockito-core/$(VERSION_MOCKITO_CORE)/$(JAR_MOCKITO_CORE)
	wget https://repo1.maven.org/maven2/net/bytebuddy/byte-buddy/$(VERSION_BYTE_BUDDY)/$(JAR_BYTE_BUDDY)
	wget https://repo1.maven.org/maven2/net/bytebuddy/byte-buddy-agent/$(VERSION_BYTE_BUDDY)/$(JAR_BYTE_BUDDY_AGENT)
	wget https://repo1.maven.org/maven2/org/objenesis/objenesis/$(VERSION_OBJENESIS)/$(JAR_OBJENESIS)
	# wget https://netcologne.dl.sourceforge.net/project/plantuml/plantuml.jar	
	# wget https://repo0.maven.org/maven2/nl/talsmasoftware/umldoclet/2.0.12/umldoclet-2.0.12.jar -o umldoclet.jar

test: # starte java tests
	javac -cp $(CP_TEST):. \
		 -d $(DESTDIR) $(TEST_FILES) $(SOURCES)
	java -jar $(JAR_JUNIT) --classpath $(CP_TEST):bin:bin/questions \
		--scan-classpath --include-engine junit-jupiter \
		--include-classname ".*Test.*" 

doc:
	CLASSPATH=$(CP_TEST) javadoc -taglet org.jdrupes.taglets.plantUml.Taglet -tagletpath $(JAR_PLANTUMLDOCLET):$(JAR_PLANTUML) $(SOURCES)

uml:
	java -jar plantuml.jar diagram.puml

jar:
	jar -v --create --main-class=bin.Main --file quiz.jar $(CLASS)

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
