This is an (experimental) implementation of Fujure using [Truffle](https://github.com/oracle/graal/tree/master/truffle).

Note that you need to use [GraalVM](https://www.graalvm.org/) as the JDK for the tests to execute successfully
(compilation should pass with the Oracle JDK, not running the code though).
You might have to export `JAVA_HOME` to force Gradle to use Graal, something like:

```bash
export JAVA_HOME=/progfiles/graalvm/graalvm-1.0.0-rc1
``` 
