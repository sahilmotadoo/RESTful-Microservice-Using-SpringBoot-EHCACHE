## RESTful Microservice Using SpringBoot + EHCACHE 

#### Pre-requisites:
- Ensure you have maven installed
- To start the container, go to the root directory of the project (on the pom.xml level) and run the following command (macOS):
  - `mvn spring-boot:run`
  OR
  - You can use IntelliJ or any other equivalent IDE and run the `WordSelectApplication.java` file which will instantiate the container 

#### wordselect Repository:
- The container has one endpoint defined which will get a random word from a list of words
- Once the container is up, you can hit the following URL(s):
  - On command line (macOS): `curl http://localhost:8080/word/select` 
  - Go to any browser (macOS/Windows) and hit `http://localhost:8080/word/select`
- You will see a random word being picked from a static list of words and displayed as a JSON response, for example
  - `{"randomWord":"longboat"}`

#### Assumptions:
- As we are dealing with a static datastore (either from a database, calling a third party URL or a file in this case), caching helps improve API performance
- We can use any caching strategy (EHCACHE, Redis etc.). For this sample, I have implemented a simple container level EHCACHE
- Using the `@Cacheable`annotation provided by Spring along with configurable EHCACHE parameters such as TTL, cache name etc., we can create a decent caching strategy to store the static list and randomly select a word from that list
- The file used is [words_alpha.txt](https://github.com/dwyl/english-words/blob/master/words_alpha.txt) which available on Github. The file is downloaded and stored on the project classpath for the sake of this example
- The TTL used for EHCACHE is 10 minutes. So after every 10 minutes, the cache will evict the current entry and refresh by constructing the word list from the file. This will take care of any data refreshes that happen server side
- For cache properties, refer to:
  - `ehcache.xml`
- For repository properties, refer to:
  - `application.properties` 

#### Links:
- [Maven Installation Guide](https://www.baeldung.com/install-maven-on-windows-linux-mac)
- [IntelliJ](https://www.jetbrains.com/idea/download/#section=mac)
- [SpringBoot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [EHCACHE documentation](https://www.ehcache.org/documentation/)