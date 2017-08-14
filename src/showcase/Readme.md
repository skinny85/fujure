The `showcase` projects use the Fujure Gradle plugin from the main source tree.
Because of that, they can't be part of the same build
(the plugins must be loaded before the projects are built).
In order to get around that, the `showcase` projects use a local Maven repository
that the main build publishes artifacts to.
So, before running these, you need to call:

    ./gradlew publish

from the root directory.
After that, you can build and run these projects.
