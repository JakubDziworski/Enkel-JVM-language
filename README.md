[![Build Status](https://travis-ci.org/CIResearchGroup/Enkel-JVM-language.svg?branch=master)](https://travis-ci.org/CIResearchGroup/Enkel-JVM-language)
#Enkel
Enkel is a simple programming language running on jvm

#[BLOG - Creating JVM Language] (http://jakubdziworski.github.io/categories.html#Enkel-ref)
I describe this project on my [BLOG - Creating JVM Language] (http://jakubdziworski.github.io/categories.html#Enkel-ref).
When in doubt reading the code take a look at the posts - all of the features are described there.

## Compiling and running Enkel scripts
1.Build compiler into executable jar

```bash
mvn clean package
```
2.Compile sample .enk file (You can find more examples in EnkelExamples directory)

```bash
java -classpath compiler/target/compiler-1.0-SNAPSHOT-jar-with-dependencies.jar:. com.kubadziworski.compiler.Compiler EnkelExamples/DefaultParamTest.enk
```

3.Run compiled .enk program

```bash
java DefaultParamTest
```
