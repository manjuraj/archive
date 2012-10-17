### Create a Maven based project
    $ mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DgroupId=com.mycompany.app -DartifactId=myapp
    Where,
      -DgroupId - group id of the project as fqn
      -DartifactId - project name

### Build: clean, compile & install
    
    $ mvn clean compile install

### Run
    $ mvn exec:java -Dexec.mainClass="com.mycompany.app.App"
