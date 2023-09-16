## Setting up the project

### Requirements
* [JDK 20](https://jdk.java.net/20/) installed on your computer
* [Maven 3.6.1+](https://maven.apache.org/download.cgi) installed on your computer
* [IntelliJ IDEA 2023.1+](https://www.jetbrains.com/idea/download/?section=windows) or similar IDE for Java

### Project setup
1. Git clone the entire [code-katas](https://github.com/BNYMellon/CodeKatas) project from GitHub or download the project
   as a .zip file.
2. Launch the project in the IDE as a maven project. You can find instructions on how to do
   that [here](https://www.jetbrains.com/idea/guide/tutorials/working-with-maven/importing-a-project/).
3. To verify that the Java 8 module is set up correctly,
   run [CoffeeShopTest](/jdk8/src/test/java/bnymellon/codekatas/coffeeshopkata/CoffeeShopTest.java) in the
   old-java-features module - the class should compile and all tests will pass.
4. To verify that the Java 21 module is set up correctly,
   run [CoffeeShopTest](/jdk21/src/test/java/bnymellon/codekatas/coffeeshopkata/CoffeeShopTest.java) in the
   new-java-features module - the class should compile but most tests will fail.

### Getting started
* Follow the [README](README.md) for instructions on how to complete the kata.