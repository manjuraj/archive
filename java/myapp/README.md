### Create a Maven based project
    $ mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DgroupId=com.mycompany.app -DartifactId=myapp
    Where,
      -DgroupId - group id of the project as fqn
      -DartifactId - project name

### Build: clean, compile & install
    
    $ mvn clean compile install

### Run

    $ mvn exec:java -Dexec.mainClass="com.mycompany.app.App"

### Maven Directory Layout
    
    src/main/java       application/Library sources
    src/main/resources	application/Library resources
    src/main/filters	resource filter files
    src/main/assembly	assembly descriptors
    src/main/config	    configuration files
    src/main/scripts	application/Library scripts
    src/main/webapp	    web application sources
    
    src/test/java	    test sources
    src/test/resources	test resources
    src/test/filters	test resource filter files

    src/site	        site
    
    LICENSE.txt	        project's license
    NOTICE.txt	        notices and attributions required by libraries that the project depends on
    README.txt	        project's readme